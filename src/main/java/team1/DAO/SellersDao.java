package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Sellers;
import team1.entities.Ticket;
import team1.entities.enums.State;
import team1.entities.sellersSons.TicketMachine;
import team1.exceptions.MOSException;
import team1.exceptions.NotFoundException;

import java.time.LocalDate;


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
        System.out.println("The element has been saved");
    }

    public Sellers findById(long id) {
        Sellers sellerFromId = entityManager.find(Sellers.class, id);
        if (sellerFromId == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return sellerFromId;
    }
    
}
