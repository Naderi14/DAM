package ejerciciosCadenas;

/*9. Sobre la cadena de texto “JEVE JEVE JEVE”, sustituye/reemplaza todas las vocales e
por la vocal a dando como resultado “JAVA JAVA JAVA”.*/

public class ReemplazarLetra {
    public static void main(String[] args)
    {
        String texto = "JEVE JEVE JEVE";
        String reemplazo = texto.toLowerCase().replace('e', 'a');

        System.out.println("Resultado: " + reemplazo.toUpperCase());
    }
}
