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

@WebServlet(urlPatterns = { "/addkysymys" })
public class HandleKysymys extends HttpServlet {
//	private static final long serialVersionUID = 1L;

//	public HandleKysymys() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<Kysymykset> list = null;
		switch (action) {
		case "/addkysymys":
			list = addkysymys(request);
			break;
		case "/readkysymys":
			list=readKysymys(request);break;
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
		Entity<Kysymykset> e = Entity.entity(k, MediaType.APPLICATION_JSON);
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {
		};

		List<Kysymykset> returnedList = b.post(e, genericList);
		return returnedList;
	}

	private List<Kysymykset> readKysymys(HttpServletRequest request) {
		String kysymysId=request.getParameter("kysymysId");
		String uri = "http://127.0.0.1:8080/rest/questionservice/readkysymys";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
	
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
		
		List<Kysymykset> returnedList=b.get(genericList);
		return returnedList;
	}
	

}
