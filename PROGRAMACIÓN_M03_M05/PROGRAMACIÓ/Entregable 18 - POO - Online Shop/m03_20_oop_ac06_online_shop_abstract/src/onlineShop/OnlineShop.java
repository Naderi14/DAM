package onlineShop;

import onlineShop.enums.PrintImage;
import onlineShop.products.*;

import java.util.ArrayList;
import java.util.List;

public class OnlineShop {
    private List<Product> stock;

    public OnlineShop()
    {
        stock = new ArrayList<>();
    }

    public boolean addProduct(Product p)
    {
        return stock.add(p);
    }

    public boolean removeProduct(Product p)
    {
        return stock.remove(p);
    }

    public boolean sellProduct(Product p, PrintImage printImage)
    {
        if (p.isOnSell())
        {
            p.setPrintImage(printImage);
            p.setPrice(p.price());
            return removeProduct(p);
        }

        return false;
    }

    public float stockValue()
    {
        float value = 0f;

        for (Product product : stock)
            value += product.getPrice();

        return value;
    }

    public String listStock()
    {
        String header = String.format("%-10S %-10S %-10S %-10S %-10S %-10S%-10S%-10S %-10S %-10S\n" +
                "---------------------------------------------------------------------------------------------------------\n",
                "BARCODE", "DESC", "PRICE", "PRINT", "COLOR", "ON-SELL", "FABRIC", "POCKET?", "BUTTONS?", "CAP-TYPE");

        String allStockString = "";

        for (Product product : stock)
            allStockString += product.toString();

        return header + allStockString;
    }

    public int numCaps()
    {
        int count = 0;

        for (Product product : stock)
        {
            if (product instanceof Cap)
                count++;
        }

        return count;
    }

    public int numTShirts()
    {
        int count = 0;

        for (Product product : stock)
        {
            if (product instanceof TShirt)
                count++;
        }

        return count;
    }

    public List<Product> getStock() {
        return stock;
    }

    public void setStock(List<Product> stock) {
        this.stock = stock;
    }
}
