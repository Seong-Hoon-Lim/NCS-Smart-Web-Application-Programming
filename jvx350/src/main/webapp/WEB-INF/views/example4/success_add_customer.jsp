<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h3>회원가입 성공</h3>
	<label>E-mail</label> : ${customer.email}<br>
	<label>비밀번호</label> : ${customer.passwd}<br>
	<label>이름</label> : ${customer.name}<br>
	<label>주민번호</label> : ${customer.ssn}<br>
	<label>연락처</label> : ${customer.phone}<br>	
</body>
</html>