package bilutleie;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (schema = "bilutleie")
public class Bestilling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bestilling_id;
	private Double pris;
	@ManyToOne
	@JoinColumn(name = "bil", referencedColumnName = "regnr")
	private Bil bil;
	@JoinColumn(name = "dato", referencedColumnName = "dato_id")
	private Dato dato;
	@OneToOne
	@JoinColumn(name = "kunde", referencedColumnName = "kunde_id")
	private Kunde kunde;
	private Integer utleietid;
	
	public Bestilling() {
		utleietid = 0;
		pris = 0.0;
	}
	
    public void setPris(Double pris) {
    	this.pris = pris;
    }
    public Double getPris() {
    	return pris;
    }
	public void setUtleietid(Integer utleietid) {
		this.utleietid = utleietid;
	}
	public Integer getUtleietid() {
		return utleietid;
	}
	public Integer getBestilling_id() {
		return bestilling_id;
	}
	public void setBestilling_id(Integer bestilling_id) {
		this.bestilling_id = bestilling_id;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public Bil getBil() {
		return bil;
	}
	public void setBil(Bil bil) {
		this.bil = bil;
	}
	public Dato getDato() {
		return dato;
	}
	public void setDato(Dato dato) {
		this.dato = dato;
	}
	
}
