<jsp:include page="/WEB-INF/view/component/headlink.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/header.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/footer.css">
<title>여기 수정</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp" />

	<div id="wrap-content">
		<h2>여기 수정</h2>
		여기 넣기
	</div>

	<jsp:include page="/WEB-INF/view/component/footer.jsp" />
</body>
</html>