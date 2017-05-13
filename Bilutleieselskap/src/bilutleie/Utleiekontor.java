package bilutleie;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "utleiekontor", schema = "bilutleie")
public class Utleiekontor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kontorNR;
    @Column(name = "tlf")
    private Integer tlf;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "selskap", referencedColumnName = "selID")
    private Selskap selskap;

    // Merk at dette er en aggregering, men IKKE komposisjon
    // Biler skal IKKE lagres når de legges til et kontor, de skal allerede være lagret
    @OneToMany(mappedBy = "utleiekontor")
    private List<Bil> biler;

    // Adresser skal lagres i databasen når de er laget og lagt til et kontor
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse", referencedColumnName = "adrID")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "selskap", referencedColumnName = "selID", insertable = true, updatable = true)
    private Selskap selskap;    
    
    public Utleiekontor(){
    	this(0,0,null,null,null);
    }
    
    public Utleiekontor(Integer kontorNR, Integer tlf, Selskap selskap, List<Bil> biler, Adresse adresse) {
		this.kontorNR = kontorNR;
		this.tlf = tlf;
		this.selskap = selskap;
		this.biler = biler;
		this.adresse = adresse;
	}
    
	public void leieUt(Bil bil) {
    	bil.setLedig(false);
    }

    public void taImot(Bil bil) {
    	bil.setLedig(true);
    }
    
    public Bil finnBil(String regnr) {
    	Bil bil = null;
    	for(int i = 0; i < biler.size(); i++) {
    		if(biler.get(i).getRegnr().equals(regnr)) {
    			bil = biler.get(i);
    		}
    	}
    	return bil;
    }

    public void leggTil(Bil bil) {
    	biler.add(bil);
    }
    
    public void ledigeBiler() {
    	System.out.println("Ledige biler:");
    	for(int i = 0; i < biler.size(); i++) {
    		if(biler.get(i).getLedig() == true) {
    			System.out.println(biler.get(i).toString());
    		}
    	}
    }
    public void skrivUtBiler() {
    	for(int i = 0; i < biler.size(); i++) {
    		System.out.println(biler.get(i).toString());
    	}
    }

	public Integer getKontorNR() {
		return kontorNR;
	}

	public void setKontorNR(Integer kontorNR) {
		this.kontorNR = kontorNR;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

	public Selskap getSelskap() {
		return selskap;
	}

	public void setSelskap(Selskap selskap) {
		this.selskap = selskap;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Selskap getSelskap() {
		return selskap;
	}

	public void setSelskap(Selskap selskap) {
		this.selskap = selskap;
	}
    
    
}
