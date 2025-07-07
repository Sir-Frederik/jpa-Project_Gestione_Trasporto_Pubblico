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
        //da aspettare per l import
        //@ManyToOne
        // private Utente utente;

        public TravelCard(){}

        public TravelCard(LocalDate start_date){
            //da aggiungere utente negli argomenti
            this.start_date = start_date;
            this.expiration_date = start_date.plusYears(1);
            //this.utente = utente;
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

        @Override
        public String toString() {
            return "TravelCard{" +
                    "id=" + id +
                    ", expiration_date=" + expiration_date +
                    ", start_date=" + start_date +
                    '}';
        }
    }





