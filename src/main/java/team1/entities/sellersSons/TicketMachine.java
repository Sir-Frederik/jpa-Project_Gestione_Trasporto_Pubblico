package team1.entities.sellersSons;

import jakarta.persistence.*;
import team1.entities.Sellers;
import team1.entities.enums.Active;


@Entity
@Table(name = "ticket_machines")
public class TicketMachine extends Sellers {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Active active;
    @Column(name = "identification_code")
    private long identificationCode;

    //COSTRUTTORI
    public TicketMachine(){}
    public TicketMachine(Active active,long identificationCode) {
        this.active = active;
        this.identificationCode = identificationCode;
    }

    //GETTER
    public Active getActive() {
        return active;
    }

    //SETTER
    public void setActive(Active active) {
        this.active = active;
    }


}
