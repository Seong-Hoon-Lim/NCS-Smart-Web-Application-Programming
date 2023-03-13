package com.kudangtang.jvx400.banking.dao;

import static java.sql.Types.BIGINT;
import static java.sql.Types.CHAR;
import static java.sql.Types.DOUBLE;
import static java.sql.Types.VARCHAR;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kudangtang.jvx400.banking.domain.CheckingAccount;
import com.kudangtang.jvx400.banking.domain.SavingsAccount;
import com.kudangtang.jvx400.banking.dto.AccountDto;

@Component
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(AccountDto account) {
		String sql = "INSERT INTO Account (accountNum, accType, balance, interestRate, overAmount, customerId)"
					+ " VALUES(?,?,?,?,?,?)";
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		
		int[] types = new int[] {VARCHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		if (account instanceof SavingsAccount) {
			sa = (SavingsAccount)account;
			args = new Object[] {sa.getAccountNum(), String.valueOf(sa.getAccountType()),
								 sa.getBalance(), sa.getInterestRate(), 0.0, 
								 sa.getMember().getCid()};
		}
		else {
			ca = (CheckingAccount)account;
			args = new Object[] {ca.getAccountNum(), String.valueOf(ca.getAccountType()),
					 ca.getBalance(), 0.0, ca.getOverAmount(), 
					 ca.getMember().getCid()};
		}
		jdbcTemplate.update(sql, args, types);
		
		
	}
	
}
