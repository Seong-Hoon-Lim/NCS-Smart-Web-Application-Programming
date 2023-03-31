<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <META charset="UTF-8">
    <title>Validation</title>
</head>
<body>
    <h3>입력에 성공했습니다.</h3>
    <%
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
    %>
    <p> 아 이 디 : <%=id%></p>
    <p> 비밀번호 : <%=password%></p>

</body>
</html>
