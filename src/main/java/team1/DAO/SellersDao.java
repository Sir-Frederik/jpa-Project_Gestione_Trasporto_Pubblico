package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import team1.entities.Sellers;
import team1.entities.Ticket;
import team1.entities.User;
import team1.entities.enums.State;
import team1.entities.enums.TicketType;
import team1.entities.sellersSons.TicketMachine;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;
import team1.exceptions.Riusablexception;

import java.time.LocalDate;
import java.util.Scanner;


public class SellersDao {
    private EntityManager entityManager;


    public SellersDao(EntityManager em) {
        this.entityManager = em;
    }


    public void save(Sellers seller) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(seller);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public Sellers findById(long id) {
        Sellers sellerFromId = entityManager.find(Sellers.class, id);
        if (sellerFromId == null) {
            throw new EntityNotFoundException("Element not found");
        }
        return sellerFromId;
    }

    //bisogna fare uno scanner in cui chiediamo il tipo di biglietto true single false subscription
    public Ticket sellTicket(Sellers seller, boolean n, User user) {
        if (seller == null) {
            throw new EntityNotFoundException("this seller does not exist");
        }

        if (seller instanceof TicketMachine) {
            if (((TicketMachine) seller).getActive() == State.INACTIVE) {
                throw new Riusablexception("this machine is out of service");
            }
        }

        if (n) {
            SingleTicket newTicket = new SingleTicket(LocalDate.now(), seller);
            System.out.println("New single ticket created");
            return newTicket;
        } else {
            if (user.getTravelCard() == null) {
                throw new Riusablexception("You can't create a subscription ticket without a travel card");
            } else {
                Scanner scanner = new Scanner(System.in); 
                System.out.println("Select your type of subscription: 1: Weekly, 2: Monthly, 3: Yearly");
                int typeSelection = Integer.parseInt(scanner.nextLine());

                switch (typeSelection) {
                    case 1:
                        SubscriptionTicket weeklyTicket = new SubscriptionTicket(LocalDate.now(), seller, TicketType.WEEKLY, LocalDate.now().plusDays(7), user.getTravelCard());
                        System.out.println("New weekly subscription ticket created");
                        return weeklyTicket;
                    case 2:
                        SubscriptionTicket monthlyTicket = new SubscriptionTicket(LocalDate.now(), seller, TicketType.MONTHLY, LocalDate.now().plusMonths(1), user.getTravelCard());
                        System.out.println("New monthly subscription ticket created");
                        return monthlyTicket;
                    case 3:
                        SubscriptionTicket yearlyTicket = new SubscriptionTicket(LocalDate.now(), seller, TicketType.YEARLY, LocalDate.now().plusYears(1), user.getTravelCard());
                        System.out.println("New yearly subscription ticket created");
                        return yearlyTicket;
                    default:
                        throw new IllegalArgumentException("Invalid subscription type selected");
                }
            }
        }
    }

}
