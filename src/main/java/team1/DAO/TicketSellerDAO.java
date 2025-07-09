package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.sellersSons.TicketSeller;

public class TicketSellerDAO {
    private EntityManager entityManager;

    public TicketSellerDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(TicketSeller ticketSeller) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticketSeller);
        transaction.commit();
        System.out.println("TicketSeller saved");
    }

    public TicketSeller findById(long id) {
        TicketSeller ts = entityManager.find(TicketSeller.class, id);
        if (ts == null) {
            throw new EntityNotFoundException("TicketSeller not found");
        }
        return ts;
    }
}
