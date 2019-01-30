package br.com.invillia.api.store;

public class StoreNotFoundException extends RuntimeException {

	public StoreNotFoundException(Long id) {
		super("Could not find store " + id);
	}
}