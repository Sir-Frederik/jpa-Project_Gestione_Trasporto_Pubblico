package team1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sellers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Sellers {

    @Id
    @GeneratedValue
    @Column(name = "sellers_id")
    protected long sellersId;

    @OneToMany
    @JoinColumn(name = "selled_tickets")
 public List<Ticket> selledTickets;

    //COSTRUTTORI
    public Sellers() {}

    public Sellers(long sellersId) {
        this.sellersId = sellersId;
    }

    //GETTER
    public long getSellersId() {
        return sellersId;
    }
}
