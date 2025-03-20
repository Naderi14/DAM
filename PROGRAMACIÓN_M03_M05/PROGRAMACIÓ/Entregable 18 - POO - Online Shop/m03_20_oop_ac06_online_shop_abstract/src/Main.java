import onlineShop.OnlineShop;
import onlineShop.enums.*;
import onlineShop.products.*;

public class Main {
    public static void main(String[] args)
    {
        BasicT basic1 = new BasicT("1001", "BASIC1", Fabric.COTTON, Color.WHITE, false, false);
        BasicT basic2 = new BasicT("1002", "BASIC2", Fabric.LINEN, Color.BLACK, true, true);
        BasicT basic3 = new BasicT("1003", "BASIC3", Fabric.RAYON, Color.BLACK, true, true);
        BasicT basic4 = new BasicT("1001","BASIC4", Fabric.COTTON ,Color.WHITE, false, false);

        VNeckT vneck1 = new VNeckT("2001", "VNECK1", Fabric.LYCRA, Color.RED, false);
        VNeckT vneck2 = new VNeckT("2002", "VNECK2", Fabric.LYCRA, Color.RED, true);

        LongT long1 = new LongT("3001", "LONG1", Fabric.POLYESTER, Color.RED, false);
        LongT long2 = new LongT("3002", "LONG2", Fabric.LYCRA, Color.YELLOW, true);

        TankT tank1 = new TankT("4001", "TANK1", Fabric.POLYESTER, Color.RED);
        TankT tank2 = new TankT("4002", "TANK2", Fabric.LYCRA, Color.YELLOW);

        Cap cap1 = new Cap("5001", "CAP1", Color.RED, Visor.FLAT);
        Cap cap2 = new Cap("5002", "CAP2", Color.YELLOW, Visor.CURVED);

        OnlineShop shop = new OnlineShop();

        System.out.println(shop.addProduct(basic1));
        System.out.println(shop.addProduct(basic2));
        System.out.println(shop.addProduct(basic3));
        System.out.println(shop.addProduct(vneck1));
        System.out.println(shop.addProduct(vneck2));
        System.out.println(shop.addProduct(long1));
        System.out.println(shop.addProduct(long2));
        System.out.println(shop.addProduct(tank1));
        System.out.println(shop.addProduct(tank2));
        System.out.println(shop.addProduct(cap1));
        System.out.println(shop.addProduct(cap2));

        System.out.println("Total price: " + shop.stockValue());
        System.out.println(shop.listStock());

        System.out.println(shop.addProduct(basic4));
        System.out.println("Total price: " + shop.stockValue());
        System.out.println(shop.listStock());

        System.out.println(shop.sellProduct(basic1, PrintImage.BULL));
        System.out.println(shop.sellProduct(vneck1, PrintImage.TIGER));
        System.out.println(shop.sellProduct(long1, PrintImage.COBRA));
        System.out.println(shop.sellProduct(tank1, PrintImage.REINDEER));
        System.out.println(shop.sellProduct(cap1, PrintImage.EAGLE));

        System.out.println("Total price: " + shop.stockValue());
        System.out.println(shop.listStock());
    }
}