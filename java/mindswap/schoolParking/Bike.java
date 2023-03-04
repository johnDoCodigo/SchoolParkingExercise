package mindswap.schoolParking;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    public Bike(String licensePlate, String brand, Teacher teacher) {
        super(licensePlate, brand, teacher);
    }
}
