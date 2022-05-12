package rest;

import java.io.IOException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//import data.AdminQuestion;
import data.Kysymykset;


@Path ("/questionservice")
public class QuestionService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikonetta");

	@GET
	@Path("/readadminquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> adminReadQuestion(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list=em.createQuery("SELECT k FROM Kysymykset k").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/etusivuAdmin.jsp");
		request.setAttribute("adminquestionlist", list);
		System.out.println(list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
		
	}	
	
	@GET
	@Path("/readalladminquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAllAdminQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list=em.createQuery("SELECT k FROM Kysymykset k").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/etusivuAdmin.jsp");
		request.setAttribute("adminquestionlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
//	@POST
//	@Path("/addquestion")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> addAdminQuestion(Kysymykset kysymykset) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(kysymykset);
//		em.getTransaction().commit();
//		List<Kysymykset> list=adminReadQuestion();		
//		return list;
//	}	
	
//	@POST
//	@Path("/updatequestion")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<AdminQuestion> updateAdminQuestion(AdminQuestion kysymys) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(kysymys);
//		em.getTransaction().commit();
//		List<AdminQuestion> list=adminReadQuestion();
//		return list;
//		
//	}
}
