package com.kudangtang.jvx330.jdbc.example2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class CustomerDaoTest {
	public static CustomerDao dao = null;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
					new AnnotationConfigApplicationContext(Example2Config.class);
		
		dao = context.getBean("customerDao", CustomerDao.class);
//		findAllCustomers();
//		findCustomersByRegDate();
//		findCustomerByEmail();
		findCustomerBySsn();
		countCustomers();
		
		context.close();
	}
	
	public static void findAllCustomers() {
		List<Customer> list = dao.findAllCustomers();
		for (Customer c : list) {
			System.out.println(c);
		}
	}
	
	public static void findCustomersByRegDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date regDate = null;
		try {
			regDate = format.parse("2023-03-03");
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomersByRegDate(regDate);
		for (Customer c : list) {
			System.out.println(c);
		}
	}
	
	public static void findCustomerByEmail() {
		System.out.println(dao.findCustomerByEmail("jojo@java.com"));
	}
	
	public static void findCustomerBySsn() {
		System.out.println(dao.findCustomerBySsn("820122-1234567"));
	}
	
	public static void countCustomers() {
		long count = dao.countCustomers();
		System.out.println(count);
	}
}
