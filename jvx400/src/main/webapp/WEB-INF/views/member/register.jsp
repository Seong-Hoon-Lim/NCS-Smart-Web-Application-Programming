<%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2023-03-09
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form action="/member/welcome" method="post">
        <label>E-mail</label><input type="text" name="email" value=""><br>
        <label>비밀번호</label><input type="password" name="email" value=""><br>
        <label>이름</label><input type="text" name="email" value=""><br>
        <label>주민번호</label><input type="password" name="email" value="" maxlength="13"><br>
        <label>연락처</label><input type="text" name="email" value="" maxlength="11"><br><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>
