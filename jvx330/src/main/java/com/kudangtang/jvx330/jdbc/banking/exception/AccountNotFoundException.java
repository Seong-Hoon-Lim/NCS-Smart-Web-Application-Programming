package com.kudangtang.jvx330.jdbc.banking.exception;

public class AccountNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 5007978391756107446L;

	public AccountNotFoundException(String msg) {
		super(msg);
	}
}
