package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.dto.AccountDto;

public interface AccountService {
	
	public void addAccount(AccountDto account);
	
	public void withDraw(AccountDto account, double amount);
	
	public List<AccountDto> findAllAccounts();
	
	public List<AccountDto> findMyAccount(String email);
	
	public void removeAccount(String email);
	
}
