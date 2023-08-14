package kh.semi.member.model.service;

import java.sql.Connection;

import kh.semi.common.jdbc.JdbcTemplate;
import kh.semi.member.model.dao.MemberDao;
import kh.semi.member.model.vo.MemberVo;

public class MemberService {
	private MemberDao dao= new MemberDao();
	
	// () 매개변수로 받아 정보를 얻음?
	public MemberVo login( String email, String password ) {
		MemberVo member = null;
		
		Connection conn = JdbcTemplate.getConnection();
		
		// login 메서드를 호출하여 () 매개인자의 정보를 얻어온다.
		member = dao.login(conn, email,password );
		
		JdbcTemplate.close(conn);
		
		
		return member;
	}
	// insert -삽입 MemberVo 자료형을 받아온다.
	public int insert(MemberVo member) {
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, member);
		JdbcTemplate.close(conn);
		
		return result;
	}
	// update -수정 
	public int update(MemberVo member) {
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, member);
		JdbcTemplate.close(conn);
		
		return  result;
	}
}
