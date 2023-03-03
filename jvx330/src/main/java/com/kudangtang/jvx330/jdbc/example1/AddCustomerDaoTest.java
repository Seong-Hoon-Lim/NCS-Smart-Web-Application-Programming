package com.kudangtang.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class AddCustomerDaoTest {
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(Example1Config.class);
		AddCustomerDao dao = 
				context.getBean("addCustomerDao", AddCustomerDao.class);
		
//		addCustomer(dao);
		addCustomer2(dao);
		context.close();
		
	}
	
	public static void addCustomer(AddCustomerDao dao) {
		Customer customer = new Customer();
		customer.setEmail("kwanwu@java.com");
		customer.setPasswd("1111");
		customer.setName("관우");
		customer.setSsn("820122-1234567");
		customer.setPhone("010-5599-8899");
		
		dao.addCustomer(customer);
		System.out.println("insert ok....");		
	}
	
	public static void addCustomer2(AddCustomerDao dao) {
		Customer customer = new Customer();
		customer.setEmail("jangbi@java.com");
		customer.setPasswd("1111");
		customer.setName("장비");
		customer.setSsn("851122-1234567");
		customer.setPhone("010-6688-8999");
		
		dao.addCustomer(customer);
		System.out.println("insert ok....");		
	}
}
