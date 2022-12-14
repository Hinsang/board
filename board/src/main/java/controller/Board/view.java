package controller.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import model.dao.Dao;
import model.dto.Dto;


/**
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		//request.getSession().invalidate(); // 모든 세션 초기화
		HttpSession session = request.getSession();	// 1. 세션 객체 선언
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		session.setAttribute("bno", bno);			// 2. 세션 생성[ 세션 메모리 할당 ]
		System.out.println(bno+"aaa");
		
		bno = (Integer)session.getAttribute("bno");
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		System.out.println("hhh:"+bno);
		Dao.getInstance().getboard(bno);
		
		//if(bno == -1) {			
		//}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
