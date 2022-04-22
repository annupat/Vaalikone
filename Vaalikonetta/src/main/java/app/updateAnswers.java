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

/**
 * @author TjWidgren
 * 
 * Update eli päivitys sivu jossa lopussa kutsutaan jsp tallennettu sivu joka näkyy käyttäjälle.
 *
 */
@WebServlet(
    name = "Update",
    urlPatterns = {"/update"}
)
public class updateAnswers extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("ReadToUpdate.java");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		ServletContext servletcontext = getServletContext();
        String ehdokas_id=(String) servletcontext.getAttribute("ehdokas_id");
		String kysymys_id=request.getParameter("kysymys_id");
		String vastaus=request.getParameter("vastaus");
		
//		Answer a=new Answer(ehdokas_id, kysymys_id);
		
		ArrayList<Answer> list=null;
		if (dao.getConnection()) {
			list=dao.updateAnswers(ehdokas_id, kysymys_id, vastaus);
			System.out.println(kysymys_id);
			System.out.println(ehdokas_id);
		}
		
		request.setAttribute("Answerlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/tallennettu.jsp");
		rd.forward(request, response);
	}
}
