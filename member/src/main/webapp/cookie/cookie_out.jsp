<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
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
        response.sendRedirect("cookieLogin.jsp");
    %>
</body>
</html>
