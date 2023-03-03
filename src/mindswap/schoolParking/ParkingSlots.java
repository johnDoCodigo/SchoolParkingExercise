package mindswap.schoolParking;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "parking_slots")
public class ParkingSlots {
    private int vehicleSlotSize = 30;
    private int bikeSlotSize = 8;
    private int carSlotSize= 22;
    private boolean statusFull = false;

    @OneToMany(mappedBy = "parking_slots")
    private Set<Vehicle> vehicles ;

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }




}
