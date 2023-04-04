<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        body {
            background-color: #ffffff;
        }
        .login-form-container {
            background-color: #87e9fc;
            max-width: 300px;
            margin: 0 auto;
            margin-top: 5rem;
        }
    </style>
</head>
<body>
<form class="login-form-container p-3 rounded-3" action="login_process.jsp" method="post">
    <div class="mb-3">
        <label for="id" class="form-label">아 이 디 :</label>
        <input type="text" class="form-control" id="id" name="id">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">비밀번호 :</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">전송</button>
</form>
</body>
</html>
