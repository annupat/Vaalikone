package data;


public class Answer {
	private String vastaus = "";
	private String kysymys_id;
	private String ehdokas_id;
	private String kommentti = "ehdokkaan " + ehdokas_id + " vastaus kysymykseen " + kysymys_id;
	
	public Answer(String ehdokas_id, String kysymys_id, String vastaus, String kommentti) {
		this.vastaus = vastaus;
	}
	
	public Answer() {

	}
	
	public String getEhdokasId() {
		return ehdokas_id;
	}
	
	public void setEhdokasId(String ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	
	public String getKysymysId() {
		
		return kysymys_id;
	}
	
	public void setKysymysId(String kysymys_id) {
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
