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

@WebServlet(
    name = "DeleteAnswer",
    urlPatterns = {"/deleteanswer"}
)
public class DeleteAnswer extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
//		String ehdokas_id=request.getParameter("ehdokas_id");
		String kysymys_id=request.getParameter("kysymys_id");
		ArrayList<Answer> list=null;
		if (dao.getConnection()) {
			list=dao.deleteAnswer(kysymys_id);
		}	
		request.setAttribute("answerlist", list);	
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/deleteanswer.jsp");  
		rd.forward(request, response);
	}
}