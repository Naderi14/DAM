import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static FileReader fr;
    private static File file;
    private static char[] caracteres;
    private static ArrayList listaCaracteres = new ArrayList<>();

    public static void main(String[] args)
    {
        try
        {
            file = new File("resources/Documento1.txt");
            fr = new FileReader("resources/Documento1.txt");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            caracteres = new char[20];

            for (int i = 0; i < 5; i++)
            {
                fr.read(caracteres, 0, caracteres.length);

                for (char ch : caracteres)
                {
                    System.out.print(ch);
                }
                System.out.println();
            }

            caracteres = new char[500];
            fr.read(caracteres);
            for (char ch : caracteres)
            {
                System.out.print(ch);
            }

            fr.close();

            /*System.out.println("Valor ASCII de la primera letra del texto: " + fr.read());

            // Cogeremos toda la longitud del archivo para luego imprimirla
            caracteres = new char[(int) file.length()];
            fr.read(caracteres);
            fr.close();
            for (char ch : caracteres)
            {
                System.out.print(ch);
            }

            // Otra forma de leer el archivo
            fr = new FileReader("resources/Documento1.txt");
            int ch = fr.read();

            while (ch != -1)
            {
                listaCaracteres.add((char) ch);
                ch = fr.read();
            }

            for (int i = 0; i < listaCaracteres.size(); i++)
            {
                System.out.print(listaCaracteres.get(i));
            }*/
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }



    }
}