package kh.semi.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.dao.MovieDao;
import kh.semi.movie.model.vo.MovieVo;
import kh.semi.review.model.dao.ReviewDao;
import kh.semi.review.model.vo.ReviewVo;

public class ReviewService {
	private ReviewDao dao = new ReviewDao();
	
	public List<ReviewVo> selectList(int movieId, String loginEmail) {		
		List<ReviewVo> result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectList(conn, movieId, loginEmail);
		JdbcTemplate.close(conn);				
		
		return result;
	}
	

}
