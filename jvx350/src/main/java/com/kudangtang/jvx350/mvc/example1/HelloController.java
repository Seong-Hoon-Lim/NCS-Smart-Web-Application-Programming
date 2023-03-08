package com.kudangtang.jvx350.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller은 Handler Bean의 역할
 * ModelAndView 는 어떤것을 보여주고 어디로 보낼지를 지정
 * @author "SHoon"
 *
 */
@Controller
public class HelloController {
	
	@GetMapping("example1/say-hello")
	public ModelAndView sayHello() {
		String greeting = "Hello! 스프링 MVC";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello");
		mav.addObject("greeting", greeting);
		
		return mav;
	}

}

/*
 * request.setAttribute("greeting", greeting);
 * request.getRequestDispatcher("example1/hello.jsp).forward(request, response);
 */
