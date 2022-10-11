package controller.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;
import model.dao.MemberDao;
import model.dto.Dto;

/**
 * Servlet implementation class Board
 */
@WebServlet("/board")
public class Board extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bid = request.getParameter("bid");
		String bpw = request.getParameter("bpw");
		
		Dto dto = new Dto( 0, btitle, bcontent, bid, bpw, null , 0);
		
		boolean result =  Dao.getInstance().signup(dto);
		
		System.out.println( dto.toString() );
		// boolean result = Dao.getInstance().signup(dto);
		
		if( result ) {
			response.sendRedirect("/board/Board/Board.jsp");
			System.out.println("등록성공!!");
		}
		else {
			System.out.println("등록실패!!");
		}
		
	}
	
	private static final long serialVersionUID = 1L;
       
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
