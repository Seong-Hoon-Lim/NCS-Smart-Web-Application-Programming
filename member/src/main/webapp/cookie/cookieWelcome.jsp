<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Welcome</title>
</head>
<body>
    <%

        boolean isLogin = false;

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("userId") && cookies[i].getValue() != null) {
                isLogin = true;
                out.println("<h1>" + cookies[i].getValue().toString() + "님 환영합니다.</h1>");
                break;
            }
        }
    %>
    <button><a href="cookie_out.jsp">로그아웃</a></button>
</body>
</html>
