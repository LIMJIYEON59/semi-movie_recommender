package kh.semi.movie.model.service;

import java.sql.Connection;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.dao.MovieDao;
import kh.semi.movie.model.vo.MovieVo;

public class MovieService {
	private MovieDao dao = new MovieDao();
	public int insert(MovieVo vo) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		JdbcTemplate.close(conn);
		return result;
	}
}
