package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminQuestion {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)  //auton tilalla IDENTITY
		private int kysymys_id;
		private String kysymys;
		
		public AdminQuestion() {
//			super();
		}
		
		public AdminQuestion(String kysymys) {
			this.kysymys = kysymys;
		}
		
		public AdminQuestion(int kysymys_id, String kysymys) {
			this.kysymys_id=kysymys_id;
			this.kysymys = kysymys;
		}

		public AdminQuestion(String kysymys_id, String kysymys) {
			// TODO Auto-generated constructor stub
//			setId(kysymys_id);
			this.setKysymys_id(kysymys_id);
			this.kysymys = kysymys;
		}
		public int getKysymys_id() {
			return kysymys_id;
		}

		public void setKysymys_id(int kysymys_id) {
			this.kysymys_id = kysymys_id;
		}
		public void setKysymys_id(String kysymys_id) {
			try {
				this.kysymys_id = Integer.parseInt(kysymys_id);
			} catch (NumberFormatException | NullPointerException e) {
			}
		}

		public String getKysymys() {
			return kysymys;
		}

		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}

}
