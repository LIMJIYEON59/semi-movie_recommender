<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/prefmovie.css">
<title>메인 페이지</title>
</head>
<body>
	<div>
		<div class="pref-title">
			<a href="index"><img src="resource/img/bakck.svg"></a>
		</div>
		<div>
			<p><br>장르선택</p>
			<p>장르 3가지를 선택해 주세요</p>
		</div>
		<div>
			<div><input type="checkbox" name="genre" value="액션"><label>액션</label></div>
			<div><input type="checkbox" name="genre" value="범죄"><label>범죄</label></div>
			<div><input type="checkbox" name="genre" value="SF"><label>SF</label></div>
			<div><input type="checkbox" name="genre" value="코미디"><label>코미디</label></div>
			<div><input type="checkbox" name="genre" value="스릴러"><label>스릴러</label></div>
			<div><input type="checkbox" name="genre" value="공포"><label>공포</label></div>
			<div><input type="checkbox" name="genre" value="전쟁"><label>전쟁</label></div>
			<div><input type="checkbox" name="genre" value="스포츠"><label>스포츠</label></div>
			<div><input type="checkbox" name="genre" value="판타지"><label>판타지</label></div>
			<div><input type="checkbox" name="genre" value="뮤지컬"><label>뮤지컬</label></div>
		</div>
		<div>
			<button type="submit">완료</button>
		</div>
	</div>
</body>
</html>