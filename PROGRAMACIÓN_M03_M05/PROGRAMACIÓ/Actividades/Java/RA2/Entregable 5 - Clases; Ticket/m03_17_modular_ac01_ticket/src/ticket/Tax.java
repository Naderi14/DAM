package ticket;

// TODO: OK

public class Tax {
    static float tax(float amount, float tax)
    {
        return Calculations.round(amount * tax / 100, (byte) 2);
    }

    static float totalWithoutTax(float total, float tax)
    {
        return Calculations.round(total - (total * tax / 100), (byte) 2);
    }
}
