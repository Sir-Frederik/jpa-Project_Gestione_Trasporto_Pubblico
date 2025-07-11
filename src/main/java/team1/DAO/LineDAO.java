package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.*;
import team1.entities.Line;
import team1.entities.TravelCard;
import team1.entities.VehicleLineJourney;
import team1.entities.Vehicles;
import team1.entities.User;
import team1.entities.Vehicles;
import team1.exceptions.NotFoundException;

import java.util.List;

public class LineDAO {

    private final EntityManager entityManager;

    public LineDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Line newline){
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newline);
        transaction.commit();
        System.out.println("The line has been saved");

    }
    public Line findById(long id) {
        Line found = entityManager.find(Line.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public List<Line> getAllLines(){
        TypedQuery<Line> query =entityManager.createQuery("SELECT l FROM Line l", Line.class);
        return query.getResultList();
    }

    public Line findByDepartureAndFinalStop (String departure, String final_stop) {
        try {
            return entityManager.createQuery(
                            "SELECT l FROM Line u WHERE LOWER(u.departure) = LOWER(:departure) AND   LOWER(u.final_stop) = LOWER(:final_stop)", Line.class)
                    .setParameter("departure", departure)
                    .setParameter("final_stop", final_stop)
                    .getSingleResult();

        } catch (NoResultException e) {
            throw new EntityNotFoundException("No line has been found with the departure or final stop you provided");
        }
    }

    //metodo forse inutile e duplicato
   /* public List<Line> getAllLine(){
        TypedQuery<Line> query = entityManager.createQuery("SELECT v FROM line v", Line.class);
        return query.getResultList();
    }*/
    public List<VehicleLineJourney> getVehicleLineJourneysByLineId(long lineId) {
        TypedQuery<VehicleLineJourney> query = entityManager.createQuery("SELECT v FROM VehicleLineJourney v WHERE v.line.id = :lineId", VehicleLineJourney.class);
        query.setParameter("lineId", lineId);
        return query.getResultList();
    }
    public double getEstimatedTimeByLineId(long id) {
        TypedQuery<Double> query = entityManager.createQuery("SELECT v.estimatedTime FROM Line v WHERE v.id = :id", Double.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
