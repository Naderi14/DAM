package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.Fabric;

public abstract class TShirt extends Product {
    protected Fabric fabric;

    public TShirt(String barCode, String desc, Fabric fabric, Color color) {
        super(barCode, desc, color);
        this.fabric = fabric;
        price = this.price();
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public float price()
    {
        float price = fabric.getPrice();

        if (printImage != null)
            price += PRICE_IMAGE;

        return price;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + "%-10S", fabric);
    }
}
