<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
	<h2>마이페이지</h2><br>
    <h3>회원 가입 정보</h3>
    <c:forEach var="member" items=${members}>
        아이디 : ${member.userId}<br>
        이름 : ${member.name}<br>
        E-mail : ${member.email}<br>
        연락처 : ${member.phone}<br><br>
      </c:forEach>
        
    <button><a href="/member_modify">회원정보수정</a></button>
</body>
</html>