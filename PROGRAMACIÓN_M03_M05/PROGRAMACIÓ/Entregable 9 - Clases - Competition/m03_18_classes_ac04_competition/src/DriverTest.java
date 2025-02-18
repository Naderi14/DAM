import competition.Car;
import competition.Driver;
import competition.Fuels;

public class DriverTest {
    public static void main(String[] args)
    {
        Driver driver1 = new Driver("Lewis Hamilton");
        Driver driver2 = new Driver("Fernando Alonso");
        Driver driver3 = new Driver("Mik Schumacher");
        Driver driver4 = new Driver("Max Verstappen");
        Driver driver5 = new Driver("Sebastian Vettel");
        Driver driver6 = new Driver("Carlos Sainz");
        Driver driver7 = new Driver("Pierre Gasly");
        Driver driver8 = new Driver("Valtteri Bottas");
        Driver driver9 = new Driver("Alexander Albon");
        System.out.println(driver3.toString());
        driver3.setName("J");
        System.out.println(driver3.toString());

        System.out.println(driver5.getName());
        System.out.println(driver5.getId());
    }
}