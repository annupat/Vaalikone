package app;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.AdminQuestion;

@WebServlet("/addquestion")
public class AdminSaveQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	String action = request.getServletPath();
	List<AdminQuestion> list=null;
	list=addquestion(request);
	
	request.setAttribute("questionlist", list);
	  RequestDispatcher rd=request.getRequestDispatcher("/jsp/questionform.jsp");
	  rd.forward(request, response);
	//response.getWriter().append("Served at: ").append(request.getContextPath());
}
	
	private List<AdminQuestion> addquestion(HttpServletRequest request) {
		AdminQuestion a=new AdminQuestion(request.getParameter("kysymys"));
		System.out.println(a);
		String uri = "http://127.0.0.1:8080/rest/questionservice/addquestion";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Entity<AdminQuestion> e=Entity.entity(a,MediaType.APPLICATION_JSON);
		GenericType<List<AdminQuestion>> genericList = new GenericType<List<AdminQuestion>>() {};
		
		List<AdminQuestion> returnedList=b.post(e, genericList);
		return returnedList;
	}

}
