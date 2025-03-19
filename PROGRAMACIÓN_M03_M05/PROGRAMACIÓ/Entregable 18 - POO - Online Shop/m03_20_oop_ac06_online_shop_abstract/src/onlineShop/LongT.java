package onlineShop;

import onlineShop.enums.Color;
import onlineShop.enums.Fabric;

public class LongT extends TShirt{
    private boolean hasPocket;

    public LongT(String barCode, String desc, Fabric fabric, Color color, boolean hasPocket) {
        super(barCode, desc, fabric, color);
        this.hasPocket = hasPocket;
        price = price();
    }

    @Override
    public float price() {
        return hasPocket ? 14f : 12f;
    }
}
