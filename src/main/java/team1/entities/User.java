package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.Genre;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "residence")
    private String residenceCity;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToOne
    @JoinColumn(name = "travel_card_id") // questo è il lato proprietario
    private TravelCard travelCard;

    // Costruttori
    public User() {}

    public User(String name, String surname, LocalDate birthDate, String residenceCity, Genre genre, TravelCard travelCard) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.residenceCity = residenceCity;
        this.genre = genre;
    }

    // Getter e Setter
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

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getResidenceCity() {
        return residenceCity;
    }
    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public TravelCard getTravelCard() {
        return travelCard;
    }
    public void setTravelCard(TravelCard travelCard) {
        this.travelCard = travelCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", residenceCity='" + residenceCity + '\'' +
                ", genre=" + genre +
                ", travelCard=" + (travelCard != null ? travelCard.getId() : null) +
                '}';
    }
}

