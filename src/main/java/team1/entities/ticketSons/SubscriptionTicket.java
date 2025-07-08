package team1.entities.ticketSons;

import jakarta.persistence.*;
import team1.entities.Ticket;
import team1.entities.TravelCard;
import team1.entities.User;
import team1.entities.Vehicles;
import team1.entities.enums.TicketType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Subscription_ticket")

public class SubscriptionTicket extends Ticket {

    @Enumerated(EnumType.STRING)
    TicketType type;
    private LocalDate expiration;

    @ManyToOne
    @JoinColumn(name = "travel_card_id")
    private TravelCard travelCard;


    public SubscriptionTicket(){}

    public SubscriptionTicket(LocalDate purchaseDate, LocalDate stampedDate,
                              TicketType type, LocalDate expiration, TravelCard travelCard) {
        super(purchaseDate, stampedDate);
        this.type = type;
        this.expiration = expiration;
        this.travelCard = travelCard;
    }


    public TicketType getType() {
        return type;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public TravelCard getTravelCard() {
        return travelCard;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setTravelCard(TravelCard travelCard) {
        this.travelCard = travelCard;
    }

    @Override
    public String toString() {
        return "SubscriptionTicket{" +
                "type=" + type +
                ", expiration=" + expiration +
                ", travelCard=" + travelCard +
                '}';
    }
}
