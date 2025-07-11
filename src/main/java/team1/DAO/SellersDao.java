package team1.DAO;

import jakarta.persistence.*;
import team1.entities.*;
import team1.entities.enums.State;
import team1.entities.enums.TicketType;
import team1.entities.sellersSons.TicketMachine;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;
import team1.exceptions.ReUsableException;

import java.time.LocalDate;
import java.util.List;
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

    public Ticket sellTicket(Sellers seller, User user) {
        if (seller == null) {
            throw new EntityNotFoundException("this seller does not exist");
        }

        if (seller instanceof TicketMachine) {
            if (((TicketMachine) seller).getState() == State.INACTIVE) {
                throw new ReUsableException("this machine is out of service");
            }
        }

        Scanner scanner  = new Scanner(System.in);
        System.out.println("Which type of ticket do you need? 1 for single ticket, " +
                "2 for weekly or monthly (IF YOU CHOOSE OPTIONS 2 YOU NEED A TRAVELCARD)");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice){
            case 1:
                SingleTicket newTicket = new SingleTicket(LocalDate.now(), seller);
                System.out.println("New single ticket created");
                return newTicket;
            case 2:
                if(user.getAllTravelCards().isEmpty()){
                    System.out.println("you cant buy this ticket");
                }else{
                    //questa e una lista io voglio vedere se nella lista c e una card valida
                   List<TravelCard> cardStatus =  user.getAllTravelCards().stream()
                            .filter(tc->tc.getExpiration_date().isAfter(LocalDate.now()))
                                    .toList();

                   //da vedere se la tessera e scaduta lo user deve crearne una nuova
                    if(cardStatus.isEmpty()){
                        throw new ReUsableException("you have to create another travel card");
                    }

                    System.out.println("2 for weekly 3 for monthly");
                    int userChoice2 = Integer.parseInt(scanner.nextLine());
                    switch (userChoice2){
                        case 2:
                            SubscriptionTicket newSubsciptionWeekly = new SubscriptionTicket(LocalDate.now(), seller,
                                    TicketType.WEEKLY,cardStatus.getFirst());
                            System.out.println("New  ticket created");
                            return newSubsciptionWeekly;
                        case 3:
                            SubscriptionTicket newSubsciptionMonthly = new SubscriptionTicket(LocalDate.now(), seller,
                                    TicketType.MONTHLY,cardStatus.getFirst());
                            System.out.println("New  ticket created");
                            return newSubsciptionMonthly;
                    }

                }
            default:
                throw new ReUsableException("value selected is not ok");
        }
    }
    public List<Sellers> getAllSeller(){
        TypedQuery<Sellers> query = entityManager.createQuery("SELECT v FROM Sellers v", Sellers.class);
        return query.getResultList();
    }
    public void findSellerByIdAndDelete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Seller u WHERE u.id = :id");
        query.setParameter("id", id);
        int deletedCount = query.executeUpdate();
        transaction.commit();
        if (deletedCount > 0) {
            System.out.println("Element successfully removed!");
        } else {
            System.out.println("No element found with the given ID.");
        }
    }

}
