package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answer;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readtodelete")
public class ReadToDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadToDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ehdokas_id=request.getParameter("ehdokas_id");
		Answer a=null;
		if (dao.getConnection()) {
			a=dao.readAnswer(ehdokas_id);
		}
		request.setAttribute("answer", a);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/dr.jsp");
		rd.forward(request, response);
	}
}
