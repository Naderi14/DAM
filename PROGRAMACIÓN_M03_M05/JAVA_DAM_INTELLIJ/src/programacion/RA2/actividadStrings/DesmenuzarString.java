package programacion.RA2.actividadStrings;

/*2. Desmenuza el String “JAVA” mostrándolo por pantalla carácter a carácter.
La consola debe mostrar:
J
A
V
A*/

public class DesmenuzarString {
    public static void main(String[] args)
    {
        String palabra = "JAVA";

        for (int i = 0; i < palabra.length() ; i++)
        {
            System.out.println(palabra.charAt(i));
        }
    }
}
