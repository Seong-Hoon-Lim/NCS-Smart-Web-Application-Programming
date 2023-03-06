package com.kudangtang.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;
import com.kudangtang.jvx330.jdbc.banking.domain.SavingsAccount;

public class AccountDaoTest {
	private static AccountDao dao;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Example5Config.class);
		dao = context.getBean("accountDao", AccountDao.class);
		
		addSavingsAccount();
		
		context.close();
	}
	
	public static void addSavingsAccount() {
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNum("111-11-1111");
		sa.setAccountType('S');
		sa.setBalance(1000.0);
		sa.setInterestRate(0.03);
		sa.setCustomer(new Customer(1002));
		dao.addAccount(sa);
		System.out.println("completed......");
	}

}
