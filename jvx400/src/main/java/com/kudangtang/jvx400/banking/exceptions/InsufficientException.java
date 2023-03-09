package com.kudangtang.jvx400.banking.exceptions;

@SuppressWarnings("serial")
public class InsufficientException extends Exception {
//	private static final long serialVersionUID = 6968351825481954463L;

	public InsufficientException(String msg) {
		super(msg);
	}
}
