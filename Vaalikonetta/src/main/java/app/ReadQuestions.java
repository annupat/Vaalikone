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
 * @author Mona J‰‰skel‰inen & Annukka Patrikainen
 *Luokka lukee tietokannasta kysymykset dao-luokan metodin avulla. Kysymyslista l‰hetet‰‰n vastaa.jsp:lle.
 *
 */
@WebServlet("/readquestions")
public class ReadQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}   
	

    public ReadQuestions() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Question> list=null;										//
		if (dao.getConnection()) {		
			list=dao.readAllQuestion();		
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/vastaa.jsp");		
		rd.forward(request, response);
		
	}

	

}
