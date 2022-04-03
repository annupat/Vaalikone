package data;

public class Question {
	private int kysymys_id;
	private String kysymys;	

	public Question(String kysymys_id, String kysymys) {
		// TODO Auto-generated constructor stub
		setId(kysymys_id);
		this.kysymys=kysymys;
	}
	public Question() {
		// TODO Auto-generated constructor stub
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
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
}


