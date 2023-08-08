<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header class="main-header">
<nav>
<ul>
<li>
<a href="/smovie/index"><img alt="메인로고" src="이미지경로"></a>
<li>

<form action="#(검색결과url)" method="get" class="search-box">
	<div class="search-box">
		<input type="text" name="" placeholder="영화 제목을 입력하세요">
		<button type="submit">검색</button>
	</div>
</form>
</ul>
</nav>
</header>
<%-- <a href="${pagecontext.request.contextpath }/index"></a> --%>

</body>
</html>