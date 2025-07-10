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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Hi, who are you? 0:Admin 1:User 2:Exit");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0: // Admin
                    boolean accessControl = false;
                    for (int i = 0; i < 3; i++) {
                        System.out.println("You have entered the admin section. Enter the password to access the system:");
                        String password = scanner.nextLine();
                        if (password.equals("1234")) {
                            System.out.println("Access granted. Welcome, Admin.");
                            accessControl = true;
                            break;
                        } else {
                            System.out.println("Incorrect password.");
                        }
                    }
                    if (!accessControl) {
                        System.out.println("Too many failed attempts. Returning to main menu...\n");
                    } else {
                        System.out.println("Welcome to the admin section, what do you want to do?");
                    }
                    break;

                case 1: // User
                    System.out.println("Welcome, User!");
                    System.out.println("Are you a registered user? (1 = Yes, 2 = No)");
                    int choice1 = Integer.parseInt(scanner.nextLine());

                    switch (choice1) {
                        case 1:
                            User user = registeredUser(scanner, em, ud);
                            System.out.println("Hello " + user.getName() + "!");
                            userChoices(scanner, em, ud, user);
                            break;

                        case 2:
                            System.out.println("You need to register first.");
                            registerUser(scanner, em, ud);
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
                    System.out.println("Invalid choice. Please enter 0 (Admin), 1 (User), or 2 (Exit).");
            }

        } while (choice != 2);

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

    public static void userChoices(Scanner scanner, EntityManager em, UserDAO ud, User user) {
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
                    System.out.println(user);
                    break;
                case 2:
                    System.out.println("Ticket purchase not yet implemented.");
                    break;
                case 3:
                    System.out.println("Travel card functionality not yet implemented.");
                    break;
                case 4:
                    System.out.println("Ride functionality not yet implemented.");
                    break;
                case 5:
                    System.out.println("Exiting user menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }

    public static void registerUser(Scanner scanner, EntityManager em, UserDAO ud) {
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
}
