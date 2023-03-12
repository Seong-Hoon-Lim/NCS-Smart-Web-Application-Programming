package com.kudangtang.jvx400.banking.service;

import java.util.ArrayList;
import java.util.List;

import com.kudangtang.jvx400.banking.dao.MemberDao;
import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	public MemberServiceImpl(DataSource dataSource) {
		memberDao = new MemberDao(dataSource);
	}

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
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
		memberDao.saveMember(member);

	}

	@Override
	public Member loginMember(String userId) {
		// TODO Auto-generated method stub
		Member member = new Member();
		member = memberDao.findMemberByUserId(userId);
		return member;
	}

	@Override
	public void updateMemberInfo(MemberDto member) {
		// TODO Auto-generated method stub
		member = new MemberDto();
		memberDao.updateMember(member);
	}

	@Override
	public List<Member> membersFindList() {
		List<Member> list = new ArrayList<>();
		// TODO Auto-generated method stub
		return list;
	}

}
