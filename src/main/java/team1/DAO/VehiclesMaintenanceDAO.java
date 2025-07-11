package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team1.entities.Vehicles;
import team1.entities.VehiclesMaintenance;
import team1.entities.enums.Availability;
import team1.entities.enums.VehiclesType;

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
            TypedQuery<VehiclesMaintenance> query =entityManager.createQuery("SELECT vm FROM VehiclesMaintenance vm", VehiclesMaintenance.class);
            return query.getResultList();
    }

    public void createNewMaintenance(LocalDate dateStart, Vehicles vehicleToSet){
       VehiclesMaintenance newMaintenance = new VehiclesMaintenance(dateStart,vehicleToSet);
            save(newMaintenance);
            System.out.println("new maintenance added");
    }

    public void endMaintenanceAndSetReady(LocalDate date, VehiclesMaintenance maintenance){
            maintenance.setMaintenanceEndDate(date);
            maintenance.setServiceStartDate(date);
        System.out.println("you are all set");
    }

    public Long viewAllValidatedTickets(long vehicleId) {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(t) FROM Ticket t WHERE t.vehicles.id = :vehicleId AND t.validationDate IS NOT NULL",
                    Long.class
            );
            query.setParameter("vehicleId", vehicleId);
            return query.getSingleResult();
        }

    public Long getTotalTicketsSoldInPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(t) FROM Ticket t WHERE t.purchaseDate >= :startDate AND t.purchaseDate <= :endDate",
                Long.class
        );

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getSingleResult();
    }

    public Long getTicketsSoldBySeller(Long sellerId, LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(t) FROM Ticket t " +
                        "WHERE t.sellers = :sellerId " +
                        "AND t.purchaseDate >= :startDate AND t.purchaseDate <= :endDate",
                Long.class
        );

        query.setParameter("sellerId", sellerId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getSingleResult();
    }

}
