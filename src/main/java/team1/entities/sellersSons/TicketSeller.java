package team1.entities.sellersSons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import team1.entities.Sellers;

import java.time.LocalDate;

@Entity
@Table(name = "ticket_sellers")
public class TicketSeller extends Sellers {

    @Column(name = "name")
    private String name;

    //COSTRUTTORI
    public TicketSeller() {
    }
    public TicketSeller(String name) {
        this.name = name;
    }

    //GETTER
    public String getName() {
        return name;
    }
}
