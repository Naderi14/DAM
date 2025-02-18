import competition.Car;
import competition.Driver;
import competition.Fuels;

public class CarTest {
    public static void main(String[] args)
    {
        Driver driver1 = new Driver("Juan Francisco");
        Car car1 = new Car(driver1, "Mercedes", "W14", (short) 2023, Fuels.PETROL, (short) 1600, (byte) 2, (byte) 4, (byte) 1, 0);

        System.out.println(car1.toString());
        System.out.println(car1.getId());

        car1.setBrand("Ferrari");
        System.out.println(car1.toString());

        car1.setModel("F40");
        System.out.println(car1.toString());

        System.out.println(car1.getModel());
        System.out.println(car1.getDriver().getName());
    }
}