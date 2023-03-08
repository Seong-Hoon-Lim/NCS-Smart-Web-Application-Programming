package com.kudangtang.jvx350.mvc.example3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController")	//Bean 의 이름이 중복되더라도 다르게 인식하도록 해줌
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
	@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) {
		//스프링에서 HttpServletRequest 를 주입해줌
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example3/login_result");
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);		
		return mav;
	}
	
	@PostMapping("/example3/login2")
	public ModelAndView login2(@RequestParam(value = "userId") String id,
							   @RequestParam String passwd) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example3/login_result");
		mav.addObject("userId", id);
		mav.addObject("passwd", passwd);		
		return mav;
	}
	
	@PostMapping("/example3/login3")
	public ModelAndView login3(@RequestParam Map<String, String> param) {
		param.entrySet().forEach(m -> 
						System.out.println(m.getKey() + ":" + m.getValue()));
		ModelAndView mav = new ModelAndView();
		for(String key : param.keySet()) {
			mav.addObject(key, param.get(key));
		}
		mav.setViewName("example3/login_result");
		return mav;
	
	}

}
