package team1.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "vehicle_line_journeys")
public class VehicleLineJourney {

    @Id
    @GeneratedValue
    private long id;
    private double estimated_time;
    private double actual_time;

    @ManyToOne
    private Vehicles vehicle_id;

    @ManyToOne
    private Line line_id;
     //in vehicle da togliere la manytomany delle lines
}
