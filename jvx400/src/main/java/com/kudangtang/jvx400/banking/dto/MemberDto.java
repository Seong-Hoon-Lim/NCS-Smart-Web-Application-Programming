package com.kudangtang.jvx400.banking.dto;

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
public class MemberDto {
	
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	
	private String ssn;
	private String ssn1;
	private String ssn2;
	
	private String email;
	private String email1;
	private String email2 = "gmail.com";
	
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	
	private String regDate;
	private List<AccountDto> accountList = new ArrayList<>();
	
	public MemberDto(String userId, String passwd, String name,
			String ssn, String email, String phone) {
		
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
	}

	public MemberDto(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	/**
	 * 고객 계좌 중복여부 확인 후 중복이 아닐 경우 계좌를 추가
	 * @param account
	 */
	public void addAccount(AccountDto account) {
		boolean validate = false;
		for (AccountDto act : accountList) {
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
