package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Question;
import data.Answer;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {		//annetaan tiedot yhteydestä
		this.url=url;
		this.user=user;
		this.pass=pass;

}
	
	public boolean getConnection() {						//luodaan yhteys
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Question> readAllQuestion() {							
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Question q=new Question();
				q.setId(RS.getInt("kysymys_id"));
				q.setKysymys(RS.getString("kysymys"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
		}
	

	
	public Question readQuestion(String kysymys_id) {							//luetaan tietty kysymys
		Question q=null;
		try {
			String sql="select * from kysymys where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				q=new Question();
				q.setId(RS.getInt("kysymys_id"));
				q.setKysymys(RS.getString("kysymys"));
			}
			return q;
		}
		catch(SQLException e) {
			return null;
		}
	}
	

	public ArrayList<Answer> saveAnswer(Answer a) {
		 ArrayList<Answer> list = new ArrayList<>();
		try {
			String sql = "Insert into vastaukset (ehdokas_id, kysymys_id, vastaus, kommentti) values (?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			System.out.println("ehdokas_id" + a.getEhdokasId());
			System.out.println("kysymys_id" + a.getKysymysId());
			pstmt.setString(1, a.getEhdokasId());
			pstmt.setInt(2, a.getKysymysId());
			pstmt.setString(3, a.getVastaus());
			pstmt.setString(4, a.getKommentti());
			pstmt.executeUpdate();
			System.out.println("Tiedot lähetetty tietokantaan");
			
			return list;
			
		}
		catch(SQLException e) {
			System.out.println("Tiedot ei lähetetty tietokantaan" +e);
			return null;
	}
	}

}