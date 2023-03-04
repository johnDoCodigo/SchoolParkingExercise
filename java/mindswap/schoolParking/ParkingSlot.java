package mindswap.schoolParking;


import javax.persistence.*;
import java.util.LinkedList;


@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;




    public ParkingSlot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        vehicle.setParkingSlot(this);
    }

    public void removeVehicle() {
        this.vehicle = null;
    }


}




