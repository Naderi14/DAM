package entornosDesarrollo.RA1.refactorization;
import java.util.Scanner;

public class Temperatura {
    public static final float K273_15 = 273.15f;
    public static final float K_5F = 5f;
    public static final float K_9F = 9f;
    public static final float K_32F = 32f;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        byte option = menu();

        if (option == 1) {
            String text = "Enter the degrees in Celsius: ";
            System.out.printf("%nThe degrees in Fahrenheit is %.2f°F" , celsius2Fahrenheit(enterTemp(text)));
        }
        else if (option == 2) {
            String text = "Enter the degrees in Celsius: ";
            System.out.printf("%nThe degrees in Kelvin is %.2f°K" , celsius2Kelvin(enterTemp(text)));
        }
        else if (option == 3) {
            String text = "Enter the degrees in Fahrenheit: ";
            System.out.printf("%nThe degrees in Celsius is %.2f°C" , fahrenheit2Celsius(enterTemp(text)));
        }
        else if (option == 4) {
            String text = "Enter the degrees in Fahrenheit: ";
            System.out.printf("%nThe degrees in Kelvin is %.2fºK" ,  fahrenheit2Kelvin(enterTemp(text)));

        } else if (option == 5){
            String text = "Enter the degrees in Kelvin: ";
            System.out.printf("%nThe degrees in Celsius is %.2fºC" , kelvin2Celsius(enterTemp(text)));

        } else {
            String text = "Enter the degrees in Kelvin: ";
            System.out.printf("%nThe degrees in Fahrenheit is %.2fºF" ,  kelvin2Fahrenheit(enterTemp(text)));
        }
        sc.close();
    }

    private static void init()
    {
        System.out.println("**********************************************************************\n"
                + "* TEMPERATURE CONVERSION                              © Joan Sèculi  *\n"
                + "*                                                                    *\n"
                + "* This program converts between CELSIUS, FAHRENHEIT and KELVIN       *\n"
                + "**********************************************************************");
    }

    private static byte menu()
    {
        System.out.println("\nWhat do you want to convert:\n"
                + "1. Celsius to Fahrenheit\n"
                + "2. Celsius to Kelvin\n"
                + "3. Fahrenheit to Celsius\n"
                + "4. Fahrenheit to Kelvin\n"
                + "5. Kelvin to Celsius\n"
                + "6. Kelvin to Fahrenheit");

        System.out.print("\nEnter your option? ");

        return sc.nextByte();
    }

    private static float enterTemp(String text)
    {
        System.out.print(text);

        float temp = 0;
        boolean isValid = false;

        while (!isValid) {
            if (sc.hasNextFloat()) {
                temp = sc.nextFloat();
                isValid = true;
            } else {
                sc.next();
                System.out.println("\nError: " + text);
            }
        }

        return temp;
    }

    private static float celsius2Fahrenheit(float temp)
    {
        return temp + K273_15;
    }

    private static float celsius2Kelvin(float temp)
    {
        return (temp - K_32F) * K_5F / K_9F;
    }

    private static float fahrenheit2Celsius(float temp)
    {
        return (temp - K_32F) * K_5F / K_9F;
    }

    private static float fahrenheit2Kelvin(float temp)
    {
        return K_5F / K_9F * (temp - K_32F) + K273_15;
    }

    private static float kelvin2Celsius(float temp)
    {
        return temp - K273_15;
    }

    private static float kelvin2Fahrenheit(float temp)
    {
        return (K_9F / K_5F) * (temp - K273_15) + K_32F;
    }
}
