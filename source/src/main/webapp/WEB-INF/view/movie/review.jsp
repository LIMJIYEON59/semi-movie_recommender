<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/review.css"> 
<title>리뷰 페이지</title>
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
					<div class="comment-form-inner">
						<textarea name="comment" rows="4" cols="" placeholder="댓글 입력해주세요"></textarea>
					</div>
				<div class="comment-submit">
					<button type="submit" class="btn" onclick="addComment(this,20); return false;">등록</button>
				</div>
				</div>
			</form>
		</div>
		
		<h3>모든 리뷰</h3>
			<div class="text-write">
					<div class="inner-text-weite">
						<div class="box-textarea">
							<textarea placeholder="댓글 입력해주세요" rows="" cols=""></textarea>
						</div>
					</div>
			</div>
		
	</div>
</body>
</html>