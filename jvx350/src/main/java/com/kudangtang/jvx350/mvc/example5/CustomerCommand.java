package com.kudangtang.jvx350.mvc.example5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCommand {
	private String email;
	private String email1;
	private String email2 = "naver.com";
	
	private String passwd;
	private String name;
	
	private String ssn;
	private String ssn1;
	private String ssn2;
	
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	
	public CustomerCommand() {
		
	}
	
	public CustomerCommand(String name) {
		this.name = name;
	}
	
}
