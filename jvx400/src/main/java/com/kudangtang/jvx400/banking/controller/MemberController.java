package com.kudangtang.jvx400.banking.controller;

import com.kudangtang.jvx400.banking.domain.Member;
import com.kudangtang.jvx400.banking.dto.MemberDto;
import com.kudangtang.jvx400.banking.service.MemberServiceImpl;
import com.kudangtang.jvx400.config.EmailProvider;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController { 
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	public MemberController(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	/*
	 * 회원가입
	 */
    @GetMapping("/signup")
    public String signupMember(Model model) {    	
        model.addAttribute("member", new MemberDto());
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signSucceed(MemberDto member, Model model) {
    	member.setEmail(member.getEmail1() + "@" + member.getEmail2());
    	member.setSsn(member.getSsn1() + "-" + member.getSsn2());
    	member.setPhone(member.getPhone1() + "-" + member.getPhone2() 
										   + "-" + member.getPhone3());
        model.addAttribute("member", member);
        memberService.signupMember(member);
        return "member/welcome";
    }
    
    /*
     * 로그인
     */
    @GetMapping("/login")
    public String memberLoginForm(@ModelAttribute("loginForm") MemberController controller) {  
    	return "member/login";
    }
    
    @PostMapping("/login")
    public String memberLogin(Member member, @Validated @ModelAttribute MemberController controller, 
    			BindingResult bindingResult, HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	if (bindingResult.hasErrors()) {
    		return "member/login";
    	}
    	Member loginMember = memberService.loginMember(member.getUserId());
    	if (loginMember == null) {
    		bindingResult.reject("loginFail", "아이디가 맞지 않습니다.");
    		return "member/login";
    	}
    	else {
    		System.out.println(loginMember.toString());
    		model.addAttribute("member", loginMember);
    		session.setAttribute("loginMember", loginMember);
    		return "./index_logined";
    	}   	    	
    }
    
	/*
	 * 로그아웃
	 */
    @PostMapping("/logout")
    public String memberLogout(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	
    	return "redirect:/index";
    }
    
    /*
     * 마이페이지
     */
    @GetMapping("/mypage")
    public String membershipPage() {
    	return "member/mypage";
    }

	@PostMapping("/mypage")
	public String membershipInfo(Model model) {
		
		List<Member> members = new ArrayList<>();
    	model.addAttribute("members", members);
		return "member/mypage";
	}
	
	@PostMapping("/member_modify")
	public String updateMember() {
		
		return null;
	}
    
    @PostMapping("/mypage_modify")
	public String updateSucceed() {
    	
    	return null;
	}
    
    
    
    
    @ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<>();
		list.add(new EmailProvider("구글", "gmail.com"));
		list.add(new EmailProvider("네이버", "naver.com"));
		list.add(new EmailProvider("다음", "daum.com"));
		list.add(new EmailProvider("한메일", "hanmail.net"));
		list.add(new EmailProvider("네이트", "nate.com"));
		
		return list;			
	}		
	
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		List<String> list = new ArrayList<>();
		list.add("010");
		list.add("011");
		list.add("02");
		list.add("031");
		list.add("032");
		list.add("053");
		list.add("051");
		list.add("070");
		
		return list;
		
	}

}
