import competition.Car;
import competition.Driver;
import competition.Fuels;

public class DriverTest {
    public static void main(String[] args)
    {
        Driver driver1 = new Driver("Juan Francisco");

        System.out.println(driver1.toString());
        System.out.println(Driver.getIdNext());

        Car car = new Car(driver1, "Finolis", "Lamborgini", (short) 1992, Fuels.PETROL, (short) 2000);

        System.out.println(car.toString());
    }
}