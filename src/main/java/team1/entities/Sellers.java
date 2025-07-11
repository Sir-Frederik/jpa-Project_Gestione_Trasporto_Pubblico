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
    @Column(name = "city")
    protected String city;
    @Column(name = "address")
    protected String address;

    @OneToMany(mappedBy = "sellers")
    public List<Ticket> tickets;

    //COSTRUTTORI
    public Sellers() {}
    public Sellers(String city,String address) {
        this.city = city;
        this.address = address;
    }
    //GETTER
    public long getSellersId() {
        return sellersId;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    //SETTER


    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "sellersId=" + sellersId +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", tickets=" + tickets +
                '}';
    }


}
