package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.Fabric;

public class VNeckT extends TShirt{
    private boolean hasPocket;

    public VNeckT(String barCode, String desc, Fabric fabric, Color color, boolean hasPocket) {
        super(barCode, desc, fabric, color);
        this.hasPocket = hasPocket;
        price = this.price();
    }

    public boolean isHasPocket() {
        return hasPocket;
    }

    public void setHasPocket(boolean hasPocket) {
        this.hasPocket = hasPocket;
    }

    @Override
    public float price() {
        return hasPocket ? 13f : 11f;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + "%-10S\n", hasPocket);
    }
}
