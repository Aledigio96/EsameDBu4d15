package alessandrodigiovanni.dao;

import alessandrodigiovanni.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //--------------------metodo per salvare--------------------
    public void save(Catalogo newcatalogo){
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newcatalogo);
        transaction.commit();
        System.out.println("Salvato con successo");
    }
    //-----------------metodo per cercare per isbn-----------------

    public List<Catalogo> findsByIsbn(long codiceIsbn) {
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.codiceIsbn = :codiceIsbn", Catalogo.class);
        query.setParameter("codiceIsbn", codiceIsbn);
        return query.getResultList();
    }
    //--------------------metodo per cercare per data pubblicazione-------------
    public List<Catalogo> findsByDate(int annoPubblicazione) {
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :annoPubblicazione", Catalogo.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();}


//------------------------metodo per cercare tramite isbn e cancellare l'elemento----------
    public void findByISBNAndDelete(long codiceIsbn) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Query query = entityManager.createQuery("DELETE FROM Catalogo c WHERE c.codiceIsbn = :codiceIsbn");
        query.setParameter("codiceIsbn", codiceIsbn);

         query.executeUpdate();

        transaction.commit();

        System.out.println( "Elemento cancellato con successo!");
    }
    //---------------------metodo per cercare tramite autore---------------
    public List<Catalogo> findsByAuthor(String autore) {
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.autore = :autore", Catalogo.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }
    //--------------------metodo per cercare tramite titolo o parte di esso----------------
    public List<Catalogo> findElementByTitleStartingWith(String partialTitle) {
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.titolo LIKE :partialTitle", Catalogo.class);
        query.setParameter("partialTitle", partialTitle + "%");

        return query.getResultList();

    }


}
