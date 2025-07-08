package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import org.hibernate.mapping.Selectable;
import team1.entities.Sellers;
import team1.entities.Ticket;

public class SellersDao {
    private EntityManager entityManager;


    public SellersDao(EntityManager em) {
        this.entityManager = em;
    }


    public void save(Sellers seller) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(seller);
        transaction.commit();
    }

    public Sellers getById(long id) {
        Sellers sellerFromId = entityManager.find(Sellers.class, id);
        if (sellerFromId == null) {
            throw new EntityNotFoundException("evento non trovato");
        }
        return sellerFromId;
    }
}
