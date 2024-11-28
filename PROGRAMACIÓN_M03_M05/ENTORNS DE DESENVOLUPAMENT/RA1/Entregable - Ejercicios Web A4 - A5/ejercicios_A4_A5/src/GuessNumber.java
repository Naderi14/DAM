/*
 * RandomNumbers.java 18 Nov 2023
 *
 *
 * ©Copyright 2023 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

// ACTIVIDAD 5

/*
* Errores:
*   1. El rango de attempts no parece estar correctamente configurado (CORREGIDO)
*   2. Falta de salto de linea entre la configuración del juego y el mismimo juego (CORREGIDO)
*   3. No se gestiona bien la condición de si el número es mayor o menor (CORREGIDO)
*   4. Si aciertas antes de agotar los intentos, no sales del bucle (CORREGIDO)
*   5. El bucle es infinito (CORREGIDO)
*   6. La variable end no se tiene en cuenta en el While, cuando ganas no acaba el bucle (CORREGIDO)
*   7. El mensaje de perder la partida aparece aun cuando has acertado el número (CORREGIDO)
*   8. El condicional del mensaje de perder la partida, debe invertirse en cuanto al booleano (CORREGIDO)
* */
import java.util.Random;
import java.util.Scanner;
//Amb dataEntry
/*
 * RandomNumbers.java 18 Nov 2023
 *
 *
 * ©Copyright 2023 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

// ACTIVIDAD 5

/*
 * Errores:
 *   1. El rango de attempts no parece estar correctamente configurado (CORREGIDO)
 *   2. Falta de salto de linea entre la configuración del juego y el mismimo juego (CORREGIDO)
 *   3. No se gestiona bien la condición de si el número es mayor o menor (CORREGIDO)
 *   4. Si aciertas antes de agotar los intentos, no sales del bucle (CORREGIDO)
 *   5. El bucle es infinito (CORREGIDO)
 *   6. La variable end no se tiene en cuenta en el While, cuando ganas no acaba el bucle (CORREGIDO)
 *   7. El mensaje de perder la partida aparece aun cuando has acertado el número (CORREGIDO)
 *   8. El condicional del mensaje de perder la partida, debe invertirse en cuanto al booleano (CORREGIDO)
 * */
import java.util.Random;
import java.util.Scanner;
//Amb dataEntry
public class GuessNumber {
    public static Scanner scanner = new Scanner(System.in);
    public static final byte MAX = 100;
    public static final byte MIN = 10;

    public static final byte MAX_ATTEMPTS = 10;
    public static final byte MIN_ATTEMPTS = 1;

    /**
     * The main method test all methods of the class
     *
     * @author  <a href="mailto:jseculi@escoladeltreball.org">Joan Sèculi</a>
     * @version 1.0
     * @since   07/11/2021
     * @param args  args are not used
     * @return void
     *
     */
    public static void main(String[] args) {

        byte count = 1;
        boolean end = false;

        init();

        byte max = dataEntryByteMinMax("Enter the maximum number (10 .. 100): ", MIN, MAX);

        byte attempts = dataEntryByteMinMax("Enter the number of attempts: ", MIN_ATTEMPTS, MAX_ATTEMPTS);
        System.out.println();
        byte rand = randomNumber(max);
        //  System.out.println("Number to guess: " + rand);

        while (count <= attempts && !end)  {
            byte num = dataEntryByteMinMax("ATTEMPT " + count + ". Enter 1 to " + max + ": ", (byte)1, max);

            byte output = guessNumber(num, rand);
            if(output == 1) {
                System.out.println("YOU HAVE WON!!! THE END.");
                end = true;

            } else if (output == -1) {
                System.out.print("Too low! ");
            } else {
                System.out.print("Too high! ");
            }
            count++;
        }
        if (!end) System.out.println("You have lost!\nBye!");

        scanner.close();
    }

    /**
     * Generates a random card.
     *
     * @return a random number between 1 and 10.
     */
    public static byte randomNumber(byte max) {
        //Option 1: using Math.random
        //Math.random() * (max - min + 1) + min
        //int i = (byte) (Math.random() * 10) + 1;
        //return (byte)( (Math.random() * 10) + 1);

        //Option 2: using Random class
        Random rd = new Random();
        //int min = 1;
        //return rd.next.Int(max - min  + 1) + min
        return (byte)(rd.nextInt(max) + 1);
    }

    /**
     * Indicates if the guess number is correct
     * @param num   the number entered by user
     * @param randomNum the number to be guessed
     * @return  returns a 0 if the number is the same as the guess number, 1 if it is bigger and -1 if it is smaller
     */
    public static byte guessNumber(byte num, byte randomNum) {
        if (num > randomNum)
            return 0;
        else if (num < randomNum)
            return -1;
        else
            return 1;
    }


    public static byte dataEntryByteMinMax(String text, byte min, byte max) {
        byte number = 0;
        System.out.print(text);
        boolean isValid = false;
        while (!isValid) {
            if (scanner.hasNextByte()) {
                number = scanner.nextByte();
                if(number >= min && number <= max){
                    isValid = true;
                }else{
                    System.out.print("Only number from "+ min + " to "+ max + ". Enter number: ");
                }
            } else {
                scanner.next(); // consume next line
                System.out.print("Error! " + text);
            }
        }
        return number;
    }

    private static void init() {
        System.out.println("*********************************************************************");
        System.out.println("* GUESS A NUMBER                                     \u00A9 Joan S�culi  *");
        System.out.println("*                                                                   *");
        System.out.println("* You have X attempts to guess a number between 1 and MAX.          *");
        System.out.println("* The X and MAX values will be decided at the begining of the game. *");
        System.out.println("* X must be a number between 2 and 10, and MAX between 10 and 100.  *");
        System.out.println("*********************************************************************\n");

    }
}


