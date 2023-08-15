<jsp:include page="/WEB-INF/view/component/headlink.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/movie.css">

<title>메인 페이지</title>
<!-- 슬라이드 -->
<link rel="stylesheet"href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<!-- bx스타일시트를 로드한다 -->
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/movie.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp" />
	<hr>
	<div id="wrap-content">
		<h2>메인</h2>
		<div class="main-banner">
			<section class="banner">
				<div class="banner-slide">
					<ul>
						<li><img alt="영화1" src="/smovie/resource/img/movie1.jpg"></li>
						<li><img alt="영화2" src="/smovie/resource/img/movie2.jpg"></li>
						<li><img alt="영화3" src="/smovie/resource/img/movie3.jpg"></li>
					</ul>
					<!-- controller 부분 자동 생성 -->
					<div class="bx-controls">
						<div class="bx-pager">1 / 3</div>
						<div class="bx-controls-direction">
							<a class="bx-prev" href>Prev</a>
							<!-- 이전버튼  -->
							<a class="bx-next" href>Next</a>
							<!-- 다음버튼 -->
						</div>
						<div class="bx-controls-auto">
							<a class="bx-stop" href>Stop</a>
						</div>
					</div>
				</div>
			</section>
		</div>
		<div class="grid-3">
			<c:forEach items="${movieList }" var="vo">
				<div>
					<a
						href="${pageContext.request.contextPath }/movieinfo?mvid=${vo.movieId }">
						<div>${vo.movieId }</div>
						<div>${vo.title }</div>
						<div>${vo.openingYear }</div>
						<div>${vo.poster }</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/component/footer.jsp" />
</body>
</html>