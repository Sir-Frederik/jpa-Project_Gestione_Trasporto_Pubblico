package team1.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team1.entities.TravelCard;
import team1.entities.User;

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
