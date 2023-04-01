<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>

    <%
        session.invalidate();
        response.sendRedirect("sessionLogin.jsp");
    %>


</body>
</html>
