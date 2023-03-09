package com.kudangtang.jvx400.banking.service;

import java.util.List;

import com.kudangtang.jvx400.banking.dao.MemberDao;
import com.kudangtang.jvx400.banking.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Component("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	public MemberServiceImpl(DataSource dataSource) {
		memberDao = new MemberDao(dataSource);
	}

	public MemberServiceImpl() {

	}

	/**
	 * Member 회원가입 기능
	 * @param member
	 */
	@Override
	public void signupMember(Member member) {
		// TODO Auto-generated method stub
		memberDao.addMember(member);

	}

	@Override
	public Member loginMember(String email, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member myPage(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> membersFindList() {
		// TODO Auto-generated method stub
		return null;
	}

}
