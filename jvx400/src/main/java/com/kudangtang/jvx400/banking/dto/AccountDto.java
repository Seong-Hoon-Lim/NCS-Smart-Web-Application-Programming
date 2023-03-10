package com.kudangtang.jvx400.banking.dto;

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
public class AccountDto {
	private long aid;
	protected String accountNum;
	protected double balance;
	private double interestRate;
	private double overAmount;
	private String accountType;
	private String regDate;
	private MemberDto member;
	
	public AccountDto(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public AccountDto(double balance) {
		this.balance = balance;
	}
	
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
		accountNum = (AccountNumberGenerator.accountNumberGenerate());
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
