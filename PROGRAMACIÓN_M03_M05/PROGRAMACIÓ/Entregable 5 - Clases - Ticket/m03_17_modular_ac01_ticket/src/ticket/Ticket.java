package ticket;

public class Ticket {
    static final float TAX = 21f;
    static final byte DECIMALS = 2;

    private float total(float[][] items)
    {
        float total = 0;

        for (int i = 0; i < items.length; i++)
        {
            total += totalUnit(items[i]);
        }

        return total;
    }

    private float totalUnit(float[] item)
    {
        return Calculations.round(item[1] * item[2], DECIMALS);
    }

    public String generateTicket(float[][] items)
    {
        Product product = new Product();

        String cabecera =
                "Ticket\t\t\t\t\tDate:\t\t" + Calculations.generateDate() + "\t" + Calculations.generateTime() + "\n" +
                "--------------------------------------------------------\n" +
                "Product:\t\t\t\tUnits\t\tPrice Unit\tTotal\n" +
                "--------------------------------------------------------\n";
        String productos = "";

        for (int i = 0; i < items.length; i++)
        {
            productos += product.product(i) + "\t\t\t";

            if (items[i][1] >= 10f)
                productos += items[i][1] + "\t\t" + items[i][2] + "\t\t\t" + totalUnit(items[i]) + "€\n";
            else
                productos += items[i][1] + "\t\t\t" + items[i][2] + "\t\t\t" + totalUnit(items[i]) + "€\n";
        }

        float totalTicket = total(items);

        String footer =
                "--------------------------------------------------------\n" +
                "TAX:\t\t\t\t\t" + Tax.tax(totalTicket, TAX) + "€\n" +
                "--------------------------------------------------------\n" +
                "TOTAL WITHOUT TAX:\t\t" + Tax.totalWithoutTax(totalTicket, TAX) + "€\n" +
                "--------------------------------------------------------\n" +
                "TOTAL:\t\t\t\t\t\t\t\t\t\t\t" + totalTicket + "€\n";

        return cabecera + productos + footer;
    }

    private static class Product{
        private final String[] PRODUCTS = {
                "Café grande\t", "Expresso\t", "Café con leche",
                "Macchiato\t", "Chocolate\t", "Frappuccino\t",
                "Café moca\t", "Americano\t", "Café preparado"
        };

        private String product(float product)
        {
            return PRODUCTS[(int)product];
        }
    }
}
