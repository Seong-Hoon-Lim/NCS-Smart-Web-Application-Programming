<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>다음과 같은 에러가 발생하였습니다.</h3>
	<%
		String msg_pwcheck = (String)request.getAttribute("msg_pwcheck");
	%>
	<%=msg_pwcheck %><br>
	
</body>
</html>