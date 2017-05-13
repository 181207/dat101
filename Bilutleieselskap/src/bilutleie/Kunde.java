package bilutleie;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema = "bilutleie")
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kundeNr;
	@Column(name = "fornavn")
	private String fornavn;
	@Column(name = "etternavn")
	private String etternavn;
	@Column(name = "tlf")
	private Integer tlf;
	@Column(name = "kort")
	private Integer kort;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse", referencedColumnName = "id")
    private Adresse adresse;
	
	public Kunde(){
		this(0,"","",0,0,null);
	}

	public Kunde(Integer kundeNr, String fornavn, String etternavn, Integer tlf, Integer kort, Adresse adresse) {
		this.kundeNr = kundeNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.tlf = tlf;
		this.kort = kort;
		this.adresse = adresse;
	}

	public Integer getKundeNr() {
		return kundeNr;
	}

	public void setKundeNr(Integer kundeNr) {
		this.kundeNr = kundeNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

	public Integer getKort() {
		return kort;
	}

	public void setKort(Integer kort) {
		this.kort = kort;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	

}