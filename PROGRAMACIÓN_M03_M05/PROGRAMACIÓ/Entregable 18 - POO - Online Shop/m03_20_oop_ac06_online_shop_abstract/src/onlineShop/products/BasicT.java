package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.Fabric;

public class BasicT extends TShirt{
    private boolean hasPocket;
    private boolean hasButtons;

    public BasicT(String barCode, String desc, Fabric fabric, Color color, boolean hasPocket, boolean hasButtons) {
        super(barCode, desc, fabric, color);
        this.hasPocket = hasPocket;
        this.hasButtons = hasButtons;
        price = this.price();
    }

    public boolean isHasButtons() {
        return hasButtons;
    }

    public void setHasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
    }

    public boolean isHasPocket() {
        return hasPocket;
    }

    public void setHasPocket(boolean hasPocket) {
        this.hasPocket = hasPocket;
    }

    @Override
    public float price() {
        float price = 10f;

        if (hasPocket)
            price += 2f;
        if (hasButtons)
            price += 3f;

        return price;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + "%-10S %-10S\n", hasPocket, hasButtons);
    }
}
