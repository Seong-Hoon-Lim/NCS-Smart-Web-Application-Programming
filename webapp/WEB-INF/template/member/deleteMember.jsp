<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%
  String sessionId = (String) session.getAttribute("sessionMemberId");
%>

<sql:setDataSource var="dataSource"
                   url="jdbc:mysql://localhost:3306/member?serverTimeoutzone=Asia/Seoul"
                   driver="com.mysql.cj.jdbc.Driver" user="root" password="1234" />

<sql:update dataSource="${dataSource}" var="resultSet">
  DELETE FROM member WHERE id = ?
  <sql:param value="<%=sessionId%>" />
</sql:update>

  <c:if test="${resultSet>=1}">
    <c:import var="url" url="logoutMember.jsp" />
    <c:redirect url="resultMember.jsp" />
  </c:if>
