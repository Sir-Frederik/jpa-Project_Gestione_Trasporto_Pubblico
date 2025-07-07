package team1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Sellers {

    @Id
    @GeneratedValue
    @Column(name = "sellers_id")
    protected long sellersId;

    //list biglietto collegata con i biglietti

    //COSTRUTTORI
    public Sellers() {}

    //GETTER
    public long getSellersId() {
        return sellersId;
    }
}
