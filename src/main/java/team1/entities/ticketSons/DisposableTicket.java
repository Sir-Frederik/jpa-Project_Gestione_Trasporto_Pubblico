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

    @Id
    @GeneratedValue
    private long ticketId;



    public DisposableTicket() {
    }


    public DisposableTicket(long ticketId, LocalDate purchaseDate, LocalDate stampedDate, User user, List<Vehicles> all_vehicles) {
        super(ticketId, purchaseDate, stampedDate, user, all_vehicles);
        this.ticketId = ticketId;
    }

    public long getticketId() {
        return ticketId;
    }



}
