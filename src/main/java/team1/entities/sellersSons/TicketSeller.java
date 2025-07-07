package team1.entities.sellersSons;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import team1.entities.Sellers;

@Entity
@Table(name = "ticket_seller")
public class TicketSeller extends Sellers {

    //COSTRUTTORI
    public TicketSeller() {
    }
}
