<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
    <h3>입력에 성공했습니다.</h3>
    <%
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("id");
        String userPw = request.getParameter("password");

        if (userId.equals("admin") && userPw.equals("admin1234")) {
            Cookie cookieId = new Cookie("userId", userId);

            response.addCookie(cookieId);
            response.sendRedirect("cookieWelcome.jsp");
        }
        else {
            response.sendRedirect("cookieLogin.jsp");
        }
    %>

</body>
</html>
