package team1.entities.ticketSons;

import jakarta.persistence.*;
import team1.entities.Sellers;
import team1.entities.Ticket;
import team1.entities.TravelCard;
import team1.entities.enums.TicketType;

import java.time.LocalDate;

@Entity
@Table(name = "subscription_tickets")

public class SubscriptionTicket extends Ticket {

    @Enumerated(EnumType.STRING)
    TicketType type;
    private LocalDate expiration;

    @ManyToOne
    @JoinColumn(name = "travel_card_id")
    private TravelCard travelCard;

    //COSTRUTTORI
    public SubscriptionTicket(){}
    public SubscriptionTicket(LocalDate purchaseDate, Sellers sellers, TicketType type, TravelCard travelCard) {
        super(purchaseDate, sellers);
        this.type = type;
        this.expiration = setExpirationDate();
        this.travelCard = travelCard;
    }

    //GETTER
    public TicketType getType() {
        return type;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public TravelCard getTravelCard() {
        return travelCard;
    }

    //SETTER
    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setTravelCard(TravelCard travelCard) {
        this.travelCard = travelCard;
    }


    //metodo per scadenza
    public LocalDate setExpirationDate(){

        LocalDate dateExpiration = null;
        switch (this.type)
        {
            case WEEKLY:
                dateExpiration = this.getPurchaseDate().plusDays(7);
            case MONTHLY:
                dateExpiration = this.getPurchaseDate().plusMonths(1);
            case YEARLY:
                dateExpiration = this.getPurchaseDate().plusYears(1);
        }
        return dateExpiration;
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
