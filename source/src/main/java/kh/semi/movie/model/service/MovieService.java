package kh.semi.movie.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.dao.MovieDao;
import kh.semi.movie.model.vo.ActorVo;
import kh.semi.movie.model.vo.DirectorVo;
import kh.semi.movie.model.vo.GenreVo;
import kh.semi.movie.model.vo.MovieVo;

// MovieDao 클래스의 기능을 활용하여 DBㅇ[ 영화 정보를 삽입하는 역할을 한다. 
public class MovieService {
	private MovieDao dao = new MovieDao();
	public List<MovieVo> selectList() {		
		List<MovieVo> result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectList(conn);
		JdbcTemplate.close(conn);				
		
		return result;
	}
	
	public MovieVo selectOne(int movieId) {		
		MovieVo result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectOne(conn, movieId);
		JdbcTemplate.close(conn);				
		
		return result;
	}
	
	public int insert(MovieVo vo) {		//영화 정보를 받아와서 DB에 삽입하는 메서드이다.
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);	//movie dao의 객체의 inser() 메서드를 호출하여 영화 정보를 DB에 삽입한다 
		JdbcTemplate.close(conn);				//conn은 DB연결 객체이며 vo는 영화 정보 객체이다 삽입 작업의 결과는 result 변수에 저장된다.
		
		return result;
	}
	
	public int insert(List<MovieVo> volist) {		// kobis 영화 정보 여러개 받아와서 DB에 삽입하는 메서드이다.
		int result = 0;
		int totalInsertCnt = 0;
		Connection conn = JdbcTemplate.getConnection();
		for(MovieVo vo : volist) {
			// MOVIE테이블에 insert
			result = dao.insert(conn, vo);
			if(result < 1) {
				System.out.println("insert  실패: "+ vo);
				continue; // 실패시 다음 영화. 실패시 actor, director, company 등은 insert 하지 않음.
			} else {
				totalInsertCnt++;
				System.out.println("insert  누적: "+ totalInsertCnt);
			}
			if(vo.getActors() != null)
			for(ActorVo e : vo.getActors()) {
				// actor 테이블에 배우가 있다면 해당 actorcd 번호를 읽어온다.
				String actorcd = dao.searchActor(conn, e.getActorName());
				// actorcd 번호가 없다면 
				if(actorcd == null) {
					// actor 테이블에 insert하고
					result = dao.insertActor(conn, e);
					// 다시 배우의 actorcd 번호를 읽어온다.
					actorcd = dao.searchActor(conn, e.getActorName());
				}
				// actorcd 번호가 있다면
				if(actorcd != null) {
					result = dao.insertMVActor(conn, vo.getMovieId(), actorcd); 
				}
			}
			if(vo.getDirectors() != null)
			for(DirectorVo e : vo.getDirectors()) {
				// directory 테이블에 감독가 있다면 해당 directorycd 번호를 읽어온다.
				int directorycd = dao.searchDirector(conn, e.getDirectorName());
				// directory 번호가 없다면 
				if(directorycd == 0) {
					// directory 테이블에 insert하고
					result = dao.insertDirector(conn, e);
					// 다시 감독의 directorycd 번호를 읽어온다.
					directorycd = dao.searchDirector(conn, e.getDirectorName());
				}
				// directorycd 번호가 있다면
				if(directorycd != 0) {
					result = dao.insertMVDirector(conn, vo.getMovieId(), directorycd); 
				}
			}
			if(vo.getGenres() != null)
			for(GenreVo e : vo.getGenres()) {
				// genre 테이블에 장르가 있다면
				int genrecd = dao.searchGenre(conn, e.getGenreTitle());
				// genrenm 가 없다면 
				if(result == 0) {
					// genre 테이블에 insert하고
					result = dao.insertGenre(conn, e.getGenreTitle());
					// 다시 감독의 directorycd 번호를 읽어온다.
					genrecd = dao.searchGenre(conn, e.getGenreTitle());
				}
				// genrenm 추가 됐다면
				if(result != 0) {
					result = dao.insertMVGenre(conn, vo.getMovieId(), genrecd);
				}
			}			
		}
		JdbcTemplate.close(conn);
		return totalInsertCnt;
	}
}
