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
@WebServlet("/board/viewload")
public class viewload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		//request.getSession().invalidate(); // 모든 세션 초기화
//		HttpSession session = request.getSession();	// 1. 세션 객체 선언
		
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		session.setAttribute("bno", bno);			// 2. 세션 생성[ 세션 메모리 할당 ]
//		System.out.println(bno+"aaa");
		
		int bno = (Integer)request.getSession().getAttribute("bno");
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		System.out.println("hhh:"+bno);
		Dto dto = Dao.getInstance().getviewload(bno);
		System.out.println(dto);
		
		//if(bno == -1) {			
		//}
		
		

		JSONObject object = new JSONObject();
		object.put("bno", dto.getBno());
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		object.put("bid", dto.getBid() );
		object.put("bpw", dto.getBpw() );
		object.put("bdate", dto.getBdate() );
		object.put("bpoint", dto.getBpoint() );
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print( object );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
