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
    <h3>회원 정보 입력</h3>
    <form:form method="post" modelAttribute="member">
    
    	<label>아이디</label>
    	<form:input path="userId"/><br>
		
		<label>비밀번호</label>
		<form:password path="passwd"/><br>
		
		<label>이름</label>
		<form:input path="name"/><br>
		
		<label>주민번호</label>
		<form:input path="ssn1" maxlength="6"/>-<form:password path="ssn2" maxlength="7"/><br>
		
		<label>E-mail</label>
		<form:input path="email1"/>@
		<form:select path="email2">
			<option value="unknown">--선택--</option>
			<form:options items="${emailProviderList}"
						 itemValue="emailHost" itemLabel="emailCode"/>			
		</form:select><br>
		
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
