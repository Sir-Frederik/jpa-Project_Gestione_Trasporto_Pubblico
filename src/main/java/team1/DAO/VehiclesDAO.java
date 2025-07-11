package team1.DAO;

import jakarta.persistence.*;
import team1.entities.Ticket;
import team1.entities.Vehicles;
import team1.entities.ticketSons.SingleTicket;
import team1.entities.ticketSons.SubscriptionTicket;
import team1.entities.enums.Availability;
import team1.entities.enums.VehiclesType;
import team1.exceptions.ReUsableException;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.List;

public class VehiclesDAO {

    private EntityManager entityManager;

    public VehiclesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Vehicles newVehicles) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehicles);
        transaction.commit();
        System.out.println("The element has been saved");
    }

    public Vehicles findById(long vehiclesId) {
        Vehicles found = entityManager.find(Vehicles.class, vehiclesId);
        if (found == null) throw new EntityNotFoundException("Element not found");
        return found;
    }

    public void validatioTicket(Ticket t){
        if(t instanceof SingleTicket) {
            if (t.getValidationDate().isBefore(LocalDate.now())) {
                throw new ReUsableException("this ticket is already used");
            }
            t.setValidationDate(LocalDate.now());
        }else if (t instanceof SubscriptionTicket){

           if( ((SubscriptionTicket) t).getExpiration().isAfter(LocalDate.now())){
               if(t.getValidationDate() != null){
                   System.out.println("ticket ok");
               }
               t.setValidationDate(LocalDate.now());
           }else{
               throw new ReUsableException("your subscription is expired");
           }
        }
    }

    public List<Vehicles> getAllVehicles(){
        TypedQuery<Vehicles> query =entityManager.createQuery("SELECT v FROM Vehicles v", Vehicles.class);
        return query.getResultList();
    }

    public List<Vehicles> getAllBus(){
        TypedQuery<Vehicles> query = entityManager.createQuery("SELECT v FROM Vehicles v WHERE v.vehiclesType = AUTOBUS", Vehicles.class);
        return query.getResultList();
    }

    public List<Vehicles> getAllTram(){
        TypedQuery<Vehicles> query = entityManager.createQuery("SELECT v FROM Vehicles v WHERE v.vehiclesType = TRAM", Vehicles.class);
        return query.getResultList();
    }


    public void addNewBus(int capacity, String plate) {
        Vehicles newbus = new Vehicles(VehiclesType.AUTOBUS, Availability.AVAILABLE, capacity, plate);
        save(newbus);
        System.out.println("new bus added");
    }

    public void addNewTram(int capacity, String plate) {
        Vehicles newtram = new Vehicles(VehiclesType.TRAM, Availability.AVAILABLE, capacity, plate);
        save(newtram);
        System.out.println("new tram added");
    }

    public void deleteVehicle(long id){
            EntityTransaction transaction = entityManager.getTransaction();
                transaction.begin();
                Vehicles vehicle = entityManager.find(Vehicles.class, id);
                if (vehicle != null) {
                    entityManager.remove(vehicle);
                } else {
                    System.out.println("Vehicle not found with ID: " + id);
                }
                transaction.commit();
        System.out.println("Removed");
    }
}
