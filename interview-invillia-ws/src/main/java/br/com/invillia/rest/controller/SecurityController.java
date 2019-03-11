package br.com.invillia.rest.controller;

import br.com.invillia.api.security.User;
import br.com.invillia.api.service.UserService;
import br.com.invillia.api.util.PBKDF2Encoder;
import br.com.invillia.rest.dto.AuthRequest;
import br.com.invillia.rest.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

//    @Autowired
//    private JWTUtil jwtUtil;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private PBKDF2Encoder passwordEncoder;

    @Autowired
    private UserService userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequest ar) {
        User byUsername = userRepository.findByUsername(ar.getUsername());
        if (passwordEncoder.encode(ar.getPassword()).equals(byUsername.getPassword())) {
            return ResponseEntity.ok(new AuthResponse(passwordEncoder.encode(byUsername.getPassword())));
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}