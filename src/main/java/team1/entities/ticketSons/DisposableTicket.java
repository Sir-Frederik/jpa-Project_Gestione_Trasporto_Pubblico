package team1.entities.ticketSons;

import jakarta.persistence.*;
import team1.entities.Ticket;
import team1.entities.User;
import team1.entities.Vehicles;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Disposable_ticket")


public class DisposableTicket extends Ticket {


    public DisposableTicket() {
    }


    public DisposableTicket(LocalDate purchaseDate, LocalDate stampedDate, long ticketId) {
        super(purchaseDate, stampedDate);
    }


}
