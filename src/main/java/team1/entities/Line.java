package team1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String departure;
    private  String final_stop;
    private int line_number;
    private double estimatedTime;

    //COSTRUTTORI
    public Line(){};

    public Line(String departure, String final_stop, int line_number, double estimatedTime){
        this.line_number = line_number;
        this.final_stop = final_stop;
        this.departure = departure;
        this.estimatedTime = estimatedTime;
    }

    //GETTER
        public long getId() {
            return id;
        }
        public String getDeparture() {
            return departure;
        }
        public String getFinal_stop() {
            return final_stop;
        }
        public int getLine_number() {
            return line_number;
        }
        public double getEstimatedTime() {
        return estimatedTime;
        }

    //SETTER
        public void setDeparture(String departure) {
            this.departure = departure;
        }

        public void setFinal_stop(String final_stop) {
            this.final_stop = final_stop;
        }

        public void setLine_number(int line_number) {
            this.line_number = line_number;
        }


        @Override
        public String toString() {
            return "Line{" +
                    "id=" + id +
                    ", departure='" + departure + '\'' +
                    ", final_stop='" + final_stop + '\'' +
                    ", line_number=" + line_number +
                    '}';
        }
    }


