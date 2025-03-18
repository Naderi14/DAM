import pokemon.FileManager;
import pokemon.Pokemon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PokemonTest {
    public static final Scanner SC = new Scanner(System.in);
    public static final String PATH = "src/pokemons.csv";
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args)
    {
        menuPrincipal();
    }

    private static void menuPrincipal()
    {
        boolean isExit = false;

        while (!isExit)
        {
            try
            {
                showMenu();
                int option = SC.nextInt();
                SC.nextLine();

                switch (option)
                {
                    case 1:
                        totals();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 0:
                        System.out.println("BYE!");
                        isExit = true;
                        break;
                    default:
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: INVALID INPUT VALUE -!>");
            }
            catch (IOException e)
            {
                System.out.println("<!- ERROR: " + e.getMessage() + " -!>");
            }
        }
    }

    private static void totals() throws IOException
    {
        fileManager.write(fileManager.readTotals(PATH, "Loco", "Tuneao"), "src/pokemonsFiltered.csv");
    }

    private static void showMenu()
    {
        System.out.print("\nMENU" +
                "\n1. TOTALS" +
                "\n2. POKEMON SEARCH" +
                "\n3. EXTRACT GENERATION" +
                "\n4. ORDER LEGENDARY" +
                "\n5. ORDER BY TYPE1 AND TYPE2" +
                "\n6. ORDER BY GENERATION AND NAME" +
                "\n0. QUIT" +
                "\nCHOOSE MENU OPTION: ");
    }
}