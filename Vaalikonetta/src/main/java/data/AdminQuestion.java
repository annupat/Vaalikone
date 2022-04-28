package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminQuestion {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int kysymys_id;
		private String kysymys;
		
		public AdminQuestion() {
			super();
		}

		public AdminQuestion(String kysymys_id, String kysymys) {
			// TODO Auto-generated constructor stub
			setId(kysymys_id);
			this.kysymys = kysymys;
		}

		public int getId() {
			return kysymys_id;
		}

		public void setId(int id) {
			this.kysymys_id = id;
		}

		public void setId(String id) {
			try {
				this.kysymys_id = Integer.parseInt(id);
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
