package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answer;
import data.Question;

/**
 * Servlet implementation class Save
 */
@WebServlet(
		name = "Save",
		urlPatterns = {"/Save"}
)

public class Save extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
	@Override
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Save() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("jsp/tallennettu.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		for ( int i = 0; i < 19; i++) {
			String ehdokas_id = request.getParameter("ehdokas_id");
			String tmp = "vastaus_" + i;
			String vastaus = request.getParameter(tmp);
			int kysymys_id = i+1;
			String kommentti = request.getParameter("kommentti");
			
			System.out.println("vastaus: "+ vastaus);
			System.out.println("ehdokas id:"+ehdokas_id);
			System.out.println("kysymys id:"+kysymys_id);
			System.out.println("kommentti:"+kommentti);
																	
			Answer a = new Answer(ehdokas_id, kysymys_id, vastaus, kommentti);
			
			ArrayList<Answer> list = null;
			if (dao.getConnection()) {
				list=dao.saveAnswer(a);
			}
		
			request.setAttribute("answerlist", list);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/tallennettu.jsp");
			rd.forward(request, response);
	}	}

}
