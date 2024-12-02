package boletin5;

/*11-Se pretende realizar un programa para gestionar la lista de participaciones en una competición de
salto de longitud. El número de plazas disponible es de 10. Sus datos se irán introduciendo en el
mismo orden que vayan inscribiéndose los atletas. Diseñar el programa que muestre las siguientes
opciones:

1- Inscribir un participante.
2- Mostrar listado de datos.
3- Mostrar listado por marcas.
4- Finalizar el programa.

Si se selecciona 1, se introducirán los datos de uno de los participantes: Nombre, mejor marca del
2002, mejor marca del 2001 y mejor marca del 2000.
Si se elige la opción 2, se debe mostrar un listado por número de dorsal.
La opción 3 mostrará un listado ordenado por la marca del 2002, de mayor a menor.
Tras procesar cada opción, se debe mostrar de nuevo el menú inicial, hasta que se seleccione la
opción 4, que terminará el programa.*/

public class Ejercicio11 {
    final static int TAM = 10;

    private static String[] nombreParticipante = new String[TAM];
    private static int[] marca2002 = new int[TAM];
    private static int[] marca2001 = new int[TAM];
    private static int[] marca2000 = new int[TAM];

    private static int contadorParticipantes = 0;

    public static void main(String[] args)
    {
        int opcion;
        do {
            menu();
            opcion = Main.sc.nextInt();
            switchMenu(opcion);
        } while (opcion != 4);
    }

    private static void menu()
    {
        System.out.println("(( -- Competición de salto de longitud -- ))" +
                "\n 1. Inscribir un participante." +
                "\n 2. Mostrar listado de datos." +
                "\n 3. Mostrar listado por marcas." +
                "\n 4. Finalizar el programa.");
    }

    private static void switchMenu(int opcion)
    {
        switch (opcion)
        {
            case 1:
                if (!isListaLlena())
                {
                    System.out.println("<- Introduce nombre participante D" + posicionLibre() + " ->");
                    String nombre = Main.sc.next();
                    System.out.println("<- Mejor marca 2002 ->");
                    int m2002 = Main.sc.nextInt();
                    System.out.println("<- Mejor marca 2001 ->");
                    int m2001 = Main.sc.nextInt();
                    System.out.println("<- Mejor marca 2000 ->");
                    int m2000 = Main.sc.nextInt();

                    inscribirParticipante(nombre, m2002, m2001, m2000);
                    System.out.println("<- Participante inscrito ->\n");
                }
                else
                {
                    System.out.println("<!- La lista de participantes se encuentra llena -!>\n");
                }
                break;
            case 2:
                if (!isListaVacia())
                    mostrarDatos();
                else
                    System.out.println("<!- La lista de participantes se encuentra vacia -!>\n");
                break;
            case 3:
                if (!isListaVacia())
                    listaMarcas();
                else
                    System.out.println("<!- La lista de participantes se encuentra vacia -!>\n");
                break;
            case 4:
                System.out.println("<- Hasta la próxima ->\n");
                break;
        }
    }

    private static void inscribirParticipante(String nombre, int m2002, int m2001, int m2000)
    {
        for (int i = 0; i < nombreParticipante.length; i++)
        {
            if (nombreParticipante[i] == null)
            {
                nombreParticipante[i] = nombre;
                marca2002[i] = m2002;
                marca2001[i] = m2001;
                marca2000[i] = m2000;
                contadorParticipantes++;
                break;
            }
        }
    }

    private static void mostrarDatos()
    {
        System.out.println("<- Lista participantes ->");
        for (int i = 0; i < contadorParticipantes; i++)
        {
            System.out.println("Participante: " + nombreParticipante[i] + " | Dorsal: " + i + " | Marca 2002: " + marca2002[i] + "m | Marca 2001: " + marca2001[i] + "m | Marca 2000: " + marca2000[i] + "m");
        }
        System.out.println();
    }

    private static void listaMarcas()
    {
        System.out.println("<- Lista marcas 2002 ordenadas ->");
        int[] listaAuxiliar = new int[TAM];

        listaAuxiliar[0] = marca2002[0];

        for (int i = 0; i < contadorParticipantes; i++)
        {
            int maxIndex = i;
            for (int j = i + 1; j < contadorParticipantes; j++)
            {
                if (marca2002[j] > marca2002[i])
                    maxIndex = j;
            }
        }

        for (int i = 0; i < contadorParticipantes; i++)
        {
            for (int j = 0; j < contadorParticipantes; j++)
            {
                if (marca2002[j] == listaAuxiliar[i])
                {
                    System.out.println("Nombre: " + nombreParticipante[j] + " | Marca 2002: " + marca2002[j] + "m");
                }
            }
        }
        System.out.println();
    }

    private static boolean isListaLlena()
    {
        boolean isListaLlena = true;

        for (int i = 0; i < nombreParticipante.length; i++)
        {
            if (nombreParticipante[i] == null)
                isListaLlena = false;
        }

        return isListaLlena;
    }

    private static boolean isListaVacia()
    {
        boolean isListaVacia = true;

        for (int i = 0; i < nombreParticipante.length; i++)
        {
            if (nombreParticipante[i] != null)
                isListaVacia = false;
        }

        return isListaVacia;
    }

    private static int posicionLibre()
    {
        int posicion = -1;

        for (int i = 0; i < nombreParticipante.length; i++)
        {
            if (nombreParticipante[i] == null)
            {
                posicion = i;
                break;
            }
        }

        return posicion;
    }
}
