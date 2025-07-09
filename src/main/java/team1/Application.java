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

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporto");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
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

        // PRIMA: crei le TravelCard SENZA assegnare ancora l'utente
        TravelCard tc1 = new TravelCard(LocalDate.of(2024, 7, 1));
        TravelCard tc2 = new TravelCard(LocalDate.of(2024, 6, 15));
        TravelCard tc3 = new TravelCard(LocalDate.of(2024, 5, 20));
        TravelCard tc4 = new TravelCard(LocalDate.of(2024, 4, 10));
        TravelCard tc5 = new TravelCard(LocalDate.of(2024, 3, 5));
        TravelCard tc6 = new TravelCard(LocalDate.of(2024, 2, 28));
        TravelCard tc7 = new TravelCard(LocalDate.of(2024, 1, 14));
        TravelCard tc8 = new TravelCard(LocalDate.of(2023, 12, 1));
        TravelCard tc9 = new TravelCard(LocalDate.of(2023, 11, 23));
        TravelCard tc10 = new TravelCard(LocalDate.of(2023, 10, 9));

// POI: crei gli User assegnando loro le TravelCard
        User u1 = new User("Oronzo", "Canà", LocalDate.of(1940, 5, 21), "Alberobello", Genre.MALE, tc1);
        User u2 = new User("Paolino", "Paperino", LocalDate.of(1934, 6, 9), "Paperopoli", Genre.MALE, tc2);
        User u3 = new User("Marilyn", "Monroe", LocalDate.of(1926, 6, 1), "Los Angeles", Genre.FEMALE, tc3);
        User u4 = new User("Albert", "Einstein", LocalDate.of(1879, 3, 14), "Princeton", Genre.MALE, tc4);
        User u5 = new User("Daffy", "Duck", LocalDate.of(1937, 4, 17), "Looneyville", Genre.MALE, tc5);
        User u6 = new User("Lady", "Gaga", LocalDate.of(1986, 3, 28), "New York", Genre.FEMALE, tc6);
        User u7 = new User("Freddie", "Mercury", LocalDate.of(1946, 9, 5), "Zanzibar", Genre.MALE, tc7);
        User u8 = new User("Greta", "Thunberg", LocalDate.of(2003, 1, 3), "Stoccolma", Genre.FEMALE, tc8);
        User u9 = new User("Totò", "Principe", LocalDate.of(1898, 2, 15), "Napoli", Genre.MALE, tc9);
        User u10 = new User("Sam", "Genderfluid", LocalDate.of(1990, 8, 8), "Berlino", Genre.OTHER, tc10);

// ORA colleghi anche il lato inverso (facoltativo ma consigliato)
        tc1.setUser(u1);
        tc2.setUser(u2);
        tc3.setUser(u3);
        tc4.setUser(u4);
        tc5.setUser(u5);
        tc6.setUser(u6);
        tc7.setUser(u7);
        tc8.setUser(u8);
        tc9.setUser(u9);
        tc10.setUser(u10);

