package team1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class Line {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;
        private String departure;
        private  String final_stop;
        private int line_number;
        private int estimated_duration;
        private int  actual_duration;
        //da collegare ai mezzi

        public Line(){};

        public Line(String departure, String final_stop, int line_number, int estimated_duration){
            this.line_number = line_number;
            this.final_stop = final_stop;
            this.departure = departure;
            this.estimated_duration = estimated_duration;
        }

        public long getId() {
            return id;
        }


        public String getDeparture() {
            return departure;
        }

        public void setDeparture(String departure) {
            this.departure = departure;
        }

        public String getFinal_stop() {
            return final_stop;
        }

        public void setFinal_stop(String final_stop) {
            this.final_stop = final_stop;
        }

        public int getLine_number() {
            return line_number;
        }

        public void setLine_number(int line_number) {
            this.line_number = line_number;
        }

        public int getEstimated_duration() {
            return estimated_duration;
        }

        public void setEstimated_duration(int estimated_duration) {
            this.estimated_duration = estimated_duration;
        }

        public int getActual_duration() {
            return actual_duration;
        }

        public void setActual_duration(int actual_duration) {
            this.actual_duration = actual_duration;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "id=" + id +
                    ", departure='" + departure + '\'' +
                    ", final_stop='" + final_stop + '\'' +
                    ", line_number=" + line_number +
                    ", estimated_duration=" + estimated_duration +
                    ", actual_duration=" + actual_duration +
                    '}';
        }
    }


