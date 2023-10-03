package kh.lclass.semi.movie.model.vo;

import java.util.List;


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
	//// FK
	private List<ActorVo> actors;
	private List<DirectorVo> directors;
	private List<GenreVo> genres;
	
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

	public List<ActorVo> getActors() {
		return actors;
	}

	public void setActors(List<ActorVo> actors) {
		this.actors = actors;
	}

	public List<DirectorVo> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorVo> directors) {
		this.directors = directors;
	}

	public List<GenreVo> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreVo> genres) {
		this.genres = genres;
	}
	
	
	

}
