package com.kudangtang.jvx400.banking.controller;

import com.kudangtang.jvx400.banking.service.MemberServiceImpl;
import com.kudangtang.jvx400.banking.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping("/member/register")
    public String signupMember(Member member, Model model) {
        model.addAttribute("member", member);
        memberService = new MemberServiceImpl();
        memberService.signupMember(member);
        return "member/register";
    }

    @PostMapping("/member/welcome")
    public String signSucceed(Member member, Model model) {
        model.addAttribute("member", member);
        return "member/welcome";
    }

}
