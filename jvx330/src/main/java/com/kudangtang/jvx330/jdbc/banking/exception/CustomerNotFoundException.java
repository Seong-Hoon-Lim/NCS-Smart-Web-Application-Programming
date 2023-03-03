package com.kudangtang.jvx330.jdbc.banking.exception;

public class CustomerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -6993092229839716631L;

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
