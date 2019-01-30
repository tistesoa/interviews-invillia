package br.com.invillia.api.model;

public abstract class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super(msg);
	}
}