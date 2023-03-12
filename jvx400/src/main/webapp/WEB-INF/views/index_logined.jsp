<%--
  Created by IntelliJ IDEA.
  User: UserK
  Date: 2023-03-09
  Time: 오후 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Happy Bank</title>
</head>
<body>
	<header>
        <h1>로고</h1>
    </header>
    <section>
        <h2>안녕하세요 ${member.name}님</h2>
    </section>
    <section>
    	<button><a href="member/mypage">마이페이지</a></button>
    	<button><a href="http://localhost:8080/">로그아웃</a></button>
    </section>
</body>
</html>
