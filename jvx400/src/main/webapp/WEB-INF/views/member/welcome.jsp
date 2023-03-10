<%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2023-03-09
  Time: 오후 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>회원가입이 완료됬습니다. 환영합니다.<br><br>좋은 서비스로 보답하겠습니다.</h2><br>
    <h3>회원 가입 정보</h3>
        아이디 : ${member.userId}<br>
        비밀번호 : ${member.passwd}<br>
        이름 : ${member.name}<br>
        주민번호 : ${member.ssn}<br>
        E-mail : ${member.email}<br>
        연락처 : ${member.phone}<br><br>
        
    <button><a href="http://localhost:8080/">홈으로</a></button>
</body>
</html>
