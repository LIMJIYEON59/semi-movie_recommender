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
    <!-- 경고창 띄우기 위한 방법 -3 -->
    <jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>  
    
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
				 <input type="button" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/login'">
			</div>
			<div>이미 아이디가 있으신가요?
				<a href="<%=request.getContextPath()%>/login">로그인</a>
			</div>
		</form>
	</div>

	
	<script>
		$("#frmSignup [type=button]").click(sumbitHandler);
		function sumbitHandler(){
			console.log("여기 들어완?")
			
			//<유효성검사>
			//닉네임
			// 폼에서 name 속성이 mnickname인 요소의 값을 가져와서 nickname변수에 할당한다.
			var nickname =$("[name=mnickname]").val();	
			var regEx_nickname = /^[가-힣A-Za-z0-9]{2,10}$/;	//3-11글자,영문자로 시작,숫자,특수기호못씀!
			if( !regEx_nickname.test(nickname) ){
				console.log("정규표현식 부적합");
				alert("닉네임이 올바르지 않습니다.");
				$("[name=mnickname]").focus(); //jquery를 사용하여 특정 html요소에 포커스를 설정하는 코드이다. 'name'속성이 "mpwd"를 선택한다.
				return;								//.focus():선택된 요소에 포커스를 설정하는 메서드이다. 사용자가 입력 필드에 자동으로 포커스를 받게된다.
		    }else {
		    	console.log("정규표현식 적합");
		    }

			//이메일 
			var email =$("[name=memail]").val();	
			var regEx_email = /^([A-Za-z0-9_]+)@([A-Za-z]+)\.[A-Za-z]{2,}$/;  //2,(2글자 이상)
			if( !regEx_email.test(email) ){
				console.log("정규표현식 부적합");
				alert("이메일 형식이 올바르지 않습니다.");
				$("[name=memail]").focus();
				return;
		    }else {
		    	console.log("정규표현식 적합");
		    }
			
			//비밀번호
			var pwd =$("[name=mpwd]").val();	
			var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#_?_@])[a-zA-Z0-9!_#_?_@]{5,9}$/;  //5-9 대문자, 소문자, 숫자, 특수문자(!_#) 최소1개이상 포함(?=.*(...) 이거 붙여서 쓰면 된다.)
			if( !regEx_pwd.test(pwd) ){
				console.log("정규표현식 부적합");
				alert("비밀번호는 5-9자 입력해주세요.");
				$("[name=mpwd]").focus();
				return;
		    }else{
		    	console.log("정규표현식 적합");
		    }
			
			//비밀번호확인
			var pwd2 =$("[name=mpwd2]").val();
			if( pwd !== pwd2 ){
				console.log("정규표현식 부적합");
				alert("비밀번호가 일치하지 않습니다.")
				$("[name=mpwd2]").focus();
				return;
			}else{
				console.log("정규표현식 적합");
			}
		}
	</script>	
	
</body>
</html>