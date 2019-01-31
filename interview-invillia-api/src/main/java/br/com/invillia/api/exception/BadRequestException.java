package br.com.invillia.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class BadRequestException extends ResponseStatusException {

	public BadRequestException(String msg) {
		super(HttpStatus.BAD_REQUEST,msg);
	}
}