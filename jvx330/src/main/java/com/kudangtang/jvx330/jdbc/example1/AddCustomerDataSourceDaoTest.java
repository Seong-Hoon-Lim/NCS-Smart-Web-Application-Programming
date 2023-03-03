package com.kudangtang.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.kudangtang.jvx330.jdbc.banking.domain.Customer;

public class AddCustomerDataSourceDaoTest {
	public static void main(String[] args) {
		GenericApplicationContext context = 
						new AnnotationConfigApplicationContext(Example1Config.class);
		AddCustomerDataSourceDao dao = 
						context.getBean("addCustomerDataSourceDao", AddCustomerDataSourceDao.class);
		Customer customer = new Customer();
		customer.setEmail("yubi@java.com");
		customer.setPasswd("1111");
		customer.setName("유비");
		customer.setSsn("801111-1234567");
		customer.setPhone("010-5599-8888");
		dao.addCustomer(customer);
		System.out.println("insert ok....");
		context.close();
	}
}
