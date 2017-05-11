package bilutleie;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema = "bilutleie")
public class Dato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dato_id;
	private String start_dato;
	private String slutt_dato;

	
	public Dato () {
		start_dato = "";
		slutt_dato = "";
	}
	
	public String getStart_dato() {
		return start_dato;
	}

	public void setStart_dato(String start_dato) {
		this.start_dato = start_dato;
	}

	public String getSlutt_dato() {
		return slutt_dato;
	}

	public void setSlutt_dato(String slutt_dato) {
		this.slutt_dato = slutt_dato;
	}
	

}
