package team1.entities;

import jakarta.persistence.*;
import team1.entities.enums.Availability;
import team1.entities.enums.VehiclesType;

import java.time.LocalDate;

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
    @Column(name = "maintenance_start_date")
    private LocalDate maintenanceStartDate;
    @Column(name = "maintenance_end_date")
    private LocalDate maintenanceEndDate;
    @Column(name = "service_start_date")
    private LocalDate serviceStartDate;

    //Biglietti vidimati che va preso dalla relazione con biglietti
    //Va collegato anche con tratta e preso le informazioni

    //COSTRUTTORI
    public Vehicles(){}
    public Vehicles(VehiclesType vehiclesType,Availability availability,long capacity, String plate, LocalDate maintenanceStartDate, LocalDate maintenanceEndDate, LocalDate serviceStartDate) {
        this.vehiclesType =  vehiclesType;
        this.availability = availability;
        this.capacity = capacity;
        this.plate = plate;
        this.maintenanceStartDate = maintenanceStartDate;
        this.maintenanceEndDate = maintenanceEndDate;
        this.serviceStartDate = serviceStartDate;
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
    public LocalDate getMaintenanceStartDate() {
        return maintenanceStartDate;
    }
    public LocalDate getMaintenanceEndDate() {
        return maintenanceEndDate;
    }
    public LocalDate getServiceStartDate() {
        return serviceStartDate;
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
    public void setMaintenanceStartDate(LocalDate maintenanceStartDate) {
        this.maintenanceStartDate = maintenanceStartDate;
    }
    public void setMaintenanceEndDate(LocalDate maintenanceEndDate) {
        this.maintenanceEndDate = maintenanceEndDate;
    }
    public void setServiceStartDate(LocalDate serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehiclesId=" + vehiclesId +
                ", vehiclesType=" + vehiclesType +
                ", availability=" + availability +
                ", capacity=" + capacity +
                ", plate='" + plate + '\'' +
                ", maintenanceStartDate=" + maintenanceStartDate +
                ", maintenanceEndDate=" + maintenanceEndDate +
                ", serviceStartDate=" + serviceStartDate +
                '}';
    }
}
