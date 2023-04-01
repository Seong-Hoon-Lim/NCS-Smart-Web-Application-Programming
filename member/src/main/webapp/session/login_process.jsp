<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("id");
        String userPw = request.getParameter("password");

        if (userId.equals("admin") && userPw.equals("admin1234")) {
            session.setAttribute("userId", userId);
            System.out.println("session create success!");
            response.sendRedirect("page_01.jsp");
        }
        else {
            System.out.println("session create fail!");
            response.sendRedirect("login.jsp");
        }

    %>
