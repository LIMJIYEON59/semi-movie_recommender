<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kofic데이터</title>
</head>
<body>
<!-- //MOVIE_ID, TITLE, OPENING_YEAR, POSTER -->
<h1>kofic open api 데이터 받아오기</h1>
<table border="1">
	<tr>
		<td>영화번호</td>
		<td>영화제목</td>
		<td>개봉연도</td>
		<td>포스터</td>
	</tr>
		<td>${movie.movieId}</td>
		<td>${movie.title}</td>
		<td>${movie.openingYear}</td>
		<td>${movie.poster}</td>
	</tr>
</table>

</body>
</html>