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
import data.Question;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readtoupdate")
public class ReadToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "timojaakko", "T1mo67");
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
		ArrayList<Question> list=null;										//
		if (dao.getConnection()) {		
			list=dao.readAllQuestion();		
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/päivitä.jsp");		
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}

