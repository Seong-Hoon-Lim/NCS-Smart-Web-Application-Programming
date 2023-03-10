package com.kudangtang.jvx400.banking.service;

import java.util.ArrayList;
import java.util.List;

import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;
import com.kudangtang.jvx400.banking.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public MemberServiceImpl(DataSource dataSource) {
		memberRepository = new MemberRepository(dataSource);
	}

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public MemberServiceImpl() {
		
	}

	/**
	 * Member 회원가입 기능
	 * @param member
	 */
	@Override
	public void signupMember(MemberDto member) {
		// TODO Auto-generated method stub
		memberRepository.addMember(member);

	}

	@Override
	public Member loginMember(String userId) {
		// TODO Auto-generated method stub
		Member member = new Member();
		member = memberRepository.findMemberByUserId(userId);
		return member;
	}

	@Override
	public MemberDto myPage(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> membersFindList() {
		List<Member> list = new ArrayList<>();
		// TODO Auto-generated method stub
		return list;
	}

}
