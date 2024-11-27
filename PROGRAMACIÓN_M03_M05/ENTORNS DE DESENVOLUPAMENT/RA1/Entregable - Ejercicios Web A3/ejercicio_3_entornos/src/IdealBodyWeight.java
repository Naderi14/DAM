// ACTIVIDAD 3 ENTORNOS

import java.util.Scanner;

public class IdealBodyWeight {
    public static final int INT_100 = 100;
    public static final double DOUBLE_10 = 10.0;
    public static final double DOUBLE_0_9 = 0.9;
    public static final double DOUBLE_150 = 150.0;
    public static final int INT_4 = 4;
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        switchFormulas(menu());
        leer.close();
    }

    private static byte menu() {
        System.out.println("\nWhat formula do you want to use:\n"
                + "1. Creff Formula\n"
                + "2. Lorentz Formula\n"
                + "3. Berthean Formula");
        System.out.print("\nEnter your option? ");
        byte option = leer.nextByte();

        return option;
    }

    private static void init()
    {
        System.out.println("**********************************************************************\n"
                + "* IDEAL BODY WEIGHT                                 © Juan Francisco *\n"
                + "*                                                                    *\n"
                + "* There are several formulas to calculate your ideal body weight.    *\n"
                + "* This program uses 3 different formulas:                            *\n"
                + "* Creff Formula                                                      *\n"
                + "* Lorentz Formula                                                    *\n"
                + "* Berthean Formula                                                   *\n"
                + "**********************************************************************");
    }

    private static void switchFormulas(byte option)
    {
        int age;
        int height;
        switch (option)
        {
            case 1:
                int morphology = dataEntry("\nSelect morphology: 1. small, 2. medium, 3. broad ? ");
                height = dataEntry("Enter your height in cm: ");
                age = dataEntry("Enter your age: ");

                System.out.println("Creff = " + getCreffFormula(morphology, height, age) + "kg");
                break;
            case 2:
                height = dataEntry("Enter your height in cm: ");
                age = dataEntry("Enter your age: ");
                int gender = dataEntry("Enter your gender (Men = 1, Women = 2): ");

                System.out.println("Lorentz = " + getLorentzFormula(gender, height, age) + "kg");
                break;
            case 3:
                height = dataEntry("Enter your height in cm: ");
                age = dataEntry("Enter your age: ");

                System.out.print("Berthan = " + getBerthanFormula(height, age) + " kg");
                break;
        }
    }

    private static double getBerthanFormula(int height, int age)
    {
        double berthan = 0.8 * (height - INT_100) + age / 2.0;
        return getRound(berthan);
    }

    private static double getLorentzFormula(int gender, int height, int age)
    {
        double lorentz = 0;
        if (gender == 1) {
            lorentz = height - INT_100 - (height - DOUBLE_150) / INT_4 + (age - 20.0) / INT_4;
        } else {
            lorentz = height - INT_100 - (height - DOUBLE_150) / INT_4 + (age - 20) / 2.5;
        }
        return getRound(lorentz);
    }

    private static double getCreffFormula(int morphology, int height, int age)
    {
        double creff = 0;
        if (morphology == 2) {
            creff = (height - INT_100 + age / DOUBLE_10) * DOUBLE_0_9; // medium (normal)
        } else if (morphology == 1) {
            creff = (height - INT_100 + age / DOUBLE_10) * Math.pow(DOUBLE_0_9, 2); // small (fina)
        } else {
            creff = (height - INT_100 + age / DOUBLE_10) * DOUBLE_0_9 * 1.1; // broad (gran)
        }
        return getRound(creff);
    }

    private static double getRound(double number)
    {
        return Math.round(number * INT_100) / 100.0;
    }

    private static int dataEntry(String text) {
        System.out.print(text);
        int data = 0;
        boolean isValid = false;
        while (!isValid) {
            if (leer.hasNextInt()) {
                data = leer.nextInt();
                isValid = true;
            } else {
                leer.next();
                System.out.println("\nError: " + text);
            }
        }
        return data;
    }
}
