package rmit.com.sept.sept.service;

import java.util.List;

import rmit.com.sept.sept.Company;
import rmit.com.sept.sept.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public List<User> getUserDetails(int id);
	
	public boolean isUserPresent(User user);
	
	public int findByUsername(String username);

}
