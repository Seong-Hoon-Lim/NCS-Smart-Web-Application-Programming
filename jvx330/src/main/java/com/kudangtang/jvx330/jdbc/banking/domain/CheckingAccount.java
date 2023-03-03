package com.kudangtang.jvx330.jdbc.banking.domain;

public class CheckingAccount extends Account{
	private double overdraftProtection;

	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNum, double balance, double interestRate, double overdraft, char accountType, Long customerId) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.customerId = customerId;
	}
	
	public CheckingAccount(String accountNum, double initBalance, double protect){
		super(accountNum, initBalance);
		this.overdraftProtection = protect;
	}
	
	public void withdraw(double amount) {

		if(balance - amount < 0){
			double overdraftNeeded = amount - balance;
			
			if (overdraftProtection < overdraftNeeded) {
				//System.out.println("(�뿉�윭-�븳�룄�븸珥덇낵)�옍怨� : " + balance);
//				throw new OverdraftException("(�븳�룄�븸 珥덇낵) �옍怨� : " + balance);
			} else {
				balance = overdraftNeeded * -1.0;
				overdraftProtection = overdraftProtection - overdraftNeeded;
				System.out.println("�옍�뿬 ���썡�븸 : " + (overdraftProtection));
			}
		}else{
			balance -= amount;
			System.out.println("�옍怨� : " + balance);
		}
	}

	public double getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(double overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}

	@Override
	public String toString() {
		return "CheckingAccount [accountNum=" + accountNum + ", balance=" 
				+ balance + ", overdraftProtection=" + overdraftProtection + "]";
	}
	
	
}
