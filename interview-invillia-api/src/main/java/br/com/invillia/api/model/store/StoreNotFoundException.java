package br.com.invillia.api.model.store;

import br.com.invillia.api.model.NotFoundException;

public class StoreNotFoundException extends NotFoundException {

	public StoreNotFoundException(Long id) {
		super("Could not find store " + id);
	}
}