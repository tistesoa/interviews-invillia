package br.com.invillia.api.model;

public abstract class ConstraintException extends RuntimeException {

	public ConstraintException(String msg) {
		super(msg);
	}
}