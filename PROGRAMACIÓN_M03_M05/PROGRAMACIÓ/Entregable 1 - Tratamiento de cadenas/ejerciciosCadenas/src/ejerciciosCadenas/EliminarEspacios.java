package ejerciciosCadenas;

/*4. Elimina los espacios del texto: “Tratamiento de cadenas con JAVA”*/

import java.util.Scanner;

public class EliminarEspacios {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce un texto para retirarlo los espacios ->");
        String texto = leer.nextLine();

        System.out.println(texto.replace(" ", ""));
    }
}
