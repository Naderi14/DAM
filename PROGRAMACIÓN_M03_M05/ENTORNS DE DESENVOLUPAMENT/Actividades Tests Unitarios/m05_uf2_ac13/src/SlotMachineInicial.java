import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class SlotMachineInicial {
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.UK);
    public static final byte B1 = 1;
    public static final byte B2 = 2;
    public static final byte B3 = 3;
    public static final byte B4 = 4;
    public static final byte B5 = 5;
    public static final byte B6 = 6;

    public static final String STRAWBERRY = "STRAWBERRY";
    public static final String BANANA = "BANANA";
    public static final String APPLE = "APPLE";
    public static final String LEMON = "LEMON";
    public static final String WATERMELON = "WATERMELON";
    public static final String STAR = "STAR";

    public static final String ONE_STAR = "ONE STAR";
    public static final String TWO_FRUITS = "TWO FRUITS";
    public static final String TWO_FRUITS_ONE_START = "TWO FRUITS ONE STAR";
    public static final String TWO_STARS = "TWO STARS";
    public static final String THREE_FRUITS = "THREE FRUITS";
    public static final String THREE_STARS = "THREE STARS";
    public static final String LOST = "YOU HAVE LOST!!";
    public static final String BYE = "BYE!!";

    public static final String NO_MORE_MONEY = "SORRY! YOU DON\'T HAVE ENOUGH MONEY TO BET!!";

    public static final byte BET = 25;
    public static final float MONEY_MACHINE = 1000.0f;
    private static final byte DECIMALS = 2;

    public static final byte PRIZE_3 = 3;
    public static final byte PRIZE_4 = 4;
    public static final byte PRIZE_5 = 5;
    public static final byte PRIZE_11 = 11;

    public static void main(String[] args) {

        SlotMachineInicial s = new SlotMachineInicial();
        byte fruit1 = 0;
        byte fruit2 = 0;
        byte fruit3 = 0;
        byte bet = 0;
        float moneyPrize = 0;
        float moneyMachine = MONEY_MACHINE;
        float moneyUser = s.enterMoney("Enter money of the user: ", BET, 1000);

        bet = BET;
        int i = 1;
        boolean end = false;

        byte option = s.menu();
        if (option == 0) {
            System.out.println(BYE);
        }
        if (moneyMachine < BET * (PRIZE_11 - 1))
            System.out.println("Machine does not have more moeny");
        while (option != 0 && moneyUser >= BET && moneyMachine >= BET * (PRIZE_11 - 1)) {
            switch (option) {
                case 1:

                    fruit1 = s.randomFruit();
                    fruit2 = s.randomFruit();
                    fruit3 = s.randomFruit();

                    System.out.println(
                            "Result[" + i + "]: " + s.figure(fruit1) + "\t" + s.figure(fruit2) + "\t" + s.figure(fruit3));

                    moneyPrize = s.round(s.prize(bet, s.result(fruit1, fruit2, fruit3)), DECIMALS);
                    String res = s.result(fruit1, fruit2, fruit3);
                    System.out.println(res + " -> " + moneyPrize);

                    moneyUser = s.round(moneyUser + moneyPrize - bet, DECIMALS);

                    System.out.println("Money user: " + moneyUser);

                    moneyMachine = s.round(moneyMachine - moneyPrize + bet, DECIMALS);

                    System.out.println("Money machine: " + moneyMachine);
                    i++;
                    if (moneyUser - BET < 0)
                        end = true;

                    break;

                default:
                    System.out.println("Wrong entry, please enter a number 1 or 0: ");
                    break;
            }
            if (end) {
                System.out.println(NO_MORE_MONEY + "\n" + BYE);
            } else {
                option = s.menu();
                if (option == 0) {
                    System.out.println(BYE);
                }
            }
        }

        scanner.close();

    }

    public byte menu() {
        System.out.print("\nMENU: ");
        System.out.print("1. Play / ");
        System.out.print("0. Quit. ");
        byte option = dataEntryByte("Choose option: ");
        return option;
    }

    /**
     * Result of the game as a text
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return the text of the result of the game
     */
    public static String result(byte fruit1, byte fruit2, byte fruit3) {
        if (isThreeStars(fruit1, fruit2, fruit3))            return "THREE STARS";
        else if (isThreeFruits(fruit1, fruit2, fruit3))      return "THREE FRUITS";
        else if (isTwoStars(fruit1, fruit2, fruit3))         return "TWO STARS";
        else if (isTwoFruitsOneStar(fruit1, fruit2, fruit3)) return "TWO FRUITS ONE STAR";
        else if (isTwoFruits(fruit1, fruit2, fruit3))        return "TWO FRUITS";
        else return "YOU HAVE LOST!!";
    }

    /**
     * Returns the prize of the game
     *
     * @param bet    the bet amount
     * @param result the combination of the game
     * @return the total amount of the prize
     */
    public static float prize(float bet, String result) {
        switch (result) {
            case "TWO FRUITS": return bet;
            case "TWO FRUITS ONE STAR": return bet * 3;
            case "TWO STARS": return bet * 4;
            case "THREE FRUITS": return bet * 5;
            case "THREE STARS": return bet * 11;
            default: return 0;
        }
    }

    /**
     * Get the name of the fruit
     *
     * @param fruit		the fruit in number
     * @return			the fruit in text
     */
    public static String figure(byte fruit) {
        switch (fruit) {
            case 1: return "STRAWBERRY";
            case 2: return "BANANA";
            case 3: return "APPLE";
            case 4: return "LEMON";
            case 5: return "WATERMELON";
            case 6: return "STAR";
            default: return "ERROR";
        }
    }

    /**
     * Generates a number between 1 and 6
     * The probability of 6 is the half of 1 to 5
     *
     * @return	A number between 1 and 6
     */
    public static byte randomFruit() {
        Random rand = new Random();
        int[] probabilities = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        int index = rand.nextInt(probabilities.length);
        return (byte) probabilities[index];
    }

    /**
     * 2 equal fruits
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return true is we get two equal fruits but
     * they are not a star, and the other is not a star
     */
    public static boolean isTwoFruits(byte fruit1, byte fruit2, byte fruit3) {
        if (fruit1 == fruit2 && fruit3 != fruit1 && fruit3 != 6) return true;
        if (fruit1 == fruit3 && fruit2 != fruit1 && fruit2 != 6) return true;
        if (fruit2 == fruit3 && fruit1 != fruit2 && fruit1 != 6) return true;
        return false;
    }

    /**
     * 2 equal fruits and 1 star
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return true if we get two equals fruits and they are not a star
     * and the other is a star
     */
    public static boolean isTwoFruitsOneStar(byte fruit1, byte fruit2, byte fruit3) {
        if (fruit1 == fruit2 && fruit3 == 6 && fruit1 != 6) return true;
        if (fruit1 == fruit3 && fruit2 == 6 && fruit1 != 6) return true;
        if (fruit2 == fruit3 && fruit1 == 6 && fruit2 != 6) return true;
        return false;
    }

    /**
     * 3 equal fruits
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return true is we get 3 equal fruits but they are not a star
     */
    public static boolean isThreeFruits(byte fruit1, byte fruit2, byte fruit3) {
        return (fruit1 == fruit2 && fruit2 == fruit3 && fruit1 != 6);
    }

    /**
     * 2 stars
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return true is we get 2 stars
     */
    public static boolean isTwoStars(byte fruit1, byte fruit2, byte fruit3) {
        int starCount = 0;
        if (fruit1 == 6) starCount++;
        if (fruit2 == 6) starCount++;
        if (fruit3 == 6) starCount++;

        return starCount == 2;
    }

    // 6 6 6
    /**
     * 3 stars
     *
     * @param fruit1 value of first fruit
     * @param fruit2 value of second fruit
     * @param fruit3 value of third fruit
     * @return true if we get 3 stars
     */
    public static boolean isThreeStars(byte fruit1, byte fruit2, byte fruit3) {
        return fruit1 == 6 && fruit2 == 6 && fruit3 == 6;
    }

    public byte dataEntryByte(String text) {
        byte number = 0;
        System.out.println(text);
        boolean isValid = false;
        while (!isValid) {
            if (scanner.hasNextByte()) {
                number = scanner.nextByte();
                isValid = true;
            } else {
                scanner.next(); // Consume next line
                System.out.println("Error! " + text);
            }
        }
        return number;
    }


    public float enterMoney(String text, float min, float max) {
        float number = 0;
        System.out.println(text);
        boolean isValid = false;
        while (!isValid) {
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                // isValid = true;
                if (number < min || number > max) {
                    isValid = false;
                    System.out.println(
                            "ERROR! Bet can't be less than " + min + " or bigger than " + max + ". Enter again: ");
                } else {
                    isValid = true;
                }
            } else {
                scanner.next(); // consume next line
                System.out.println("Error! " + text);
            }
        }
        return number;
    }

    /**
     * Round to a specific number of decimals
     *
     * @param num real number to round
     * @param dec decimal numbers
     * @return the rounded number
     */
    public float round(float num, byte dec) {
        return (float) (Math.round(num * Math.pow(10.0, dec)) / Math.pow(10.0, dec));
    }
}
