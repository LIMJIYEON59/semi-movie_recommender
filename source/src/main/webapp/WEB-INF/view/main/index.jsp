<jsp:include page="/WEB-INF/view/component/headlink.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css파일들 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/movie.css">


<title>메인 페이지</title>
<!-- 슬라이드 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"> --> <!-- 삭제?0 --> 
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/movie.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp" />
	<div id="wrap-content">
		<div class="main-banner">
			<div class="banner">
				<div class="banner-slide">
					<div class="banner-slide-bx">
						<ul>
							<li><a href="#"><img alt="영화1" src="<%=request.getContextPath()%>/resource/img/movie1.jpg"></a></li>
							<li><a href="#"><img alt="영화2" src="<%=request.getContextPath()%>/resource/img/movie2.jpg"></a></li>
							<li><a href="#"><img alt="영화3" src="<%=request.getContextPath()%>/resource/img/movie3.jpg"></a></li>
						</ul>
					</div>
				</div>
	<!-- 		 	<div class="bx-controls">
						<a class="bx-prev" href>Prev</a> 
						<a class="bx-next" href>Next</a>
				</div>  -->
			</div>
		</div>
		<div class="grid-3">
			<c:forEach items="${movieList }" var="vo">
				<div>
					<a href="${pageContext.request.contextPath }/movieinfo?mvid=${vo.movieId }">
						<div>${vo.movieId }</div>
						<div>${vo.title }</div>
						<div>${vo.openingYear }</div>
						<div><img src="${pageContext.request.contextPath }/${vo.poster }" width="300"></div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/component/footer.jsp" />
</body>
</html>