import vehicle.Car;
import vehicle.Vehicle;
import vehicle.interfaces.Refillable;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(0, 0, 1000, true);

        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);

        car.move('y');
        System.out.println(car);
        car.move('y');
        System.out.println(car);
        car.move('y');
        System.out.println(car);
        car.move('y');
        System.out.println(car);
        car.move('y');
        System.out.println(car);

        System.out.println(car.move('y'));
        System.out.println(car);

        System.out.println(car.refill());
        System.out.println(car);

        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);
        car.move('x');
        System.out.println(car);

        System.out.println(car.collision());
        System.out.println(car);
        System.out.println(car.repair());
        System.out.println(car.collision());
        System.out.println(car);
        car.setMoney(500);
        System.out.println(car.repair());
        System.out.println(car);
    }
}