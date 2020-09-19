//package rmit.com.sept.sept;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
//
//import rmit.com.sept.sept.controller.AuthenticationController;
//import rmit.com.sept.sept.service.BookingService;
//
//@SpringBootTest
//class SeptApplicationTests {
//
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//	private final PrintStream originalOut = System.out;
//	private final PrintStream originalErr = System.err;
//
//	@Autowired
//	private BookingService service;
//
//	@Test
//	void contextLoads() {
//	}
//
//
//	@Test
//	void checkBookingSize() {
//		Booking booking = new Booking(1,1,"1/02/2020", "12:24", "Barbar", "Prabhav");
//		service.createBooking(booking);
//		// Will Fail as Company is not yet Registered
//		service.findAllCompany("Barbar");
//		List<Booking> bookingList = service.getAllBookings();
//		assertEquals(7, bookingList.size());
//	}
//
//	@Test
//	void checkBooking() {
//		Booking booking = new Booking(1,1,"1/02/2020", "12:24", "Barbar", "Prabhav");
//		String expected = "Barbar";
//		service.createBooking(booking);
//		// Will Fail as Company is not yet Registered
//		service.findAllCompany("Barbar");
//		assertEquals(expected, outContent.toString());
//	}
//
//	@Test
//	public void testRegisterPageLoading() throws URISyntaxException
//	{
//		AuthenticationController homeController = new AuthenticationController();
//        ModelAndView result = homeController.login();
//        assertEquals(result, "login");
//	}
//
//
//	@Test
//	void checkUser() {
//		User user = new User();
//		String expected = "Prabhav";
//		user.setName(expected);
//		assertEquals(expected, user.getName());
//	}
//	@Test
//	void service_Booking() {
//		String workerName = "Jack";
//		Booking booking = new Booking(1,1,"1/02/2020", "12:24", "Barbar", workerName);
//		assertEquals(workerName, booking.getWorkerName());
//	}
//
//}
