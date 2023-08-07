package kh.semi.movie.model.vo;

public class ActorVo {
	
//	<출연진> (ACTOR)
//	"ACTOR_ID"	NUMBER		NOT NULL,
//	"ACTOR_NAME"	VARCHAR2(300)		NOT NULL

//  <ACTOR_LIST>
//	"MOVIE_ID"	NUMBER		NOT NULL
	
	private int actorId;
	private String actorName;
	private int movieId;
	
	public ActorVo() {
		super();
	}

	public ActorVo(int actorId, String actorName, int movieId) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "ActorVo [actorId=" + actorId + ", actorName=" + actorName + ", movieId=" + movieId + "]";
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	

}
