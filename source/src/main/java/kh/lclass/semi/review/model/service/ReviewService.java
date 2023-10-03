package kh.lclass.semi.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.lclass.semi.review.model.dao.ReviewDao;
import kh.lclass.semi.review.model.vo.ReviewVo;
import kh.lclass.semi.common.jdbc.JdbcTemplate;

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
