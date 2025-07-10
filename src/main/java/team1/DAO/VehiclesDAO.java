package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Ticket;
import team1.entities.Vehicles;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;
import team1.exceptions.ReUsableException;

import java.time.LocalDate;

public class VehiclesDAO {

    private EntityManager entityManager;

    public VehiclesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Vehicles newVehicles) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehicles);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public Vehicles findById(long vehiclesId) {
        Vehicles found = entityManager.find(Vehicles.class, vehiclesId);
        if (found == null) throw new EntityNotFoundException("Element not found");
        return found;
    }

    public void validatioTicket(Ticket t){
        if(t instanceof SingleTicket) {
            if (t.getValidationDate().isBefore(LocalDate.now())) {
                throw new ReUsableException("this ticket is already used");
            }
            t.setValidationDate(LocalDate.now());
        }else if (t instanceof SubscriptionTicket){

           if( ((SubscriptionTicket) t).getExpiration().isAfter(LocalDate.now())){
               if(t.getValidationDate() != null){
                   System.out.println("ticket ok");
               }
               t.setValidationDate(LocalDate.now());
           }else{
               throw new ReUsableException("your subscription is expired");
           }
        }
    }
}
