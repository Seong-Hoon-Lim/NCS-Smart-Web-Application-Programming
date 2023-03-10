package com.kudangtang.jvx400.banking.domain;

import com.kudangtang.jvx400.banking.dto.AccountDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavingsAccount extends AccountDto {
	private double interestRate;	

	public SavingsAccount(String accountNum, double balance, double rate) {
		super(accountNum, balance);
		this.interestRate = rate;
	}
	
}
