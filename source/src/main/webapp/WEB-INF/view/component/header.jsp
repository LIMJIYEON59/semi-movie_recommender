<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="main-header">
		<nav>
			<ul>
				<li class="logo"><a href="/smovie/index"><img alt="HOME" src="${pageContext.request.contextPath }/resource/img/logo.jpg"  width="50">HOME</a></li>
				<li><a href="${pageContext.request.contextPath }/prefmovie"><p>취향선택</p></a></li>
				<li>
					<form action="#(검색결과url)" method="get" class="search-box">
						<div class="search-box">
							<input type="text" name="" placeholder="영화 제목을 입력하세요">
							<button type="submit">검색</button>
						</div>
					</form>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/signup"><p>회원가입</p></a>
					<a href="${pageContext.request.contextPath }/login"><p>로그인</p></a></li>
			</ul>
		</nav>
		
	</header>
	<%-- <a href="${pagecontext.request.contextpath }/index"></a> --%>
