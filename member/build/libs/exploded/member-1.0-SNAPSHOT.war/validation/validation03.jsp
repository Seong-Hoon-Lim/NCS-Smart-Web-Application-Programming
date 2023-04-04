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

            if (form.id.value.length < 4 || form.id.value.length > 12) {
                alert("아이디는 4~12자 이내로 입력 가능합니다!");
                form.id.select();
                return;
            }
            else if (!isNaN(form.id.value.substr(0, 1))) {
                alert("아이디는 숫자로 시작할 수 없습니다!");
                form.id.select();
                return;
            }
            else if (form.password.value.length < 4) {
                alert("비밀번호는 4자 이상으로 입력해야합니다.");
                form.password.select();
                return;
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
