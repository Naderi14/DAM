/*Crea un programa que guarde en un array 10 números enteros leídos por teclado. A
continuación, se recorre el array y calcula cuántos números son positivos, cuántos
son negativos y cuántos ceros. Muestra al final el valor de cada caso.

Se debe crear un array de tamaño 10.
Después se recorrerá ese array y con tres variables que usaremos de contador, iremos
viendo si son positivos, negativos o ceros.
Muestra al final el resultado en cada caso.*/

public class NumerosPositivosNegativos {
    public static void main(String[] args)
    {
        int[] numeros = new int[10];
        int contadorPositivos = 0, contadorNegativos = 0, contadorZeros = 0;

        for (int i = 0; i < numeros.length; i++)
        {
            System.out.println("<- Número " + i + ": ");
            numeros[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i++)
        {
            if (numeros[i] > 0)
                contadorPositivos++;
            else if (numeros[i] == 0)
                contadorZeros++;
            else if (numeros[i] < 0)
                contadorNegativos++;
        }

        System.out.println("Positivos: " + contadorPositivos + " | Negativos: " + contadorNegativos + " | Zeros: " + contadorZeros);
    }
}
