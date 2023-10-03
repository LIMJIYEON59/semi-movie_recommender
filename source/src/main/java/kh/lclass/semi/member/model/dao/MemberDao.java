package kh.lclass.semi.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.lclass.semi.member.model.vo.MemberVo;
import kh.lclass.semi.common.jdbc.JdbcTemplate;


public class MemberDao {
	//회원정보와 관련된 DB 작업을 수행한다. //회원가입을 위해서는 insert를 해줘야한다.
	public int insert(Connection conn, MemberVo vo) {
		int result = 0;
		
		String query = "INSERT INTO MEMBER (EMAIL, PASSWORD, NICKNAME, AGE_GROUP)";
		query += "VALUES (?, ?, ?, ?)";
		//	INSERT INTO MEMBER (EMAIL, PASSWORD, NICKNAME, AGE_GROUP)
		//	VALUES ('ABC@NAVER.COM', '1234567!', '영화좋아', 10);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getNickname());
			pstmt.setInt(4, vo.getAgeGroup());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	
		public  String login(Connection conn, String email) {
			System.out.println("[Member Dao login] email:" + email);
		
			String result = null;
			String query="select password from member where email=?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("password");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("[Member Dao login] return:" + result);
		return result;
	}
		
	// update- 수정 회원정보수정시 필요함
	/*
	public int update(Connection conn, MemberVo member ) {
		System.out.println("[MemberVo Dao update] member:" + member);
		int result = 0;
		//TODO
		System.out.println("[Member Dao update] return:" + result);
		return result;
	}
	*/
	

}

