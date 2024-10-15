package programacion.RA1.programacionModularEjercicios;

/*Realice un programa modular donde se calcule la suma de los dígitos de
un número que el usuario introduzca por pantalla.*/

import java.util.Scanner;

public class Ejercicio1 {
    public void sumarDigitosDeNumero()
    {
        Scanner leer = new Scanner(System.in);

        int sumaDigitos;

        System.out.println("Introduce un número para sumar sus digitos");
        int numero = leer.nextInt();

        if (isInto(numero))
        {
            if (numero < 10)
            {
                sumaDigitos = numero;
            }
            else if (numero < 100)
            {
                
            }
            else
            {

            }
        }
    }

    public boolean isInto(int numero)
    {
        if (numero > 0 && numero < 1000)
        {
            return true;
        }
        return false;
    }
}
