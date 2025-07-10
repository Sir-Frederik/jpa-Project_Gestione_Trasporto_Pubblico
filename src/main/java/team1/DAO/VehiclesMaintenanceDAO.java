package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team1.entities.Vehicles;
import team1.entities.VehiclesMaintenance;
import team1.entities.enums.Availability;
import team1.entities.enums.VehiclesType;

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
            TypedQuery<VehiclesMaintenance> query =entityManager.createQuery("SELECT vm FROM VehiclesMaintenance vm", VehiclesMaintenance.class);
            return query.getResultList();
    }

//    public VehiclesMaintenance createNewMaintenance(){
////        public void addNewBus() {
////            Vehicles newbus = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, 30, "xxxx");
////            save(newbus);
////            System.out.println("new bus added");
////        }
//    }


}
