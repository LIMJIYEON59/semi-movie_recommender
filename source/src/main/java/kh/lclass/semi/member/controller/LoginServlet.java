package kh.lclass.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 경고창 띄우기 위한 방법 -2
		String msg = (String) request.getSession().getAttribute("msg");
		if (msg != null) {
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		
		System.out.println("login get 진입");
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}
}
