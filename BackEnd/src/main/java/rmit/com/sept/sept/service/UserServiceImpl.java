package rmit.com.sept.sept.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rmit.com.sept.sept.Company;
import rmit.com.sept.sept.Role;
import rmit.com.sept.sept.User;
//import rmit.com.sept.sept.repository.CompanyRepository;
import rmit.com.sept.sept.repository.RoleRepository;
import rmit.com.sept.sept.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
    JdbcTemplate template;
	
	private int sessionUserID;
	
	@Override
	public void saveUser(User user) {

		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		System.out.println(user.getCompanyName());
		if(user.getCompanyName().isEmpty()) {
			Role userRole = roleRepository.findByRole("SITE_USER");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		}
		else {
			user.setIsCompany(true);
			Role userRole = roleRepository.findByRole("ADMIN_USER");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		}
		userRepository.save(user);
		
	}

	@Override
	public boolean isUserPresent(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSessionUserID() {
		return sessionUserID;
	}

	public void setSessionUserID(int sessionUserID) {
		this.sessionUserID = sessionUserID;
	}
	
	@Override
	public List<User> getUserDetails(int id) {
	
		String sql = "select firstname,lastname,email from user where user.user_id = '" + id + "'";
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"));
                System.out.println(user.getName());
                System.out.println(user.getLastName());
               
                return user;
            }
        };

        return template.query(sql, rm);
	}

	@Override
	public int findByUsername(String username) {
		int intId = 0;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root","ronaldo7!!"); 
	        Statement st = conn.createStatement(); 
	        ResultSet rs;
	        
            rs = st.executeQuery("SELECT user_id FROM user WHERE email ='"+username+"'");
            while ( rs.next() ) {
                String id = rs.getString("user_id");
                intId=Integer.parseInt(id);  
                System.out.println(intId);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
		
		return intId;
		
	}

//	@Override
//	public void saveCompany(Company company) {
//		companyRepository.save(company);
//		
//	}



	
}
