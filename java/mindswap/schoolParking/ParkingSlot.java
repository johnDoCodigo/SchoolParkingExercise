package mindswap.schoolParking;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "parkingSlot")
    private List<Vehicle> vehicles = new ArrayList<>();




    public ParkingSlot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
}






