package data;

//import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 * The persistent class for the kysymykset database table.
 * 
 */
@Entity
//@Table(name = "kysymykset")
//@NamedQuery(name="Kysymykset.findAll", query="SELECT k FROM Kysymykset k")
public class Kysymykset {//implements Serializable {
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KYSYMYS_ID")
	private int kysymysId;

	private String kysymys;

	public Kysymykset() {
	}

	public Kysymykset(String kysymys) {
		this.kysymys=kysymys;
	
	}
	public Kysymykset(int kysymysIid, String kysymys) {
		this.kysymysId=kysymysId;
		this.kysymys=kysymys;
	}
	
	public Kysymykset(String kysymysId, String kysymys) {
		this.setKysymysId(kysymysId);
		this.kysymys=kysymys;
	}
	public int getKysymysId() {
		return this.kysymysId;
	}

	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}
	
	public void setKysymysId(String kysymysId) {
		this.kysymysId = Integer.parseInt(kysymysId);
	}

	public String getKysymys() {
		return this.kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	public String toString() {
		return this.kysymysId+": "+this.kysymys;
	}
//	public List<Kysymykset> getKysymyksetAdmin() {
//		return this.kysymyksetAdmin;
//	}
//	
	
	// Lukee kaikki kalat 
		// Fish<Fish> list=em.createQuery("select k from Fish k").getResultList();

}