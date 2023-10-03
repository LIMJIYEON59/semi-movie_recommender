package kh.lclass.semi.common.openapi;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.semi.movie.model.service.MovieService;
import kh.lclass.semi.movie.model.vo.MovieVo;


/**
 * Servlet implementation class OpenApiKoficController
 */
//영화 정보를 가져오고 데이터를 준비
@WebServlet("/openapi")
public class OpenApiKoficController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService service = new MovieService(); //service 객체 생성
	// 영화정보 담음	//영화 정보를 OpenAPI로 가져와서 movielist에 담는다.
	private List<MovieVo> movielist = new ArrayList<MovieVo>();
	
    public OpenApiKoficController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
	
	//OpenAPI 호출 및 영화 정보를 가져오는 작업을 한다.
	//OpenAPI 호출과 데이터 처리 로직을 추가하고 원하는 곳에 호출 

}

