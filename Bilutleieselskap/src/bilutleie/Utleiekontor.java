package bilutleie;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Utleiekontor-entitet.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema = "bilutleie")
public class Utleiekontor {
    @Id
    private Integer nummer;
    private Integer telefon;

    // Merk at dette er en aggregering, men IKKE komposisjon
    // Biler skal IKKE lagres når de legges til et kontor, de skal allerede være lagret
    @OneToMany(mappedBy = "kontor")
    private List<Bil> biler;

    // Adresser skal lagres i databasen når de er laget og lagt til et kontor
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse", referencedColumnName = "id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "selskap", referencedColumnName = "navn", insertable = true, updatable = true)
    private Bilutleieselskap selskap;
    
    @OneToMany
    private List<Bestilling> bestillinger;
    
    
    public Utleiekontor() {
    	nummer = 0;
    	telefon = 0;
    	bestillinger = new ArrayList<>();
    	biler = new ArrayList<>();
    	
    }
    
    /**
     * Leier ut bil 
     * 
     * @param bil
     */
    public void leieUt(Bil bil) {
    	bil.setLedig(false);
    }
    /**
     * Tar en bil i retur
     * 
     * @param bil
     */
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
    /**
     * Legger bil til biler.
     * 
     * @param bil
     */
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
    
    /**
     * Legger bestilling til bestillinger.
     * 
     * @param bestilling
     */
    public void leggTil(Bestilling bestilling) {
    	bestillinger.add(bestilling);
    }
    /**
     * Henter nummer.
     *
     * @return nummer
     */
    public Integer getNummer() {
        return nummer;
    }

    /**
     * Setter nummer.
     *
     * @param nummer nummer
     */
    public void setNummer(Integer nummer) {
        this.nummer = nummer;
    }

    /**
     * Henter telefon.
     *
     * @return telefon
     */
    public Integer getTelefon() {
        return telefon;
    }

    /**
     * Setter telefon.
     *
     * @param telefon telefon
     */
    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    /**
     * Henter adresse.
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter adresse.
     *
     * @param adresse adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    /**
     * Henter biler.
     * 
     * @return
     */
    public List<Bil> getBiler() {
    	return biler;
    }
    
    /**
     * Setter biler.
     * 
     * @param biler
     */
    public void setBiler(List<Bil> biler) {
    	this.biler = biler;
    }
    
    /**
     * Henter selskap.
     * 
     * @return
     */
   public Bilutleieselskap getSelskap() {
	   return selskap;
   }
   
   /**
    * Setter selskap.
    * 
    * @param selskap
    */
   public void setSelskap(Bilutleieselskap selskap) {
	   this.selskap = selskap;
   }
   
   /**
    * Henter bestillinger.
    * 
    * @return
    */
   public List<Bestilling> getBestillinger() {
	   return bestillinger;
   }
   
   /**
    * Setter bestillinger.
    * 
    * @param bestillinger
    */
   public void setBestillinger(List<Bestilling> bestillinger) {
	   this.bestillinger = bestillinger;
   }
}
