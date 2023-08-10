<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="main-header">
		<nav>
			<ul>
				<li><a href="/smovie/index"><img alt="메인로고" src="${pageContext.request.contextPath }/resource/좋아요.svg"></a></li>
				<li>
					<form action="#(검색결과url)" method="get" class="search-box">
						<div class="search-box">
							<input type="text" name="" placeholder="영화 제목을 입력하세요">
							<button type="submit">검색</button>
						</div>
					</form>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/signup"><p>회원가입</p></a>
					<a href="<%=request.getContextPath()%>/login"><p>로그인</p></a></li>
			</ul>
		</nav>
	</header>
	<%-- <a href="${pagecontext.request.contextpath }/index"></a> --%>
