package team1.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "user")
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
