package com.kudangtang.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("memberDao")
public class MemberDao {
	private List<Member> memberList = new ArrayList<>();
	
	public MemberDao() {
		System.out.println("생성자 호출");
	}
	
	//bean 이 만들어질 때 자동으로 실행 되도록 하는 역할
	@PostConstruct
	public void initMemberList() {
		memberList.add(new Member("유비"));
		memberList.add(new Member("관우"));
		memberList.add(new Member("장비"));		
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}
}
