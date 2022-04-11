package data;


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
	
	public Answer() {

	}
	
	public String getEhdokasId() {
		return ehdokas_id;
	}
	
	public void setEhdokasId(String ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	
	public int getKysymysId() {
		
		return kysymys_id;
	}
	
	public void setKysymysId(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	
	public String getVastaus() {
		return vastaus;
	}
	
	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}
	
	public String getKommentti() {
		return kommentti;
	}
	
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

}
