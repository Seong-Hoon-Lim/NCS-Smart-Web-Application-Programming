<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>

    <%
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("id");
        String userPw = request.getParameter("password");

        if (userId.equals("admin") && userPw.equals("admin1234")) {
            Cookie cookieId = new Cookie("userId", userId);

            response.addCookie(cookieId);
            System.out.println("쿠키 생성이 성공했습니다.");
            response.sendRedirect("cookieWelcome.jsp");
        }
        else {
            System.out.println("쿠키 생성이 실패했습니다.");
            response.sendRedirect("cookieLogin.jsp");
        }
    %>

</body>
</html>
