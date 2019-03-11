package br.com.invillia.impl.service;

import br.com.invillia.api.security.Role;
import br.com.invillia.api.security.User;
import br.com.invillia.api.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
	
	//username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final User user = new User(userUsername, "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, Arrays.asList(Role.ROLE_USER));
	
	//username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername, "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, Arrays.asList(Role.ROLE_ADMIN));
	
	public User findByUsername(String username) {
		if (username.equals(userUsername)) {
			return user;
		} else if (username.equals(adminUsername)) {
			return admin;
		} else {
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return this.findByUsername(s);
	}
}