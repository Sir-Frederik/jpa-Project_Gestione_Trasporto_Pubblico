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
private List<TravelCard> all_travel_cards;

    public User() {
    }

    public User(long id, String name, String surname, List<TravelCard> all_travel_cards) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.all_travel_cards = all_travel_cards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

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
}
