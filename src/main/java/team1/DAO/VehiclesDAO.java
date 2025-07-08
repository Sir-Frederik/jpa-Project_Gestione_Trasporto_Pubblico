package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Vehicles;

public class VehiclesDAO {

    private EntityManager entityManager;

    public VehiclesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveNewVehicles(Vehicles newVehicles) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehicles);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public Vehicles findVehiclesById(long vehiclesId) {
        Vehicles found = entityManager.find(Vehicles.class, vehiclesId);
        if (found == null) throw new EntityNotFoundException("Element not found");
        return found;
    }
}
