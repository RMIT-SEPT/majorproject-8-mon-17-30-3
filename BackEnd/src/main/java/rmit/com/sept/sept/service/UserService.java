package rmit.com.sept.sept.service;

import rmit.com.sept.sept.User;
import rmit.com.sept.sept.repository.UserRepository;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean isUserPresent(int id);
	
	public int findByUsername(String username);

	public UserRepository getUserRepository();
}
