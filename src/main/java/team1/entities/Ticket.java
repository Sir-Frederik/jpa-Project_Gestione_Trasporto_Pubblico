package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.TicketType;
import team1.entities.ticketSons.SubscriptionTicket;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "ticket")
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



    @ManyToMany(mappedBy = "associated_ticket")
    private List<Vehicles> all_vehicles;


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



    public List<Vehicles> getAll_vehicles() {
        return all_vehicles;
    }


    public long getTicketId() {
        return ticketId;
    }
}
