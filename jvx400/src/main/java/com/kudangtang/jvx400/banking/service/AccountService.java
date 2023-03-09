package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.vo.Account;

public interface AccountService {
	
	public void addAccount(Account account);
	
	public void withDraw(Account account, double amount);
	
	public List<Account> findAllAccounts();
	
	public List<Account> findMyAccount(String email);
	
	public void removeAccount(String email);
	
}
