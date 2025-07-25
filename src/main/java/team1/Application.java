package team1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import team1.DAO.*;
import team1.entities.*;
import team1.entities.enums.Availability;
import team1.entities.enums.Genre;
import team1.entities.enums.State;
import team1.entities.enums.VehiclesType;
import team1.entities.sellersSons.TicketMachine;
import team1.entities.sellersSons.TicketSeller;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;
import team1.exceptions.ReUsableException;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporto");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LineDAO ld = new LineDAO(em);
        SellersDao sd = new SellersDao(em);
        TicketMachinesDAO tmd = new TicketMachinesDAO(em);
        TicketSellerDAO tsd = new TicketSellerDAO(em);
        TicketDao td = new TicketDao(em);
        TravelCardDAO tcd = new TravelCardDAO(em);
        UserDAO ud = new UserDAO(em);
        VehicleLineJourneyDAO jd = new VehicleLineJourneyDAO(em);
        VehiclesDAO vd = new VehiclesDAO(em);
        VehiclesMaintenanceDAO vmd = new VehiclesMaintenanceDAO(em);

/*
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

        User user1fromDb = ud.findById(1);
        User user2fromDb = ud.findById(2);
        User user3fromDb = ud.findById(3);
        User user4fromDb = ud.findById(4);
        User user5fromDb = ud.findById(5);
        User user6fromDb = ud.findById(6);
        User user7fromDb = ud.findById(7);
        User user8fromDb = ud.findById(8);
        User user9fromDb = ud.findById(9);
        User user10fromDb = ud.findById(10);

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


        TravelCard tc1 = new TravelCard(LocalDate.of(2024, 7, 1), user1fromDb);
        TravelCard tc2 = new TravelCard(LocalDate.of(2024, 6, 15), user2fromDb);
        TravelCard tc3 = new TravelCard(LocalDate.of(2024, 5, 20), user3fromDb);
        TravelCard tc4 = new TravelCard(LocalDate.of(2024, 4, 10), user4fromDb);
        TravelCard tc5 = new TravelCard(LocalDate.of(2024, 3, 5), user5fromDb);
        TravelCard tc6 = new TravelCard(LocalDate.of(2024, 2, 28), user6fromDb);
        TravelCard tc7 = new TravelCard(LocalDate.of(2024, 1, 14), user7fromDb);
        TravelCard tc8 = new TravelCard(LocalDate.of(2023, 12, 1), user8fromDb);
        TravelCard tc9 = new TravelCard(LocalDate.of(2023, 11, 23), user9fromDb);
        TravelCard tc10 = new TravelCard(LocalDate.of(2023, 10, 9), user10fromDb);

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
        VehicleLineJourney j10 = new VehicleLineJourney(13, vehicles10Fromdb, line10FromDb);*/


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
        /*
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

       // System.out.println( jd.findNumberOfTravelsOfAVehicle(1, 1));*/

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Hi, who are you? 0:Admin 1:User 2:Exit: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 0: // Admin
                    boolean accessControl = false;
                    for (int i = 0; i < 3; i++) {
                        System.out.println("You have entered the administered section. Enter the password to access the system:");
                        String password = scanner.nextLine();
                        if (password.equals("1234")) {
                            System.out.println("Access granted. Welcome, Admin.");
                            accessControl = true;
                            break;
                        } else {
                            System.out.println("Incorrect password");
                        }
                    }

                    if (!accessControl) {
                        System.out.println("Too many failed attempts. Returning to main menu...\n");
                        break;
                    }

                    // Admin main menu
                    int adminSelection;
                    do {
                        System.out.println("\nWelcome to the admin section");
                        System.out.println(
                                "What do you want to do?\n" +
                                        "Choose the section to view:\n" +
                                        "1: TravelCard\n" +
                                        "2: User\n" +
                                        "3: Line\n" +
                                        "4: Sellers\n" +
                                        "5: Vehicles\n" +
                                        "0: Exit"
                        );

                        try {
                            adminSelection = Integer.parseInt(scanner.nextLine());
                            if (adminSelection < 0 || adminSelection > 5) {
                                System.out.println("Invalid choice. Please enter a number from 0 to 5.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            adminSelection = -1;
                            continue;
                        }

                        switch (adminSelection) {

                            case 1: // TravelCard
                                int selection1;
                                do {
                                    System.out.println("\nYou have entered the TravelCard section");
                                    tcd.getAllCard().forEach(System.out::println);
                                    System.out.println("This is the list of all cards");

                                    System.out.println(
                                            "\nWhat do you want to do?\n" +
                                                    "1: Remove\n" +
                                                    "2: User Details\n" +
                                                    "0: Back to Admin Menu"
                                    );

                                    try {
                                        selection1 = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number.\n");
                                        selection1 = -1;
                                        continue;
                                    }

                                    switch (selection1) {
                                        case 1:
                                            System.out.println("Enter the id of the TravelCard you want to remove:");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                tcd.findTravelCardByIdAndDelete(id);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Enter the TravelCard id to find the user:");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                System.out.println(tcd.findUserByTravelCardId(id));
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Returning to Admin Menu");
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                    }

                                } while (selection1 != 0);
                                break;

                            case 2: // User
                                int selection2;
                                do {
                                    System.out.println("\nYou have entered the User section");
                                    ud.getAllUser().forEach(System.out::println);
                                    System.out.println("This is the list of all Users");

                                    System.out.println(
                                            "\nWhat do you want to do?\n" +
                                                    "1: Remove User\n" +
                                                    "2: Tickets List\n" +
                                                    "3: TravelCard\n" +
                                                    "0: Back to Admin Menu"
                                    );

                                    try {
                                        selection2 = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number.");
                                        selection2 = -1;
                                        continue;
                                    }

                                    switch (selection2) {
                                        case 1:
                                            System.out.println("Enter the id of the User you want to remove:");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                ud.findUserByIdAndDelete(id);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Enter the ID of the user to view their tickets:");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                ud.getAllTicketByUser(id).forEach(System.out::println);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Enter the ID of the user to view their TravelCard:");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                System.out.println(ud.findTravelCardByUserId(id));
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Returning to Admin Menu");
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                    }

                                } while (selection2 != 0);
                                break;

                            case 3:
                                int selection3;
                                do {
                                    System.out.println("\nYou have entered the Line section");
                                    ld.getAllLines().forEach(System.out::println);
                                    System.out.println("This is the list of all Line");

                                    System.out.println(
                                            "\nWhat do you want to do?\n" +
                                                    "1: Show vehiclesLineJourney list\n" +
                                                    "2: Show estimated time for this route\n" +
                                                    "0: Back to Admin Menu"
                                    );

                                    try {
                                        selection3 = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number.");
                                        selection3 = -1;
                                        continue;
                                    }

                                    switch (selection3) {
                                        case 1:
                                            System.out.println("Enter the id of the Line to view their VehiclesLineJourney: ");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                ld.getVehicleLineJourneysByLineId(id).forEach(System.out::println);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 2:
                                            System.out.println("enter the id of the route for which you want to know the estimated time: ");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                ld.getEstimatedTimeByLineId(id);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 0:
                                            System.out.println("Returning to Admin Menu");
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                    }

                                } while (selection3 != 0);
                                break;
                            case 4:
                                int selection4;
                                do {
                                    System.out.println("You have entered the Seller section");
                                    sd.getAllSeller().forEach(System.out::println);
                                    System.out.println("This is the list of all Sellers");

                                    System.out.println(
                                            "What do you want to do?\n" +
                                                    "1: Delete a seller\n" +
                                                    "2: Change the status of a ticket machine\n" +
                                                    "3: Create a new ticket machine" +
                                                    "\n4: Create a new ticket seller" +
                                                    "\n0: Back to Admin Menu"
                                    );

                                    try {
                                        selection4 = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number.");
                                        selection4 = -1;
                                        continue;
                                    }

                                    switch (selection4) {
                                        case 1:
                                            System.out.println("Enter the id of the seller that you want remove: ");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                sd.findSellerByIdAndDelete(id);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter the id of the Ticket machine of which you want to change the status: ");
                                            try {
                                                long id = Long.parseLong(scanner.nextLine());
                                                tmd.setTicketMachineState(id);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid id format");
                                            } catch (ReUsableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter the values to create the Ticket Machine");
                                            System.out.println("Enter the identification code of the Ticket Machine ");
                                            int identificationCd = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Enter the city of the Ticket Machine");
                                            String city = scanner.nextLine();
                                            System.out.println("Enter the address of the Ticket Machine");
                                            String address = scanner.nextLine();
                                            int state = -1;
                                            while (state != 0 && state != 1) {
                                                System.out.println("Enter the status of the Ticket Machine 1:ACTIVE or 0:INACTIVE");
                                                try {
                                                    state = Integer.parseInt(scanner.nextLine());
                                                    if (state != 0 && state != 1) {
                                                        System.out.println("Invalid number enter 1 for set status on ACTIVE or 0 for set status on INACTIVE.");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a numeric value (0 or 1).");
                                                }
                                            }
                                            if (state == 1){
                                                TicketMachine tKm = new TicketMachine(city,address,State.ACTIVE,identificationCd);
                                            }else{
                                                TicketMachine tKm = new TicketMachine(city,address,State.INACTIVE,identificationCd);
                                            }
                                        case 4:
                                            System.out.println("Enter the values to create the Ticket Seller");
                                            System.out.println("Enter the name of the seller");
                                            String name = scanner.nextLine();
                                            System.out.println("Enter the surname of the seller");
                                            String surname = scanner.nextLine();
                                            System.out.println("Enter the city of the Ticket Machine");
                                            String city1 = scanner.nextLine();
                                            System.out.println("Enter the address of the Ticket Machine");
                                            String address1 = scanner.nextLine();
                                            TicketSeller tKs = new TicketSeller(city1,address1,name,surname);
                                        case 0:
                                            System.out.println("Returning to Admin Menu");
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                    }

                                } while (selection4 != 0);
                                break;

                            case 5:
                                int selection5 =-1;
                                do {
                                    System.out.println("You have entered in the Vehicles section");
                                    vd.getAllVehicles().forEach(System.out::println);
                                    System.out.println("This is the list of all Vehicles");

                                    System.out.println(
                                            "What do you want to do? Choose the action to do:\n" +
                                                    "1: Bus Menu\n" +
                                                    "2: Tram Menu\n" +
                                                    "3: Maintenance Menu\n" +
                                                    "0: Back to Admin Menu"
                                    );

                                    try {
                                        selection5 = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid number.\n");
                                        selection5 = -1;
                                        continue;
                                    }


                                    switch (selection5) {
                                        case 1:
                                            int busSection = -1;
                                            do{
                                                System.out.println("You have entered in the Bus Menu");
                                                vd.getAllBus().forEach(System.out::println);
                                                System.out.println("This is the list of all Bus");

                                                System.out.println(
                                                        "What do you want to do? Choose the action to do:\n" +
                                                                "1: Add Bus\n" +
                                                                "2: Remove Bus\n" +
                                                                "3: Find Bus with id\n"+
                                                                "0: Back"
                                                );

                                                try {
                                                    busSection = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid number.\n");
                                                    selection5 = -1;
                                                    continue;
                                                }


                                                switch (busSection){
                                                    case 1:
                                                        System.out.println("Create new bus:");
                                                        System.out.println("set a capacity");
                                                        int capacityInput = Integer.parseInt(scanner.nextLine());
                                                        System.out.println("set a plate");
                                                        String plateInput = scanner.nextLine();
                                                        vd.addNewBus(capacityInput, plateInput);
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter the Bus id to remove:");
                                                        try{
                                                            long userInputId = Long.parseLong(scanner.nextLine());
                                                            vd.deleteVehicle(userInputId);
                                                        }catch(NumberFormatException e){
                                                            System.out.println("Invalid ID format. Please enter a numeric value.");
                                                        }
                                                        break;
                                                    case 3:
                                                            System.out.println("Enter the id for search:");
                                                            long userInputFind = Long.parseLong(scanner.nextLine());
                                                            vd.findById(userInputFind);
                                                            break;
                                                    case 0:
                                                        System.out.println("Returning to Vehicles Menu...");
                                                        break;
                                                }

                                            }while(busSection !=0);
                                            break;
                                        case 2:
                                            int tramSection = -1;
                                            do {
                                                System.out.println("You have entered the Tram Menu");
                                                vd.getAllTram().forEach(System.out::println);
                                                System.out.println("This is the list of all Trams");

                                                System.out.println(
                                                        "What do you want to do? Choose the action to do:\n" +
                                                                "1: Add Tram\n" +
                                                                "2: Remove Tram\n" +
                                                                "3: Find Tram with id\n"+
                                                                "0: Back"
                                                );

                                                try {
                                                    tramSection = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid number.\n");
                                                    tramSection = -1;
                                                    continue;
                                                }

                                                switch (tramSection) {
                                                    case 1:
                                                        System.out.println("Create new tram:");
                                                        System.out.println("set a capacity");
                                                        int capacityInput = Integer.parseInt(scanner.nextLine());
                                                        System.out.println("set a plate");
                                                        String plateInput = scanner.nextLine();
                                                        vd.addNewTram(capacityInput, plateInput);
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter the Tram ID to remove:");
                                                        try {
                                                            long tramId = Long.parseLong(scanner.nextLine());
                                                            vd.deleteVehicle(tramId);
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Invalid ID format. Please enter a numeric value.");
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Enter the id for search:");
                                                        long userInputFind = Long.parseLong(scanner.nextLine());
                                                        vd.findById(userInputFind);
                                                        break;
                                                    case 0:
                                                        System.out.println("Returning to Vehicles Menu...");
                                                        break;
                                                    default:
                                                        System.out.println("Invalid option.");
                                                        break;
                                                }

                                            } while (tramSection != 0);
                                        break;
                                        case 3:
                                            int maintenanceSection = -1;
                                            do {
                                                System.out.println("You have entered the Maintenance Menu");
                                                System.out.println(
                                                        "What do you want to do? Choose the action to do:\n" +
                                                                "1: See full log of maintenance \n" +
                                                                "2: See specific maintenance with id\n" +
                                                                "3: Set a maintenance for a Vehicle\n" +
                                                                "4: Set a Vehicle to be ready\n" +
                                                                "5: View how many tickets have been validated on a vehicle\n"+
                                                                "6: View all tickets sold in a given time\n"+
                                                                "7: View the total tickets sold by a seller\n"+
                                                                "8: Get average time for journeys\n"+
                                                                "0: Back"
                                                );
                                                try {
                                                    maintenanceSection = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Invalid input. Please enter a valid number.\n");
                                                    maintenanceSection = -1;
                                                    continue;
                                                }

                                                switch (maintenanceSection){
                                                    case 1:
                                                        vmd.getLogForAll().forEach(System.out::println);
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter the ID to search:");
                                                        try {
                                                            long maintenanceLogId = Long.parseLong(scanner.nextLine());
                                                            System.out.println(vmd.findById(maintenanceLogId));
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Invalid ID format. Please enter a numeric value.");
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Enter ID of the Vehicle to set maintenance");
                                                        try{
                                                            long inputId = Long.parseLong(scanner.nextLine());
                                                            System.out.println(vd.findById(inputId));
                                                            Vehicles vehicleToSet = vd.findById((inputId));

                                                            System.out.println("What date should this vehicle enter manintenance? " +
                                                                    "(use format yyyy-mm-dd)");
                                                            String inputStartDate = scanner.nextLine();
                                                            LocalDate inputDateParsed;
                                                            try {
                                                                inputDateParsed = LocalDate.parse(inputStartDate);
                                                                vd.findById(inputId).setAvailability(Availability.NOTAVAILABLE);
                                                                vmd.createNewMaintenance(inputDateParsed, vehicleToSet);
                                                            } catch (DateTimeParseException e) {
                                                                System.out.println("Invalid input. Please enter date (use format yyyy-MM-dd);\n");
                                                                maintenanceSection = -1;
                                                                continue;
                                                            }
                                                        }catch (NumberFormatException e){
                                                            System.out.println("Invalid ID format. Please enter a numeric value.");
                                                        }
                                                        break;

                                                    case 4:
                                                        System.out.println("Enter ID of the maintenance to set ready");
                                                        try{
                                                            long inputId = Long.parseLong(scanner.nextLine());
                                                            System.out.println(vmd.findById(inputId));
                                                            VehiclesMaintenance maintenanceToSetReady = vmd.findById((inputId));

                                                            System.out.println("What date should this vehicle end maintenance and be ready? " +
                                                                    "(use format yyyy-mm-dd)");
                                                            String inputReadyDate = scanner.nextLine();
                                                            LocalDate inputDateParsed;
                                                            try {
                                                                inputDateParsed = LocalDate.parse(inputReadyDate);
                                                                vd.findById(inputId).setAvailability(Availability.AVAILABLE);
                                                                vmd.endMaintenanceAndSetReady(inputDateParsed, maintenanceToSetReady);
                                                            } catch (DateTimeParseException e) {
                                                                System.out.println("Invalid input. Please enter date (use format yyyy-MM-dd);\n");
                                                                maintenanceSection = -1;
                                                                continue;
                                                            }
                                                        }catch (NumberFormatException e){
                                                            System.out.println("Invalid ID format. Please enter a numeric value.");
                                                        }
                                                        break;
                                                    case 5:
                                                        System.out.println("set id vehicle");
                                                        int idInput = Integer.parseInt(scanner.nextLine());
                                                        long toChech = vmd.viewAllValidatedTickets(idInput);
                                                        System.out.println("this is the number of tickets in the bus selected");
                                                        System.out.println(toChech);
                                                        break;
                                                    case 6:
                                                        System.out.println("Start date(format yyyy-mm-ddd):");
                                                        LocalDate starDateInput = LocalDate.parse(scanner.nextLine());
                                                        System.out.println("End date (format yyyy-mm-dd):");
                                                        LocalDate endDateInput = LocalDate.parse(scanner.nextLine());
                                                        long toDisplay = vmd.getTotalTicketsSoldInPeriod(starDateInput,endDateInput);
                                                        System.out.println("Total sold: ");
                                                        System.out.println(toDisplay);
                                                        break;
                                                    case 7:
                                                        System.out.println("Start date(format yyyy-mm-ddd):");
                                                        LocalDate starDateInput2 = LocalDate.parse(scanner.nextLine());
                                                        System.out.println("End date (format yyyy-mm-dd):");
                                                        LocalDate endDateInput2 = LocalDate.parse(scanner.nextLine());
                                                        System.out.println("list of sellers");
                                                        sd.getAllSeller().forEach(System.out::println);
                                                        System.out.println("enter id of seller");
                                                        long inputSellerId = Long.parseLong(scanner.nextLine());
                                                        long toDisplay2 = vmd.getTicketsSoldBySeller( inputSellerId, starDateInput2,endDateInput2);
                                                        System.out.println("Total sold: ");
                                                        System.out.println(toDisplay2);
                                                        break;
                                                    case 8 :
                                                        double timetodisplay = vmd.getAverageTime();
                                                        System.out.println("this is the average time");
                                                        System.out.println(timetodisplay);
                                                        break;
                                                }

                                            }while(maintenanceSection!=0);
                                            break;
                                        case 0:
                                            System.out.println("Back");
                                            break;
                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }


                                }while(selection5 != 0);
                                break;


                            case 0:
                                System.out.println("Exiting admin menu...");
                                break;
                        }

                    } while (adminSelection != 0);

                case 1: // User
                    System.out.println("Welcome, User!");
                    System.out.println("Are you a registered user? (1 = Yes, 2 = No)");
                    int choice1 = Integer.parseInt(scanner.nextLine());

                    switch (choice1) {
                        case 1:
                            User user = registeredUser(scanner, em, ud);
                            System.out.println("Hello " + user.getName() + "!");
                            userChoices(scanner, em, ud, user, sd, ld, td, tcd, vd, jd);
                            break;

                        case 2:
                            System.out.println("You need to register first.");
                            registerUser(scanner, em, ud, sd);
                            break;

                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 0 (Admin) or 1 (User).");
            }

        } while (choice!=2);

        scanner.close();
        em.close();
        emf.close();
    }

    public static User registeredUser(Scanner scanner, EntityManager em, UserDAO ud) {
        System.out.println("Tell me your First Name so I can identify you:");
        String name = scanner.nextLine();
        System.out.println("Now your Last Name:");
        String surname = scanner.nextLine();
        return ud.findByNameAndSurname(name, surname);
    }

    public static void userChoices(Scanner scanner, EntityManager em, UserDAO ud, User user, SellersDao sd, LineDAO ld, TicketDao td, TravelCardDAO tcd, VehiclesDAO vd, VehicleLineJourneyDAO jd) {
        int choice;
        do {
            System.out.println("What would you do?");
            System.out.println("1 - See your Data");
            System.out.println("2 - Buy tickets");
            System.out.println("3 - Get a new travel card");
            System.out.println("4 - Take a ride");
            System.out.println("5 - Exit");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println(user.toString());
                    break;
                case 2:
                    System.out.println("Great, do you want to buy it from a physical retailer (1) or  an automatic distributor (2)? Press 0 to go back");
                    int choice2 =  Integer.parseInt(scanner.nextLine());
                  switch (choice2){
                      case 1:
                          ticketFromSeller(scanner, em, ud, sd, user);
                          break;
                      case 2:
                          ticketFromDistributor(scanner, em, ud, sd, user);
                          break;
                      case 0:
                          break;
                      default:
                          System.out.println("Invalid. Choice again. 1 for Physical reatailer, 2 for distributor or 0 to go back");


                  }
                    break;
                case 3:
                    System.out.println("Get new card");
                    TravelCard toDisplay =tcd.getNewCard(user);
                    System.out.println("New card issued");
                    System.out.println(toDisplay);
                    break;

               
                case 4:
                    takeARide(scanner, em, ld, vd, jd);

                    // Validation check
                    System.out.print("\nInsert the id of your ticket for the validation check: ");
                    try {
                        long ticketId = Long.parseLong(scanner.nextLine());

                        // Trova il ticket
                        Ticket ticket = td.findById(ticketId);

                        if (ticket == null) {
                            System.out.println("❌ Ticket not found!");
                            break;
                        }

                        // Prova a validare il ticket
                        try {
                            vd.validatioTicket(ticket);
                            System.out.println("✅ Welcome on board!");

                            // Mostra info aggiuntive in base al tipo di ticket
                            if (ticket instanceof SingleTicket) {
                                System.out.println("Single ticket validated for today: " + LocalDate.now());
                            } else if (ticket instanceof SubscriptionTicket) {
                                SubscriptionTicket subTicket = (SubscriptionTicket) ticket;
                                System.out.println("Subscription valid until: " + subTicket.getExpiration());
                            }

                            // Salva le modifiche al ticket (la data di validazione è stata aggiornata)
                            td.updateTicket(ticket);

                        } catch (ReUsableException e) {
                            System.out.println("❌ " + e.getMessage());
                            System.out.println("The ticket or the Subscription is not valid GET OUT!!");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ticket ID format!");
                    } catch (EntityNotFoundException e) {
                        System.out.println("❌ Ticket not found in the system!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting user menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }

    public static void registerUser(Scanner scanner, EntityManager em, UserDAO ud, SellersDao sd) {
        System.out.print("Insert name: ");
        String name = scanner.nextLine();

        System.out.print("Insert surname: ");
        String surname = scanner.nextLine();

        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Insert your birth date (dd/mm/yyyy): ");
            try {
                birthDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format");
            }
        }

        System.out.print("Insert your residence city: ");
        String residenceCity = scanner.nextLine();

        Genre genre = null;
        while (genre == null) {
            System.out.println("Insert your genre: MALE, FEMALE, OTHER");
            String genreStr = scanner.nextLine().toUpperCase();
            try {
                genre = Genre.valueOf(genreStr);
            } catch (IllegalArgumentException e) {
                System.out.println("The value inserted is incorrect.");
            }
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setBirthDate(birthDate);
        newUser.setResidenceCity(residenceCity);
        newUser.setGenre(genre);

        ud.save(newUser);

    }

    public static void takeARide(Scanner scanner, EntityManager em, LineDAO ld, VehiclesDAO vd, VehicleLineJourneyDAO jd) {
        try {
            System.out.println("\n=== TAKE A RIDE ===");

            // Mostra tutte le linee disponibili
            System.out.println("Available lines:");
            List<Line> allLines = ld.getAllLines();

            if (allLines.isEmpty()) {
                System.out.println("No lines available at the moment!");
                return;
            }

            // Mostra le linee con tutti i dettagli
            for (int i = 0; i < allLines.size(); i++) {
                Line line = allLines.get(i);
                System.out.println((i + 1) + ". Line " + line.getLine_number() +
                        ": " + line.getDeparture() + " → " + line.getFinal_stop() +
                        " (Estimated time: " + line.getEstimatedTime() + " minutes)");
            }

            // Selezione della linea
            System.out.print("\nSelect a line by number (0 to cancel): ");
            int lineChoice = Integer.parseInt(scanner.nextLine());

            if (lineChoice == 0) {
                System.out.println("Operation cancelled.");
                return;
            }

            if (lineChoice < 1 || lineChoice > allLines.size()) {
                System.out.println("Invalid selection!");
                return;
            }

            Line selectedLine = allLines.get(lineChoice - 1);
            System.out.println("\nYou selected Line " + selectedLine.getLine_number() +
                    ": " + selectedLine.getDeparture() + " → " + selectedLine.getFinal_stop());

            // Mostra i veicoli disponibili
            System.out.println("\nAvailable vehicles for this ride:");
            List<Vehicles> availableVehicles = vd.getAllVehicles().stream()
                    .filter(v -> v.getAvailability() == Availability.AVAILABLE)
                    .toList();

            if (availableVehicles.isEmpty()) {
                System.out.println("No vehicles available at the moment! Please try again later.");
                return;
            }

            // Mostra i veicoli con indice
            for (int i = 0; i < availableVehicles.size(); i++) {
                Vehicles v = availableVehicles.get(i);
                String vehicleType = v.getClass().getSimpleName();
                System.out.println((i + 1) + ". " + vehicleType + " - Plate: " + v.getPlate() +
                        " - Capacity: " + v.getCapacity() + " passengers");
            }

            // Selezione del veicolo
            System.out.print("\nSelect a vehicle by number (0 to cancel): ");
            int vehicleChoice = Integer.parseInt(scanner.nextLine());

            if (vehicleChoice == 0) {
                System.out.println("Operation cancelled.");
                return;
            }

            if (vehicleChoice < 1 || vehicleChoice > availableVehicles.size()) {
                System.out.println("Invalid selection!");
                return;
            }

            Vehicles selectedVehicle = availableVehicles.get(vehicleChoice - 1);

            // Calcola il tempo effettivo in modo randomico (±20% del tempo stimato)
            double estimatedTime = selectedLine.getEstimatedTime();
            double variation = estimatedTime * 0.2; // 20% di variazione
            double minTime = estimatedTime - variation;
            double maxTime = estimatedTime + variation;

            // Genera un tempo random tra minTime e maxTime
            Random random = new Random();
            double randomTime = minTime + (maxTime - minTime) * random.nextDouble();
            int actualTime = (int) Math.round(randomTime);

            // Simula il viaggio
            System.out.println("\n🚌 Starting journey...");
            System.out.println("Estimated time: " + (int)estimatedTime + " minutes");

            // Pausa drammatica
            Thread.sleep(1000);

            // Determina se il viaggio è in orario, in anticipo o in ritardo
            String status;
            if (actualTime < estimatedTime - 2) {
                status = "✓ Arrived early!";
            } else if (actualTime > estimatedTime + 2) {
                status = "⚠ Arrived late due to traffic";
            } else {
                status = "✓ Arrived on time!";
            }

            // Crea il nuovo VehicleLineJourney
            VehicleLineJourney newJourney = new VehicleLineJourney(actualTime, selectedVehicle, selectedLine);

            // Salva nel database usando il DAO
            jd.save(newJourney);

            // Conferma successo
            System.out.println("\n✓ Journey completed successfully!");
            System.out.println("Line " + selectedLine.getLine_number() + ": " +
                    selectedLine.getDeparture() + " → " + selectedLine.getFinal_stop());
            System.out.println("Vehicle: " + selectedVehicle.getClass().getSimpleName() +
                    " - Plate: " + selectedVehicle.getPlate());
            System.out.println("Actual journey time: " + actualTime + " minutes");
            System.out.println(status);
            System.out.println("\nThank you for traveling with us!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (InterruptedException e) {
            System.out.println("Journey interrupted.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void  ticketFromSeller(Scanner scanner, EntityManager em, UserDAO ud, SellersDao sd, User user){

        System.out.println("Ok,  select the seller");
        List<Sellers> allSellers = sd.getAllSeller();
        List<TicketSeller> ticketSellers = allSellers.stream()
                .filter(seller -> seller instanceof TicketSeller)
                .map(seller -> (TicketSeller) seller)
                .toList();

        if (ticketSellers.isEmpty()){
            System.out.println(("No ticket sellers avaiable at the moment"));
            return;
        }
        System.out.println("Avaiable Ticket Sellers:");
        for (int i=0; i< ticketSellers.size(); i++){
            TicketSeller ts = ticketSellers.get(i);
            System.out.println((i+1) + ". " + ts.getName() + " " +ts.getSurname() + " - Location: " +ts.getCity() + ", " + ts.getAddress());
        }
        System.out.println("Select a seller by number. Press 0 to go back. ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice ==0) {
            return;
        }
        if (  choice > ticketSellers.size()){
            System.out.println("Invalid Selection, try again");
            return;

        }

        TicketSeller selectedSeller = ticketSellers.get(choice-1);
        System.out.println( "You've select the Seller " + selectedSeller.getSurname() + " at " + selectedSeller.getAddress() + ", " + selectedSeller.getCity());
        System.out.println("Can you confirm? (1) Yes, 2 (No)");
        choice = Integer.parseInt(scanner.nextLine());
        if (choice ==2) {
            return;
        } else if (choice == 1) {
         Ticket newTicket =  sd.sellTicket(selectedSeller, user);
            System.out.println(newTicket.toString());


        }else {
            System.out.println("Invalid Selection, try again");
            return;
        }


    }
    public static void  ticketFromDistributor(Scanner scanner, EntityManager em, UserDAO ud, SellersDao sd, User user){

        System.out.println("Ok,  select the Distributor");
        List<Sellers> allSellers = sd.getAllSeller();
        List<TicketMachine> Machine = allSellers.stream()
                .filter(seller -> seller instanceof TicketMachine)
                .map(seller -> (TicketMachine) seller)
                .toList();

        if (Machine.isEmpty()){
            System.out.println(("No ticket Machine avaiable at the moment"));
            return;
        }
        System.out.println("Avaiable Ticket Machine:");
        for (int i=0; i< Machine.size(); i++){
            TicketMachine tm = Machine.get(i);
            System.out.println((i+1) + ". " + tm.getSellersId()  + " - Location: " +tm.getCity() + ", " + tm.getAddress() + ", AVAIABILITY: " + tm.getState());
        }
        System.out.println("Select a machine by number. Press 0 to go back. ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice ==0) {
            return;
        }
        if (  choice > Machine.size()){
            System.out.println("Invalid Selection, try again");
            return;

        }

        TicketMachine selectedSeller = Machine.get(choice-1);
        System.out.println( "You've select the Seller " + selectedSeller.getSellersId() + " at " + selectedSeller.getAddress() + ", " + selectedSeller.getCity());
        System.out.println("Can you confirm? (1) Yes, 2 (No)");
        choice = Integer.parseInt(scanner.nextLine());
        if (choice ==2) {
            return;
        } else if (choice == 1) {
            Ticket newTicket =  sd.sellTicket(selectedSeller, user);
            System.out.println("Ticket " + newTicket.getPurchaseDate() + ", " + newTicket.getTicketId() + ", Type: " + newTicket.getClass());



        }else {
            System.out.println("Invalid Selection, try again");
            return;
        }


    }



}


