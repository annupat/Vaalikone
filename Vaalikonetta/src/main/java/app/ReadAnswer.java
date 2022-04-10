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


/**
 * Servlet implementation class ReadAnswer
 */
@WebServlet("/readanswer")
public class ReadAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ehdokas_id=request.getParameter("ehdokas_id");
		ArrayList<Answer> list=null;										
		if (dao.getConnection()) {		
			list=dao.readAllAnswer();	
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("answerlist", list);		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/deleteanswer.jsp");		
		rd.forward(request, response);
		
	}

//public void doGet(HttpServletRequest request, HttpServletResponse response) 
//	     throws IOException {
//		response.sendRedirect("index.html");
//	}
//	public void doPost(HttpServletRequest request, HttpServletResponse response) 
//	     throws IOException, ServletException {
//		String ehdokas_id=request.getParameter("ehdokas_id");
//		String kysymys_id=request.getParameter("kysymys_id");
//		String vastaus=request.getParameter("vastaus");
//		
//		Answer a=new Answer(ehdokas_id, kysymys_id, vastaus);
//		
//		ArrayList<Answer> list=null;
//		if (dao.getConnection()) {
//			list=dao.deleteAnswer(ehdokas_id,kysymys_id);
//		}
//		
//		request.setAttribute("answerlist", list);
//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/deleteanswer.jsp");
//		rd.forward(request, response);
//	}

}
