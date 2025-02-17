import ps.PS;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);

    private static BufferedReader buffer;
    private static File file;
    private static FileWriter fw;
    private static ArrayList<PS> listFestivals = new ArrayList<>();

    public static void main(String[] args)
    {
        try
        {
            chargeData();
            showMenu();
        }
        catch (IOException e)
        {
            System.out.println("<- Error ocurred when try to read or write a file ->\n" + e);
        }
    }

    private static void chargeData() throws IOException
    {
        buffer = new BufferedReader(new FileReader("src/primaverasound.txt"));
        buffer.readLine();
        String linea = buffer.readLine();

        while (linea != null)
        {
            String[] stringValues = linea.split(";");

            listFestivals.add(new PS(
                    stringValues[0],
                    Short.parseShort(stringValues[1]),
                    stringValues[2],
                    Integer.parseInt(stringValues[3]),
                    Integer.parseInt(stringValues[4]),
                    Float.parseFloat(stringValues[5]),
                    Integer.parseInt(stringValues[6]),
                    Float.parseFloat(stringValues[7]),
                    Integer.parseInt(stringValues[8]),
                    Float.parseFloat(stringValues[9]),
                    stringValues[10]
            ));

            linea = buffer.readLine();
        }
        buffer.close();
    }

    private static void showMenu() throws IOException
    {
        while (true)
        {
            try
            {
                System.out.println("MENU:\n1. FIND TOTALS\n2. SEARCH ARTIST\n3. HEADLINERS\n4. PRICE TOTALS\n0. LEAVE\nOPTION (0 .. 4) ? CHOSE MENU OPTION");
                if (pedirOpcion())
                    break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("<- Forbidden characters, must be a number ->\n" + e);
                SC.nextLine();
            }
        }

        System.out.println("<- Bye! ->");
    }

    private static boolean pedirOpcion() throws InputMismatchException, IOException
    {
        int opcion = SC.nextInt();

        switch (opcion)
        {
            case 0:
                return true;
            case 1:
                findTotals();
                break;
            case 2:
                SC.nextLine();
                searchArtist();
                break;
            case 3:
                headLiners();
                break;
            case 4:
                priceTickets();
                break;
            default:
                System.out.println("<- Incorrect Option ->");
                break;
        }
        return false;
    }

    private static void findTotals() throws IOException
    {
        fw = new FileWriter("src/totals.txt", false);

        String headerFields = "EDITION;YEAR;DATE;ASSISTANTS;TICKETSDAY;PRICEDAY;TICKETSFULLFEST;PRICEFULLFEST;TICKETSVIP;PRICEVIP;TOTALTICKETS;EARNINGS\n";
        String dataFields = "";

        for (PS ps : listFestivals)
        {
            dataFields += ps.getEdition() + ";" +
                    ps.getYear() + ";" +
                    ps.getDate() + ";" +
                    ps.getAssistants() + ";" +
                    ps.getTicketsDay() + ";" +
                    ps.getPriceDay() + ";" +
                    ps.getTicketsFullFest() + ";" +
                    ps.getPriceFullFest() + ";" +
                    ps.getTicketsVips() + ";" +
                    ps.getPriceVip() + ";" +
                    (ps.getTicketsDay() + ps.getTicketsFullFest() + ps.getTicketsVips()) + ";" +
                    (long)(ps.getTicketsDay() * ps.getPriceDay() + ps.getTicketsFullFest() * ps.getPriceFullFest() + ps.getTicketsVips() * ps.getPriceVip()) + "\n";
        }
        fw.write(headerFields + dataFields);
        fw.flush();
        fw.close();
        System.out.println("<- totals.txt has been created correctly ->");
    }

    private static void searchArtist() throws IOException
    {
        System.out.println("<- Insert name of artist ->");
        String artistName = SC.nextLine().toLowerCase();
        String headerFields = "EDITION;YEAR;HEADLINERS\n";
        String dataFields = "";

        if (!artistName.trim().isEmpty())
        {
            boolean founded = false;
            for (PS ps : listFestivals)
            {
                if (ps.getHeadLiners().toLowerCase().contains(artistName))
                {
                    founded = true;
                    dataFields += ps.getEdition() + ";" + ps.getYear() + ";" + ps.getHeadLiners() + "\n";
                }
            }

            if (founded)
            {
                fw = new FileWriter("src/artist.txt", false);
                fw.write(headerFields + dataFields);
                fw.flush();
                fw.close();
                System.out.println("<- artist.txt has been created correctly ->");
            }
            else
            {
                System.out.println("<- Artist not found ->");
            }
        }
        else
        {
            System.out.println("<- Artist must be a not Empty name! ->");
        }
    }

    private static void headLiners() throws InputMismatchException, IOException
    {
        System.out.println("<- Insert year ->");
        int year = SC.nextInt();
        boolean founded = false;

        String fieldArtists = "";

        for (PS ps : listFestivals)
        {
            if (ps.getYear() == year)
            {
                founded = true;
                String[] artistsOfYear = ps.getHeadLiners().split(",");

                for (String artist : artistsOfYear)
                {
                    fieldArtists += artist.trim() + "\n";
                }

                break;
            }
        }

        if (founded)
        {
            String pathName = "src/headlines" + year + ".txt";
            fw = new FileWriter(pathName);
            fw.write("HEADLINERS\n" + fieldArtists);
            fw.flush();
            fw.close();
            System.out.println("<- " + pathName + " has been created correctly ->");
        }
        else
        {
            System.out.println("<- Year not found ->");
        }
    }

    private static void priceTickets() throws InputMismatchException, IOException
    {
        System.out.println("<- Insert year ->");
        int year = SC.nextInt();

        boolean founded = false;
        String headerFields = "EDITION;YEAR;PRICEDAY;PRICEFULLFEST;PRICEVIP\n";
        String priceFields = "";

        for (PS ps : listFestivals)
        {
            if (ps.getYear() == year)
            {
                founded = true;
                priceFields += ps.getEdition() + ";" + ps.getYear() + ";" + ps.getPriceDay() + ";" + ps.getPriceFullFest() + ";" + ps.getPriceVip();
            }
        }

        if (founded)
        {
            String pathName = "src/tickets" + year + ".txt";
            fw = new FileWriter(pathName);
            fw.write(headerFields + priceFields);
            fw.flush();
            fw.close();
            System.out.println("<- " + pathName + " has been created correctly ->");
        }
        else
        {
            System.out.println("<- Year not found ->");
        }
    }
}