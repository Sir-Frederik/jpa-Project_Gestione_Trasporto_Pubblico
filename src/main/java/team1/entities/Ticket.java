package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.TicketType;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue

    private long id;

private TicketType typology;
private boolean stamped;
private  boolean valid;
@Column (name = "expiration_date")
private LocalDate expiration;
@Column (name = "purchase_date")
private LocalDate purchaseDate;
@Column (name = "stamped_date")
private LocalDate stampedDate;

    public Ticket() {
    }


    public Ticket(long id, TicketType typology, boolean stamped, boolean valid, LocalDate expiration, LocalDate purchaseDate, LocalDate stampedDate) {
        this.id = id;
        this.typology = typology;
        this.stamped = stamped;
        this.valid = valid;
        this.expiration = expiration;
        this.purchaseDate = purchaseDate;
        this.stampedDate = stampedDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", typology=" + typology +
                ", stamped=" + stamped +
                ", valid=" + valid +
                ", expiration=" + expiration +
                ", purchaseDate=" + purchaseDate +
                ", stampedDate=" + stampedDate +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TicketType getTypology() {
        return typology;
    }

    public void setTypology(TicketType typology) {
        this.typology = typology;
    }

    public boolean isStamped() {
        return stamped;
    }

    public void setStamped(boolean stamped) {
        this.stamped = stamped;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

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
}
