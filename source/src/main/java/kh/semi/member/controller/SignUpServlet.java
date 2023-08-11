package kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
//회원가입
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경고창 띄우기 위한 방법 -2
		String msg = (String) request.getSession().getAttribute("msg");
		if (msg != null) {
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		
		System.out.println("여기 Get 들어왔음!!");
		request.getRequestDispatcher("/WEB-INF/view/member/signup.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		  System.out.println("여기 POST 들어왔음!!");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String pwd = request.getParameter("mid");
			System.out.println("nickname" + nickname);
			System.out.println("email" + email);
			System.out.println("pwd" + pwd);
			
			int result = 1; // 0이면 저장실패, 1이면 저장성공
			
			//로그인 화면으로 이동
			if(result > 0) {
				System.out.println("회원가입성공");
				// 경고창 띄우기 위한 방법 -1
				request.getSession().setAttribute("msg", "회원가입에 성공했습니다.");
				
				response.sendRedirect(request.getContextPath()+"/login"); //doGet 호출 // login부분으로 갈거임
				
			}else {
				System.out.println("회원가입실패");
				//경고창 띄우기 위한 방법 -1
				request.getSession().setAttribute("msg", "회원가입에 실패했습니다. 다시 입력해주세요.");
				
				response.sendRedirect(request.getContextPath() + "/signup"); //doGet호출
				
			}
		
	  
	  }
}
