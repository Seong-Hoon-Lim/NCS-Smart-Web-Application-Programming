<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Login</title>
</head>
<body>

  <form action="cookieLogin_process.jsp" method="post" >
    <label> 아 이 디 : <input type="text" name="id"> </label> <br><br>
    <label> 비밀번호 : <input type="password" name="password"> </label> <br><br>
    <input type="submit" value="전송">
  </form>

</body>
</html>
