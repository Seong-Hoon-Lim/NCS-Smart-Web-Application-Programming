package com.kudangtang.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class AddCustomerDataSourceDao {
	private DataSource dataSource;
	
	public AddCustomerDataSourceDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)" 
					+ " VALUES (?, ?, ?, ?, ?)";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			pstmt.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
