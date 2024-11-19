package RA2.arrays;

/*Crea un programa que lea el nombre y el sueldo de 20 empleados y muestre el nombre
y el sueldo del empleado que más gana.*/

public class SueldoAndEmpleados {
    public static void main(String[] args)
    {
        int[] sueldos = new int[20];
        String[] empleados = new String[20];

        System.out.println("<- Introduce un seguido de 20 empleados con sus nombres y salarios ->");

        for (int i = 0; i < sueldos.length; i++)
        {
            System.out.println("<- Nombre empleado " + (i + 1) + ": ");
            empleados[i] = Main.scanner.next();
            System.out.println("<- Sueldo empleado " + (i + 1) + ": ");
            sueldos[i] = Main.scanner.nextInt();
        }

        int sueldoMayor = sueldos[0];
        String nombreMayor = empleados[0];

        for (int i = 0; i < sueldos.length; i++)
        {
            if (sueldoMayor < sueldos[i])
            {
                sueldoMayor = sueldos[i];
                nombreMayor = empleados[i];
            }
        }

        System.out.println("Empleado " + nombreMayor + " con mayor sueldo de " + sueldoMayor + "€");
    }
}
