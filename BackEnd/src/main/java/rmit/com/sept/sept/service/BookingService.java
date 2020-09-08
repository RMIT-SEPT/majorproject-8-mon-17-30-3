package rmit.com.sept.sept.service;

import java.util.List;

import rmit.com.sept.sept.Booking;
import rmit.com.sept.sept.Company;

public interface BookingService {
	public void createBooking(Booking booking);
	
	public List<Company> findAllCompany(String service_name);
	
	public List<Booking> getAllBookings();
}
