package com.kudangtang.jvx400.banking.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kudangtang.jvx400.banking.dao.AccountDao;
import com.kudangtang.jvx400.banking.dto.AccountDto;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Override
	public void addAccount(AccountDto account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withDraw(AccountDto account, double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountDto> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountDto> findMyAccount(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccount(String email) {
		// TODO Auto-generated method stub

	}

}
