//package br.com.invillia.rest.manager;
//
//import br.com.invillia.api.security.Role;
//import br.com.invillia.api.util.JWTUtil;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class AuthenticationJWTManager implements AuthenticationProvider {
//
//	@Autowired
//	private JWTUtil jwtUtil;
//
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException{
//		String authToken = authentication.getCredentials().toString();
//
//		String username;
//		try {
//			username = jwtUtil.getUsernameFromToken(authToken);
//		} catch (Exception e) {
//			username = null;
//		}
//		if (username != null && jwtUtil.validateToken(authToken)) {
//			Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
//			List<String> rolesMap = claims.get("role", List.class);
//			List<Role> roles = new ArrayList<>();
//			for (String rolemap : rolesMap) {
//				roles.add(Role.valueOf(rolemap));
//			}
//			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//				username,
//				null,
//				roles.stream().map(authority -> new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList())
//			);
//			return auth;
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public boolean supports(Class<?> aClass) {
//		return false;
//	}
//}