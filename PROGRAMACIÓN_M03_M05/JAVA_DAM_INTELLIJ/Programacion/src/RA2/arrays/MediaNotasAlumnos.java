package RA2.arrays;

/*Crear un programa que lea por teclado la nota de los alumnos de una clase y calcule la
nota media del grupo. Y que también muestre los alumnos con notas superiores a la
media. El número de alumnos se leerá por teclado.*/

public class MediaNotasAlumnos {
    public static void main(String[] args)
    {
        System.out.println("<- Cuantos alumnos hay en clase? ->");
        int cantidadAlumnos = Main.scanner.nextInt();
        int[] notas = new int[cantidadAlumnos];
        int suma = 0;

        for (int i = 0; i < notas.length; i++)
        {
            System.out.println("<- Nota alumno " + (i + 1) + ": ");
            notas[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < notas.length; i++)
        {
            suma += notas[i];
        }

        double media = (double) suma / notas.length;

        System.out.println("Media clase: " + media + "\n");

        for (int i = 0; i < notas.length; i++)
        {
            if (notas[i] > media)
                System.out.println("Nota alumno " + (i + 1) + ": " + notas[i]);
        }
    }
}
