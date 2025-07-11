package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team1.entities.Ticket;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("The element has been saved");
    }

    public Ticket findById(long id) {
        Ticket ticketFromId = entityManager.find(Ticket.class, id);
        if (ticketFromId == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return ticketFromId;
    }
    public boolean isTicketValid(Long ticketId) {
        Ticket ticket = entityManager.find(Ticket.class, ticketId);

        if (ticket == null) {
            throw new EntityNotFoundException("Ticket with id " + ticketId + "not found.");
        }
        if (ticket instanceof SingleTicket st) {
            return st.getValidationDate() == null;
        } else if (ticket instanceof SubscriptionTicket sub) {
            return sub.getExpiration().isAfter(LocalDate.now());
        }
        return false ;
    }

    public void updateTicket(Ticket ticket) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(ticket);
        transaction.commit();
        System.out.println("Ticket updated successfully");
    }
}
