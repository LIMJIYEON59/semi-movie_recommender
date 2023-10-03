package kh.lclass.semi.movie.model.vo;

public class GenreVo {
//	<장르>
//	"GENRE_ID"	NUMBER		NOT NULL,
//	"GENRE_TITLE"	VARCHAR2(15)		NOT NULL

//	<GENRE_LIST>
//	"MOVIE_ID"	NUMBER		NOT NULL
	
	
	private int genreId;
	private String genreTitle;
	private int movieId;
	
	
	public GenreVo() {
		super();
	}

	public GenreVo(int genreId, String genreTitle, int movieId) {
		super();
		this.genreId = genreId;
		this.genreTitle = genreTitle;
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "GenreVo [genreId=" + genreId + ", genreTitle=" + genreTitle + ", movieId=" + movieId + "]";
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreTitle() {
		return genreTitle;
	}

	public void setGenreTitle(String genreTitle) {
		this.genreTitle = genreTitle;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	

}
