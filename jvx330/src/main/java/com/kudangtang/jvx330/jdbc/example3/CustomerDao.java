package com.kudangtang.jvx330.jdbc.example3;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;



public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
		
	public CustomerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomersByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
						+ " WHERE DATE(regDate) = ?";	//DATE 는 MySQL 에서 사용되는 함수로 날짜만 표기되도록 해줌
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
					+ " WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), email);
				
	}
	
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
				+ " WHERE ssn = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), ssn);
	}
	
	public long countCustomers() {
		String sql = "SELECT COUNT(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
				
	}
}
