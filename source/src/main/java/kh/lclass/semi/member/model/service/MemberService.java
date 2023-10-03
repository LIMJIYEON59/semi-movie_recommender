package kh.lclass.semi.member.model.service;

import java.sql.Connection;

import kh.lclass.semi.member.model.dao.MemberDao;
import kh.lclass.semi.member.model.vo.MemberVo;
import kh.lclass.semi.common.jdbc.JdbcTemplate;

public class MemberService {
	private MemberDao dao= new MemberDao();
	
	// () 매개변수로 받아 정보를 얻음?
	public String login(String email) {
		String result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.login(conn, email);
		JdbcTemplate.close(conn);
		
		return result;
		
	}
	// insert -삽입 MemberVo 자료형을 받아온다.
	public int insert(MemberVo member) {
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, member);
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	// update -수정 회원정보수정시 필요함
	/*
	public int update(MemberVo member) {
		int result = 0;
		
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, member);
		JdbcTemplate.close(conn);
		
		return  result;
	}
	*/
}
