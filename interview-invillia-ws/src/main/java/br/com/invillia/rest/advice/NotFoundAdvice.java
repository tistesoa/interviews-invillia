package br.com.invillia.rest.advice;

import br.com.invillia.api.model.NotFoundException;
import br.com.invillia.api.model.store.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(StoreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String notFoundHandler(NotFoundException ex) {

	    return ex.getMessage();
	}
}