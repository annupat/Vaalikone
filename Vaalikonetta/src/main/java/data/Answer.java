package data;

public class Answer {
	private int ehdokas_id;
	private int kysymys_id;
	private int vastaus;
	private String kommentti;

	public Answer(String ehdokas_id, String kysymys_id, String vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		setKysymys_id(kysymys_id);
		this.vastaus = Integer.parseInt(vastaus);
	}

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public int getEhdokas_id() {
		return ehdokas_id;
	}


	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}

	public void setEhdokas_id(String ehdokas_id) {
		try {
			this.ehdokas_id = Integer.parseInt(ehdokas_id);
		} catch (NumberFormatException | NullPointerException e) {
			// Do nothing - the value of id won't be changed
		}
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
			// Do nothing - the value of id won't be changed
		}
	}

	public int getVastaus() {
		return vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

	public void setVastaus(String vastaus) {
		try {
			this.vastaus = Integer.parseInt(vastaus);
		} catch (NumberFormatException | NullPointerException e) {
			// Do nothing - the value of id won't be changed
		}
	}

	public String getKommentti() {
		return kommentti;
	}


public class Answer {
	private String vastaus = "";
	private int kysymys_id;
	private String ehdokas_id;
	private String kommentti;
	
	public Answer(String ehdokas_id, int kysymys_id, String vastaus) {
		this.kommentti = "ehdokkaan " + ehdokas_id + " vastaus kysymykseen " + kysymys_id;
		this.vastaus = vastaus;
		this.ehdokas_id = ehdokas_id;
		this.kysymys_id = kysymys_id;
	}
}

}
