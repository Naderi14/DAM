package onlineShop.products;

import onlineShop.enums.Color;
import onlineShop.enums.PrintImage;

public abstract class Product {
    public static final float PRICE_IMAGE = 10;
    public static final float PRICE_BASIC = 10;
    public static final float PRICE_POCKET = 2;
    public static final float PRICE_BUTTONS = 3;
    public static final float PRICE_LONGT = 12;
    public static final float PRICE_TANKT = 12;
    public static final float PRICE_VNECKT = 11;
    public static final float PRICE_FLAT = 20;
    public static final float PRICE_CURVED = 30;

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

    @Override
    public String toString()
    {
        return String.format("%-10S %-10S %-10S %-10S %-10S %-10S",
                barCode, desc, price, printImage, color, onSell);
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
