	package bilutleie;

import javax.persistence.*;
import java.util.*;

/**
 * Bil-entitet.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(name = "bil", schema = "bilutleie")
public class Bil {
    @Id
    private String regnr;
    @Column(name = "merke")
    private String merke;
    private String modell;
    private String farge;
    private Boolean ledig = Boolean.TRUE;

    @OneToOne
    @JoinColumn(name = "kategori", referencedColumnName = "verdi")
    private Kategori kategori;
    	
    @OneToMany(mappedBy = "bil")
    private List<Bestilling> bestillinger;

    @ManyToOne
    @JoinColumn(name = "selskap", referencedColumnName = "navn")
    // insertable = true, updatable = true)
    private Bilutleieselskap selskap;

    @ManyToOne
    @JoinColumn(name = "kontor", referencedColumnName = "nummer")
    private Utleiekontor kontor;

    /**
     * Konstruktør
     * 
     */
    
    public Bil() {
    	regnr = "";
    	merke = "";
    	modell = "";
    	farge = "";
    	
    }
    
    /**
     * Henter regnr.
     *
     * @return regnr
     */
    public String getRegnr() {
        return regnr;
    }

    /**
     * Setter regnr.
     *
     * @param regnr regnr
     */
    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    /**
     * Henter merke.
     *
     * @return merke
     */
    public String getMerke() {
        return merke;
    }

    /**
     * Setter merke.
     *
     * @param merke merke
     */
    public void setMerke(String merke) {
        this.merke = merke;
    }

    /**
     * Henter modell.
     *
     * @return modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * Setter modell.
     *
     * @param modell modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * Henter farge.
     *
     * @return farge
     */
    public String getFarge() {
        return farge;
    }

    /**
     * Setter farge.
     *
     * @param farge farge
     */
    public void setFarge(String farge) {
        this.farge = farge;
    }

    /**
     * Henter kategori.
     *
     * @return kategori
     */
    public Kategori getKategori() {
        return kategori;
    }

    /**
     * Setter kategori.
     *
     * @param kategori kategori
     */
    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    /**
     * Henter kontor.
     *
     * @return kontor
     */
    public Utleiekontor getKontor() {
        return kontor;
    }

    /**
     * Setter kontor.
     *
     * @param kontor kontor
     */
    public void setKontor(Utleiekontor kontor) {
        this.kontor = kontor;
    }

    /**
     * Henter ledig.
     *
     * @return ledig
     */
    public Boolean getLedig() {
        return ledig;
    }

    /**
     * Setter ledig
     * 
     * @param  ledig ledig
     */
    public void setLedig(Boolean ledig) {
    	this.ledig = ledig;
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
     * Henter selskap.
     * 
     * @return
     */
    public Bilutleieselskap getSelskap() {
    	return selskap;
    }
    
    public String toString() {
    	return regnr + " " + merke + " " +  modell + " " + farge;
    }
}
