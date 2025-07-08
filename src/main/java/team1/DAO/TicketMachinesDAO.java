package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.sellersSons.TicketMachine;

public class TicketMachinesDAO {
    private EntityManager entityManager;

    public TicketMachinesDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(TicketMachine ticketMachine) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticketMachine);
        transaction.commit();
        System.out.println("TicketMachine saved");
    }

    public TicketMachine findById(long id) {
        TicketMachine tm = entityManager.find(TicketMachine.class, id);
        if (tm == null) {
            throw new EntityNotFoundException("TicketMachine not found");
        }
        return tm;
    }
}
