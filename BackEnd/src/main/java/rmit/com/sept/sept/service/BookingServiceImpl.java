package rmit.com.sept.sept.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import rmit.com.sept.sept.Booking;
import rmit.com.sept.sept.Company;
import rmit.com.sept.sept.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
//	private UserServiceImpl service;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
    JdbcTemplate template;
	
	@Override
	public void createBooking(Booking booking) {
//		UserServiceImpl service = new UserServiceImpl();
//		System.out.println(service.getSessionUserID());
//		booking.setUserId(service.getSessionUserID());
		bookingRepository.save(booking);
	}

	@Override
	public List<Company> findAllCompany(String service_name) {
		System.out.println(service_name);
		String sql = "select * from company where service_name = '" + service_name + "'";
        RowMapper<Company> rm = new RowMapper<Company>() {
            @Override
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                Company company = new Company(resultSet.getInt("company_id"),
                        resultSet.getString("company_name"),
                        resultSet.getString("service_name"));
               
                return company;
            }
        };

        return template.query(sql, rm);
	}

	@Override
	public List<Booking> getAllBookings() {
		String sql = "select * from booking" ;
        RowMapper<Booking> rm = new RowMapper<Booking>() {
            @Override
            public Booking mapRow(ResultSet resultSet, int i) throws SQLException {
                Booking booking = new Booking(
                		resultSet.getInt("user_id"),
                		resultSet.getInt("booking_id"),
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getString("servicename"),
                        resultSet.getString("worker_name"));
               
                return booking;
            }
        };

        return template.query(sql, rm);
	}

	@Override
	public void deleteBooking(int id) {
//		String iaa = "2";
//		int i=Integer.parseInt(iaa);  
		List<Booking> b = getAllBookings();
		b.removeIf(t -> t.getBookingId() == (id));
	}

}
