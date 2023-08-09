package kh.semi.movie.model.service;

import java.sql.Connection;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.movie.model.dao.MovieDao;
import kh.semi.movie.model.vo.MovieVo;

// MovieDao 클래스의 기능을 활용하여 DBㅇ[ 영화 정보를 삽입하는 역할을 한다. 
public class MovieService {
	private MovieDao dao = new MovieDao();
	public int insert(MovieVo vo) {		//영화 정보를 받아와서 DB에 삽입하는 메서드이다.
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);	//movie dao의 객체의 inser() 메서드를 호출하여 영화 정보를 DB에 삽입한다 
		JdbcTemplate.close(conn);				//conn은 DB연결 객체이며 vo는 영화 정보 객체이다 삽입 작업의 결과는 result 변수에 저장된다.
		
		return result;
	}
}
