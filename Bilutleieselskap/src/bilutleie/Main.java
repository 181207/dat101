package bilutleie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * @author Atle Geitung
 *
 */
public final class Main {
    private static Kategori kategoriA;
    private static Kategori kategoriB;
    private static Kategori kategoriC;
    private static Kategori kategoriD;
    private static Utleiekontor kontor;
    private static Bil bil1;
    private static Bil bil2;

    /**
     * Skjuler konstruktøren.
     */
    private Main() {
    }

    /**
     * Applikasjonen.
     * 
     * @param args Ikke i bruk
     */
    public static void main(final String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
        EntityManager em = entityManagerFactory.createEntityManager();

        // finnKategorier(em);
        // finnUtleiekontor(em, 1);
        // leggInnKategorier(em);
        // leggInnBiler(em);
        // nyttUtleiekontor(em, 1);

        // Henter inn et bilutleieselskap og gjør det "managed"
        // Nå vil alt selskapet refererer til også være
        // managed og kan benyttes
        Bilutleieselskap selskap = em.find(Bilutleieselskap.class, "kronbil	");
        System.out.println(selskap.getNavn());

        for (Kategori kategori : selskap.getKategorier()) {
            System.out.println(kategori);
        }

        Kategori g = new Kategori();
        g.setPris(new Double(700));
        g.setSelskap(selskap);
        g.setVerdi('G');
        selskap.getKategorier().add(g);
        try {
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        for (Kategori kategori : selskap.getKategorier()) {
            System.out.println(kategori);
        }

        // Fjern kategorien
        selskap.getKategorier().remove(g);
        try {
            em.getTransaction().begin();
            em.flush();
            em.remove(g);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        for (Kategori kategori : selskap.getKategorier()) {
            System.out.println(kategori);
        }

        // // test ut adresse Adresse bergen = new Adresse(); bergen.setGate("Byparken"); bergen.setPostnr(5000);
        // bergen.setPoststed("Bergen");
        //
        // // Utfør en transaksjon try { em.getTransaction().begin(); em.persist(bergen); em.getTransaction().commit();
        // }catch(
        // RollbackException e)
        // { em.getTransaction().rollback(); }
        //
        // // Fjern adressen try { em.getTransaction().begin(); em.remove(bergen); em.getTransaction().commit(); } catch
        // (
        // RollbackException e)
        // {
        // em.getTransaction().rollback();
        // }
        //
        // // // Henter utleiekontor nummer 1 // Utleiekontor kontor = em.find(Utleiekontor.class, 1); // // // Henter
        // kategori A // Kategori kategoriA = em.find(Kategori.class, 'A'); // // // lager en ny bil // Bil nyBil = new
        //
        // Bil(); // nyBil.setRegnr("SX10000"); // nyBil.setFarge("Rød"); // nyBil.setKategori(kategoriA); //
        // nyBil.setMerke("Ford"); // nyBil.setModell("ukjent"); // nyBil.setLedig(Boolean.TRUE); // // // Utfør en
        //
        // transaksjon // try { // em.getTransaction().begin(); // // // legger bilen til i listen til kontoret //
        // em.persist(nyBil); // kontor.leggTil(nyBil); // em.flush(); // // em.getTransaction().commit(); // } catch
        // (
        // RollbackException e)
        // { // em.getTransaction().rollback(); // } // // // Sletter bilen slik at den kan legges
        // til på nytt! // try { // em.getTransaction().begin(); // // // legger bilen til i listen til kontoret //
        // kontor.fjern(nyBil); // em.remove(nyBil); // em.flush(); // // em.getTransaction().commit(); // } catch
        // (RollbackException e) { // em.getTransaction().rollback(); // }
        //
        //
        em.close(); // Denne er viktig å huske!
        entityManagerFactory.close();
    }

    /**
     * Legger inn bilene.
     * 
     * @param em entitymanager
     */
    private static void leggInnBiler(EntityManager em) {
        bil1 = new Bil();
        bil1.setRegnr("SX10000");
        bil1.setMerke("Ford");
        bil1.setModell("ukjent");
        bil1.setFarge("Rød");
        bil1.setKategori(kategoriB);
        bil1.setKontor(kontor);

        bil2 = new Bil();
        bil2.setRegnr("SY10000");
        bil2.setMerke("Volvo");
        bil2.setModell("ukjent");
        bil2.setFarge("Hvit");
        bil2.setKategori(kategoriC);
        bil2.setKontor(kontor);

        try {
            em.getTransaction().begin();
            em.persist(bil1);
            em.persist(bil2);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            // try {
            em.getTransaction().rollback();
            // } catch (Throwable ex) {
            // // Fang ALDRI Throwable eller Exception
            // }
        }
    }

    /**
     * Henter utleiekontor nr fra databasen.
     * 
     * @param em entitymanager
     * @param nr nummer
     */
    private static void finnUtleiekontor(EntityManager em, Integer nr) {
        kontor = em.find(Utleiekontor.class, nr);
    }

    /**
     * Henter kategorier fra databasen.
     * 
     * @param em entitymanager
     */
    private static void finnKategorier(EntityManager em) {
        kategoriA = em.find(Kategori.class, 'A');
        kategoriB = em.find(Kategori.class, 'B');
        kategoriC = em.find(Kategori.class, 'C');
        kategoriD = em.find(Kategori.class, 'D');
    }

    /**
     * Legger inn et nytt utleiekontor.
     * 
     * @param nr nummer
     */
    private static void nyttUtleiekontor(EntityManager em, Integer nr) {
        kontor = new Utleiekontor();
        kontor.setNummer(nr);
        kontor.setTelefon(12345678);

        Adresse adresse = new Adresse();
        adresse.setGate("Inndalsveien 28");
        adresse.setPostnr(5063);
        adresse.setPoststed("Bergen");
        kontor.setAdresse(adresse);

        try {
            em.getTransaction().begin();
            em.persist(kontor);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }
    }

    /**
     * Legger inn kategorier i databasen.
     * 
     * @param em entitymanager
     */
    private static void leggInnKategorier(EntityManager em) {
        kategoriA = new Kategori('A', 200.00);
        kategoriB = new Kategori('B', 300.00);
        kategoriC = new Kategori('C', 400.00);
        kategoriD = new Kategori('D', 500.00);

        try {
            em.getTransaction().begin();
            em.persist(kategoriA);
            em.persist(kategoriB);
            em.persist(kategoriC);
            em.persist(kategoriD);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            try {
                em.getTransaction().rollback();
            } catch (Throwable ex) {
                // Fang ALDRI Throwable eller Exception
            }
        }
    }

}
