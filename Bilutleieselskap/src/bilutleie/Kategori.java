package bilutleie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Kategori -entitet.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema = "bilutleie")
public class Kategori {
    @Id
    private Character verdi;
    private Double pris;

    @ManyToOne
    @JoinColumn(name = "selskap", referencedColumnName = "navn")
    private Bilutleieselskap selskap;

    /**
     * Lager en ny Kategori.
     */
    public Kategori() {
    	verdi = '?';
    	pris = 0.0;
    }

    /**
     * Lager en ny Kategori.
     *
     * @param verdi verdi
     * @param pris pris
     */
    public Kategori(Character verdi, Double pris) {
        this.verdi = verdi;
        this.pris = pris;
    }

    /**
     * Henter verdi.
     *
     * @return verdi
     */
    public Character getVerdi() {
        return verdi;
    }

    /**
     * Setter verdi.
     *
     * @param verdi verdi
     */
    public void setVerdi(Character verdi) {
        this.verdi = verdi;
    }

    /**
     * Henter pris.
     *
     * @return pris
     */
    public Double getPris() {
        return pris;
    }

    /**
     * Setter pris.
     *
     * @param pris pris
     */
    public void setPris(Double pris) {
        this.pris = pris;
    }

    /**
     * Henter selskap.
     *
     * @return selskap
     */
    public Bilutleieselskap getSelskap() {
        return selskap;
    }

    /**
     * Setter selskap.
     *
     * @param selskap selskap
     */
    public void setSelskap(Bilutleieselskap selskap) {
        this.selskap = selskap;
    }

    @Override
    public String toString() {
        return "Kategori [verdi=" + verdi + ", pris=" + pris + "]";
    }

}
