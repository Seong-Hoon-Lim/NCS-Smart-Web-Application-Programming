package com.kudangtang.jvx400.banking.vo;

import com.kudangtang.jvx400.banking.exceptions.OverdraftException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account {
private double overdraftProtection;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNum, double initBalance, double protect) {
		super(accountNum, initBalance);
		this.overdraftProtection = protect;
	}
	
	@Override
	public void withdraw(double amount) throws OverdraftException {

//		overdraftNeeded -> 마이너스금액
//		overdraftProtection -> 마이너스통장

		if (balance - amount < 0) {
			double overdraftNeeded = amount - balance;

			if (overdraftProtection < overdraftNeeded) {
				throw new OverdraftException("(한도액 초과) 잔고 : " + balance);
			} else {
				balance = overdraftNeeded * -1.0;
				overdraftProtection = overdraftProtection - overdraftNeeded;
				System.out.println("잔여 대월액 : " + (overdraftProtection));
			}
		} else {
			balance -= amount;
			System.out.println("잔고 : " + balance);
		}
		
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [accountNum=" + accountNum + ", balance=" + balance + ", overdraftProtection="
				+ overdraftProtection + "]";
	}
}
