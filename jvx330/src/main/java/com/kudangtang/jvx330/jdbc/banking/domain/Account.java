package com.kudangtang.jvx330.jdbc.banking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
	private Long aid;
	protected String accountNum;
	protected double balance;
	protected double interestRate;
	protected double overdraft;
	protected char accountType;
	private Customer customer;
	protected long customerId;
	
	public Account(double balance) {
		
	}
	
	public Account(String accountNum, double balance) {
		
	}
	
	public Account(String accountNum, double balance, double interestRate, double overdraft, char accountType, Long customerId) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.customerId = customerId;
		
	}	
}
