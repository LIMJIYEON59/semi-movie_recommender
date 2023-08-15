package kh.semi.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.vo.ActorVo;
import kh.semi.movie.model.vo.DirectorVo;
import kh.semi.movie.model.vo.MovieVo;

public class MovieDao {
	public List<MovieVo> selectList(Connection conn) {
		System.out.println("[MovieDao selectList] -");
		List<MovieVo> result = new ArrayList<MovieVo>();
		String query = "SELECT MOVIE_ID, TITLE, OPENING_YEAR, POSTER FROM MOVIE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVo vo = new MovieVo(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getInt("OPENING_YEAR"), rs.getString("POSTER"));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[MovieDao selectList] return: " + result);
		return result;	
		
	}
	
	public MovieVo selectOne(Connection conn, int MovieId) {
		System.out.println("[MovieDao selectOne] -");	// 디버깅을 위한 메세지 출력
		MovieVo result = null;				// 조회된 영화 정보를 담을 객체
		String query = "SELECT MOVIE_ID, TITLE, OPENING_YEAR, POSTER FROM MOVIE WHERE MOVIE_ID=? ";	//DB에서 영화 정보를 조회하기 위한 SQL 쿼리
		PreparedStatement pstmt = null;		// SQL 쿼리를 실행할 PreparedStatement
		ResultSet rs = null;				// 쿼리 결과를 저장하는 ResultSet
		try {
			pstmt = conn.prepareStatement(query);//SQL 쿼리 준비
			pstmt.setInt(1, MovieId);		// 쿼리의 파라미터 설정
			rs = pstmt.executeQuery();		// 쿼리 실행 및 결과 저장
			while(rs.next()) {				// ResultSet에 결과가 있는 동안 반복
				result = new MovieVo(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getInt("OPENING_YEAR"), rs.getString("POSTER"));
				// 결과로부터 영화 정보를 가져와서 MovieVo 객체를 생성하여 저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[MovieDao selectOne] return: " + result);
		return result;	
		
	}
	
	
	//Connection conn =연결객체, MovieVo vo= 영화 정보를 담고 있는 객체
	public int insert(Connection conn, MovieVo vo) {
		int result = 0;
		
		//insert(삽입: 영화정보를 데이터베이스에 삽입하는 기능을 수행한다. MOVIE 테이블에 삽입)
		// ?는 바인딩할 매개변수를 나타낸다.
		String query = "INSERT INTO MOVIE (MOVIE_ID, TITLE, OPENING_YEAR, POSTER)";
		query += "VALUES (?, ?, ?, ?)";
//		INSERT INTO MOVIE (MOVIE_ID, TITLE, OPENING_YEAR, POSTER)
//		VALUES (200101, '듄', 2021, '듄포스터');
		
		
		PreparedStatement pstmt = null;	//객체를 선언하고 초기화함, 이 객체는 sql쿼리를 미리 컴파일하여 사용할 준비가 된 상태를 유지한다.
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getMovieId());	// SQL 쿼리의 첫 번째 매개변수(?)에 영화 ID 값을 설정합니다.
			pstmt.setString(2, vo.getTitle());
			pstmt.setInt(3, vo.getOpeningYear());
			pstmt.setString(4, vo.getPoster());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;	
	}
	
	//장르 찾기
	public int searchgenre(Connection conn, String genreTitle) {
		int result = 0;
		
		String query="SELECT COUNT(*) FROM GENRE WHERE GENRE_TITLE=? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, genreTitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);	//getInt(1) = 현재 레코드의 첫 번째 칼럼의 값을 가져오는 메서드이다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
		//////////////////////////////////////////////
	// 배우 찾기 searchActor : return 찾은 actorId
	public String searchActor(Connection conn, String actorName){
		System.out.println(">>>>searchActor actorName:"+ actorName);
		String actorId = null;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select ACTOR_ID from ACTOR where ACTOR_NAME=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, actorName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				actorId = rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>searchActor Return:"+ actorId);
		return actorId;
	}
	// 감독 찾기 searchDirector : return 찾은 directorId
	public int searchDirector(Connection conn, String directorName){
		System.out.println(">>>>searchDirector directorName:"+ directorName);
		int directorId = 0;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select director_ID from director where DIRECTOR_NAME=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, directorName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				directorId = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>searchDirector Return:"+ directorId);
		return directorId;
	}
	// 장르 찾기 searchGenre : return 찾은 genre_ID
	public int searchGenre(Connection conn, String genreTitle){
		System.out.println(">>>>searchGenre genreName:"+ genreTitle);
		int result = 0;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select genre_ID from genre where GENRE_TITLE=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, genreTitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>searchGenre Return:"+ result);
		return result;
	}
	// insertActor : return 성공시 1 / 실패시 0
	public int insertActor(Connection conn, ActorVo vo) {
		System.out.println(">>>>insertActor vo:"+ vo);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO ACTOR (ACTOR_ID, ACTOR_NAME) VALUES "
				+ " ((select nvl(max(to_number(ACTOR_ID)),0)+1 from ACTOR),"
				+ " '"+vo.getActorName()+"')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("#########"+vo);
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertActor Return:"+ result);
		return result;
	}
	// insertDirector : return 성공시 1 / 실패시 0
	public int insertDirector(Connection conn, DirectorVo vo) {
		System.out.println(">>>>DirectorVo vo:"+ vo);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO Director (Director_ID, Director_NAME) VALUES "
				+ " ((select nvl(max(to_number(Director_ID)),0)+1 from Director),"
				+ " '"+vo.getDirectorName()+"')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertDirector Return:"+ result);
		return result;
	}
	// insertGenre : return 성공시 1 / 실패시 0
	public int insertGenre(Connection conn, String genrenm) {
		System.out.println(">>>>insertGenre genrenm:"+ genrenm);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO genre (genre_ID, genre_TITLE) VALUES "
				+ " ((select nvl(max(to_number(genre_ID)),0)+1 from genre), '"+genrenm+"')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertGenre Return:"+ result);
		return result;
	}
////////////////////////
	// insertMVActor : return 성공시 1 / 실패시 0
	public int insertMVActor(Connection conn, int moviecd, String actorcd) {
		System.out.println(">>>>insertMVActor moviecd:"+ moviecd+ ", actorcd:"+ actorcd);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO ACTOR_LIST (movie_ID, actor_ID) VALUES (?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, moviecd);
			pstmt.setString(2, actorcd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertMVActor Return:"+ result);
		return result;
	}
	// insertMVDirector : return 성공시 1 / 실패시 0
	public int insertMVDirector(Connection conn, int moviecd, int directorcd) {
		System.out.println(">>>>insertMVDirector moviecd:"+ moviecd+ ", directorcd:"+ directorcd);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO DirectED_MOVIE (movie_ID, director_ID) VALUES (?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, moviecd);
			pstmt.setInt(2, directorcd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertMVDirector Return:"+ result);
		return result;
	}
	// insertMVGenre : return 성공시 1 / 실패시 0
	public int insertMVGenre(Connection conn, int moviecd, int genreId) {
		System.out.println(">>>>insertMVGenre moviecd:"+ moviecd+ ", genreId:"+ genreId);
		int result = 0;
		String sql = "INSERT ";
		sql += " INTO genre_LIST (movie_ID, genre_ID) VALUES (?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, moviecd);
			pstmt.setInt(2, genreId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>insertMVGenre Return:"+ result);
		return result;
	}
}
