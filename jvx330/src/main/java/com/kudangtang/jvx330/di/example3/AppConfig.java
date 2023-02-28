package com.kudangtang.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	//bean name = "memberService" 을 의미
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	//bean name = "memberDao" 를 의미
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

}
