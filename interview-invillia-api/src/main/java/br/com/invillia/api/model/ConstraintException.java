package br.com.invillia.api.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class ConstraintException extends ResponseStatusException {

	public ConstraintException(String msg) {
		super(HttpStatus.BAD_REQUEST,msg);
	}
}