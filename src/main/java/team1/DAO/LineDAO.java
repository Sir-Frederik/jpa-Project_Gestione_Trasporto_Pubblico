package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import team1.entities.Line;
import team1.entities.TravelCard;
import team1.entities.VehicleLineJourney;
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
    public List<Line> getAllLine(){
        TypedQuery<Line> query = entityManager.createQuery("SELECT v FROM line v", Line.class);
        return query.getResultList();
    }
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
