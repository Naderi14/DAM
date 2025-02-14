package ejerciciosCadenas;

/*10. Transforma la cadena de caracteres del String: “ABCD” a ASCII. Para ello debes
desglosar la cadena en un array de caracteres, y cada carácter transformarlo a ASCII.*/

public class String2ASCII {
    public static void main(String[] args)
    {
        String texto = "ABCD";

        for(int i = 0; i < texto.length(); i++)
        {
            System.out.print((int) texto.charAt(i) + " ");
        }
    }
}
