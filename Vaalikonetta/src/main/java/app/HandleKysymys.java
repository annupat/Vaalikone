package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Kysymykset;

@WebServlet(urlPatterns = { "/addkysymys", "/deletedminquestion" ,"/updatekysymys", "/readtoupdatekysymys"})
public class HandleKysymys extends HttpServlet {
//	private static final long serialVersionUID = 1L;

//	public HandleKysymys() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		List<Kysymykset> list = null;
		switch (action) {
		case "/addkysymys":
			list = addkysymys(request);
			break;
		case "/readkysymys":
			list = readKysymys(request);
			break;

		case "/deleteadminquestion":
			String kysymysId = request.getParameter("kysymysId");
			list = deleteadminquestion(request);
			break;
		
		  case "/updatekysymys":
			  list=updatekysymys(request);break;
			  
		case "/readtoupdatekysymys":
			Kysymykset k = readtoupdatekysymys(request);
			request.setAttribute("kysymykset", k);
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/kysymysform.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("kysymyslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("./jsp/kysymysform.jsp");
		rd.forward(request, response);
	}

	private List<Kysymykset> addkysymys(HttpServletRequest request) {
		Kysymykset k = new Kysymykset(request.getParameter("kysymys"));
		System.out.println(k);
		String uri = "http://127.0.0.1:8080/rest/questionservice/addkysymys";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		b.header("Authorization", request.getHeader("Authorization"));
		Entity<Kysymykset> e = Entity.entity(k, MediaType.APPLICATION_JSON);
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {
		};

		List<Kysymykset> returnedList = b.post(e, genericList);
		return returnedList;
	}

	private List<Kysymykset> readKysymys(HttpServletRequest request) {
		String kysymysId = request.getParameter("kysymysId");
		String uri = "http://127.0.0.1:8080/rest/questionservice/readkysymys";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		b.header("Authorization", request.getHeader("Authorization"));

		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {
		};

		List<Kysymykset> returnedList = b.get(genericList);
		return returnedList;
	}

	private List<Kysymykset> deleteadminquestion(HttpServletRequest request) {
		String kysymysId = request.getParameter("kysymysId");
		String uri = "http://127.0.0.1:8080/rest/questionservice/deleteadminquestion/"+kysymysId;
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		b.header("Authorization", request.getHeader("Authorization"));
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {
		};

		List<Kysymykset> returnedList = b.delete(genericList);
		return returnedList;
	}

	private List<Kysymykset> updatekysymys(HttpServletRequest request) {
		// A Fish object to send to our web-service
		Kysymykset k = new Kysymykset(request.getParameter("kysymysId"), request.getParameter("kysymys"));
		System.out.println(k);
		String uri = "http://127.0.0.1:8080/rest/questionservice/updatekysymys";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		// alla olevan rivin lisäsin, muuta en muuttanut
		b.header("Authorization", request.getHeader("Authorization"));
		
		Entity<Kysymykset> e = Entity.entity(k, MediaType.APPLICATION_JSON);
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {
		};
		// Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Kysymykset> returnedList = b.post(e, genericList);
		return returnedList;
	}
	private Kysymykset readtoupdatekysymys(HttpServletRequest request) {
		String kysymysId=request.getParameter("kysymysId");
		String uri = "http://127.0.0.1:8080/rest/questionservice/readtoupdatekysymys/"+kysymysId;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Kysymykset kysymykset=b.get(Kysymykset.class);
		return kysymykset;

		 
		}
	
}
