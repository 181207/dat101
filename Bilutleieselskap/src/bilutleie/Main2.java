package bilutleie;

import java.util.*;
import javax.persistence.*;

public class Main2 {
	private static final String PERSISTENCE_UNIT_NAME = "eclipselink";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public static void main(String[] args) {
		EntityManager em = factory.createEntityManager();
		try {
//		em.getTransaction().begin();
//		
//		
//		
//		Adresse ad1 = new Adresse();
//		Adresse ad2 = new Adresse();
//		Adresse ad4 = new Adresse();
//		Adresse ad5 = new Adresse();
//		
//		ad1.setGate("Nygårsgaten");
//		ad1.setPostnr(5015);
//		ad1.setPoststed("Bergen");
//		ad2.setGate("Festplassen");
//		ad2.setPostnr(5015);
//		ad2.setPoststed("Bergen");
//		ad4.setGate("Kronstad");
//		ad4.setPostnr(5053);
//		ad4.setPoststed("Bergen");
//		ad5.setGate("Musèplassen");
//		ad5.setPostnr(5007);
//		ad5.setPoststed("Bergen");
//		em.persist(ad1);
//		em.persist(ad2);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		Bilutleieselskap b1 = new Bilutleieselskap();
//		b1.setAdresse(ad1);
//		b1.setNavn("Kronbil");
//		b1.setTelefon(123456789);
//		em.persist(b1);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		Utleiekontor kontor = new Utleiekontor();
//		Utleiekontor kontor2 = new Utleiekontor();
//		kontor.setAdresse(ad2);
//		kontor.setNummer(111111);
//		kontor.setSelskap(b1);
//		kontor.setTelefon(41555555);
//		kontor2.setAdresse(ad4);
//		kontor2.setNummer(222222);
//		kontor2.setSelskap(b1);
//		kontor2.setTelefon(41333333);
//		em.persist(kontor2);
//		em.persist(kontor);
//		
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		Kategori a = new Kategori();
//		Kategori b = new Kategori();
//		Kategori c = new Kategori();
//		Kategori d = new Kategori();
//		Kategori e = new Kategori();
//		a.setPris(300.0);
//		a.setVerdi('A');
//		a.setSelskap(b1);
//		b.setPris(500.0);
//		b.setVerdi('B');
//		b.setSelskap(b1);
//		c.setPris(700.0);
//		c.setVerdi('C');
//		c.setSelskap(b1);
//		d.setPris(900.0);
//		d.setVerdi('D');
//		d.setSelskap(b1);
//		e.setPris(1100.0);
//		e.setVerdi('E');
//		e.setSelskap(b1);
//		
//		
//		
//		b1.leggTil(a);
//		b1.leggTil(b);
//		b1.leggTil(c);
//		b1.leggTil(d);
//		b1.leggTil(e);
//		
//		em.persist(a);
//		em.persist(b);
//		em.persist(c);
//		em.persist(d);
//		em.persist(e);
//		
//		em.getTransaction().commit();
//		
//		List<Kategori> kategori = new ArrayList<>();
//		kategori.add(a);
//		kategori.add(b);
//		kategori.add(c);
//		kategori.add(d);
//		kategori.add(e);
//		
//		String[] merke = {"Ford", "Toyota", "Mercedes", "Volkswagen", "Audi"};
//		String[] modell = {"Fiesta", "Avensis", "Benz", "Golf", "A8"};
//		String[] regnr = {"TV1111", "TV2222", "TV3333", "SA4444", "SA5555"};
//		String[] farge = {"Rosa", "Kvitt", "Gul", "Gul", "Svart"};
//		
//		//Lager biler og legger dei til utleiekontoret
//		em.getTransaction().begin();
//		for(int i = 0; i < 5; i++) {
//			Bil bil = new Bil();
//			bil.setRegnr(regnr[i]);
//			bil.setFarge(farge[i]);
//			bil.setMerke(merke[i]);
//			bil.setModell(modell[i]);
//			bil.setKategori(kategori.get(i));
//			bil.setKontor(kontor);
//			bil.setSelskap(b1);
//			kontor.leggTil(bil);
//			b1.leggTil(bil);
//			em.persist(bil);
//		}
//		em.getTransaction().commit();
//		
//
//		em.getTransaction().begin();
//		Adresse ad3 = new Adresse();
//		ad3.setGate("Fabrikkgaten");
//		ad3.setPostnr(5059);
//		ad3.setPoststed("Bergen");
//		
//		Kunde kk = new Kunde();
//		kk.setAdresse(ad3);
//		kk.setFornavn("Jens");
//		kk.setEtternavn("Pedersen");
//		kk.setTelefon(89898989);
//		em.persist(ad3);
//		em.persist(kk);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		Dato dato = new Dato();
//		dato.setStart_dato("02.02.17");
//		dato.setSlutt_dato("30.02.17");
//		em.persist(dato);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		Bestilling bestilling = new Bestilling();
//		bestilling.setDato(dato);
//		bestilling.setKunde(kk);
//		bestilling.setBil(kontor.getBiler().get(2));
//		bestilling.setUtleietid(28);
//		kontor.getBiler().get(2).setLedig(false);
//		em.persist(bestilling);
//		em.getTransaction().commit();
//			
		
			
			
		em.getTransaction().begin();
		Adresse adresse = new Adresse();
		adresse.setGate("Grønneviksøren");
		adresse.setPostnr(5009);
		adresse.setPoststed("Bergen");
		em.persist(adresse);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Kunde k1 = new Kunde();
		k1.setAdresse(adresse);
		k1.setFornavn("Jo-Ari");
		k1.setEtternavn("Esther");
		k1.setTelefon(41415151);
		em.persist(k1);
		em.getTransaction().commit();
		
		
		Utleiekontor kontor = em.find(Utleiekontor.class, 111111);
		kontor.ledigeBiler();
		em.getTransaction().begin();
		Dato d1 = new Dato();
		d1.setStart_dato("10.10.17");
		d1.setSlutt_dato("20.10.17");
		em.persist(d1);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Bestilling best1 = new Bestilling();
		best1.setDato(d1);
		best1.setUtleietid(10);
		best1.setKunde(k1);
		best1.setBil(kontor.finnBil("SA5555"));
		best1.setPris(kontor.finnBil("SA5555").getKategori().getPris() * best1.getUtleietid());
		kontor.leieUt(kontor.finnBil("SA5555"));
		em.persist(best1);
		em.getTransaction().commit();
		
		System.out.println();
		kontor.ledigeBiler();
		
		

		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
		em.close();
		
		
		
		
	}

}
