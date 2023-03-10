<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h3>회원가입</h3>
	<form method="post">
	<label>E-mail</label><input type="text" name="email"><br>
	<label>비밀번호</label><input type="password" name="passwd"><br>
	<label>이름</label><input type="text" name="name"><br>
	<label>주민번호</label><input type="password" maxlength="13" name="ssn"><br>
	<label>연락처</label><input type="text" maxlength="11" name="phone"><br><br>
	<input type="submit" name="회원가입" value="회원가입"><br>
	</form>
	
</body>
</html>