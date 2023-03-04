package mindswap.schoolParking;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends Person {


    @OneToOne(mappedBy = "teacher")
    private Vehicle vehicle;


    public Teacher() {
        super();
    }

    public Teacher(String name) {
        super(name);
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void print() {
        System.out.println("Teacher{" +
                "id=" + getPersonId() +
                ", name='" +getName() +
                ", age='" + getAge() +
                "', vehicle='" + getVehicle()+"'}");
    }
}
