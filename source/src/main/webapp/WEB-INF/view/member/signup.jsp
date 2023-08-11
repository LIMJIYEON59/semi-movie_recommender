<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	
	<h3>회원가입</h3>
	<hr>
	<div>
		<%-- <form action="<%=request.getContextPath()%>/signup" method="post"> --%>
		<form id="frmSignup">
			<label> 
				<input type="text" id="mnickname" name="mnickname" placeholder="닉네임">
			</label> 
			<br>
			<label> 
				<input type="text" id="memail" name="memail" placeholder="이메일">
			</label> 
			<br> 
			<label> 
				<input type="text" id="mpwd" name="mpwd" placeholder="비밀번호"> <!--비번 타입password -->
			</label>
			<br>
			<label> 
				<input type="text" id="mpwd2" name="mpwd2" placeholder="비밀번호 확인">
			</label>
			<div>
				<input type="button" value="회원가입">
			</div>
			<div>이미 아이디가 있으신가요?
				<a href="#">로그인</a>
			</div>
		</form>
	</div>

	
	<script>
		$("#frmSignup [type=button]").click(sumbitHandler);
		function sumbitHandler(){
			console.log("여기 들어완?")
			
			//<유효성검사>
			//닉네임
			var nickname =$("[name=mnickname]").val();	//여기 부분만 다름
			var regEx_nickname = /^[가-힣A-Za-z0-9]{2,10}$/;	//3-11글자,영문자로 시작,숫자,특수기호못씀!
			if( !regEx_nickname.test(nickname) ){
				console.log("정규표현식 부적합");
				alert("닉네임이 올바르지 않습니다.");
				$("[name=mnickname]").focus();
				return;
		    }else {
		    	console.log("정규표현식 적합");
		    }
			
			//이메일 chill2@naver.com 
			var nickname =$("[name=memail]").val();	//여기 부분만 다름
			var regEx_memail = /^([A-Za-z0-9_]+)@([A-Za-z]+)\.[A-Za-z]{12,20}$/;	//12-20글자,영문자로 시작,한글 안됨,숫자,특수기호@ 이것만 사용가능
			if( !regEx_memail.test(memail) ){
				console.log("정규표현식 부적합");
				alert("이메일 형식이 올바르지 않습니다.");
				$("[name=memail]").focus();
				return;
		    }else {
		    	console.log("정규표현식 적합");
		    }
			
			//닉네임이 정상적으로 입력되어있다면 다음 pwd를 체크함.
			var pwd =$("[name=mpwd]").val();	//여기 부분만 다름
			var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#_?_@])[a-zA-Z0-9!_#_?_@]{5,9}$/;	//5-9 대문자, 소문자, 숫자, 특수문자(!_#) 최소1개이상 포함(?=.*(...) 이거 붙여서 쓰면 된다.)
			if( !regEx_pwd.test(pwd) ){
				console.log("정규표현식 부적합");
				alert("비밀번호는 5-9자 입력해주세요. ");
				$("[name=mpwd]").focus();
				return;
		    }else{
		    	console.log("정규표현식 적합");
		    }
		}
	
	</script>	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>