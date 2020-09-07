package rmit.com.sept.sept.service;

import rmit.com.sept.sept.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean isUserPresent(User user);
	
	public int findByUsername(String username);

}