// INFINE salvi prima le TravelCard e poi gli User (essendo il lato proprietario)
        tcd.save(tc1);
        tcd.save(tc2);
        tcd.save(tc3);
        tcd.save(tc4);
        tcd.save(tc5);
        tcd.save(tc6);
        tcd.save(tc7);
        tcd.save(tc8);
        tcd.save(tc9);
        tcd.save(tc10);

        ud.save(u1);
        ud.save(u2);
        ud.save(u3);
        ud.save(u4);
        ud.save(u5);
        ud.save(u6);
        ud.save(u7);
        ud.save(u8);
        ud.save(u9);
        ud.save(u10);

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

        Line line1FromDb = ld.findById(1);
        Line line2FromDb = ld.findById(2);
        Line line3FromDb = ld.findById(3);
        Line line4FromDb = ld.findById(4);
        Line line5FromDb = ld.findById(5);
        Line line6FromDb = ld.findById(6);
        Line line7FromDb = ld.findById(7);
        Line line8FromDb = ld.findById(8);
        Line line9FromDb = ld.findById(9);
        Line line10FromDb = ld.findById(10);

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

        Vehicles vehicles1Fromdb = vd.findById(1);
        Vehicles vehicles2Fromdb = vd.findById(2);
        Vehicles vehicles3Fromdb = vd.findById(3);
        Vehicles vehicles4Fromdb = vd.findById(4);
        Vehicles vehicles5Fromdb = vd.findById(5);
        Vehicles vehicles6Fromdb = vd.findById(6);
        Vehicles vehicles7Fromdb = vd.findById(7);
        Vehicles vehicles8Fromdb = vd.findById(8);
        Vehicles vehicles9Fromdb = vd.findById(9);
        Vehicles vehicles10Fromdb = vd.findById(10);

        VehiclesMaintenance vm1 = new VehiclesMaintenance(
                LocalDate.of(2024, 6, 1),
                LocalDate.of(2024, 6, 10),
                LocalDate.of(2024, 6, 11),
                vehicles1Fromdb
        );

        VehiclesMaintenance vm2 = new VehiclesMaintenance(
                LocalDate.of(2024, 5, 5),
                LocalDate.of(2024, 5, 20),
                LocalDate.of(2024, 5, 21),
                vehicles2Fromdb
        );

        VehiclesMaintenance vm3 = new VehiclesMaintenance(
                LocalDate.of(2024, 4, 15),
                LocalDate.of(2024, 4, 25),
                LocalDate.of(2024, 4, 26),
                vehicles3Fromdb
        );

        VehiclesMaintenance vm4 = new VehiclesMaintenance(
                LocalDate.of(2024, 3, 10),
                LocalDate.of(2024, 3, 18),
                LocalDate.of(2024, 3, 19),
                vehicles4Fromdb
        );

        VehicleLineJourney j1 = new VehicleLineJourney(49, vehicles1Fromdb, line1FromDb);
        VehicleLineJourney j2 = new VehicleLineJourney(24, vehicles2Fromdb, line2FromDb);
        VehicleLineJourney j3 = new VehicleLineJourney(33, vehicles3Fromdb, line3FromDb);
        VehicleLineJourney j4 = new VehicleLineJourney(21, vehicles4Fromdb, line4FromDb);
        VehicleLineJourney j5 = new VehicleLineJourney(65, vehicles5Fromdb, line5FromDb);
        VehicleLineJourney j6 = new VehicleLineJourney(38, vehicles6Fromdb, line6FromDb);
        VehicleLineJourney j7 = new VehicleLineJourney(34, vehicles7Fromdb, line7FromDb);
        VehicleLineJourney j8 = new VehicleLineJourney(47, vehicles8Fromdb, line8FromDb);
        VehicleLineJourney j9 = new VehicleLineJourney(29, vehicles9Fromdb, line9FromDb);
        VehicleLineJourney j10 = new VehicleLineJourney(13, vehicles10Fromdb, line10FromDb);


//        //invoco i metodi save con le list per evitare codici troppo lunghi
//        List<User> users = List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11);
//        users.forEach(ud::save);

//        List<TicketMachine> machines = List.of(t1,t2,t3,t4,t5);
//        machines.forEach(tmd::save);
//        tsd.save(ts1);
//        tsd.save(ts2);
//        tsd.save(ts3);
//
//        List<Line> lines = List.of(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
//        lines.forEach(ld::save);
//
//        List<TravelCard> cards = List.of(tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8, tc9, tc10);
//        cards.forEach(tcd::save);
//
//        List<Vehicles> vehicles = List.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
//        vehicles.forEach(vd::save);
//
//        vmd.save(vm1);
//        vmd.save(vm2);
//        vmd.save(vm3);
//        vmd.save(vm4);
//
//        List<VehicleLineJourney> journeys = List.of(j1, j2, j3, j4, j5, j6, j7, j8, j9, j10);
//        journeys.forEach(jd::save);


        //-----------------------------------------------------------------------------------------------------------------------------


        //tickets creation
//sellers from db
        TicketMachine ticketMachineFromDb1 = tmd.findById(1);
        TicketMachine ticketMachineFromDb2 = tmd.findById(2);
        TicketMachine ticketMachineFromDb3 = tmd.findById(3);
        TicketMachine ticketMachineFromDb4 = tmd.findById(4);
        TicketMachine ticketMachineFromDb5 = tmd.findById(5);

        TicketSeller ticketSellerFromDb1 = tsd.findById(6);
        TicketSeller ticketSellerFromDb2 = tsd.findById(7);
        TicketSeller ticketSellerFromDb3 = tsd.findById(8);

        TicketSeller ticketSeller4 = new TicketSeller("test", "test");
             //   sd.save(ticketSeller4);
//io rimuoverei i dao per i figli di seller e i figli di ticket
                //sd.sellTicket(ticketMachineFromDb2);

       // System.out.println( jd.findNumberOfTravelsOfAVehicle(1, 1));

        em.close();
        emf.close();
    }
}
