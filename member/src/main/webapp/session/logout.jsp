<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.invalidate();
    System.out.println("session is delete!");
    response.sendRedirect("login.jsp");
%>
