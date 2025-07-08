package team1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_times")
public class VehicleLineJourney {
    private double estimated_time;
    private double actual_time;

    @ManyToOne
    private Vehicles vehicle_id;

    @ManyToOne
    private Line line_id;
     //in vehicle da togliere la manytomany delle lines
}
