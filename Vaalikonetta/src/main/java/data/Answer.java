package data;

/**
 * Answer-luokka m‰‰ritt‰‰ Answer-muuttujan parametrit ja sis‰lt‰‰ getterit ja setterit
 * @author annukkapatrikainen ja monaj‰‰skel‰inen
 *
 */
public class Answer {
	private int ehdokas_id;
	private int kysymys_id;
	private int vastaus;
	private String kommentti;

	public Answer(String ehdokas_id, int kysymys_id, String vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		setKysymys_id(kysymys_id);
		this.vastaus = Integer.parseInt(vastaus);
		this.ehdokas_id = Integer.parseInt(ehdokas_id);
		this.kommentti = "ehdokkaan " + ehdokas_id + " vastaus kysymykseen " + kysymys_id;

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
			
		}
	}

	public String getKommentti() {
		return kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

}
