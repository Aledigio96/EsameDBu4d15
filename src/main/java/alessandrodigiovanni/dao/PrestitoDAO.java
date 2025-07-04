package alessandrodigiovanni.dao;

import alessandrodigiovanni.entities.Catalogo;
import alessandrodigiovanni.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Prestito newprestito){
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newprestito);
        transaction.commit();
        System.out.println("Prestito salvato!");
    }
    public List<Prestito> findsByNumCard(long numeroTessera) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();

    }
}
