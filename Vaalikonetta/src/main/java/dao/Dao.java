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

	
	public Dao(String url, String user, String pass) {	
		this.url=url;
		this.user=user;
		this.pass=pass;

  }


	public boolean getConnection() {
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Question> readAllQuestion() {
		ArrayList<Question> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from kysymykset");
			while (RS.next()) {
				Question q = new Question();
				q.setId(RS.getInt("kysymys_id"));
				q.setKysymys(RS.getString("kysymys"));
				list.add(q);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Answer> readAllAnswer() {
		ArrayList<Answer> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from vastaukset");
			while (RS.next()) {
				Answer a = new Answer();
				a.setEhdokas_id(RS.getInt("ehdokas_id"));
				a.setKysymys_id(RS.getInt("kysymys_id"));
				a.setVastaus(RS.getInt("vastaus"));
				a.setKommentti(RS.getString("kommentti"));
				list.add(a);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}
  //	public Question readQuestion(String kysymys_id) {							//luetaan tietty kysymys
	//	Question q=null;

	public ArrayList<Answer> readAnswer(String ehdokas_id) {
		ArrayList<Answer> list = new ArrayList<>();
		try {
			String sql = "select * from vastaukset where ehdokas_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				Answer a = new Answer();
				a.setEhdokas_id(RS.getInt("ehdokas_id"));
				a.setKysymys_id(RS.getInt("kysymys_id"));
				a.setVastaus(RS.getInt("vastaus"));
				a.setKommentti(RS.getString("kommentti"));
				list.add(a);
				System.out.println("Toimii!");
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Ei toimi");
			return null;
		}
	}

	public ArrayList<Answer> deleteAnswer(String ehdokas_id, String kysymys_id) {
		try {
			String sql = "delete from vastaukset where ehdokas_id=? and kysymys_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			pstmt.setString(2, kysymys_id);
			pstmt.executeUpdate();
			System.out.println("Vastaus kysymykseen nro " + kysymys_id + " poistettu");
			return readAllAnswer();
      
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
}
	
	public ArrayList<Answer> saveAnswer(Answer a) {
		 ArrayList<Answer> list = new ArrayList<>();
		try {
			String sql = "Insert into vastaukset (ehdokas_id, kysymys_id, vastaus, kommentti) values (?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			System.out.println("ehdokas_id" + a.getEhdokas_id());
			System.out.println("kysymys_id" + a.getKysymys_id());
			pstmt.setInt(1, a.getEhdokas_id());
			pstmt.setInt(2, a.getKysymys_id());
			pstmt.setInt(3, a.getVastaus());
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

	public ArrayList<Question> updateQuestions(Question q) {
		try {
			String sql="update given answer=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getKysymys());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}

	}
}

