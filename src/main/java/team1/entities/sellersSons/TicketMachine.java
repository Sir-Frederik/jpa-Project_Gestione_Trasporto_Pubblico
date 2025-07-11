package team1.entities.sellersSons;

import jakarta.persistence.*;
import team1.entities.Sellers;
import team1.entities.enums.State;


@Entity
@Table(name = "ticket_machines")
public class TicketMachine extends Sellers {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "identification_code", unique = true)
    private int identificationCode;

    //COSTRUTTORI
    public TicketMachine(){}
    public TicketMachine(State state, int identificationCode) {
        this.state = state;
        this.identificationCode = identificationCode;
    }

    //GETTER
    public State getState() {
        return state;
    }

    //SETTER
    public void setState(State state) {
        this.state = state;
    }


}
