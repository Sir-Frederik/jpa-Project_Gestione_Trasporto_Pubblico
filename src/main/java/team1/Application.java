package team1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team1.DAO.LineDAO;
import team1.DAO.VehicleLineJourneyDAO;
import team1.entities.Line;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporto");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        LineDAO ld= new LineDAO(em);
        VehicleLineJourneyDAO vljd= new VehicleLineJourneyDAO(em);

        

    }
}
