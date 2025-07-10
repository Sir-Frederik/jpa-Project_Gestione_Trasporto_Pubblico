package team1.DAO;

import jakarta.persistence.*;
import team1.entities.TravelCard;
import team1.entities.User;
import team1.exceptions.ReUsableException;

import java.time.LocalDate;
import java.util.List;

public class TravelCardDAO {

    private final EntityManager em;

    public TravelCardDAO(EntityManager em) {
        this.em = em;
    }

    public void save(TravelCard newCard) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newCard);
        transaction.commit();
        System.out.println("The card " + newCard.getId() + " was saved successfully");
    }

    public TravelCard findById (long id) {
        TravelCard found = em.find(TravelCard.class, id);
        if (found == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return found;
    }
    public void findTravelCardByIdAndDelete(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM TravelCard t WHERE t.id = :id");
        query.setParameter("id", id);
        int deletedCount = query.executeUpdate(); // Torna il numero di righe cancellate
        transaction.commit();
        if (deletedCount > 0) {
            System.out.println("Element successfully removed!");
        } else {
            System.out.println("No element found with the given ID.");
        }
    }

    public TravelCard getNewCard(User user){
        //da aggiungere controllo per vecchie tessere
        TravelCard newTravelCard = new TravelCard(LocalDate.now(),user);
        return newTravelCard;
    }

    public List<TravelCard> getAllCard(){
        TypedQuery<TravelCard> query = em.createQuery("SELECT d FROM TravelCard d", TravelCard.class);
        return query.getResultList();
    }

    public TravelCard findUserByTravelCardId(long id) {
        TypedQuery<TravelCard> query = em.createQuery("SELECT t FROM TravelCard t WHERE t.id = :id", TravelCard.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new ReUsableException("Element not found");
        }
    }
}
