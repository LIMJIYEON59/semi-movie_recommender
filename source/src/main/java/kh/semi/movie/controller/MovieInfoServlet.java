package kh.semi.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.movie.model.service.MovieService;
import kh.semi.movie.model.vo.MovieVo;
import kh.semi.review.model.service.ReviewService;
import kh.semi.review.model.vo.ReviewVo;

/**
 * Servlet implementation class MovieInfoServlet
 */
//영화상세정보를 클라이언트에게 제공
@WebServlet("/movieinfo")
public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//영화 Id
		String movieIdStr = request.getParameter("mvid");
		int movieId = 0;
		try {
			movieId=Integer.parseInt(movieIdStr);
		}catch (Exception e) {
			System.out.println("숫자아님");
			// 오류메시지 뿌리지 않고 자연스럽게 메인으로 이동
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}
		
		// 좋아요확인을 위한 로그인한 email, 만약 로그아웃 상태라면 null
		String loginEmail = null;
		//TODO 로그인 기능 이후 수정하기!!
		loginEmail = "ABC@NAVER.COM";

		
		// 영화 정보 얻어오기
		MovieVo movievo = new MovieService().selectOne(movieId);
		request.setAttribute("movieVo", movievo);
		
		
		// movieId에 달린 리뷰 목록 가져오기 loginEmail사람이 좋아요한 정보!
		List<ReviewVo> reviewList = new ReviewService().selectList(movieId, loginEmail);
		request.setAttribute("reviewList", reviewList);
		
		request.getRequestDispatcher("/WEB-INF/view/movie/movieInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
