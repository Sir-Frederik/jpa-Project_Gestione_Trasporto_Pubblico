package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Ticket;

public class TicketDao {
    private EntityManager entityManager;


    public TicketDao(EntityManager em) {
        this.entityManager = em;
    }


    public void save(Ticket ticket) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticket);
        transaction.commit();
    }

    public Ticket getById(long id) {
        Ticket ticketFromId = entityManager.find(Ticket.class, id);
        if (ticketFromId == null) {
            throw new EntityNotFoundException("evento non trovato");
        }
        return ticketFromId;
    }
}
