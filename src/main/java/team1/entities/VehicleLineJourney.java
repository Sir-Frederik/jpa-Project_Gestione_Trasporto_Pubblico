package team1.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "vehicle_line_journeys")
public class VehicleLineJourney {

    @Id
    @GeneratedValue
    private long id;
    private int actualTime;

    @ManyToOne()
    private Vehicles vehicles;

    @ManyToOne
    private Line line;

    public VehicleLineJourney(){}
    public VehicleLineJourney(int actualTime, Vehicles vehicles, Line line) {
        this.actualTime = actualTime;
        this.vehicles = vehicles;
        this.line = line;
    }

    //GETTER
    public long getId() {
        return id;
    }
    public int getActualTime() {
        return actualTime;
    }
    public Vehicles getVehicles() {
        return vehicles;
    }
    public Line getLine() {
        return line;
    }
    public void setActualTime(int actualTime) {
        this.actualTime = actualTime;
    }
}
