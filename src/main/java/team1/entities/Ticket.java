package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.TicketType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "ticket")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket {
    @Id
    @GeneratedValue
    private long id;



@Column (name = "purchase_date")
private LocalDate purchaseDate;
@Column (name = "stamped_date")
private LocalDate stampedDate;

    public Ticket() {
    }

    public Ticket(long id, LocalDate purchaseDate, LocalDate stampedDate, User user, List<Vehicles> all_vehicles) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.stampedDate = stampedDate;
        this.user = user;
        this.all_vehicles = all_vehicles;
    }

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vehicles> getAll_vehicles() {
        return all_vehicles;
    }

    public void setAll_vehicles(List<Vehicles> all_vehicles) {
        this.all_vehicles = all_vehicles;
    }

    public long getId() {
        return id;
    }
}
