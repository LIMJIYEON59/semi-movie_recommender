<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/signup"><p>회원가입</p></a>
<a href="<%=request.getContextPath() %>/login"><p>로그인</p></a>
<jsp:include page="/WEB-INF/view/component/header.jsp" />



</body>
