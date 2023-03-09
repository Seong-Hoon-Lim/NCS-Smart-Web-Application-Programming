package com.kudangtang.jvx400.banking.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavingsAccount extends Account {
	private double interestRate;	

	public SavingsAccount(String accountNum, double balance, double rate) {
		super(accountNum, balance);
		this.interestRate = rate;
	}
	
}
