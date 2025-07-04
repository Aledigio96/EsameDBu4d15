package alessandrodigiovanni;

import alessandrodigiovanni.dao.CatalogoDAO;
import alessandrodigiovanni.dao.PrestitoDAO;
import alessandrodigiovanni.dao.UtenteDAO;
import alessandrodigiovanni.entities.*;
import alessandrodigiovanni.enums.Genere;
import alessandrodigiovanni.enums.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("EsameDBu4d15");
    public static void main(String[] args) {
        EntityManager em= emf.createEntityManager();
        System.out.println("funziona");
        CatalogoDAO cd= new CatalogoDAO(em);
        UtenteDAO ud= new UtenteDAO(em);
        PrestitoDAO pd= new PrestitoDAO(em);


        Rivista rivista1=new Rivista("Playboy",2025,37, Periodicità.MENSILE);
        Rivista rivista2=new Rivista("GQ",1927,45,Periodicità.SETTIMANALE);
        Rivista rivista3=new Rivista("Fumetto",1999,50,Periodicità.SEMESTRALE);
        Libro libro2=new Libro("Lord of the Ring",2000,1200,"Tolkien",Genere.FANTASY);
        Libro libro1= new Libro("Piccolo Principe",1943,300,"Antoine de Saint-Exupéry", Genere.FANTASY);
        Libro libro3= new Libro("IO",1967,490,"Giorgione",Genere.BIOGRAFIA);
        cd.save(rivista2);
        cd.save(rivista3);
        cd.save(libro2);
        cd.save(libro3);
        cd.save(rivista1);
        cd.save(libro1);

        cd.findElementByTitleStartingWith("Lo").forEach(System.out::println);
        cd.findsByDate(2025).forEach(System.out::println);
        cd.findByISBNAndDelete(5);
        cd.findsByIsbn(3).forEach(System.out::println);
        cd.findsByAuthor("Giorgione").forEach(System.out::println);


        LocalDate date=LocalDate.of(2025,07,04);
        Utente gianni= new Utente("Gianni","Paperone",date.minusYears(60),1234);
        ud.save(gianni);
        Utente pino= new Utente("Pino","Pinotti",date.minusYears(25).minusDays(12),5463);
        ud.save(pino);

        LocalDate inizioPrestito= LocalDate.now();
        LocalDate finePrestito= inizioPrestito.plusDays(30);
        Prestito prestito1= new Prestito(pino,rivista3,inizioPrestito,finePrestito,inizioPrestito.plusDays(13));
        pd.save(prestito1);
        pd.findsByNumCard(5463).forEach(System.out::println);


em.close();
emf.close();
    }



}
