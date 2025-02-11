import java.io.*;
import java.util.ArrayList;

public class Main {
    private static FileReader fr;
    private static FileWriter fw;
    private static File file;
    private static char[] caracteres;
    private static ArrayList listaCaracteres = new ArrayList<>();

    public static void main(String[] args)
    {
        try
        {
            file = new File("resources/Documento1.txt");
            fr = new FileReader("resources/Documento1.txt");

            // PRIMERA PRUEBA DE READER
            caracteres = new char[20];
            for (int i = 0; i < 5; i++)
            {
                // Usamos la funcion read con el modo de pasarle el inicio de la lectura y la cantidad de caracteres a leer
                // la cantidad le decimos que sea la misma que la longitud de nuestro array
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

            System.out.println("\n\nValor ASCII de la letra a la que esta apuntando el reader ahora: " + fr.read() + " = " + (char)fr.read());

            // Cogeremos toda la longitud del archivo para luego imprimirla mediante la instancia de File que nos da las propiedades
            caracteres = new char[(int) file.length()];
            // Leemos los caracteres que quepan en este array, por eso le pasamos el array como parametro de la funcion read
            fr.read(caracteres);
            // Función para cerrar la lectura del archivo actual del FileReader
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
            }

            fw = new FileWriter("resources/Documento1.txt");
            // Vamos a escribir, sobreescribiendo el contenido del archivo
            fw.write("Esto será ya todo el nuevo texto");
            fw.close();
            fr = new FileReader("resources/Documento1.txt");
            caracteres = new char[(int) file.length()];
            fr.read(caracteres);

            for (char caracter : caracteres)
            {
                System.out.print(ch);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}