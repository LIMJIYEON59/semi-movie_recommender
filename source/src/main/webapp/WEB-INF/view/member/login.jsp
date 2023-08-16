<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/member.css">
<title>로그인 페이지</title>
<!-- 경고창 띄우기 위한 방법 -3 -->
</head>
<body>
	<h3>로그인</h3>
	<hr>
	<div class="main-login">
		<form class="form-container" id="loginForm" action="<%=request.getContextPath()%>/login.do" method="post">
				<label><input type="text" id="memail" name="email"placeholder="이메일을 입력하세요" required="required"> </label> <br> <!-- name은 Vo에 있는 이름을 쓰는게 좋다. -->
				<label><input type="text" id="mpwd" name="pwd" placeholder="비밀번호를 입력하세요" required="required"> </label>
			<div>
				<input type="submit" value="로그인">
			</div>
			<div>
				회원이 아니신가요? <a href="<%=request.getContextPath()%>/signup">회원가입</a>
			</div>
		</form>
	</div>
	<script>
		document.getElementById("loginForm").addEventListener("submit", function(event) {
					var email = document.getElementsByName("memail")[0].value;
					var password = document.getElementsByName("mpwd")[0].value;

					// 예상 이메일과 비밀번호
					var expectedEmail = "kh88@naver.com"; //example@email.com
					var expectedPassword = "lclass88!";

					// 로그인 실패 조건을 판단하고, 실패 시 경고창을 띄웁니다.
					if (email !== expectedEmail
							|| password !== expectedPassword) {
						alert("로그인에 실패하였습니다. 이메일과 비밀번호를 확인해주세요.");
						event.preventDefault(); // 폼 제출을 막는다.
					}
				});
	</script>
</body>
</html>
