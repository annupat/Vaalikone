package data;

import data.Question;

public class Answer {
	private String vastaus;
	private String kysymys_id;
	private String ehdokas_id;
	private String kommentti;
	
	public Answer(String ehdokas_id, String kysymys_id, String vastaus, String kommentti) {
		this.vastaus = vastaus;
	}
	
	public Answer() {

	}
	
	public String getEhdokasId() {
		return ehdokas_id;
	}
	
	public String getKysymysId() {
		
		return kysymys_id;
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
