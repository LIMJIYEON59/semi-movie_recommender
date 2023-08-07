package kh.semi.movie.model.vo;

public class DirectorVo {
//	<감독>
//	"DIRECTOR_ID"	NUMBER		NOT NULL,
//	"DIRECTOR_NAME"	VARCHAR2(300)		NOT NULL

//	<DIRECTED_MOVIE>
//	"MOVIE_ID"	NUMBER		NOT NULL
	
	private int directorId;
	private String directorName;
	private int movieId;
	
	public DirectorVo() {
		super();
	}

	public DirectorVo(int directorId, String directorName, int movieId) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "DirectorVo [directorId=" + directorId + ", directorName=" + directorName + ", movieId=" + movieId + "]";
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	
	

}
