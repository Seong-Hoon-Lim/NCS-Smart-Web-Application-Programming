package com.kudangtang.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;



public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
		
	public CustomerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"),
								rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
								rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		});
	}
	
	public List<Customer> findCustomersByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
						+ " WHERE DATE(regDate) = ?";	//DATE 는 MySQL 에서 사용되는 함수로 날짜만 표기되도록 해줌
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"),
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
						rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		}, regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
					+ " WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"),
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
						rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		}, email);
				
	}
	
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer" 
				+ " WHERE ssn = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"),
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
						rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		}, ssn);
	}
	
	public long countCustomers() {
		String sql = "SELECT COUNT(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
				
	}
}
