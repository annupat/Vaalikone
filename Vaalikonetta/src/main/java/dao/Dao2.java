package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.AdminQuestion;

public class Dao2 {
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
		
		public ArrayList<AdminQuestion> readAllAdminQuestions() {
			ArrayList<AdminQuestion> list = new ArrayList<>();
			Statement stmt = null;
			int count = 0;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from kysymykset");
				while (rs.next()) {
					AdminQuestion adminQuestion = new AdminQuestion();
					adminQuestion.setId(rs.getInt("id"));
					adminQuestion.setKysymys(rs.getString("kysymys_id"));
					list.add(adminQuestion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
}
