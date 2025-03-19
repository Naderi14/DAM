package onlineShop;

import onlineShop.enums.Color;
import onlineShop.enums.PrintImage;

public abstract class Product {
    protected String barCode;
    protected String desc;
    protected float price = 0;
    protected PrintImage printImage = null;
    protected Color color;
    protected boolean onSell = true;

    public Product(String barCode, String desc, Color color) {
        this.barCode = barCode;
        this.desc = desc;
        this.color = color;
    }

    public abstract float price();

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public PrintImage getPrintImage() {
        return printImage;
    }

    public void setPrintImage(PrintImage printImage) {
        this.printImage = printImage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isOnSell() {
        return onSell;
    }

    public void setOnSell(boolean onSell) {
        this.onSell = onSell;
    }
}
