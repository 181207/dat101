package bilutleie;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entitetsklasse for bilutleieselskap.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema = "bilutleie")
public class Bilutleieselskap {

    @Id
    private String navn;
    private Integer telefon;

    // Adresser skal lagres i datab	asen når de er laget og lagt til et selskap
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse", referencedColumnName = "id")
    private Adresse adresse;

    // Her er det komposisjon
    @OneToMany(mappedBy = "selskap", cascade = CascadeType.ALL)
    private List<Utleiekontor> kontorer;

    // Her er det komposisjon
    @OneToMany(mappedBy = "selskap", cascade = CascadeType.ALL)
    private List<Bil> biler;

    // Her er det komposisjon
    @OneToMany(mappedBy = "selskap", cascade = CascadeType.PERSIST)
    private List<Kategori> kategorier;
    
    
    public Bilutleieselskap() {
    	navn = "";
    	telefon = 0;
    	biler = new ArrayList<>();
    	kontorer = new ArrayList<>();
    	kategorier = new ArrayList<>();
    	
    }

    /**
     * Henter navn.
     *
     * @return navn
     */
    
    public void leggTil(Utleiekontor kontor) {
    	kontorer.add(kontor);
    }
    
    public void leggTil(Bil bil) {
    	biler.add(bil);
    }
    public void leggTil(Kategori kategori) {
    	kategorier.add(kategori);
    }
    
    public void skrivUtBiler() {
    	for(int i = 0; i < biler.size(); i++) {
    		System.out.println(biler.get(i).toString());
    	}
    }
    public String getNavn() {
        return navn;
    }

    /**
     * Setter navn.
     *
     * @param navn navn
     */
    public void setNavn(String navn) {
        this.navn = navn;
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
     * Henter kontorer.
     *
     * @return kontorer
     */
    public List<Utleiekontor> getKontorer() {
        return kontorer;
    }
    
    /**
     * Setter kontorer.
     * 
     * @param kontorer
     */
    public void setKontorer(List<Utleiekontor> kontorer) {
    	this.kontorer = kontorer;
    }

    /**
     * Henter biler.
     *
     * @return biler
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
     * Henter kategorier.
     *
     * @return kategorier
     */
    public List<Kategori> getKategorier() {
        return kategorier;
    }
    
    /**
     * Setter kategorier.
     * 
     * @param kategorier
     */
    public void setKategorier(List<Kategori> kategorier) {
    	this.kategorier = kategorier;
    }

}
