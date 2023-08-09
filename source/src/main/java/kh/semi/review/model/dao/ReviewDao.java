package kh.semi.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.review.model.vo.ReviewVo;

public class ReviewDao {
	public int insert(Connection conn, ReviewVo vo) {
		int result = 0;
		
//		INSERT INTO REVIEW (REVIEW_ID, MOVIE_ID, EMAIL, CONTENT)
//		VALUES (1, 200101, 'ABC@NAVER.COM', '정말재밌어요');
		String query="INSERT INTO REVIEW (REVIEW_ID, MOVIE_ID, EMAIL, CONTENT=?";
		query += "VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getReviewId());
			pstmt.setInt(2, vo.getMovieId());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(3, vo.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
			
		return result;
	}

	//리뷰 조회
	
	
}
