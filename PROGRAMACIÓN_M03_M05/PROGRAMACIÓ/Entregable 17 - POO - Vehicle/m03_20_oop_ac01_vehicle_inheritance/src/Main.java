import vehicle.Car;
import vehicle.Moto;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Instancias de Vehicle
        Vehicle vehicle1 = new Vehicle("0001AAA", "Generic", "ModelX");
        Vehicle vehicle2 = new Vehicle("0002BBB", "Generic", "ModelY");
        Vehicle vehicle3 = new Vehicle("0003CCC", "Generic", "ModelZ");

        // Instancias de Car
        Car car1 = new Car("1234ABC", "Toyota", "Corolla", (byte)5, (byte)4, "Gasoline");
        Car car2 = new Car("A678DEF", "Honda", "Civic", (byte)5, (byte)4, "Diesel");
        Car car3 = new Car("9101GHI", "Ford", "Focus", (byte)5, (byte)4, "Hybrid");

        // Instancias de Moto
        Moto moto1 = new Moto("A468JKL", "Yamaha", "R1", 1000);
        Moto moto2 = new Moto("1357MNO", "Kawasaki", "Ninja", 650);
        Moto moto3 = new Moto("A876PQR", "Ducati", "Monster", 1200);

        // Instancias de Truck
        Truck truck1 = new Truck("1111AAA", "Volvo", "FH16", (byte)2, (byte)2, "Diesel", 20000, true);
        Truck truck2 = new Truck("A222BBB", "Scania", "R500", (byte)2, (byte)2, "Diesel", 25000, false);
        Truck truck3 = new Truck("3333CCC", "Mercedes", "Actros", (byte)2, (byte)2, "Diesel", 30000, true);

        // Primera parte
        System.out.println("Weight: " + vehicle1.weight() + "\n" + vehicle1);
        Vehicle vehicle4 = new Car("9101GHI", "Ford", "Focus", (byte)5, (byte)4, "Hybrid");
        Car tempCar = (Car) vehicle4;
        System.out.println("Weight: " + tempCar.weight() + "\n4 Doors: " + tempCar.has4Doors() + "\n" + tempCar);
        System.out.println("Weight: " + car1.weight() + "\n4 Doors: " + car1.has4Doors() + "\n" + car1);
        vehicle4 = new Moto("1357MNO", "Kawasaki", "Ninja", 650);
        Moto tempMoto = (Moto) vehicle4;
        System.out.println("Weight: " + tempMoto.weight() + "\n" + tempMoto);
        vehicle4 = new Truck("A222BBB", "Scania", "R500", (byte)2, (byte)2, "Diesel", 25000, false);
        Truck tempTruck = (Truck) vehicle4;
        System.out.println("Weight: " + tempTruck.weight() + "\n4 Doors: " + tempTruck.has4Doors() + "\n" + tempTruck);
        System.out.println("Weight: " + truck1.weight() + "\n4 Doors: " + truck1.has4Doors() + "\n" + truck1);

        // Segunda parte
        Set<Vehicle> vehicleList = new HashSet<>();
        vehicleList.add(car1);
        vehicleList.add(car2);
        vehicleList.add(car3);
        vehicleList.add(moto1);
        vehicleList.add(moto2);
        vehicleList.add(moto3);
        vehicleList.add(truck1);
        vehicleList.add(truck2);
        vehicleList.add(truck3);
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);
        vehicleList.add(vehicle3);

        System.out.println("\nFor each starts\n");

        for (Vehicle vehicle : vehicleList)
        {
            if (vehicle instanceof Car)
            {
                tempCar = (Car) vehicle;
                if (tempCar instanceof Truck)
                {
                    tempTruck = (Truck) vehicle;
                    System.out.println("\nTRUCK: " + tempTruck.toStringOnlyThis() + " |4 Doors: " + tempTruck.has4Doors());
                }
                else
                    System.out.println("\nCAR: " + tempCar.toStringOnlyThis());
            }
            else if (vehicle instanceof Moto)
            {
                tempMoto = (Moto) vehicle;
                System.out.println("\nMOTO: " + tempMoto.toStringOnlyThis());
            }
            else
            {
                System.out.println("\nVEHICLE: " + vehicle.toStringBase() + " |Weight: " + vehicle.weight() + "\n" + vehicle);
            }
        }
    }
}