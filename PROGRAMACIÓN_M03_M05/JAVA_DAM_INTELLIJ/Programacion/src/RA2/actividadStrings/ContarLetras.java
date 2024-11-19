package RA2.actividadStrings;

/*5. Cuenta las vocales y las consonantes del String: “JAVA JAVA JAVA”. Cuidado con los
espacios.*/

public class ContarLetras {
    public static void main(String[] args)
    {
        String texto = "JAVA JAVA JAVA";
        final String vocales = "aeiou";
        final String consonantes = "qwrtypsdfghjklñzxcvbnm";
        int cantVocales = 0, cantConsonantes = 0;

        for (int i = texto.length() - 1; i >= 0; i--)
        {
            boolean isMatched = false;
            for (int j = vocales.length() - 1; j >= 0; j--)
            {
                if (texto.toLowerCase().charAt(i) == vocales.charAt(j))
                {
                    cantVocales++;
                    isMatched = true;
                    break;
                }
            }

            if (isMatched)
                continue;

            for (int j = consonantes.length() - 1; j >= 0; j--)
            {
                if (texto.toLowerCase().charAt(i) == consonantes.charAt(j))
                {
                    cantConsonantes++;
                    break;
                }
            }
        }

        System.out.println("Vocales: " + cantVocales + " | Consonantes: " + cantConsonantes);
    }
}
