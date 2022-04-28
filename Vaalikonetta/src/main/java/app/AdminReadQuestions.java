package app;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import data.AdminQuestion;

@WebServlet(urlPatterns = {"/adminreadquestions"})

//public class AdminReadQuestions extends HttpServlet {
//	@Override 
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//		throws IOException {
	
public class AdminReadQuestions {
	@GET
	@Path("/allquestions")
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<AdminQuestion> readAllQuestions() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em = emf.createEntityManager();
		
		ArrayList<AdminQuestion> list = (ArrayList<AdminQuestion>) em.createNamedQuery("select a from AdminQuestion a").getResultList();
		return list;
	}
		
}



