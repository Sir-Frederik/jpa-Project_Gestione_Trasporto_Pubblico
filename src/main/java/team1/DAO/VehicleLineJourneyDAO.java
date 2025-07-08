package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityNotFoundException;
import team1.entities.VehicleLineJourney;

public class VehicleLineJourneyDAO {

    private final EntityManager entityManager;

    public VehicleLineJourneyDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Salva un VehicleLineJourney nel database
    public void save(VehicleLineJourney journey) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(journey);
            transaction.commit();
            System.out.println("VehicleLineJourney saved successfully");
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }


    public VehicleLineJourney findById(long id) {
        VehicleLineJourney journey = entityManager.find(VehicleLineJourney.class, id);
        if (journey == null) {
            throw new EntityNotFoundException("VehicleLineJourney with ID " + id + " not found");
        }
        return journey;
    }
}
