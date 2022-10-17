package controller.Board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.Dao;
import model.dto.Dto;

/**
 * Servlet implementation class boardlist
 */
@WebServlet("/board/boardlist")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Dto> list = Dao.getInstance().boardlist();
		
		JSONArray array = new JSONArray();
		for( Dto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno());
			object.put("btitle", dto.getBtitle());
			object.put("bcontent", dto.getBcontent());
			object.put("bid", dto.getBid());
			object.put("bdate", dto.getBdate());
			object.put("bpoint", dto.getBpoint());
			array.add( object );
		}
		
		// 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
