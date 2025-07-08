package team1.entities.ticketSons;

import jakarta.persistence.*;
import team1.entities.Ticket;
import team1.entities.enums.TicketType;

@Entity
@Table(name = "Subscription_ticket")

public class SubscriptionTicket extends Ticket {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    TicketType type;

}
