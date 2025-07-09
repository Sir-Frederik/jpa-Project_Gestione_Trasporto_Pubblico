package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.TravelCard;
import team1.entities.User;

import java.time.LocalDate;

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

    public TravelCard getNewCard(User user){
        TravelCard newTravelCard = new TravelCard(LocalDate.now(),user);
        return newTravelCard;
    }


}
