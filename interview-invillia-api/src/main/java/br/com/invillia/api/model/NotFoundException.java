package br.com.invillia.api.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class NotFoundException extends ResponseStatusException {

	public NotFoundException(String msg) {
		super(HttpStatus.NOT_FOUND,msg);
	}
}