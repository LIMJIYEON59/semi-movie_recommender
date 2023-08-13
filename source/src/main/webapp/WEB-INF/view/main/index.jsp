<jsp:include page="/WEB-INF/view/component/headlink.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/header.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/footer.css"> 
	<title>메인 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp" />
	<hr>
	<div id="wrap-content">
		<h2>메인</h2>
		<div class="grid-3">
		<c:forEach items="${movieList }" var="vo">
			<div>
			<a href="${pageContext.request.contextPath }/movieinfo?mvid=${vo.movieId }">
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