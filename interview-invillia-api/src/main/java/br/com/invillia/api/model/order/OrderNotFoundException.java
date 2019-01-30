package br.com.invillia.api.model.order;

import br.com.invillia.api.model.NotFoundException;

public class OrderNotFoundException extends NotFoundException {

	public OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}
}