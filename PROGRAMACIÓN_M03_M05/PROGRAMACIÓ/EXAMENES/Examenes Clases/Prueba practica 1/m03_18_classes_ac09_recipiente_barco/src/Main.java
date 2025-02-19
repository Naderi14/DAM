import clases.Container;
import clases.ContainerShip;
import clases.ContainerType;
import clases.Route;

public class Main {
    public static void main(String[] args)
    {
        //1. Create container Ship
        ContainerShip ship = new ContainerShip("Ever Given", 25, 15000, 7);
        //System.out.println(ship);
        System.out.println(ship);
        //2.1 Instantiate Containers
        Container container1 = new Container(ContainerType.STANDARD, 1500);
        Container container2 = new Container(ContainerType.FREEZE, 2000);
        Container container3 = new Container(ContainerType.TANK, 2500);
        Container container4 = new Container(ContainerType.OPEN_TOP, 2200);
        Container container5 = new Container(ContainerType.STANDARD, 2100);
        Container container6 = new Container(ContainerType.FREEZE, 1600);
        Container container7 = new Container(ContainerType.TANK, 1800);
        Container container8 = new Container(ContainerType.OPEN_TOP, 2300);
        Container container9 = new Container(ContainerType.STANDARD, 2500);
        Container container10 = new Container(ContainerType.FREEZE, 1500);

        Container[] containers = {
            container1, container2, container3,
            container4, container5, container6,
            container7, container8, container9,
            container10
        };
        //2.2 Print containers
        System.out.println("\nPRINT CONTAINERS");
        for (Container container : containers)
        {
            System.out.print(container);
        }
        //3.1 Add container c1
        System.out.println("Add container: " + ship.addContainer(containers[0]));
        //3.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //4.1 Add container c2
        System.out.println("Add container: " + ship.addContainer(containers[1]));
        //4.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //5.1 Add container c3
        System.out.println("Add container: " + ship.addContainer(containers[2]));
        //5.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //6.1 Add container c4
        System.out.println("Add container: " + ship.addContainer(containers[3]));
        //6.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //6.1 Add container c5
        System.out.println("Add container: " + ship.addContainer(containers[4]));
        //6.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //7.1 Add container c6
        System.out.println("Add container: " + ship.addContainer(containers[5]));
        //7.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //8.1 Add container c7
        System.out.println("Add container: " + ship.addContainer(containers[6]));
        //8.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //9.1 Add container c8
        System.out.println("Add container: " + ship.addContainer(containers[7]));
        //9.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //10.1 Add container c9
        System.out.println("Add container: " + ship.addContainer(containers[8]));
        //10.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //11.1 Add container c9
        System.out.println("Add container: " + ship.addContainer(containers[9]));
        //11.2 Check weight containership
        System.out.print("\tChecking Ship Weight: " + ship.getCurrentWeight() + "\n");
        //12.1 Print ship
        System.out.println("\n" + ship);
        //12.2 Print Total Transport Cost
        System.out.println("\nTotal Transport Cost: " + ship.totalTransportCost());
        //12.3 Order ContainerShip
        System.out.println("\nOrdered Containers:");
        Container[] orderedContainers = ship.orderContainers();
        for (Container container : orderedContainers)
        {
            System.out.print(container);
        }
        //13.1 Instantiate Route Lisbon to Buenos Aires with 9600 km
        Route route = new Route("Lisbon", "Buenos Aires", 9600, ship);
        System.out.println("\n" + route);
        //13.2 Get time of route
        System.out.println("Tiempo de ruta: " + route.getTime() + " horas");
    }
}