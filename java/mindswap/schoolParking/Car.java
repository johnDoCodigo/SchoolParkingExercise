package mindswap.schoolParking;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    public Car(String licensePlate, String brand, Teacher teacher) {
        super(licensePlate, brand, teacher);
    }
}
