package team1.DAO;
import jakarta.persistence.*;
import team1.entities.Ticket;
import team1.entities.TravelCard;
import team1.entities.User;
import team1.exceptions.ReUsableException;

import java.util.List;


public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }
    public void save(User newUser) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newUser);
        transaction.commit();
        System.out.println("The user " + newUser.getId() + " was saved successfully");
    }

    public User findById (long id) {
        User found = em.find(User.class, id);
        if (found == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return found;
    }

    public List<User> getAllUser(){
        TypedQuery<User> query = em.createQuery("SELECT d FROM User d", User.class);
        return query.getResultList();
    }

    public void findUserByIdAndDelete(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        int deletedCount = query.executeUpdate();
        transaction.commit();
        if (deletedCount > 0) {
            System.out.println("Element successfully removed!");
        } else {
            System.out.println("No element found with the given ID.");
        }
    }
    public List<Ticket> getAllTicketByUser(long userId) {
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.user.id = :userId", Ticket.class);
        query.setParameter("userId", userId);
        List<Ticket> tickets = query.getResultList();
        if (tickets.isEmpty()) {
            throw new ReUsableException("No tickets found for user with ID: " + userId);
        }
        return tickets;
    }
    public TravelCard findTravelCardByUserId(long userId) {
        TypedQuery<TravelCard> query = em.createQuery("SELECT t FROM TravelCard t WHERE t.user.id = :userId", TravelCard.class);
        query.setParameter("userId", userId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new ReUsableException("No TravelCard found for user with ID: " + userId);
        }
    }


        /*

        0
        public void save(Sellers seller) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(seller);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public Sellers getById(long id) {
        Sellers sellerFromId = entityManager.find(Sellers.class, id);
        if (sellerFromId == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return sellerFromId;
    }
         */

}
