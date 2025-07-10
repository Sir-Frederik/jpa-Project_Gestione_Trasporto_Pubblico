package team1.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import team1.entities.User;



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

    public User findByNameAndSurname (String name, String surname){
        try {
            return em.createQuery(
//                    "SELECT u FROM User u WHERE u.name = :name AND   u.surname = :surname", User.class)
                    "SELECT u FROM User u WHERE LOWER(u.name) = LOWER(:name) AND   LOWER(u.surname) = LOWER(:surname)", User.class)
                    .setParameter("name",name)
               .setParameter("surname",surname)
                    .getSingleResult();



        } catch (NoResultException e)
        {
            throw new EntityNotFoundException("No user has been found with the surname or first name you provided");
        }
    }


}
