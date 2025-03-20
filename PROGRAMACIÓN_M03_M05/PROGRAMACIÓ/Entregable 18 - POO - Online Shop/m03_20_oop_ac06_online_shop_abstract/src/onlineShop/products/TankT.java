package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.Fabric;

public class TankT extends TShirt{
    public TankT(String barCode, String desc, Fabric fabric, Color color) {
        super(barCode, desc, fabric, color);
        price = price();
    }

    @Override
    public float price() {
        return 12f;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n");
    }
}
