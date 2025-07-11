package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team1.entities.Vehicles;
import team1.entities.VehiclesMaintenance;

import java.time.LocalDate;
import java.util.List;

public class VehiclesMaintenanceDAO {
    private EntityManager entityManager;

    public VehiclesMaintenanceDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(VehiclesMaintenance newVehiclesMaintenance) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehiclesMaintenance);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public VehiclesMaintenance findById(long maintenanceId) {
        VehiclesMaintenance found = entityManager.find(VehiclesMaintenance.class, maintenanceId);
        if (found == null) throw new EntityNotFoundException("Element not found");
        return found;
    }

    public List<VehiclesMaintenance> getLogForAll(){
        TypedQuery<VehiclesMaintenance> query = entityManager.createQuery("SELECT vm FROM VehiclesMaintenance vm", VehiclesMaintenance.class);
        return query.getResultList();
    }

    public void createNewMaintenance(LocalDate dateStart, Vehicles vehicleToSet){
        VehiclesMaintenance newMaintenance = new VehiclesMaintenance();
        newMaintenance.setMaintenanceStartDate(dateStart);
        newMaintenance.setVehicles(vehicleToSet);
        save(newMaintenance);
        System.out.println("new maintenance added");
    }

    public void endMaintenanceAndSetReady(LocalDate date, VehiclesMaintenance maintenance){
        maintenance.setMaintenanceEndDate(date);
        maintenance.setServiceStartDate(date);
        System.out.println("you are all set");
    }
}
