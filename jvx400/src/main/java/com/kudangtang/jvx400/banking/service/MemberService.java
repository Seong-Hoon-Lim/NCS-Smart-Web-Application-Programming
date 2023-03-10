package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;

public interface MemberService {

	/**
	 * Member 회원가입 기능
	 * @param member
	 */
	public void signupMember(MemberDto member);
	
	public Member loginMember(String userId);
	
	public MemberDto myPage(String email);
	
	public List<Member> membersFindList();

}
