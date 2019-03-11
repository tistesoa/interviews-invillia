package br.com.invillia.api.service;

import br.com.invillia.api.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
}
