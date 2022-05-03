package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;


import com.mysql.jdbc.Statement;

import dao.Dao2;
import data.AdminQuestion;

@WebServlet(
		name = "AdminReadQuestions",
		urlPatterns = {"/adminreadquestions"}
		)

public class AdminReadQuestions extends HttpServlet {
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		doGet(request, response);
		AdminQuestion adminQuestion = readAllAdminQuestions(request);
		Dao2 dao = new Dao2();
		ArrayList<AdminQuestion> list = dao.readAllAdminQuestions();
		printAdminQuestionList(out, list);
		dao.close();
		
	}
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("adminEtusivu.html");
			rd.include(request,  response);;
			
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
				
				String kysymys = request.getParameter("kysymys");
				
				Statement stmt = (Statement) conn.createStatement();
				
				readAllAdminQuestions(conn, stmt, kysymys);
				
				ResultSet rs = stmt.executeQuery("select * from kysymykset");
				out.println("<ol>");
				
				while (rs.next()) {
					out.println("<li>"+rs.getString("kysymys"));
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			// out.println("<a href = ./___.html'>Takaisin lomakkeelle</a>");
			
			rd = request.getRequestDispatcher("htmlend.html");
			rd.include(request, response);;
	}
	
	
	private int readAllAdminQuestions(Connection conn, Statement stmt, String kysymys) throws SQLException {
		
		int count = stmt.executeUpdate("select * from kysymykset");
		return count; 
	}
	
	private void printAdminQuestionList(PrintWriter out, ArrayList<AdminQuestion> list) {
		out.println("<ul>");
		for (AdminQuestion q:list) {
			out.println("<li>"+q);
		}
		out.println("</ul>");
	}
}




