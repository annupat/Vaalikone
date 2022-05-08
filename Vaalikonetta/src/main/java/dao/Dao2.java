package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import data.AdminQuestion;

public class Dao2 {
	
	private EntityManager em;
	public Dao2(EntityManager em) {
		this.em=em;
	}
	

public void addQuestion(AdminQuestion question) { 

em.getTransaction().begin(); 
em.persist(question); 
em.getTransaction().commit(); 

} 

public AdminQuestion getQuestion(AdminQuestion question) { 

return new AdminQuestion(); 

} 

public AdminQuestion getQuestion(int id) {

	return new AdminQuestion();

}

//public ArrayList<AdminQuestion> deleteQuestion(AdminQuestion question) {
//	em.getTransaction().begin();
//	AdminQuestion q = em.find(AdminQuestion.class, AdminQuestion.getKysymys_id());

//	if (q != null) {
//		em.remove(q);// The actual insertion line
//
//	}
//
//	em.getTransaction().commit();
//
//	ArrayList<AdminQuestion> list = readAdminQuestion();
//	return list;
//}

//public ArrayList<AdminQuestion> updateAdminQuestion(AdminQuestion question) {
//	em.getTransaction().begin();
//
//	AdminQuestion q = em.find(AdminQuestion.class, question.getId());
//	if (q != null) {
//		em.merge(question);// The actual update line
//	}
//	em.getTransaction().commit();
//
////Calling the method readFish() of this service 
//	ArrayList<AdminQuestion> list = readAdminQuestion();
//	return list;
//
//}

public ArrayList<AdminQuestion> readAdminQuestion() {
	em.getTransaction().begin();
	ArrayList<AdminQuestion> list = (ArrayList<AdminQuestion>) em.createQuery("select a from AdminQuestion a").getResultList();
	em.getTransaction().commit();
	return list;

}

 
	////////////////////////////////////
		private Connection conn;
		public Dao2() {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public void close() {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<AdminQuestion> readAllAdminAdminQuestion() {
			ArrayList<AdminQuestion> list = new ArrayList<>();
			Statement stmt = null;
			int count = 0;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from kysymykset");
				while (rs.next()) {
					AdminQuestion adminQuestion = new AdminQuestion();
					adminQuestion.setKysymys_id(rs.getInt("id"));
					adminQuestion.setKysymys(rs.getString("kysymys_id"));
					list.add(adminQuestion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(list);
			return list;
			
		}
}
