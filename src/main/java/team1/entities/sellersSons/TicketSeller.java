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
    @Column(name = "surname")
    private String surname;

    //COSTRUTTORI
    public TicketSeller() {
    }

    public TicketSeller(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //GETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;

       //SETTER

    }
}
