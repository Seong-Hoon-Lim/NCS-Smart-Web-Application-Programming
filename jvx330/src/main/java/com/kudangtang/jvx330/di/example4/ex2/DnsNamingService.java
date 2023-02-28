package com.kudangtang.jvx330.di.example4.ex2;

public class DnsNamingService implements NamingService {

	@Override
	public Object lookup(String name) {
		// TODO Auto-generated method stub
		return "DNS: " + name;
	}
	
}
