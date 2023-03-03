package mindswap.schoolParking;

import javax.persistence.*;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;

    @OneToOne
    private Vehicle vehicle;

    public Person() {
    }

    public int getPersonId() {
        return id;
    }

    public void setPersonId(int personId) {
        this.id = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}