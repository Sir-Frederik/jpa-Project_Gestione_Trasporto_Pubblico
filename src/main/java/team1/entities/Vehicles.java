package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.Availability;
import team1.entities.enums.VehiclesType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicles {

    @Id
    @GeneratedValue
    @Column(name = "vehicles_id")
    private long vehiclesId;
    @Column(name = "vehicles_type")
    @Enumerated(EnumType.STRING)
    private VehiclesType vehiclesType;
    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;
    @Column(name = "capacity")
    private long capacity;
    @Column(name = "plate")
    private String plate;


    //RELAZIONI
    @OneToMany(mappedBy = "vehicles")
    private List<Ticket> all_tickets;
    @OneToMany(mappedBy = "vehicles")
    private List<VehiclesMaintenance> vehiclesMaintenances;
    @OneToMany (mappedBy = "vehicle")
    private List<VehicleLineJourney> vehicleLineJourneys;

    //COSTRUTTORI
    public Vehicles(){}
    public Vehicles(VehiclesType vehiclesType,Availability availability,long capacity, String plate) {
        this.vehiclesType =  vehiclesType;
        this.availability = availability;
        this.capacity = capacity;
        this.plate = plate;
    }

    //GETTER
    public long getVehiclesId() {
        return vehiclesId;
    }
    public VehiclesType getVehiclesType() {
        return vehiclesType;
    }
    public Availability getAvailability() {
        return availability;
    }
    public long getCapacity() {
        return capacity;
    }
    public String getPlate() {
        return plate;
    }
    public List<Ticket> getAll_tickets() {
        return all_tickets;
    }
    public List<VehiclesMaintenance> getVehiclesMaintenances() {
        return vehiclesMaintenances;
    }
    public List<VehicleLineJourney> getVehicleLineJourneys() {
        return vehicleLineJourneys;
    }
    //SETTER
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehiclesId=" + vehiclesId +
                ", vehiclesType=" + vehiclesType +
                ", availability=" + availability +
                ", capacity=" + capacity +
                ", plate='" + plate + '\'' +
                '}';
    }
}
