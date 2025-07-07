package team1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

    @Entity
    @Table(name = "travel_cards")
    public class TravelCard {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;
        private LocalDate expiration_date;
        private  LocalDate start_date;

        @ManyToOne
         private User user;

        public TravelCard(){}

        public TravelCard(LocalDate start_date, User user){
            this.start_date = start_date;
            this.expiration_date = start_date.plusYears(1);
            this.user =user;
        }

        public long getId() {
            return id;
        }

        public LocalDate getExpiration_date() {
            return expiration_date;
        }

        public void setExpiration_date(LocalDate expiration_date) {
            this.expiration_date = expiration_date;
        }

        public LocalDate getStart_date() {
            return start_date;
        }

        public void setStart_date(LocalDate start_date) {
            this.start_date = start_date;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "TravelCard{" +
                    "id=" + id +
                    ", expiration_date=" + expiration_date +
                    ", start_date=" + start_date +
                    ", user=" + user +
                    '}';
        }
    }





