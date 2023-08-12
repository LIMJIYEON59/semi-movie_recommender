<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="main-header">
		<nav>
			<ul>
				<li class="header_logo">
					<a href="/smovie/index"><img alt="HOME" src="${pageContext.request.contextPath }/resource/img/logo.jpg"  width="50">HOME</a>
				</li>
				<li class="header_pref">
					<a href="${pageContext.request.contextPath }/prefmovie">취향선택</a>
				</li>
				<li class="header_search">
					<form action="#(검색결과url)" method="get">
						<div class="search-box">
							<input type="text" name="" placeholder="영화 제목을 입력하세요">
							<button type="submit">검색</button>
						</div>
					</form>
				</li>
				<li class="header_login">
					<a href="${pageContext.request.contextPath }/login"><p>로그인</p></a>
				</li>
				<li class="header_join">
				<a href="${pageContext.request.contextPath }/signup"><p>회원가입</p></a>
				</li>
			</ul>
		</nav>
		
	</header>
	<%-- <a href="${pagecontext.request.contextpath }/index"></a> --%>
