<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>회원 가입</title>
	<script type="text/javascript">
		function checkForm() {
			if (!document.frmMemberInsert.id.value) {
				alert("아이디를 입력하세요.");
				return false;
			}

			if (!document.frmMemberInsert.password.value) {
				alert("비밀번호를 입력하세요.");
				return false;
			}

			if (document.frmMemberInsert.password.value !== document.frmMemberInsert.password_confirm.value) {
				alert("비밀번호를 동일하게 입력하세요.");
				return false;
			}
		}
	</script>
</head>
<body>
<jsp:include page="../inc/menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">회원 가입</h1>
	</div>
</div>

<div class="container">
	<form name="frmMemberInsert" class="form-horizontal" action="processAddMember.jsp" method="post" onsubmit="return checkForm()">
		<div class="form-group row">
			<label class="col-sm-2 ">아이디</label>
			<div class="col-sm-3">
				<input name="id" type="text" class="form-control" placeholder="id">
				<span class="idCheck"></span>
				<br><input type="button" name="btnIsDuplication" value="팝업 아이디 중복 확인">
				<br><input type="button" name="btnIsDuplication2nd" value="ajax 아이디 중복 확인">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">비밀번호</label>
			<div class="col-sm-3">
				<input name="password" type="text" class="form-control" placeholder="password">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">비밀번호확인</label>
			<div class="col-sm-3">
				<input name="password_confirm" type="text" class="form-control" placeholder="password confirm">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">성명</label>
			<div class="col-sm-3">
				<input name="name" type="text" class="form-control" placeholder="name">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">성별</label>
			<div class="col-sm-10">
				<input name="gender" type="radio" value="남"> 남
				<input name="gender" type="radio" value="여"> 여
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">생일</label>
			<div class="col-sm-4  ">
				<input type="text" name="birthyy" maxlength="4" placeholder="년(4자)" size="6">
				<select name="birthmm">
					<option value="">월</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select> <input type="text" name="birthdd" maxlength="2" placeholder="일" size="4">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">이메일</label>
			<div class="col-sm-10">
				<input type="text" name="mail1" maxlength="50">@
				<select name="mail2">
					<option>naver.com</option>
					<option>daum.net</option>
					<option>gmail.com</option>
					<option>nate.com</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">전화번호</label>
			<div class="col-sm-3">
				<input name="phone" type="text" class="form-control" placeholder="phone">
			</div>
		</div>
		<div class="form-group  row">
			<label class="col-sm-2 ">주소</label>
			<div class="col-sm-5">
				<input name="address" type="text" class="form-control" placeholder="address">
			</div>
		</div>
		<div class="form-group  row">
			<div class="col-sm-offset-2 col-sm-10 ">
				<input type="submit" class="btn btn-primary " value="등록 " >
				<input type="reset" class="btn btn-primary " value="취소 " onclick="reset()">
			</div>
		</div>
	</form>
	<script>
		document.addEventListener("DOMContentLoaded", function () {
			// const inputID = document.querySelector('input[name=id]');
			const frmMemberInsert = document.frmMemberInsert; //폼을 들고옴

			//1.팝업을 이용한 ID 중복 확인
			//팝업을 띄우는 이유는, 현재 페이지에서 데이터베이스에 중복 조회를 할려면 페이지 새로고침 이외에는 방법이 없음
			const btnIsDuplication = document.querySelector('input[name=btnIsDuplication]');
			btnIsDuplication.addEventListener('click', function () {
				const id = frmMemberInsert.id.value;	//아이디 input 에 있는 값
				if (id === "") {
					alert('아이디를 입력해주세요');
					frmMemberInsert.id.focus();
					return;
				}
				//아이디 중복 확인을 위해 팝업을 띄움.
				window.open('popupIdCheck.jsp?id=' + id, 'IdCheck', 'width = 500, height = 500, top = 100, left = 200, location = no');
			});


			//2. ajax를 이용한 alert 방식의 ID 중복확인
			const xhr = new XMLHttpRequest();	//XMLHttpRequest 객체 생성
			const btnIsDuplication2nd = document.querySelector('input[name=btnIsDuplication2nd]');
			btnIsDuplication2nd.addEventListener('click', function () {
				const id = frmMemberInsert.id.value;	//아이디 input에 있는 값
				xhr.open('GET', 'ajaxIdCheck.jsp?id=' + id);	//HTTP 요청 초기화. 통신 방식과 url 설정
				xhr.send();	//url에 요청을 보냄.
				//이벤트 등록. XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출.
				xhr.onreadystatechange = () => {
					//readyState 프로퍼티의 값이 DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
					if (xhr.readyState !== XMLHttpRequest.DONE) return;

					if (xhr.status === 200) {	//서버(url) 에 문서가 존재함
						console.log(xhr.response);
						const json = JSON.parse(xhr.response);
						if (json.result === 'true') {
							alert('동일한 아이디가 있습니다.')
						}
						else {
							alert('동일한 아이디가 없습니다.')
						}
					}
					else {	//서버(url)에 문서가 존재하지 않음.
						console.error('Error', xhr.status, xhr.statusText);
					}
				}
			});

			/**
			 ajax를 활용한 2. 의 방법을 사용할 때
			 중복 체크 함수를 재사용하기 위한 ajaxIdCheck() 함수
			 */
			function ajaxIdCheck(id, callback) {
				const xhr = new XMLHttpRequest();
				xhr.open('GET', 'ajaxIdCheck.jsp?id=' + id);
				xhr.send();
				xhr.onreadystatechange = () => {
					if (xhr.readyState !== XMLHttpRequest.DONE) return;

					if (xhr.status === 200) {
						const json = JSON.parse(xhr.response);
						callback(json.result);
					}
					else {
						callback(false);
					}
				}
			}
			/*
			리팩토링 된 코드
			 */
			// const btnIsDuplication2nd = document.querySelector('input[name=btnIsDuplication2nd]');
			// btnIsDuplication2nd.addEventListener('click', function () {
			// 	const id = frmMemberInsert.id.value;
			// 	ajaxIdCheck(id, function(result) {
			// 		if (result === 'true') {
			// 			alert('동일한 아이디가 있습니다.')
			// 		}
			// 		else {
			// 			alert('동일한 아이디가 없습니다.')
			// 		}
			// 	});
			// });

			//3. ajax를 이용한 실시간 ID 중복확인
			const inputId = document.querySelector('input[name=id]');
			inputId.addEventListener('keyup', function () {
				const id = frmMemberInsert.id.value;	//아이디 input에 있는 값
				const idCheck = document.querySelector('.idCheck');	//결과 문자열이 표현될 영역
				xhr.open('GET', 'ajaxIdCheck.jsp?id=' + id);	//HTTP 요청 초기화. 통신 방식과 url 설정
				xhr.send();	//url에 요청을 보냄.
				//이벤트 등록. XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출.
				xhr.onreadystatechange = () => {
					//readyState 프로퍼티의 값이 DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
					if (xhr.readyState !== XMLHttpRequest.DONE) return;

					if (xhr.status === 200) {	//서버(url) 에 문서가 존재함
						const json = JSON.parse(xhr.response);
						if (json.result === 'true') {
							idCheck.style.color = 'red';
							idCheck.innerHTML = '동일한 아이디가 있습니다.';
						}
						else {
							idCheck.style.color = 'gray';
							idCheck.innerHTML = '동일한 아이디가 없습니다';
						}
					}
					else {	//서버(url)에 문서가 존재하지 않음.
						console.error('Error', xhr.status, xhr.statusText);
					}
				}
			});

			/**
			 ajax를 활용한 3. 의 방법을 사용할 때
			 중복 체크 함수를 재사용하기 위한 checkId() 함수
			 */
			function checkId(url, id, onSuccess, onError) {
				const xhr = new XMLHttpRequest();  // XMLHttpRequest 객체 생성
				xhr.open('GET', url + '?id=' + id);  // HTTP 요청 초기화. 통신 방식과 url 설정
				xhr.send();  // url에 요청을 보냄.
				xhr.onreadystatechange = () => {
					// readyState 프로퍼티의 값이 DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
					if (xhr.readyState !== XMLHttpRequest.DONE) return;
					if (xhr.status === 200) {  // 서버(url) 에 문서가 존재함
						const json = JSON.parse(xhr.response);
						if (json.result === 'true') {
							onSuccess();
						} else {
							onError();
						}
					} else {  // 서버(url)에 문서가 존재하지 않음.
						console.error('Error', xhr.status, xhr.statusText);
					}
				}
			}

			/*
			리팩토링 된 코드
			 */
			// const inputId = document.querySelector('input[name=id]');
			// const idCheck = document.querySelector('.idCheck');  // 결과 문자열이 표현될 영역
			// inputId.addEventListener('keyup', function () {
			// 	const id = frmMemberInsert.id.value;  // 아이디 input에 있는 값
			// 	checkId('ajaxIdCheck.jsp', id, function () {
			// 		idCheck.style.color = 'red';
			// 		idCheck.innerHTML = '동일한 아이디가 있습니다.';
			// 	}, function () {
			// 		idCheck.style.color = 'gray';
			// 		idCheck.innerHTML = '동일한 아이디가 없습니다';
			// 	});
			// });


		});


	</script>
</div>
<jsp:include page="../inc/footer.jsp" />
</body>
</html>