package rmit.com.sept.sept.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import rmit.com.sept.sept.Booking;
import rmit.com.sept.sept.CustomLoginSuccessHandler;
import rmit.com.sept.sept.Role;
import rmit.com.sept.sept.User;
import rmit.com.sept.sept.repository.BookingRepository;
import rmit.com.sept.sept.repository.RoleRepository;
import rmit.com.sept.sept.repository.UserRepository;
import rmit.com.sept.sept.service.BookingService;
import rmit.com.sept.sept.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthenticationController {

	@Value("${spring.datasource.password}")
	public String password;
	
	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	private final BCryptPasswordEncoder encoder;

	private final UserService userService;

	private final BookingRepository bookingRepository;

	private int userID;

	private final BookingService bookingService;

	private final CustomLoginSuccessHandler custom;


	
	public AuthenticationController(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder encoder, UserService userService, CustomLoginSuccessHandler custom,
			BookingRepository bookingRepository, BookingService bookingService) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.userService = userService;
		this.custom = custom;
		this.bookingRepository = bookingRepository;
		this.bookingService = bookingService;
	}
	
	// returns a json containing information of the bookings
	@GetMapping("/bookings")
	public String booking() {
		List<Booking> bookingList = bookingService.getAllBookings();
		String jsonString = "{\"data\":[";

		for (int i = 0; i < bookingList.size(); i++) {
			jsonString += "{\"bookingID\":\"" + bookingList.get(i).getBookingId() + "\",\"serviceName\":\""
					+ bookingList.get(i).getServiceName() + "\",\"workerName\":\"" + bookingList.get(i).getWorkerName()
					+ "\",\"date\":\"" + bookingList.get(i).getDate() + "\",\"time\":\"" + bookingList.get(i).getTime();

			if (i != bookingList.size() - 1) {
				jsonString += "\"},";
			}
		}

		jsonString += "\"}]}";
		return jsonString;
	}

	// logs user out from the system
	@GetMapping("/logoutUser")
	public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		userID = 0;
		return "redirect:/login?logout";
	}

	// returns the the type of user logging in for authentication
	@PostMapping("/loginUser")
	public String login(@RequestBody User newUser) {
		System.out.println(password);
		int id = userService.findIdLogin(newUser.getEmail());
		userID = id;
		String userType = userService.findUserType(id);
		System.out.println(userID);

		String jsonString = "{\"email\":\"" + newUser.getEmail() + "\", \"userType\":\"" + userType + "\"}";

		return jsonString;

	}

	// returns json of email, first name and last name
	@GetMapping("/profile")
	public String profile() {
		List<User> userList = userService.getUserDetails(userID);
		String jsonString = "{\"email\":\"" + userList.get(0).getEmail() + "\"," + " \"firstName\":\""
				+ userList.get(0).getName() + "\"," + " \"lastName\":\"" + userList.get(0).getLastName() + "\"}";

		return jsonString;
	}
	
	// Registers a user
	@PostMapping("/createUser")
	public User registerUser(@RequestBody User newUser) {
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		newUser.setStatus("VERIFIED");

		if (newUser.getCompanyName() == null) {
			Role userRole = roleRepository.findByRole("SITE_USER");
			newUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		} else {
			newUser.setIsCompany(true);
			Role userRole = roleRepository.findByRole("ADMIN_USER");
			newUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		}
		return userRepository.save(newUser);

	}
	
	// Creates a Booking For the User 
	@PostMapping("/createBooking")
	public Booking createBooking(@RequestBody Booking newBooking) {
		newBooking.setUserId(userID);
		return bookingRepository.save(newBooking);
	}
	
	public String getPassword() {
		return password;
	}

}
