package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.vo.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withDraw(Account account, double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findMyAccount(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccount(String email) {
		// TODO Auto-generated method stub

	}

}
