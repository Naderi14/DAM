import competition.*;

public class RaceTest {
    public static void main(String[] args)
    {
        Driver driver1 = new Driver("Lewis Hamilton");
        Driver driver2 = new Driver("Max Verstappen");
        Driver driver3 = new Driver("Charles Leclerc");
        Driver driver4 = new Driver("Lando Norris");
        Driver driver5 = new Driver("Fernando Alonso");
        Driver driver6 = new Driver("George Russell");
        Driver driver7 = new Driver("Carlos Sainz");
        Driver driver8 = new Driver("Sergio Pérez");
        Driver driver9 = new Driver("Oscar Piastri");
        Driver driver10 = new Driver("Nico Hülkenberg");

        // Creación de 10 coches asociados a los corredores
        Car car1 = new Car(driver1, "Mercedes", "W14", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car2 = new Car(driver2, "Red Bull", "RB19", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car3 = new Car(driver3, "Ferrari", "SF-23", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car4 = new Car(driver4, "McLaren", "MCL60", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car5 = new Car(driver5, "Aston Martin", "AMR23", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car6 = new Car(driver6, "Mercedes", "W14", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car7 = new Car(driver7, "Ferrari", "SF-23", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car8 = new Car(driver8, "Red Bull", "RB19", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);
        Car car9 = new Car(driver9, "McLaren", "MCL60", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);

        Car[] cars = {car1, car2, car3, car4, car5, car6, car7, car8, car9};

        Race race = new Race(cars);

        System.out.println(race.toString());
        System.out.println("\n ACABÓ LA CARRERA, NUEVA PUNTUACION DE LOS CORREDORES \n");
        race.startRace();
        System.out.println(race.toString());
    }
}
