package br.com.invillia.api.model.order.exception;

import br.com.invillia.api.exception.NotFoundException;

public class OrderNotFoundException extends NotFoundException {

	public OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}
}