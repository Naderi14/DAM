import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static BufferedReader buffer;
    private static File file;
    private static FileWriter fw;

    public static void main(String[] args)
    {
        while (pedirOpcion())
        {
        }
    }

    private static void mainMenu()
    {
        System.out.print("MENU\n1. COUNT LINES\n2. SEARCH WORD\n3. EXTRACT CHAPTER\n0. LEAVE\nOPTION (0 .. 3) ? CHOOSE MENU OPTION: ");
    }

    private static boolean pedirOpcion()
    {
        mainMenu();
        try
        {
            int opcion = SC.nextInt();
            SC.nextLine();
            switch (opcion)
            {
                case 1:
                    System.out.println(fileLinesCounter());
                    break;
                case 2:
                    searchWord();
                    break;
                case 3:
                    extractChapter();
                    break;
                case 0:
                    System.out.println("¡BYE!");
                    return false;
                default:
                    System.out.println("<- INTRODUCE A VALID OPTION ->");
                    break;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("ERROR: INPUT MISMATCH VALUE, TRY AGAIN");
        }
        catch (IOException e)
        {
            System.out.println("ERROR: INPUT OR OUTPUT STREAM FAILED, SORRY");
        }

        return true;
    }

    private static int fileLinesCounter() throws IOException
    {
        buffer = new BufferedReader(new FileReader("src/AliceWonderland.txt"));
        fw = new FileWriter("src/NumLines.txt", false);
        int totalLines = 1;
        String linea = buffer.readLine();

        while (linea != null)
        {
            linea = buffer.readLine();
            totalLines++;
        }

        buffer.close();
        fw.write("Total Lines: " + totalLines);
        fw.flush();
        fw.close();

        return totalLines;
    }

    private static void searchWord() throws IOException
    {
        buffer = new BufferedReader(new FileReader("src/AliceWonderland.txt"));
        fw = new FileWriter("src/results.txt", false);

        System.out.print("Enter a word: ");
        String word = SC.nextLine().toLowerCase();

        int numLine = 1;
        String linea = buffer.readLine();
        String dateRows = "";
        int countFoundeds = 0;

        while (linea != null)
        {
            if (linea.toLowerCase().contains(word))
            {
                countFoundeds++;
                if (countFoundeds < 6)
                    dateRows += countFoundeds + " - LINE: " + numLine + " - " + linea + "\n";
                else
                    break;
            }

            linea = buffer.readLine();
            numLine++;
        }
        buffer.close();
        fw.write(dateRows);
        fw.flush();
        fw.close();
    }

    private static void extractChapter() throws IOException, InputMismatchException
    {
        buffer = new BufferedReader(new FileReader("src/AliceWonderland.txt"));

        int chapter;
        do
        {
            System.out.print("Choose chapter: ");
            chapter = SC.nextInt();
        } while (chapter >= 13 || chapter <= 0);

        String roman = RomanNumber.fromValue(chapter).name();
        fw = new FileWriter("src/chapter" + roman + ".txt", false);

        String extractedChapter = "";
        boolean inChapter = false;

        String linea = buffer.readLine();
        while (linea != null)
        {
            if (linea.contains("CHAPTER " + roman) && !inChapter)
            {
                inChapter = true;
                extractedChapter += linea + "\n\n";
                linea = buffer.readLine();
            }

            if (inChapter)
            {
                if (linea.contains("CHAPTER" ))
                    break;

                extractedChapter += linea + "\n";
            }

            linea = buffer.readLine();
        }
        buffer.close();
        fw.write(extractedChapter);
        fw.flush();
        fw.close();
    }

    private enum RomanNumber
    {
        I(1), II(2), III(3), IV(4),
        V(5), VI(6), VII(7), VIII(8),
        IX(9), X(10), XI(11), XII(12);

        private int value;

        private RomanNumber(int value)
        {
            this.value = value;
        }

        public static RomanNumber fromValue(int value)
        {
            for (RomanNumber num : RomanNumber.values())
            {
                if (num.value == value)
                {
                    return num;
                }
            }

            return RomanNumber.I;
        }
    }
}