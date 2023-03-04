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

        Car car1 = new Car("44-ZZ-99", "BMW",t1);
        Car car2 = new Car("55-XX-88", "AUDI",t2);
        Car car3 = new Car("66-YY-77", "MERCEDES",t3);
        Bike bike1 = new Bike("88-AA-66", "YAMAHAA",t4);
        Bike bike2 = new Bike("77-BB-55", "HONDA",t5);
        Bike bike3 = new Bike("99-CC-44", "SUZUKI",t6);
        //createParkingSlots

        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();
        ParkingSlot p3 = new ParkingSlot();
        ParkingSlot p4 = new ParkingSlot();
        ParkingSlot p5 = new ParkingSlot();
        ParkingSlot p6 = new ParkingSlot();

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
        //enter on carPark
        p1.parkVehicle(car1);
        p2.parkVehicle(car3);
        p3.parkVehicle(car2);
        p4.parkVehicle(bike3);
        p5.parkVehicle(bike2);
        p6.parkVehicle(bike1);




        em.getTransaction().commit();
    }
}

//        //get vehicles
//        em.getTransaction().begin();
//
//
//        em.createQuery("Select  FROM  v", Vehicle.class)
//                .getResultList()
//                .forEach(Teacher::print);
//
//        em.getTransaction().commit();

//        //Update Teachers with ID
//
//        em.getTransaction().begin();
//
//        Teacher teacherToUpdate = em.find(Teacher.class, 2);
//
//        teacherToUpdate.setName("robert");
//        em.persist(teacherToUpdate);
//        em.getTransaction().commit();
//    }
//
//        //get all vehicles
//}