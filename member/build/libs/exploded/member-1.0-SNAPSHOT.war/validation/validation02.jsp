<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <META charset="UTF-8">
    <title>Validation</title>
</head>
<body>
    <script type="text/javascript">

        function checkLogin() {
            const form = document.loginForm;

            if (form.id.value === "") {
                alert("아이디를 입력해주세요.");
                form.id.focus();
                return false;
            }
            else if (form.password.value === "") {
                alert("비밀번호를 입력해주세요.");
                form.password.focus();
                return false;
            }
            form.submit();  /* action="validation02_process.jsp" method="post" 로 form 값을 전달 */
        }

    </script>
    <%--폼 페이지에서 입력한 데이터 (아이디와 비밀번호) 값의 유무 검사--%>
    <form name="loginForm" action="validation02_process.jsp" method="post">
        <p>아 이 디 : <input type="text" name="id"></p>
        <p>비밀번호 : <input type="password" name="password"></p>
        <p> <input type="button" value="전송" onclick="checkLogin()"></p>

    </form>
</body>
</html>
