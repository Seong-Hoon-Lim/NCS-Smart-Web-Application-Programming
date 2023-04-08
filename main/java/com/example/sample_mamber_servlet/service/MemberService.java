package com.example.sample_mamber_servlet.service;

import com.example.sample_mamber_servlet.dao.MemberDAO;
import com.example.sample_mamber_servlet.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
public class MemberService {
    //MemberDAO 의 객체를 가져옴 (새로 생성하지 않음)
    MemberDAO memberDAO = MemberDAO.getInstance();

    public void isExistId(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {

        log.info("isExistId()...");
        String id = request.getParameter("id");
        response.getWriter().print("{\"result\":\"");

            if (memberDAO.isExistId(id)) {
                response.getWriter().print("true");
            }
            else {
                response.getWriter().print("false");
            }
        response.getWriter().print("\"}");
    }

    /* 회원가입 처리 */
    public boolean addMember(HttpServletRequest request) throws Exception {

        MemberDTO memberDTO = new MemberDTO();

         memberDTO.setId(request.getParameter("id"));
         memberDTO.setPassword(request.getParameter("password"));
         memberDTO.setName(request.getParameter("name"));
         memberDTO.setGender(request.getParameter("gender"));

        String year = request.getParameter("birthyy");
        String month = request.getParameterValues("birthmm")[0];
        String day = request.getParameter("birthdd");
         memberDTO.setBirth(year + "/" + month + "/" + day);

        String mail1 = request.getParameter("mail1");
        String mail2 = request.getParameterValues("mail2")[0];
         memberDTO.setMail(mail1 + "@" + mail2);

         memberDTO.setPhone(request.getParameter("phone"));
         memberDTO.setZipcode(request.getParameter("zipcode"));
         memberDTO.setAddress01(request.getParameter("address01"));
         memberDTO.setAddress02(request.getParameter("address02"));

        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
        String registerDay = formatter.format(new java.util.Date());

        memberDTO.setRegistDay(registerDay);

         return memberDAO.saveMember(memberDTO);

    }

    public boolean loginMember(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        log.info("loginMember()...");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name;
        if (memberDAO.findMemberByIdPassword(id ,password)) {
            name = memberDAO.getNameById(id);   //DB에서 name 가져와서 session 에 전달하는 역할
            request.getSession().setAttribute("sessionMemberId", id);
            request.getSession().setAttribute("sessionMemberName", name);

            return true;
        }
        else {
            return false;
        }
    }

    /* 로그아웃 처리 */
    public void logoutMember(HttpServletRequest request) {
        request.getSession().invalidate();
    }

//    /* 회원정보 수정 처리 */
//    public MemberDTO getMemberById(HttpServletRequest request)
//            throws SQLException, ClassNotFoundException {
//        String id = (String) request.getSession().getAttribute("sessionMemberId");
//        return memberDAO.findMemberById(id);
//    }

//    public boolean updateMember(HttpServletRequest request)
//            throws SQLException, ClassNotFoundException {
//
//        MemberDTO memberDTO = new MemberDTO();
//        String id = (String) request.getSession().getAttribute("sessionMemberId");
//
//        memberDTO.setId(id);
//        memberDTO.setPassword(request.getParameter("password"));
//        memberDTO.setName(request.getParameter("name"));
//        memberDTO.setGender(request.getParameter("gender"));
//
//        String year = request.getParameter("birthyy");
//        String month = request.getParameterValues("birthmm")[0];
//        String day = request.getParameter("birthdd");
//        memberDTO.setBirth(year + "/" + month + "/" + day);
//
//        String mail1 = request.getParameter("mail1");
//        String mail2 = request.getParameterValues("mail2")[0];
//        memberDTO.setMail(mail1 + "@" + mail2);
//
//        memberDTO.setPhone(request.getParameter("phone"));
//        memberDTO.setAddress(request.getParameter("address"));
//
//        return memberDAO.updateMember(memberDTO);
//
//    }
}
