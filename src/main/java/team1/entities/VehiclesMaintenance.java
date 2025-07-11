package team1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table  (name="vehicles_maintenances")
public class VehiclesMaintenance {


    @Id
    @GeneratedValue
    @Column(name = "maintenance_id")
    private long maintenanceId;
    @Column(name = "maintenance_start_date")
    private LocalDate maintenanceStartDate;
    @Column(name = "maintenance_end_date")
    private LocalDate maintenanceEndDate;
    @Column(name = "service_start_date")
    private LocalDate serviceStartDate;

    //RELAZIONI
    @ManyToOne
    @JoinColumn(name = "vehicles_id")
    private Vehicles vehicles;

    //COSTRUTTORI
    public VehiclesMaintenance() {}

    public VehiclesMaintenance(LocalDate maintenanceStartDate, LocalDate maintenanceEndDate, LocalDate serviceStartDate, Vehicles vehicles) {
        this.maintenanceStartDate = maintenanceStartDate;
        this.maintenanceEndDate = maintenanceEndDate;
        this.serviceStartDate = serviceStartDate;
        this.vehicles = vehicles;
    }

    //GETTER
    public long getMaintenanceId() {
        return maintenanceId;
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
    public Vehicles getVehicles() {
        return vehicles;
    }

    //SETTER
    public void setMaintenanceStartDate(LocalDate maintenanceStartDate) {
        this.maintenanceStartDate = maintenanceStartDate;
    }
    public void setMaintenanceEndDate(LocalDate maintenanceEndDate) {
        this.maintenanceEndDate = maintenanceEndDate;
    }
    public void setServiceStartDate(LocalDate serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "VehiclesMaintenance{" +
                "maintenanceId=" + maintenanceId +
                ", maintenanceStartDate=" + maintenanceStartDate +
                ", maintenanceEndDate=" + maintenanceEndDate +
                ", serviceStartDate=" + serviceStartDate +
                ", vehicles=" + vehicles +
                '}';
    }
}
