package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Vehicles;
import team1.entities.VehiclesMaintenance;

public class VehiclesMaintenanceDAO {
    private EntityManager entityManager;

    public VehiclesMaintenanceDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveNewVehiclesMaintenance(VehiclesMaintenance newVehiclesMaintenance) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehiclesMaintenance);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public VehiclesMaintenance foundVehiclesMaintenanceById(long maintenanceId) {
        VehiclesMaintenance found = entityManager.find(VehiclesMaintenance.class, maintenanceId);
        if (found == null) throw new EntityNotFoundException("Element not found");
        return found;
    }
}
