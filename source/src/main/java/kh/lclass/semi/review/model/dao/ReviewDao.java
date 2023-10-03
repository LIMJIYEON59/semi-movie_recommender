package kh.lclass.semi.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.semi.review.model.vo.ReviewVo;
import kh.lclass.semi.common.jdbc.JdbcTemplate;

public class ReviewDao {
	public List<ReviewVo> selectList(Connection conn, int movieId, String loginEmail) {
		System.out.println("[ReviewDao selectList] movieId: " +movieId+", loginEmail: "+loginEmail);
		List<ReviewVo> result = new ArrayList<ReviewVo>();
		String query = "SELECT REVIEW_ID, MOVIE_ID, EMAIL, CONTENT FROM review where movie_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, movieId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo vo = new ReviewVo(rs.getInt("REVIEW_ID"), rs.getInt("MOVIE_ID"), rs.getString("EMAIL"), rs.getString("CONTENT")
						,false, 0 //TODO
						);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[ReviewDao selectList] return: " + result);
		return result;	
		
	}
	
	
	public int insert(Connection conn, ReviewVo vo) {
		int result = 0;

//		INSERT INTO REVIEW (REVIEW_ID, MOVIE_ID, EMAIL, CONTENT)
//		VALUES (1, 200101, 'ABC@NAVER.COM', '정말재밌어요');
//		INSERT INTO LIKED (REVIEW_ID, EMAIL)
//		VALUES (1, 'ABC@NAVER.COM');
		String query = "INSERT INTO REVIEW (REVIEW_ID, MOVIE_ID, EMAIL, CONTENT) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getReviewId());
			pstmt.setInt(2, vo.getMovieId());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getContent());
			result = pstmt.executeUpdate(); // 리뷰 등록 실행
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}

		return result; // 리뷰 등록 결과 반환
	}

	// 좋아요 등록
	public int insertLinked(Connection conn, ReviewVo vo) {
		int result = 0;

		String query = "INSERT INTO LIKED (REVIEW_ID, EMAIL) VALUES (?, ?)";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getReviewId());
			pstmt.setString(2, vo.getEmail());
			result = pstmt.executeUpdate(); // 좋아요 추가 실행함!
			if (result > 0) {
				System.out.println("좋아요가 추가 되었습니다.");
			} else {
				System.out.println("좋아요가 추가에 실패했습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}

		return result; // 좋아요 추가 결과 반환
	}

	// 좋아요 취소
	public int deleteLiked(Connection conn, int review_Id, String email) {
		int result = 0;

		String query = "DELETE FROM LIKED WHERE REVIEW_ID =? AND EMAIL =?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, review_Id);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}

		return result;
	}

//		// 좋아요 수 카운트
//		public int updateLikeCount(Connection conn, String review_Id, String email) {			
//			int result = 0;
//			
//			String query = "UPDATE COUNTE(*) FROM LIKED =?";
//			
//			PreparedStatement pstmt = null;
//			
//			try {
//				pstmt = conn.prepareStatement(query);
//				pstmt.setInt(1, Integer.parseInt(review_Id));
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				JdbcTemplate.close(pstmt);
//			}
//			
//			return result;
//		
//			
//		}

	// 좋아요 확인
	public boolean checkLiked(Connection conn, int review_Id, String email) {
		boolean rliked = false;

		String query = "SELECT COUNT(*) FROM LIKED WHERE REVIEW_ID=? AND EMAIL=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, review_Id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1); // 가져 온 좋아요를 count에 저장한다.
				rliked = count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}

		return rliked;
	}

}
