package kh.semi.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.vo.GenreVo;
import kh.semi.movie.model.vo.MovieVo;

public class MovieDao {
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
		ResultSet rs = null;			//객체를 선언하고 초기화한다. 쿼리 실행 결과를 저장하는데 사용됨 //여기서는 insert 작업을 수행하여 결과셋이 필요하지 않다.
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

}
