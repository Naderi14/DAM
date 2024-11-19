package actividadesRefactor;

import java.util.Scanner;

// ACTIVIDAD 2 ENTORNOS

public class CurrencyConversion {
    private static final Scanner leer = new Scanner(System.in);
    private static float amount;
    private static String fromCurrency, toCurrency;

    public static void main(String[] args)
    {
        init();
        amount = requestAmount("Enter an amount to convert:");
        fromCurrency = requestCurrency("Enter currerncy from (E, D, P o Y):");
        toCurrency = requestCurrency("Enter currerncy to (E, D, P o Y):");

        System.out.println(amount + getSymbol(fromCurrency) + " = " + convertCurrency(amount, fromCurrency, toCurrency) + getSymbol(toCurrency));
    }

    private static void init()
    {
        System.out.println("**********************************************************************\n" +
                           "* CURRENCY CONVERSION                              © Juan Francisco  *\n" +
                           "*                                                                    *\n" +
                           "* This program converts currency between:                            *\n" +
                           "* EURO(E), DOLLAR(D), POUND(P) and YEN(Y)                            *\n" +
                           "**********************************************************************");
    }

    private static float requestAmount(String text)
    {
        System.out.println(text);
        return leer.nextFloat();
    }

    private static String requestCurrency(String text)
    {
        System.out.println(text);
        return leer.next().toUpperCase();
    }

    private static float convertCurrency(float amount, String from, String to)
    {
        float amountConverted = 0f;
        switch (from)
        {
            case "E":
                switch (to)
                {   // Valor conversion monedas a fecha 17 Noviembre, 18:20 UTC
                    case "D":
                        amountConverted = amount * 1.05f;
                        break;
                    case "P":
                        amountConverted = amount * 0.83f;
                        break;
                    case "Y":
                        amountConverted = amount * 162.76f;
                        break;
                    default:
                        amountConverted = amount;
                        break;
                }
                break;
            case "D":
                switch (to)
                {   // Valor conversion monedas a fecha 17 Noviembre, 18:22 UTC
                    case "E":
                        amountConverted = amount * 0.95f;
                        break;
                    case "P":
                        amountConverted = amount * 0.79f;
                        break;
                    case "Y":
                        amountConverted = amount * 154.33f;
                        break;
                    default:
                        amountConverted = amount;
                        break;
                }
                break;
            case "P":
                switch (to)
                {   // Valor conversion monedas a fecha 17 Noviembre, 18:24 UTC
                    case "D":
                        amountConverted = amount * 1.26f;
                        break;
                    case "E":
                        amountConverted = amount * 1.2f;
                        break;
                    case "Y":
                        amountConverted = amount * 195f;
                        break;
                    default:
                        amountConverted = amount;
                        break;
                }
                break;
            case "Y":
                switch (to)
                {   // Valor conversion monedas a fecha 17 Noviembre, 18:25 UTC
                    case "D":
                        amountConverted = amount * 0.0065f;
                        break;
                    case "P":
                        amountConverted = amount * 0.0051f;
                        break;
                    case "E":
                        amountConverted = amount * 0.0061f;
                        break;
                    default:
                        amountConverted = amount;
                        break;
                }
                break;
        }

        return (float) round(amountConverted, (byte)2);
    }

    private static double round(double num, byte dec)
    {
        double cantDecimal = Math.pow(10, dec);
        return Math.round(num * cantDecimal) / cantDecimal;
    }

    private static String getSymbol(String currency)
    {
        String symbol = "";

        switch (currency)
        {
            case "E":
                symbol = "\u20AC";
                break;
            case "D":
                symbol = "\u0024";
                break;
            case "P":
                symbol = "\u00A3";
                break;
            case "Y":
                symbol = "\u00A5";
                break;
        }

        return symbol;
    }
}
