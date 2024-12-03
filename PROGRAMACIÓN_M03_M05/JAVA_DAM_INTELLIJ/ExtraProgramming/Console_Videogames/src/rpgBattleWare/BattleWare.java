package rpgBattleWare;

import java.util.Scanner;

/*
* El juego tendra que poder empezar una nueva partida y elegir crear personaje de una clase
* */

public class BattleWare {
    private static Scanner leer = new Scanner(System.in);
    private Personaje pj;

    public static void main(String[] args)
    {
        System.out.println("####\t  Bienvenido a BATTLEWARE\t\t####\n");
        String opcion;

        do
        {
            opcion = mainMenu();
        } while (!opcion.equals("3"));
    }

    private static String mainMenu() {
        System.out.println(
                "1. Nueva partida\n" +
                "2. Cargar partida\n" +
                "3. Salir"
        );

        String opcion = leer.next();

        if (Utilities.isStringNumeric(opcion))
        {
            switch (opcion)
            {
                case "1":
                    elegirNuevoPersonaje();
                    break;
                case "2":
                case "3":
                    System.out.println("<#-- HASTA LA PRÓXIMA --#>");
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

        return opcion;
    }

    public static void elegirNuevoPersonaje()
    {

    }
}
