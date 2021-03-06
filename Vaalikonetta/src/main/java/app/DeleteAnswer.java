
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
 * @author annukkapatrikainen
 *
 *         DeleteAnswer poistaa halutun vastuksen
 *
 */

@WebServlet(name = "DeleteAnswer", urlPatterns = { "/delete" })
public class DeleteAnswer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * Luodaan Dao-luokan avulla mysql-yhteys
	 */
	private Dao dao;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}

	/**
	 * Saa kysymys_id:n requestina DeleteAnswer.jsp:lta Saa ehdokas_id:n
	 * servletContextilla ReadAnwer.java-luokasta Poistaa Dao-luokan metodilla
	 * halutun ehdokkaan hautun vastauksen Ohjaa muokatun vastauslistan tulostumaan
	 * poistettu.jsp:lle
	 */

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String kysymys_id = request.getParameter("kysymys_id");
		ServletContext servletcontext = getServletContext();
		String ehdokas_id = (String) servletcontext.getAttribute("ehdokas_id");
		ArrayList<Answer> list = null;
		if (dao.getConnection()) {
			list = dao.deleteAnswer(ehdokas_id, kysymys_id);
			System.out.println("Kysymys_id: " + kysymys_id);
			System.out.println("Ehdokas_id: " + ehdokas_id);
		}
		request.setAttribute("answerlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/poistettu.jsp");
		rd.forward(request, response);
	}
}