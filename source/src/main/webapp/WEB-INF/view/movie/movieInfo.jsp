<jsp:include page="/WEB-INF/view/component/headlink.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/header.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/footer.css">
<title>영화상세정보 영화 클릭하면 나오는 화면</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp" />

	<div class="movie-info-list" id="wrap-content">
		<h2>${movieVo.title }</h2>
		<div>
			<div>${movieVo.title }</div>
			<div>${movieVo.openingYear }</div>
			<div><img src="${pageContext.request.contextPath } /${movieVo.poster }" width="100"></div>
		</div>
	</div>
	<div>
		<c:forEach items="${reviewList }" var="vo">
			<div>${vo.reviewId }</div>
			<div>${vo.content }</div>
		</c:forEach>
	</div>
	<jsp:include page="/WEB-INF/view/movie/review.jsp" />
	<jsp:include page="/WEB-INF/view/component/footer.jsp" />
</body>
</html>