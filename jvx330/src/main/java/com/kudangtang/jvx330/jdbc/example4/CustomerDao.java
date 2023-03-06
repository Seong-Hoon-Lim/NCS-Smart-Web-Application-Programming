package com.kudangtang.jvx330.jdbc.example4;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;


public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		//MySQL 테이블의 칼럼명 과 Bean 의 프라퍼티의 이름만 같으면 자동으로 스프링에서 매핑 시켜줌
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));		
	}
	
	public List<Customer> findCustomersByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
				+ " WHERE DATE(regDate) = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
				+ " WHERE email = ?";
		
	return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email);
			
	}
	
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
				+ " WHERE ssn = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), ssn);
	}
	
	public long countCustomers() {
		String sql = "SELECT COUNT(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
				
	}

}
