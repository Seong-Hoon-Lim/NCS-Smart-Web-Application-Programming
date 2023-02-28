package com.kudangtang.jvx330.di.example4.ex2;

public class ByTypeClient {
	private NamingService namingService;
	
	public NamingService getJNamingService() {
		return namingService;
	}
	
	public void setNamingSerivce(NamingService namingService) {
		this.namingService = namingService;
	}
	
	public void service(String name) {
		Object o = namingService.lookup(name);
		System.out.println(o);
	}
	
}
