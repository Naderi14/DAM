package RA2.actividadStrings;

/*6. Divide la cadena de texto “Este es el módulo, de programación” en dos partes: “Este
                es el módulo” y “de programación”.*/

public class DividirCadenaTexto {
    public static void main(String[] args)
    {
        String texto = "Este es el módulo, de programación";

        String parte1 = texto.substring(0, texto.indexOf(','));
        String parte2 = texto.substring(texto.indexOf(',') + 2);
        String parte3 = parte1.concat(", " + parte2);

        System.out.println("Parte 1: \"" + parte1 + "\" | Parte 2: \"" + parte2 + "\" | Parte 3: \"" + parte3 + "\"");
    }
}
