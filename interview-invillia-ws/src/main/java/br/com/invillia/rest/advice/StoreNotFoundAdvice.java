package br.com.invillia.rest.advice;

import br.com.invillia.api.store.StoreNotFoundException;
import br.com.invillia.api.store.entity.Store;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class StoreNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(StoreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String storeNotFoundHandler(StoreNotFoundException ex) {
		return ex.getMessage();
	}
}