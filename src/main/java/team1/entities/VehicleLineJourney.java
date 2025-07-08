package team1.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "vehicle_line_journeys")
public class VehicleLineJourney {

    @Id
    @GeneratedValue
    private long id;
    private double actualTime;

    @ManyToOne
    @JoinColumn(name = "vehicles_id")
    private Vehicles vehiclesId;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line lineId;

    public VehicleLineJourney(){}
    public VehicleLineJourney( double actualTime, Vehicles vehiclesId, Line lineId) {
        this.actualTime = actualTime;
        this.vehiclesId = vehiclesId;
        this.lineId = lineId;
    }

    //GETTER
    public long getId() {
        return id;
    }
    public double getActualTime() {
        return actualTime;
    }
    public Vehicles getVehiclesId() {
        return vehiclesId;
    }
    public Line getLineId() {
        return lineId;
    }
}
