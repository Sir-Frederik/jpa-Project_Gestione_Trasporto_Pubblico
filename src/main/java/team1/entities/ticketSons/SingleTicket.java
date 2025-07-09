package team1.entities.ticketSons;

import jakarta.persistence.*;
import team1.entities.Sellers;
import team1.entities.Ticket;

import java.time.LocalDate;

@Entity
@Table(name = "disposable_tickets")
public class SingleTicket extends Ticket {


    public SingleTicket() {
    }

    public SingleTicket(LocalDate purchaseDate, Sellers sellers) {
        super(purchaseDate, sellers);
    }


}
