package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.Visor;

public class Cap extends Product{
    private Visor visor;

    public Cap(String barCode, String desc, Color color, Visor visor) {
        super(barCode, desc, color);
        this.visor = visor;
        price = price();
    }

    public Visor getVisor() {
        return visor;
    }

    public void setVisor(Visor visor) {
        this.visor = visor;
    }

    @Override
    public float price() {
        return visor == Visor.FLAT ? PRICE_FLAT + PRICE_IMAGE : visor == Visor.CURVED ? PRICE_CURVED + PRICE_IMAGE : 0f;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + "%-10S %-10S %-10S %-15S\n","","","", visor);
    }
}
