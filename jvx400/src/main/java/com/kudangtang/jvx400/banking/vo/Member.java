package com.kudangtang.jvx400.banking.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private long cid;

	private String email;
	private String email1;
	private String email2 = "gmail.com";
	
	private String passwd;
	private String name;
	
	private String ssn;
	private String ssn1;
	private String ssn2;
	
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	
	private String regDate;
	private List<Account> accountList = new ArrayList<>();
	
	public Member(String email, String passwd, String name,
			String ssn, String phone) {
		
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}

	public Member(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	/**
	 * 고객 계좌 중복여부 확인 후 중복이 아닐 경우 계좌를 추가
	 * @param account
	 */
	public void addAccount(Account account) {
		boolean validate = false;
		for (Account act : accountList) {
			if (act.getAccountNum().equals(account.getAccountNum())) {
				validate = true;
				break;
			}
		}
		if(!validate) {
			accountList.add(account);
		}
	}
	
	

	
	
}
