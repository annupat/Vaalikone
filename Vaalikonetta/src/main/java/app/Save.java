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
 * Servlet implementation class Save
 */
@WebServlet(
		name = "Save",
		urlPatterns = {"/Save"}
)

public class Save extends HttpServlet {
	private Dao dao;
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "mona", "Nikunacho69!");
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
			String ehdokas_id = request.getParameter("ehdokas_id");
			String kysymys_id = request.getParameter("kysymys_id");
			String vastaus = request.getParameter("vastaus_0");
			String kommentti = request.getParameter("Ehdokkaan " + ehdokas_id + "vastaus kysymykseen " + kysymys_id);
			
			System.out.println("Vastaus:"+vastaus);
			System.out.println("ehdokas:"+ehdokas_id);
			System.out.println("kysymys:"+kysymys_id);
			System.out.println("kommentti:"+kommentti);
			
			Answer a = new Answer(ehdokas_id, kysymys_id, vastaus, kommentti);
			
			ArrayList<Answer> list = null;
			if (dao.getConnection()) {
				list = dao.saveAnswer(a);
			}
			
			request.setAttribute("questionlist", list);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/tallennettu.jsp");
			rd.forward(request, response);
	}

}
