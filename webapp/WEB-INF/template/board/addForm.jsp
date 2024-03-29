<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String sessionMemberId = (String) session.getAttribute("sessionMemberId");
%>
<html>
<head>
    <title>게시판</title>
</head>
    <script type="text/javascript">
        /*
        session 의 값이 없을 경우 로그인 페이지로 이동
         */
        if (${sessionMemberId == null}) {
            alert("로그인 해주세요");
            location.href = "/member/loginMember";
        }

        /*
        게시판 글쓰기 입력 폼에서 submit 할 때 검증
         */
        function checkForm() {
            if (!document.frmAdd.name.value) {
                alert("성명을 입력하세요");
                return false;
            }
            if (!document.frmAdd.subject.value) {
                alert("제목을 입력하세요");
                return false;
            }
            if (!document.frmAdd.content.value) {
                alert("내용을 입력하세요");
                return false;
            }
        }


    </script>
<body>
    <jsp:include page="/inc/menu.jsp" />
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">게시판</h1>
        </div>
    </div>

    <div class="container">
        <form name="frmAdd" action="/addAction.do" class="form-horizontal" method="post" onsubmit="return checkForm()">
            <div class="form-group row">
                <label class="col-sm-2 control-label">성명</label>
                <div class="col-sm-3">
                    <input name="name" type="text" class="form-control" value="${sessionMemberName}" placeholder="name">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 control-label">제목</label>
                <div class="col-sm-5">
                    <input name="subject" type="text" class="form-control" placeholder="subject">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 control-label">내용</label>
                <div class="col-sm-8">
                    <textarea name="content" cols="50" rows="5" class="form-control" placeholder="content"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="등록">
                    <input type="reset" class="btn btn-primary" value="취소">
                </div>
            </div>
        </form>
        <hr>
    </div>
    <jsp:include page="/inc/footer.jsp" />
</body>
</html>
