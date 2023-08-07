package kh.semi.review.model.vo;

public class ReviewVo {
//	"REVIEW_ID"	INT		NOT NULL,
//	"MOVIE_ID"	NUMBER		NOT NULL,
//	"EMAIL"	VARCHAR2(50)		NOT NULL,
//	"CONTENT"	VARCHAR2(200)		NOT NULL
	
	//좋아요
	//여기다가 select문을 해서 넣어준다.
	private boolean myLiked;	//내가 누른 것
	private int cntLiked;	    //좋아요 수 카운트
	
	private int reviewId;
	private int movieId;
	private String email;
	private String content;
	
	public ReviewVo() {
		super();
	}
	
	
	public ReviewVo(boolean myLiked, int cntLiked, int reviewId, int movieId, String email, String content) {
		super();
		this.myLiked = myLiked;
		this.cntLiked = cntLiked;
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.email = email;
		this.content = content;
	}


	@Override
	public String toString() {
		return "ReviewVo [myLiked=" + myLiked + ", cntLiked=" + cntLiked + ", reviewId=" + reviewId + ", movieId="
				+ movieId + ", email=" + email + ", content=" + content + "]";
	}
	public boolean isMyLiked() {
		return myLiked;
	}
	public void setMyLiked(boolean myLiked) {
		this.myLiked = myLiked;
	}
	public int getCntLiked() {
		return cntLiked;
	}
	public void setCntLiked(int cntLiked) {
		this.cntLiked = cntLiked;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
