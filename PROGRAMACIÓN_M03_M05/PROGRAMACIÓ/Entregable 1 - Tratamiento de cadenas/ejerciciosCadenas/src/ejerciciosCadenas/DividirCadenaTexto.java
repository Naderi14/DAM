package ejerciciosCadenas;

/*6. Divide la cadena de texto “Este es el módulo, de programación” en dos partes: “Este
                es el módulo” y “de programación”.*/

public class DividirCadenaTexto {
    public static void main(String[] args)
    {
        String texto = "Este es el módulo, de programación";

        String parte2 = texto.substring(texto.indexOf(','));
        String parte1 = "";

        for (int i = 0; i < texto.length() - parte2.length(); i++)
        {
            parte1 += texto.charAt(i);
        }

        System.out.println("Parte 1: \"" + parte1 + "\" | Parte 2: \"" + parte2 + "\"");
    }
}
