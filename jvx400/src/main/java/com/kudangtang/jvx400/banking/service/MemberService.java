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

	/**
	 * Member 로그인 기능
	 * @param userId
	 * @return
	 */
	public Member loginMember(String userId);

	/**
	 * 마이페이지 회원정보 수정 기능
	 * @param member
	 */
	public void updateMemberInfo(MemberDto member);
	
	public List<Member> membersFindList();

}
