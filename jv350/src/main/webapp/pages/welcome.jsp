<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/welcome.css">
    <title>Welcome</title>
</head>
<body>
    <div id="wrap">
        <div id="dummy">

        </div>
		
		<% 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		%>
        <div id="others">
            <h3>ȸ�������� �Ϸ�Ǿ����ϴ�.</h3>
            <p><%= name %>���� ȸ�������� �����մϴ�. <br> �����ϰ� �Ǽ��ִ� ���񽺷� ã�ƺ˰ڽ��ϴ�. </p>

            <div id="btns">
                <button><a href="../index.jsp">Ȩ����</a></button>
                <button><a href="../pages/login.jsp">�α���</a></button>
            </div>
           
        </div>
    
    
    </div>
</body>
</html>