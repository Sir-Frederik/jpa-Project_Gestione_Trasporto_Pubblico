package team1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team1.DAO.*;
import team1.entities.*;
import team1.entities.enums.Active;
import team1.entities.sellersSons.TicketMachine;
import team1.entities.sellersSons.TicketSeller;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporto");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        LineDAO ld= new LineDAO(em);
        SellersDao sd = new SellersDao(em);
        TicketDao td = new TicketDao(em);
        TravelCardDAO tcd = new TravelCardDAO(em);
        UserDAO ud = new UserDAO(em);
        VehicleLineJourneyDAO vljd = new VehicleLineJourneyDAO(em);
        VehiclesDAO vd = new VehiclesDAO(em);
        VehiclesMaintenanceDAO vmd = new VehiclesMaintenanceDAO(em);

        User u1 = new User("Pippo","Pluto");
        User u2 = new User("Paperino","Quaqua");
        User u3 = new User("Alessio","Panconi");

        TicketMachine t1 = new TicketMachine(Active.ACTIVE,707);
        TicketMachine t2 = new TicketMachine(Active.INACTIVE,676);

        TicketSeller ts1 = new TicketSeller("Antonio");
        TicketSeller ts2 = new TicketSeller("Umberto");

        
    }
}
