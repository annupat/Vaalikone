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

import data.AdminQuestion;


@Path ("/questionservice")
public class QuestionService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikonetta");

	@GET
	@Path("/readadminquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AdminQuestion> adminReadQuestion() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<AdminQuestion> list=em.createQuery("select a from kysymykset a").getResultList();		
		em.getTransaction().commit();
		System.out.println(list);
		return list;
		
	}	
	
	@POST
	@Path("/addquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AdminQuestion> addAdminQuestion(AdminQuestion kysymys) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymys);
		em.getTransaction().commit();
		List<AdminQuestion> list=adminReadQuestion();		
		return list;
	}	
}
