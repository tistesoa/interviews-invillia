/*
package br.com.invillia.impl.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Mono<Void> save(ServerWebExchange swe, SecurityContext sc) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Mono<SecurityContext> load(ServerWebExchange swe) {
		ServerHttpRequest request = swe.getRequest();
		String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String authToken = authHeader.substring(7);
			Authentication auth = new UsernamePasswordAuthenticationToken(authToken, authToken);
			return this.authenticationManager.authenticate(auth).map((authentication) -> {
				return new SecurityContextImpl(authentication);
			});
		} else {
			return Mono.empty();
		}
	}
	
}*/
