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
	<h3>회원가입</h3>
	<!-- path="" 의 값이 html 에서 id 와 name 으로 변환됨 -->
	<form:form method="post" modelAttribute="customer">
		<label>E-mail</label>
		<form:input path="email1"/>@
		<form:select path="email2">
			<option value="unknown">--선택--</option>
			<form:options items="${emailProviderList}"
						 itemValue="emailHost" itemLabel="emailCode"/>			
		</form:select><br>
		
		<label>비밀번호</label>
		<form:password path="passwd"/><br>
		
		<label>이름</label>
		<form:input path="name"/><br>
		
		<label>주민번호</label>
		<form:input path="ssn1" maxlength="6"/>-<form:password path="ssn2" maxlength="7"/><br>
		
		<label>연락처</label>
		<form:select path="phone1">
			<option value="unknown">--선택--</option>
			<form:options items="${phoneProviderList}"/>
		</form:select>
		<form:input path="phone2" maxlength="4"/>-<form:input path="phone3" maxlength="4"/><br>		
		
		<input type="submit" value="가입하기">
		
	</form:form>
	
</body>
</html>