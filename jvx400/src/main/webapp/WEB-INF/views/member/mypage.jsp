<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
	<h2>마이페이지</h2><br>
    <h3>회원 가입 정보</h3>
        아이디 : ${member.userId}<br>
        이름 : ${member.name}<br>
        E-mail : ${member.email}<br>
        연락처 : ${member.phone}<br><br>
        
    <button><a href="/member_modify">회원정보수정</a></button>
</body>
</html>