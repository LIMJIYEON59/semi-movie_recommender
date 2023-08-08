package kh.semi.common.openapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.movie.model.vo.MovieVo;


/**
 * Servlet implementation class OpenApiKoficController
 */
@WebServlet("/OpenApiKoficController")
public class OpenApiKoficController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 영화정보 담음
	private List<MovieVo> movielist = new ArrayList<MovieVo>();
	
    public OpenApiKoficController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/kofic/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
	private void getData() {
		
	}
}

