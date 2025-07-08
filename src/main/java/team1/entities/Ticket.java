package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.TicketType;
import team1.entities.ticketSons.SubscriptionTicket;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "tickets")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket {
    @Id
    @GeneratedValue
    private long ticketId;



@Column (name = "purchase_date")
private LocalDate purchaseDate;
@Column (name = "stamped_date")
private LocalDate stampedDate;


    public Ticket() {
    }

    public Ticket( LocalDate purchaseDate, LocalDate stampedDate) {
        this.purchaseDate = purchaseDate;
        this.stampedDate = stampedDate;
    }



    @ManyToOne
  private Vehicles vehicles;

    @ManyToOne ()
    private Sellers selles;


    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getStampedDate() {
        return stampedDate;
    }

    public void setStampedDate(LocalDate stampedDate) {
        this.stampedDate = stampedDate;
    }






    public long getTicketId() {
        return ticketId;
    }
}
