<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h3>회원정보 입력</h3>
	<form action="step3" method="post">
		<label>E-mail</label><input type="text" name="email"><br>
		<label>비밀번호</label><input type="password" name="passwd"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>