package com.kudangtang.jvx350.mvc.example5;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountCommand {
	private String accountNum;
	private double balance;
	private String accountType;
	private Date openDate;
	private CustomerCommand customer;
	
	public AccountCommand() {
		
	}

}
