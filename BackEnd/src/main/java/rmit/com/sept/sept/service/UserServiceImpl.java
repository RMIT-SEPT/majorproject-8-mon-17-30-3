package rmit.com.sept.sept.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rmit.com.sept.sept.Role;
import rmit.com.sept.sept.User;
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
	
	private int sessionUserID;
	
	@Override
	public void saveUser(User user) {
//		System.out.println("Dd"+getSessionUserID());
//		setSessionUserID(user.getId());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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



	
}
