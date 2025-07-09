package team1.entities;

import jakarta.persistence.*;
import team1.entities.ticketSons.SubscriptionTicket;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "travel_cards")
public class TravelCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDate expirationDate;
    private LocalDate startDate;

    // RELAZIONI
    @OneToOne(mappedBy = "travelCard")
    private User user;

    @OneToMany(mappedBy = "associated_tickets")
    private List<SubscriptionTicket> subscriptionTickets;

    // COSTRUTTORI
    public TravelCard() {}

    public TravelCard(LocalDate startDate) {
        this.startDate = startDate;
        this.expirationDate = startDate.plusYears(1);
    }

    // GETTER & SETTER
    public long getId() {
        return id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public User getUser() {
        return user;
    }

    public List<SubscriptionTicket> getSubscriptionTickets() {
        return subscriptionTickets;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TravelCard{" +
                "id=" + id +
                ", expirationDate=" + expirationDate +
                ", startDate=" + startDate +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}






