package com.kudangtang.jvx330.jdbc.example5;

import javax.sql.DataSource;
import static java.sql.Types.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kudangtang.jvx330.jdbc.banking.domain.Account;
import com.kudangtang.jvx330.jdbc.banking.domain.CheckingAccount;
import com.kudangtang.jvx330.jdbc.banking.domain.SavingsAccount;

@Component
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);		
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (accountNum, accType, balance, interestRate, overAmount, customerId) " 
					+ " VALUES(?,?,?,?,?,?)";
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		
		int[] types = new int[] {VARCHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		if (account instanceof SavingsAccount) {
			sa = (SavingsAccount)account;
			args = new Object[] {sa.getAccountNum(), String.valueOf(sa.getAccountType()),
								 sa.getBalance(), sa.getInterestRate(), 0.0, 
								 sa.getCustomer().getCid()};
		}
		else {
			ca = (CheckingAccount)account;
			args = new Object[] {ca.getAccountNum(), String.valueOf(ca.getAccountType()),
					 ca.getBalance(), 0.0, ca.getOverdraftAmount(), 
					 ca.getCustomer().getCid()};
		}
		jdbcTemplate.update(sql, args, types);
		
	}

}
