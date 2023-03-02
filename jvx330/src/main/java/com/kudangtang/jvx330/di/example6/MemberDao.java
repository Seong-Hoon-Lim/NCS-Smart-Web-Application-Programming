package com.kudangtang.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("memberDao")
public class MemberDao {
	private List<Member> memberList = new ArrayList<>();
	
	public MemberDao() {
		System.out.println("������ ȣ��");
	}
	
	//bean �� ������� �� �ڵ����� ���� �ǵ��� �ϴ� ����
	@PostConstruct
	public void initMemberList() {
		memberList.add(new Member("����"));
		memberList.add(new Member("����"));
		memberList.add(new Member("���"));		
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}
}
