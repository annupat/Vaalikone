package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answer;
import data.Question;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readtoupdate")
public class ReadToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ehdokas_id=request.getParameter("ehdokas_id");
		ArrayList<Answer> list=null;
		if (dao.getConnection()) {
			list=dao.readAnswer(ehdokas_id);
		//	System.out.println("Kysymys_id: " + kysymys_id);
			System.out.println("Ehdokas_id: " + ehdokas_id);
		}	
		request.setAttribute("answerlist", list);	
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/muokkaa.jsp");  
		rd.forward(request, response);
		
		ServletContext servletcontext = getServletContext();
		servletcontext.setAttribute("ehdokas_id", ehdokas_id);
	}
}

