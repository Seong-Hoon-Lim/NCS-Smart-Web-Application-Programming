package com.kudangtang.jvx330.jdbc.example3;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"),
				rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"),
				rs.getString("phone"), rs.getTimestamp("regDate"));
		return customer;
	}
	
}
