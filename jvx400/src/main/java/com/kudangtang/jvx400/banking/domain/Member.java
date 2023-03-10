package com.kudangtang.jvx400.banking.domain;

import java.sql.Timestamp;
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
	private String userId;
	private String passwd;
	private String name;	
	private String ssn;	
	private String email;	
	private String phone;	
	private Timestamp regDate;
	private List<Account> accountList = new ArrayList<>();
	
	public Member(long cid, String userId, String passwd, String name, String ssn, String email, String phone,
			Timestamp regDate) {
		super();
		this.cid = cid;
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.regDate = regDate;
	}
	
	public Member(String userId, String passwd, String name,
			String ssn, String email, String phone) {
		
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.email = email;
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
