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
            let idData = form.id.value;
            let passwordData = form.password.value;

            if (idData === "") {
                alert("아이디를 입력해주세요.");
                form.select();
                return;
            }
            else if (passwordData === "") {
                alert("비밀번호를 입력해주세요.");
                form.select();
                return;
            }
            else if (passwordData.indexOf(idData) !== -1) {
                alert("비밀번호는 ID를 포함할 수 없습니다!");
                form.select();
                return;
            }
            form.submit();

        }

    </script>

    <form name="loginForm" action="validation01_process.jsp" method="post">
        <p>아 이 디 : <input type="text" name="id"></p>
        <p>비밀번호 : <input type="password" name="password"></p>
        <p> <input type="button" value="전송" onclick="checkLogin()"></p>

    </form>
</body>
</html>
