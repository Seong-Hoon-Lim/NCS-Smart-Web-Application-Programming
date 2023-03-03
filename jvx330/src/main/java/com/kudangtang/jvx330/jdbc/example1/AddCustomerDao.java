package com.kudangtang.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class AddCustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public AddCustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * DB에 데이터를 등록하면서 keyHolder 를 동시에 받아낼 수 있는 방식
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)" 
				+ " VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
						throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				return pstmt;
			}
		});
	}
	
	/**
	 * keyHolder 를 받아낼 수 없고 순수하게 DB에 데이터만 등록하는 방식
	 * @param customer
	 */
	public void addCustomer2(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)" 
				+ " VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(),
						customer.getName(), customer.getSsn(), customer.getPasswd());
		
	}
}
