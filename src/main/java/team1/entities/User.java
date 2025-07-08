package team1.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;

    @OneToMany
    private List<TravelCard> allTravelCards;

    //COSTRUTTORI
    public User() {
    }
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //GETTER SETTER
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public List<TravelCard> getAllTravelCards() {
        return allTravelCards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
