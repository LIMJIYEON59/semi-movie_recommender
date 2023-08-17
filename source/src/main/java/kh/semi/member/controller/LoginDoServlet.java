package kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;



/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.do")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login진입?");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MemberVo vo = new MemberVo(email, password);
		String result = new MemberService().login(email);
		
		// TODO sesstion
		
		
		if(result != null) {
			System.out.println("로그인 성공");
			request.setAttribute("loginemail", email);
			request.getSession().setAttribute("successFailMsg", "로그인성공");
			request.getSession().setAttribute("ssLoginEmail", email);
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			response.sendRedirect(request.getContextPath() + "/index");
		}
		
	}

}
