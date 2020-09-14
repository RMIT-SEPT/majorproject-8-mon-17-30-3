package rmit.com.sept.sept.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import rmit.com.sept.sept.Booking;
import rmit.com.sept.sept.Company;
import rmit.com.sept.sept.User;
import rmit.com.sept.sept.Worker;
import rmit.com.sept.sept.service.BookingService;
import rmit.com.sept.sept.service.UserService;
import rmit.com.sept.sept.service.WorkerService;

@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	WorkerService workerService;
	
	public int userId;
	
	

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.htm
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
//		Company company = new Company();
		modelAndView.addObject("user", user);
//		modelAndView.addObject("company", company);
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/registerWorker", method = RequestMethod.GET)
	public ModelAndView registerWorker(Model model) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		Worker worker = new Worker();
		 List<Company> listCat  = workerService.list();
		 model.addAttribute("listCat",listCat);
		modelAndView.addObject("worker", worker);
		modelAndView.setViewName("registerWorker"); // resources/template/registerWorker.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/createBooking", method = RequestMethod.GET)
	public ModelAndView booking() {
		
		ModelAndView modelAndView = new ModelAndView();
		Booking booking = new Booking();
		modelAndView.addObject("booking", booking);
		modelAndView.setViewName("createBooking"); // resources/template/register.html
		return modelAndView;
	}
	
	   @ModelAttribute("companyList")
	   public List<Company> getNumbersList() throws SQLException {
	      List<Company> companyList = workerService.list();
	      System.out.println(companyList.size());
	      return companyList;
	   }


	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println(RequestContextHolder.currentRequestAttributes().getSessionId());
		ModelAndView modelAndView = new ModelAndView();
		
		final Object currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		String convertedToString = String.valueOf(currentUserName);
		System.out.println(userService.findByUsername(convertedToString));
		userId = userService.findByUsername(convertedToString);
//		System.out.println(currentUserName);
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user,BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserPresent(user)){
			modelAndView.addObject("successMessage", "user already exists!");			
		}
		// we will save the user if, no binding errors
		else {
			userService.saveUser(user);
//			userService.saveCompany(company);
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		
		modelAndView.addObject("user", new User());
//		modelAndView.addObject("company", new Company());
		
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registerWorker", method=RequestMethod.POST)
	public ModelAndView registerWorker2(@Valid Worker worker, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		
		
//		else if(userService.isUserPresent(user)){
//			modelAndView.addObject("successMessage", "user already exists!");			
//		}
//		// we will save the user if, no binding errors
//		else {
//			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "User is registered successfully!");
//		}
//		modelAndView.addObject("user", new User());
		
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}
	
	@RequestMapping(value="/createBooking", method=RequestMethod.POST)
	public ModelAndView createBooking(@Valid Booking booking) {
		ModelAndView modelAndView = new ModelAndView();
//		// Check for the validations
//		if(bindingResult.hasErrors()) {
//			modelAndView.addObject("successMessage", "Please correct the errors in form!");
//			modelMap.addAttribute("bindingResult", bindingResult);
//		}
//		
		// we will save the user if, no binding errors
//		else {
		
			booking.setUserId(userId);
			bookingService.createBooking(booking);
			modelAndView.addObject("successMessage", "Booking successfully!");
//		}
		modelAndView.addObject("booking", new Booking());
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value = "company", method = RequestMethod.GET)
    public String company(@RequestParam (value = "search", required = false) String service_name, Model md){
        md.addAttribute("search", bookingService.findAllCompany(service_name));
        return "company";
    }
	
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
    public String booking(Model md){
        md.addAttribute("booking", bookingService.getAllBookings());

        return "bookings";
    }
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model md){
		System.out.println("profile" + userId);
        md.addAttribute("user", userService.getUserDetails(userId));

        return "profile";
    }
	
	
	@RequestMapping(value = "/booking/{id}", method = RequestMethod.DELETE)
    public String deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
        return "bookings";
        
    }
	
	

}

