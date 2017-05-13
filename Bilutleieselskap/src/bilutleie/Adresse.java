package bilutleie;

import javax.persistence.*;

@Entity
@Table(name = "adresse", schema = "bilutleie")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adrID;
    @Column (name = "gateAdr")
    private String gateAdr;
    @Column (name = "postNr")
    private Integer postnr;
    @Column (name = "poststed")
    private String poststed;
    
    public Adresse(){
    	this(0,"",0,"");
    }
	
    public Adresse(Integer adrID, String gateAdr, Integer postnr, 
    		String poststed) {
		this.adrID = adrID;
		this.gateAdr = gateAdr;
		this.postnr = postnr;
		this.poststed = poststed;
	}
	public Integer getAdrID() {
		return adrID;
	}
	public void setAdrID(Integer adrID) {
		this.adrID = adrID;
	}
	public String getGateAdr() {
		return gateAdr;
	}
	public void setGateAdr(String gateAdr) {
		this.gateAdr = gateAdr;
	}
	public Integer getPostnr() {
		return postnr;
	}
	public void setPostnr(Integer postnr) {
		this.postnr = postnr;
	}
	public String getPoststed() {
		return poststed;
	}
	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}
    
	public void lastOppAdresseDB(EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}
    
}
