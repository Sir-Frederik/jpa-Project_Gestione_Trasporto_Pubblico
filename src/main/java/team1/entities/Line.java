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

    //
    @OneToMany(mappedBy = "line")
    private List<VehicleLineJourney> vehicleLineJourney;

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
        public List<VehicleLineJourney> getVehicleLineJourney() {
            return vehicleLineJourney;
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
        return "Line {\n" +
                "  id=" + id + ",\n" +
                "  departure='" + departure + "',\n" +
                "  final_stop='" + final_stop + "',\n" +
                "  line_number=" + line_number + "\n" +
                '}';
    }
}


