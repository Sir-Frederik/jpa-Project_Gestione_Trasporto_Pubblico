package team1.entities;

import jakarta.persistence.*;
import team1.entities.ticketSons.SubscriptionTicket;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "travel_cards")
public class TravelCard {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;
        private LocalDate expirationDate;
        private LocalDate startDate;

        //RELAZIONI
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "travelCard")
        private List<SubscriptionTicket> subscriptionTickets;

        //COSTRUTTORI
        public TravelCard(){}
        public TravelCard(LocalDate startDate, User user){
            this.startDate = startDate;
            this.expirationDate = startDate.plusYears(1);
            this.user =user;
        }

        //GETTER SETTER
        public long getId() {
            return id;
        }

        public LocalDate getExpiration_date() {
            return expirationDate;
        }

        public void setExpiration_date(LocalDate expiration_date) {
            this.expirationDate = expiration_date;
        }

        public LocalDate getStart_date() {
            return startDate;
        }

        public User getUser() {
            return user;
        }




        @Override
        public String toString() {
            return "TravelCard{" +
                    "id=" + id +
                    ", expiration_date=" + expirationDate +
                    ", start_date=" + startDate +
                    ", user=" + user +
                    '}';
        }
    }





