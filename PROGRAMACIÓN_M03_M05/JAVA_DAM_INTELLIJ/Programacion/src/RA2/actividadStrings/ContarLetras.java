package RA2.actividadStrings;

/*5. Cuenta las vocales y las consonantes del String: “JAVA JAVA JAVA”. Cuidado con los
espacios.*/

public class ContarLetras {
    public static void main(String[] args)
    {
        String texto = "JAVA JAVA JAVA";
        texto = texto.toLowerCase();
        final String consonantes = "qwrtypsdfghjklñzxcvbnm";
        int cantVocales = 0, cantConsonantes = 0;

        for (int i = texto.length() - 1; i >= 0; i--)
        {
            char letra = texto.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u')
            {
                cantVocales++;
                continue;
            }
            if (consonantes.contains(String.valueOf(letra)))
                cantConsonantes++;
        }

        System.out.println("Vocales: " + cantVocales + " | Consonantes: " + cantConsonantes);
    }
}
