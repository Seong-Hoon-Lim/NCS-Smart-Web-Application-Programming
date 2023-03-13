<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>신규계좌 등록</h3>
	<form:form method="post" modelAttribute="accountCommand">
		<label>고객명</label>
		<form:input path="customer.name"/><br>
		
		<label>계좌번호</label>
		<form:input path="accountNum"/><br>
		
		<label>계좌종류</label>
		<form:radiobuttons items="${accountTypeList}" itemValue="accountType" 
						itemLabel="accountName" path="accountType"/><br>
		
		<label>초기 입금액</label>
		<form:input path="balance"/><br>		
		
		<input type="submit" value="계좌생성">		
	</form:form>
	
</body>
</html>