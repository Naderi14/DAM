package RA2.actividadStrings;

/*7. Transforma la cadena de texto “ilerna” a mayúsculas. Guarda el valor en la variable y
posteriormente conviértela nuevamente en minúsculas.*/

public class MinusMayusMinus {
    public static void main(String[] args)
    {
        String nombre = "ilerna";
        nombre = nombre.toUpperCase();

        System.out.println(nombre);

        nombre = nombre.toLowerCase();

        System.out.println(nombre);
    }
}
