package team1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "tickets")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ticket {

    @Id
    @GeneratedValue
    private long ticketId;
    @Column (name = "purchase_date")
    private LocalDate purchaseDate;
    @Column (name = "validation_date")
    private LocalDate validationDate;


    //RELAZIONI
    @ManyToOne ()
    private Sellers sellers;

    @ManyToOne
    private Vehicles vehicles;

    //COSTRUTTORI
    public Ticket() {}
    public Ticket( LocalDate purchaseDate, Sellers sellers) {
        this.purchaseDate = purchaseDate;
        this.sellers = sellers;
    }

    //GETTER SETTER
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public long getTicketId() {
        return ticketId;
    }
}
