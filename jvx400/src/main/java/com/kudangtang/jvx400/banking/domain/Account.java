package com.kudangtang.jvx400.banking.domain;

import com.kudangtang.jvx400.banking.dto.AccountNumberGenerator;
import com.kudangtang.jvx400.banking.exceptions.InsufficientException;
import com.kudangtang.jvx400.banking.exceptions.OverdraftException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private long aid;
	protected String accountNum;
	protected double balance;
	private double interestRate;
	private double overAmount;
	private String accountType;
	private String regDate;
	private Member member;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public Account(double balance) {
		this.balance = balance;
	}
	
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
		accountNum = (AccountNumberGenerator.generateAccountNum());
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientException, OverdraftException {
		if (balance >= amount) {
			this.balance -= amount;
		}
		else {
			throw new InsufficientException("잔고가 부족합니다. 현재 잔고는 " + balance + "원 입니다");
		}
	}
	
	
	
	

}
