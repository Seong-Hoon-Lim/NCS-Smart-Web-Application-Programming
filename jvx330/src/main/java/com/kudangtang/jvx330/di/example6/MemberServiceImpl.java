package com.kudangtang.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		
		return memberDao.getMemberList();
	}
	
}
