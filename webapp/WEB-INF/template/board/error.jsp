<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>에러 페이지</title>
</head>
<body>
    <jsp:include page="/inc/menu.jsp" />
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">게시판</h1>
        </div>
    </div>

    <div class="container">
        <h1>잘못된 접근입니다.</h1>
    </div>
    <hr>
    <jsp:include page="/inc/footer.jsp" />
</body>
</html>
