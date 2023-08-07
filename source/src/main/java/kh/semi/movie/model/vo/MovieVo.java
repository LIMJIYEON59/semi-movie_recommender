package kh.semi.movie.model.vo;

public class MovieVo {
//	<movie>          
//	------------ -------- ------------- 
//	MOVIE_ID     NOT NULL NUMBER        
//	TITLE        NOT NULL VARCHAR2(300) 
//	OPENING_YEAR NOT NULL NUMBER        
//	POSTER       NOT NULL VARCHAR2(200) 
	
	
	private int movieId;
	private String title;
	private int openingYear;
	private String poster;
	
	public MovieVo() {
		super();
	}

	public MovieVo(int movieId, String title, int openingYear, String poster) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.openingYear = openingYear;
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "MovieVo [movieId=" + movieId + ", title=" + title + ", openingYear=" + openingYear + ", poster="
				+ poster + "]";
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOpeningYear() {
		return openingYear;
	}

	public void setOpeningYear(int openingYear) {
		this.openingYear = openingYear;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	
	

}
