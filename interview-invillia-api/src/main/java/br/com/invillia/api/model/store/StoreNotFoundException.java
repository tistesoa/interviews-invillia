package br.com.invillia.api.model.store;

import br.com.invillia.api.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StoreNotFoundException extends ResponseStatusException {

	public StoreNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND,"Could not find store " + id);
	}
}