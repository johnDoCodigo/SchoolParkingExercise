package mindswap.schoolParking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school_parking");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //createTeachers

        Teacher t1 = new Teacher("Joao", 22);
        Teacher t2 = new Teacher("Reinaldo", 23);
        Teacher t3 = new Teacher("Miguel", 24);
        Teacher t4 = new Teacher("Rodrigues", 25);
        Teacher t5 = new Teacher("Marques", 26);
        Teacher t6 = new Teacher("Machado", 27);
        //createVehicles

        Car car1 = new Car("44-ZZ-99", "BMW", t1);
        Car car2 = new Car("55-XX-88", "AUDI", t2);
        Car car3 = new Car("66-YY-77", "MERCEDES", t3);
        Bike bike1 = new Bike("88-AA-66", "YAMAHAA", t4);
        Bike bike2 = new Bike("77-BB-55", "HONDA", t5);
        Bike bike3 = new Bike("99-CC-44", "SUZUKI", t6);

        //createParkingSlots

        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();
        ParkingSlot p3 = new ParkingSlot();
        ParkingSlot p4 = new ParkingSlot();
        ParkingSlot p5 = new ParkingSlot();
        ParkingSlot p6 = new ParkingSlot();


        t1.setVehicle(car1);
        t2.setVehicle(car2);
        t3.setVehicle(car3);
        t4.setVehicle(bike1);
        t5.setVehicle(bike2);
        t6.setVehicle(bike3);

        //addVehicles

        em.persist(car1);
        em.persist(car2);
        em.persist(car3);
        em.persist(bike1);
        em.persist(bike2);
        em.persist(bike3);
        //addTeachers

        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(t4);
        em.persist(t5);
        em.persist(t6);
        //addParkingSlots

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.getTransaction().commit();
        //enter on carPark
        em.getTransaction().begin();

        car3.setParkingSlot(p1);
        car2.setParkingSlot(p2);
        car1.setParkingSlot(p3);
        bike1.setParkingSlot(p4);
        bike2.setParkingSlot(p5);
        bike3.setParkingSlot(p6);

        p1.addVehicle(car3);
        p2.addVehicle(car2);
        p3.addVehicle(car1);
        p4.addVehicle(bike1);
        p5.addVehicle(bike2);
        p6.addVehicle(bike3);

        em.getTransaction().commit();


         //a. listing all the vehicles
        em.getTransaction().begin();

        em.createQuery("Select v FROM Vehicle v ", Vehicle.class)
                .getResultList()
                .forEach(Vehicle::print);

        em.getTransaction().commit();

        // b. finding the vehicle assigned to a particular spot
        em.getTransaction().begin();

        em.createQuery("SELECT v FROM Vehicle v " +
                "WHERE v.parkingSlot = :slot "
                ,Vehicle.class)
                    .setParameter("slot",p5)
                    .getResultList()
                    .forEach(Vehicle::print);

        em.getTransaction().commit();

        // c. finding the owner of a particular vehicle
        em.getTransaction().begin();
        em.createQuery("SELECT t FROM Teacher t, Vehicle v " +
                        "WHERE v = :car " +
                        "AND v.teacher = t.id",Teacher.class)
                .setParameter("car",car3)
                .getResultList()
                .forEach(Teacher::print);

        em.getTransaction().commit();


    }
}
