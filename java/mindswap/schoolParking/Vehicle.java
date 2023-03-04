package mindswap.schoolParking;

import javax.persistence.*;

@Entity
@Table (name="vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract   class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String licensePlate;
    private String brand;



    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne(mappedBy = "vehicle")
    @JoinColumn(name = "parkingSlot_id")
    private ParkingSlot parkingSlot;

    public Vehicle() {

    }

    public Vehicle(String licensePlate, String brand,Teacher teacher) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public void print() {
        System.out.println("Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate  + '\'' +
                ", brand= '" + brand + '\''+
                ", parkingSlot= '" + parkingSlot + '\'' +
                ", teacher= '" + teacher.getName() +
                '}');
    }


}
