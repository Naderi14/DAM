package programacion.Extra.rpgBattleWare;

import java.util.Scanner;

public class BattleWare {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("####\t  Bienvenido a BATTLEWARE\t\t####\n");

        System.out.println(
                "1. Nueva partida\n" +
                "2. Cargar partida\n" +
                "3. Salir"
        );

        String opcion = leer.next();

        if (isNumeric(opcion))
        {
            switch (opcion)
            {
                case "1":
                    elegirNuevoPersonaje();
                    break;
                case "2":
                case "3":
                    System.out.println("<#-- Aun no esta hecha esta opción del menú --#>");
                    break;
                default:
                    System.out.println("<!!-- No es una opción de menú válida --!!>");
                    break;
            }
        }
        else
        {
            System.out.println("<!!-- Has introducido un valor incorrecto --!!>");
        }
    }

    public static void elegirNuevoPersonaje()
    {

    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
