package com.kudangtang.jvx330.di.example4.ex1;

public class ByNameClient {
	private NamingService namingService;
	
	public NamingService getJNamingService() {
		return namingService;
	}
	
	public void setJmsNamingSerivce(NamingService namingService) {
		this.namingService = namingService;
	}
	
	public void service(String name) {
		Object o = namingService.lookup(name);
		System.out.println(o);
	}
	
}
