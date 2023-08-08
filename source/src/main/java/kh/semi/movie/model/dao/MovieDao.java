package kh.semi.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.vo.MovieVo;

public class MovieDao {
	public int insert(Connection conn, MovieVo vo) {
		int result = 0;
		String query = "INSERT INTO MOVIE (MOVIE_ID, TITLE, OPENING_YEAR, POSTER)";
		query += "VALUES (?, ?, ?, ?)";
//		INSERT INTO MOVIE (MOVIE_ID, TITLE, OPENING_YEAR, POSTER)
//		VALUES (200101, '듄', 2021, '듄포스터');
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getMovieId());
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

}
