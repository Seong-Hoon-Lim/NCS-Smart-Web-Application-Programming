<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("id");
        String userPw = request.getParameter("password");

        if (userId.equals("admin") && userPw.equals("admin1234")) {
           session.setAttribute("userId", userId);
           response.sendRedirect("sessionWelcome.jsp");
        }
        else {
            System.out.println("세션 생성에 실패하였습니다");
            response.sendRedirect("sessionLogin.jsp");
        }

    %>
