package com.kudangtang.jvx330.jdbc.banking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	private Long cid;
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private String regDate;
	
}
