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
	@Path("/readkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> readKysymys() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list=em.createQuery("select k from Kysymykset k").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	
	
	 @GET
	    @Path("/readadminquestion")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Kysymykset> adminReadQuestion() {
	        EntityManager em=emf.createEntityManager();
	        em.getTransaction().begin();
	        List<Kysymykset> list=em.createQuery("SELECT k FROM Kysymykset k").getResultList();       
	        em.getTransaction().commit();
	        System.out.println(list);
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
	        RequestDispatcher rd = request.getRequestDispatcher("/jsp/kysymysform.jsp");
	        request.setAttribute("adminquestionlist", list);
	        try {
	            rd.forward(request, response);
	        } catch (ServletException | IOException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        }
	    }
	
	@POST
	@Path("/addkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> addKysymys(Kysymykset kysymykset) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymykset);
		em.getTransaction().commit();
		List<Kysymykset> list=adminReadQuestion();		
		return list;
	}	
	
	@PUT
	@Path("/updatekysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> updateKysymys(Kysymykset kysymys) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymys);
		em.getTransaction().commit();
		List<Kysymykset> list=adminReadQuestion();
		return list;
		
	}
	
	@GET
	@Path("/readtoupdatekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Kysymykset readToUpdateKysymys(@PathParam("kysymysId") int kysymysId) { 
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	Kysymykset k=em.find(Kysymykset.class, kysymysId); 
	em.getTransaction().commit();
	return k;
	}
	
//	@DELETE
//	@Path("/deleteadminquestion/{kysymysId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> deletekysymys(@PathParam("kysymysId") int kysymysId) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		Kysymykset k=em.find(Kysymykset.class, kysymysId);
//		if (k!=null) {
//			em.remove(k);//The actual delete line
//		}
//		em.getTransaction().commit();
//		//Calling the method readFish() of this service
//		List<Kysymykset> list=readKysymys();		
//		return list;
//	}	
	@GET
	@Path("/deleteadminquestion/{kysymysId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteKysymysByGet(@PathParam("kysymysId") int kysymysId, 
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k=em.find(Kysymykset.class, kysymysId);
		if (k!=null) {
			em.remove(k);//The actual delete line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymykset> list=readKysymys();		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/kysymysform.jsp");
		request.setAttribute("kysymykset", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}

