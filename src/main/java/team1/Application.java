package team1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team1.DAO.*;
import team1.entities.*;
import team1.entities.enums.Availability;
import team1.entities.enums.State;
import team1.entities.enums.Genre;
import team1.entities.enums.VehiclesType;
import team1.entities.sellersSons.TicketMachine;
import team1.entities.sellersSons.TicketSeller;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporto");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        LineDAO ld= new LineDAO(em);
        SellersDao sd = new SellersDao(em);
        TicketMachinesDAO tmd = new TicketMachinesDAO(em);
        TicketSellerDAO tsd = new TicketSellerDAO(em);
        TicketDao td = new TicketDao(em);
        TravelCardDAO tcd = new TravelCardDAO(em);
        UserDAO ud = new UserDAO(em);
        VehicleLineJourneyDAO jd = new VehicleLineJourneyDAO(em);
        VehiclesDAO vd = new VehiclesDAO(em);
        VehiclesMaintenanceDAO vmd = new VehiclesMaintenanceDAO(em);


        User u1 = new User("Oronzo", "Canà", LocalDate.of(1940, 5, 21), "Alberobello", Genre.MALE);
        User u2 = new User("Paolino", "Paperino", LocalDate.of(1934, 6, 9), "Paperopoli", Genre.MALE);
        User u3 = new User("Marilyn", "Monroe", LocalDate.of(1926, 6, 1), "Los Angeles", Genre.FEMALE);
        User u4 = new User("Albert", "Einstein", LocalDate.of(1879, 3, 14), "Princeton", Genre.MALE);
        User u5 = new User("Daffy", "Duck", LocalDate.of(1937, 4, 17), "Looneyville", Genre.MALE);
        User u6 = new User("Lady", "Gaga", LocalDate.of(1986, 3, 28), "New York", Genre.FEMALE);
        User u7 = new User("Freddie", "Mercury", LocalDate.of(1946, 9, 5), "Zanzibar", Genre.MALE);
        User u8 = new User("Greta", "Thunberg", LocalDate.of(2003, 1, 3), "Stoccolma", Genre.FEMALE);
        User u9 = new User("Totò", "Principe", LocalDate.of(1898, 2, 15), "Napoli", Genre.MALE);
        User u10 = new User("Sam", "Genderfluid", LocalDate.of(1990, 8, 8), "Berlino", Genre.OTHER);
        User u11 = new User("Ajeje", "Brazorf", LocalDate.of(1975, 11, 22), "Messina", Genre.MALE);


        TicketMachine t1 = new TicketMachine(State.ACTIVE,707);
        TicketMachine t2 = new TicketMachine(State.INACTIVE,676);
        TicketMachine t3 = new TicketMachine(State.ACTIVE,101);
        TicketMachine t4 = new TicketMachine(State.ACTIVE,100);
        TicketMachine t5 = new TicketMachine(State.INACTIVE,176);

        TicketSeller ts1 = new TicketSeller("Antonio", "Dimagli");
        TicketSeller ts2 = new TicketSeller("Umberto", "Smaila");
        TicketSeller ts3 = new TicketSeller("Umperio", "Bogarto");

        Line l1 = new Line("Napoli", "Salerno", 101, 50.0);
        Line l2 = new Line("Milano", "Monza", 102, 25.5);
        Line l3 = new Line("Roma", "Fiumicino Aeroporto", 103, 32.0);
        Line l4 = new Line("Torino", "Venaria Reale", 104, 20.0);
        Line l5 = new Line("Firenze", "Pisa", 105, 60.0);
        Line l6 = new Line("Bologna", "Modena", 106, 40.5);
        Line l7 = new Line("Bari", "Polignano a Mare", 107, 35.0);
        Line l8 = new Line("Cagliari", "Pula", 108, 45.0);
        Line l9 = new Line("Palermo", "Mondello", 109, 30.0);
        Line l10 = new Line("Paperino", "Bassano del Grappa", 110, 12.5);

        TravelCard tc1 = new TravelCard(LocalDate.of(2024, 7, 1), u1);
        TravelCard tc2 = new TravelCard(LocalDate.of(2024, 6, 15), u2);
        TravelCard tc3 = new TravelCard(LocalDate.of(2024, 5, 20), u3);
        TravelCard tc4 = new TravelCard(LocalDate.of(2024, 4, 10), u4);
        TravelCard tc5 = new TravelCard(LocalDate.of(2024, 3, 5), u5);
        TravelCard tc6 = new TravelCard(LocalDate.of(2024, 2, 28), u6);
        TravelCard tc7 = new TravelCard(LocalDate.of(2024, 1, 14), u7);
        TravelCard tc8 = new TravelCard(LocalDate.of(2023, 12, 1), u8);
        TravelCard tc9 = new TravelCard(LocalDate.of(2023, 11, 23), u9);
        TravelCard tc10 = new TravelCard(LocalDate.of(2023, 10, 9), u10);

        Vehicles v1 = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, 60, "AB123CD");
        Vehicles v2 = new Vehicles(VehiclesType.TRAM, Availability.NOTAVAILABLE, 100, "TR456FG");
        Vehicles v3 = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, 55, "BC789HJ");
        Vehicles v4 = new Vehicles(VehiclesType.TRAM, Availability.AVAILABLE, 120, "TM321KL");
        Vehicles v5 = new Vehicles(VehiclesType.AUTOBUS, Availability.NOTAVAILABLE, 70, "CD654MN");
        Vehicles v6 = new Vehicles(VehiclesType.TRAM, Availability.AVAILABLE, 95, "TR963OP");
        Vehicles v7 = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, 50, "EF741QR");
        Vehicles v8 = new Vehicles(VehiclesType.TRAM, Availability.NOTAVAILABLE, 110, "TM852ST");
        Vehicles v9 = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, 45, "GH963UV");
        Vehicles v10 = new Vehicles(VehiclesType.TRAM, Availability.AVAILABLE, 130, "TR147WX");

        VehiclesMaintenance vm1 = new VehiclesMaintenance(
                1001L,
                LocalDate.of(2024, 6, 1),
                LocalDate.of(2024, 6, 10),
                LocalDate.of(2024, 6, 11),
                v1
        );

        VehiclesMaintenance vm2 = new VehiclesMaintenance(
                1002L,
                LocalDate.of(2024, 5, 5),
                LocalDate.of(2024, 5, 20),
                LocalDate.of(2024, 5, 21),
                v2
        );

        VehiclesMaintenance vm3 = new VehiclesMaintenance(
                1003L,
                LocalDate.of(2024, 4, 15),
                LocalDate.of(2024, 4, 25),
                LocalDate.of(2024, 4, 26),
                v3
        );

        VehiclesMaintenance vm4 = new VehiclesMaintenance(
                1004L,
                LocalDate.of(2024, 3, 10),
                LocalDate.of(2024, 3, 18),
                LocalDate.of(2024, 3, 19),
                v4
        );

        VehicleLineJourney j1 = new VehicleLineJourney(49, v1, l1);
        VehicleLineJourney j2 = new VehicleLineJourney(24, v2, l2);
        VehicleLineJourney j3 = new VehicleLineJourney(33, v3, l3);
        VehicleLineJourney j4 = new VehicleLineJourney(21, v4, l4);
        VehicleLineJourney j5 = new VehicleLineJourney(65, v5, l5);
        VehicleLineJourney j6 = new VehicleLineJourney(38, v6, l6);
        VehicleLineJourney j7 = new VehicleLineJourney(34, v7, l7);
        VehicleLineJourney j8 = new VehicleLineJourney(47, v8, l8);
        VehicleLineJourney j9 = new VehicleLineJourney(29, v9, l9);
        VehicleLineJourney j10 = new VehicleLineJourney(13, v10, l10);


        //invoco i metodi save con le list per evitare codici troppo lunghi
        List<User> users = List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11);
        users.forEach(ud::save);

        List<TicketMachine> machines = List.of(t1,t2,t3,t4,t5);
        machines.forEach(tmd::save);
        tsd.save(ts1);
        tsd.save(ts2);
        tsd.save(ts3);

        List<Line> lines = List.of(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
        lines.forEach(ld::save);

        List<TravelCard> cards = List.of(tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8, tc9, tc10);
        cards.forEach(tcd::save);

        List<Vehicles> vehicles = List.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
        vehicles.forEach(vd::save);

        vmd.save(vm1);
        vmd.save(vm2);
        vmd.save(vm3);

        List<VehicleLineJourney> journeys = List.of(j1, j2, j3, j4, j5, j6, j7, j8, j9, j10);
        journeys.forEach(jd::save);
        //-----------------------------------------------------------------------------------------------------------------------------

        em.close();
        emf.close();
    }
}
