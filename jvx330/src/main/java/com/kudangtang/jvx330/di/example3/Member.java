package com.kudangtang.jvx330.di.example3;

public class Member {
	private String userId;
	private String name;

	public Member(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", name=" + name + "]";
	}
		
}
