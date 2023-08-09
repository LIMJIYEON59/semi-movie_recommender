package kh.semi.preferences.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.preferences.model.vo.PreferencesVo;

public class PreferencesDao {
	public int insert(Connection conn, PreferencesVo vo) {
		int result = 0;
		
//		INSERT INTO PREFERENCE (EMAIL, GENRE_ID)
//		VALUES ('ABC@NAVER.COM', 200201);
		String query= "INSERT INTO PREFERENCES (EMAIL, GENRE_ID)";
		query += "VALUES(?, ?)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setInt(2, vo.getGenreId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
	
		return result;
	}
	
	
	


}
