<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="main-header">
		<nav>
			<div class="header_container">
				<div class="header_weapper">
					<ul class="header_ul">
						<li class="catagoties">
							<a class="logo" href="${pageContext.request.contextPath }/index">HOME</a>
						</li>
						<li class="catagoties">
							<a class="pref" href="${pageContext.request.contextPath }/prefmovie">취향선택</a>
						</li>
						<li class="search">
							<div class="search-box">
								<input type="text" name="searchKeyword" placeholder="영화 제목을 입력하세요">
								<button type="submit">검색</button>
							</div>
						</li>
						<li class="log">
							<a class="login" href="${pageContext.request.contextPath }/login">로그인</a>
						</li>
						<li class="log">
							<a class="join" href="${pageContext.request.contextPath }/signup">회원가입</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<hr>
	</header>
	<%-- <a href="${pagecontext.request.contextpath }/index"></a> --%>
