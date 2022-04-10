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

@WebServlet(
    name = "Update",
    urlPatterns = {"/update"}
)
public class updateQuestions extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "timojaakko", "T1mo67");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("ReadToUpdate.java");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		String kysymys=request.getParameter("kysymys");
		
		Question f=new Question(id, kysymys);
		
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.updateQuestions(f);
		}
		
		request.setAttribute("Questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/vastaa.jsp");
		rd.forward(request, response);
	}
}
