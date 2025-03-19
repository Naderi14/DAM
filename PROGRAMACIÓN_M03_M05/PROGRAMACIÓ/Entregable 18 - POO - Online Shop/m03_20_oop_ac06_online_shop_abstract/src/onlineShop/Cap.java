package onlineShop;

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
        return visor == Visor.FLAT ? 20f : visor == Visor.CURVED ? 30f : 0f;
    }
}
