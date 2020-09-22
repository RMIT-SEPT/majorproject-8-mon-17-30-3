package rmit.com.sept.sept.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rmit.com.sept.sept.Role;
import rmit.com.sept.sept.SeptApplication;
import rmit.com.sept.sept.User;
import rmit.com.sept.sept.repository.RoleRepository;
import rmit.com.sept.sept.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	
	SeptApplication app = new SeptApplication();
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
    JdbcTemplate template;
	 
	List<User> userList = new ArrayList<User>();
	
	private int sessionUserID;
	
	// stores the user in the database
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

	// yet to be implemented
	@Override
	public boolean isUserPresent(int id) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(id)){
			return true;
		}		//return false;
		return false;
	}

	// returns session ID
	public int getSessionUserID() {
		return sessionUserID;
	}

	// sets session ID
	public void setSessionUserID(int sessionUserID) {
		this.sessionUserID = sessionUserID;
	}
	
	// returns a list containing user details (First Name, Last Name and email)
	@Override
	public List<User> getUserDetails(int id) {
	
		String sql = "select firstname,lastname,email from user where user.user_id = '" + id + "'";
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"));
                user.setName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                System.out.println(user.getName());
                System.out.println(user.getLastName());
               userList.add(user);
                return user;
            }
        };

        return template.query(sql, rm);
    }
	
	// finds the email of the user and returns an int
    @Override
    public int findIdLogin(String email){

        int intId = 0;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root",	SeptApplication.sqlPassword); 
	        Statement st = conn.createStatement(); 
	        ResultSet rs;
	        
            rs = st.executeQuery("SELECT user_id FROM user WHERE user.email ='"+email+"'");
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

    // returns a string of the type of user
    @Override
    public String findUserType(int id){

        String userType = "";
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root",SeptApplication.sqlPassword); 
	        Statement st = conn.createStatement(); 
	        ResultSet rs;
	        
            rs = st.executeQuery("SELECT auth_role_id FROM auth_user_role WHERE auth_user_role.auth_user_id ='"+id+"'");
            while ( rs.next() ) {
                String type = rs.getString("auth_role_id");
                int userId =Integer.parseInt(type);  
                if(userId == 1 ){
                    userType = "ADMIN_USER";
                }
                if(userId == 2 ){
                    userType = "SITE_USER";
                }
                System.out.println(userType);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
		
		return userType;
      
    }

    // finds the user by their username
	@Override
	public int findByUsername(String username) {
		int intId = 0;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root",SeptApplication.sqlPassword); 
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

	// returns user repository
	public UserRepository getUserRepository(){
		return this.userRepository;

	}

	// returns the global list of user
	@Override
	public List<User> getList() {
		return userList;
	}






}
