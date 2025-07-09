package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Ticket;
import team1.entities.Vehicles;
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

    //validation ticket
    public void validatioTicket(Ticket t){
        //da capire come funziona con gli abbonamenti
        if (t.getValidationDate().isBefore(LocalDate.now())){
            throw new ReUsableException("this ticket is already used");
        }
        t.setValidationDate(LocalDate.now());
    }
}
