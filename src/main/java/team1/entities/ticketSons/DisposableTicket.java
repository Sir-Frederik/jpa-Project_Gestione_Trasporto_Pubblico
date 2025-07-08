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
    private long id;



    public DisposableTicket() {
    }


    public DisposableTicket(long id, LocalDate purchaseDate, LocalDate stampedDate, User user, List<Vehicles> all_vehicles, long id1) {
        super(id, purchaseDate, stampedDate, user, all_vehicles);
        this.id = id1;
    }

    public long getId() {
        return id;
    }



}
