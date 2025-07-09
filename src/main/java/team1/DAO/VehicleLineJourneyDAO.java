package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import team1.entities.Line;
import team1.entities.VehicleLineJourney;
import team1.entities.Vehicles;

import java.util.List;

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

    public long findNumberOfTravelsOfAVehicle(long idVehicle, long idLine) {
        TypedQuery<VehicleLineJourney> query = entityManager.createQuery(
                "SELECT v FROM VehicleLineJourney v WHERE v.vehiclesId.vehiclesId = :idVehicle AND v.lineId.id = :idLine",
                VehicleLineJourney.class
        );
        query.setParameter("idVehicle", idVehicle);
        query.setParameter("idLine", idLine);

        List<VehicleLineJourney> resultList = query.getResultList();
        return resultList.size();
    }


    //public double averageTime(Vehicles v, Line l){}
        //serve il mezzo
    //serve la tratta
    //prendere il tempo effettivo per ogni percorso
    //calcolo media
}
