package mindswap.schoolParking;

import javax.persistence.*;

@Entity
@Table (name="vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String licensePlate;
    private String brand;

    @OneToOne (mappedBy = "vehicle")
    private Person person;

    @ManyToOne
    private ParkingSlots parkingSlots;

    public Vehicle() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void print() {
        System.out.println("Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate  + '\'' +
                ", brand'" + brand + '\''+
                '}');
    }
}
