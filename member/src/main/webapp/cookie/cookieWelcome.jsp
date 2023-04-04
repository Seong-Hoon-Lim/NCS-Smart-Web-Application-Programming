<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Welcome</title>
</head>
<body>
    <%

        Cookie[] cookies = request.getCookies();
        String userId = null;

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().trim().equals("userId")) {
                userId = cookies[i].getValue();
                break;
            }
        }
        if (userId == null) {
            response.sendRedirect("cookieLogin.jsp");
        }
        else {
    %>
    <h3> <%=userId%>님 환영합니다.</h3>
    <%
        }
    %>
    <button><a href="cookie_out.jsp">로그아웃</a></button>
</body>
</html>
