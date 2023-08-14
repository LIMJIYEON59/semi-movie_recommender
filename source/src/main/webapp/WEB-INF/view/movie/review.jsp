<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
</head>
<body>
	<hr>
	<div class="comments">
		<h3>댓글</h3>
		<h5>내가 쓴 리뷰</h5>
		<div id="comment-container">
			<div class="my-comment">
				<ul></ul>
			</div>
			<form action="" method="">
				<div class="comment-form">
				<textarea name="comment" rows="4" cols="" placeholder="댓글 입력해주세요"></textarea>
				<div class="submit">
					<button type="submit" class="btn" onclick="addComment(this,20); return false;">등록</button>
				</div>
				</div>
			</form>
		</div>
		
		<h3>모든 리뷰</h3>
			<div>
				<div>
					<div>
						<div class="writer-name">사용자1</div>
						<div class="comment"><span>영화 감상평</span></div>
						<div class="comment-like"><span src="/"></span></div>
					</div>
				</div>
			</div>
		
	</div>
</body>
</html>