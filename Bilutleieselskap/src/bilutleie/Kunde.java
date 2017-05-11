package bilutleie;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema = "bilutleie")
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kunde_id;
	private String fornavn;
	private String etternavn;
	private Integer telefon;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse", referencedColumnName = "id")
    private Adresse adresse;
	
	public Kunde() {
		fornavn = "";
		etternavn = "";
		telefon = 0;
	}
	
	public Integer getKunde_id() {
		return kunde_id;
	}

	public void setKunde_id(Integer kunde_id) {
		this.kunde_id = kunde_id;
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

	public Integer getTelefon() {
		return telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}