package com.example.sample_mamber_servlet.controller;

import com.example.sample_mamber_servlet.dto.MemberDTO;
import com.example.sample_mamber_servlet.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * controller 에서는 복잡한 로직을 처리 하지 않고
 * 페이지 노출 또는 post action 작업 처리 및 예외 처리만 진행
 * 복잡한 로직 처리는 service 에서 처리해야 유지보수가 쉬우며
 * 에러 발생 시 명확하게 구분이 가능
 */
@Log4j2
@WebServlet("/member/*")
public class MemberController extends HttpServlet {

    MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String RequestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String command = RequestURI.substring(contextPath.length());

        log.info("command: " + command);
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");

        switch (command) {
            case "/":
                log.info("welcome...");
                req.getRequestDispatcher("/main/welcome.jsp").forward(req, resp);
                break;
            case "/member/addMember":   //회원 가입 페이지 노출
                log.info("addMember...");
                req.getRequestDispatcher("/WEB-INF/template/member/addMember.jsp").forward(req, resp);
                break;
            case "/member/ajaxIdCheck": //아이디 중복 체크
                log.info("ajaxIdCheck...");
                try {
                    memberService.isExistId(req, resp);
                }
                catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/member/addMemberAction": //회원 가입 처리
                log.info("addMemberAction...");
                try {
                    if (memberService.addMember(req)) {
                        resp.sendRedirect("resultMember?msg=1");
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/member/loginMember":   //로그인 페이지 노출
                log.info("login...");
                req.getRequestDispatcher("/WEB-INF/template/member/loginMember.jsp").forward(req, resp);
                break;
            case "/member/loginAction":  //로그인 처리
                log.info("loginAction...");
                try {
                    if (memberService.loginMember(req)) {
                        resp.sendRedirect("resultMember?msg=2");
                    }
                    else {
                        resp.sendRedirect("loginMember?error=1");
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/member/resultMember":    //결과 페이지
                log.info("resultMember...");
                String param = req.getParameter("msg");
                req.getRequestDispatcher("/WEB-INF/template/member/resultMember.jsp?msg=" + param).forward(req, resp);
                break;
            case "/member/logoutAction": //로그아웃 처리
                log.info("logoutAction...");
                memberService.logoutMember(req);
                resp.sendRedirect("/member/loginMember");
                break;
//            case "/member/updateMember":    //회원정보 수정 페이지 노출
//                log.info("updateMember...");
//                try {
//                    MemberDTO memberDTO = memberService.getMemberById(req);
//                    log.info("memberDTO : " + memberDTO);
//                    req.setAttribute("member", memberDTO);
//                }
//                catch (SQLException | ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                req.getRequestDispatcher("/WEB-INF/template/member/updateMember.jsp").forward(req, resp);
//                break;
//            case "/member/updateMemberAction": //회원 가입 처리
//                log.info("updateMemberAction...");
//                try {
//                    if (memberService.updateMember(req)) {
//                        resp.sendRedirect("resultMember?msg=0");
//                    }
//                }
//                catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                break;

        }

    }
}
