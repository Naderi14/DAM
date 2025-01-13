import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GuiTest {

    /*public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número 1");
        int numero1 = sc.nextInt();
        System.out.println("Introduce el número 2");
        int numero2 = sc.nextInt();
        int potencia = 1;

        for (int i = 0; i < numero2; i++) {
            potencia = numero1*potencia;
        }
        System.out.println("potencia: "+potencia);
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola, introduce los valores");
        double numero1 = sc.nextDouble();
        double numero2 = sc.nextDouble();

        System.out.println("1. sumar" +
                "\n2. restar" +
                "\n3. multiplicar" +
                "\n4. dividir");
        int opcion = sc.nextInt();
        double resultado =  0;

        if(opcion == 1){
            resultado = numero1 + numero2;
        }
        if(opcion == 2){
            resultado = numero1 - numero2;
        }
        if(opcion == 3){
            resultado = numero1 * numero2;
        }
        if(opcion == 4){
            resultado = numero1 / numero2;
        }
        System.out.println("Resultado: "+resultado);
    }*/

    /*public static void main(String[] args) {
        System.out.println(5 % 2);
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola mis bubuamigos , introduzca el primer valor");
        int numero1 = sc.nextInt();
        System.out.println("Hola mis bubuamigos , introduzca el segundo valor");
        int numero2 = sc.nextInt();
        int mayor;

        if (numero1  >  numero2){
            mayor = numero1;
        }
        else
        {
            mayor = numero2;
        }

        System.out.println("El numero mayor es: "+ mayor);

        if ( mayor % 2 == 0 ) {
            System.out.println("Es par");
        }
        else
        {
            System.out.println("Es impar");
        }
    }*/

    /*public static void main(String[] args) {
        Que me diga todos los números del 1 al 1000 que al dividirse me den de residuo 2
        Scanner sc = new Scanner(System.in);
        int numero;
        int contador = 0;

        do
        {
            System.out.println("Introduce el número del 1 al 1000: ");
            numero = sc.nextInt();
        } while (numero <= 0 || numero > 1000);

        for (int i = 0; i <= 1000; i++)
        {
            if (i % numero == 2)
            {
                System.out.println("Resto de " + i + " / " + numero + " = 2");
                contador++;
            }
        }
        System.out.println("En total han sido " + contador + " números");
    }*/

    /*public static void main(String[] args) {
        int numeroEntero = 4;
        double numeroReal = 4.5;
        String texto = "Hola mi bubu, como estas";
        char caracter = '+';
        boolean interruptor = false;

        if (texto.toLowerCase().equals("texto"))
        {
            System.out.println("Es verdadera la condicion");
        }
        else
        {
            System.out.println("Es falsa la condición");
        }

        for (int indice = 0; indice < texto.length(); indice++)
        {
            System.out.println(texto.charAt(indice));
        }
    }*/

    /*public static void main(String[] args) {
        Quiero que el usuario introduzca una frase, y luego una letra, y ha de decir si hay esa letra en
        el texto, o si no la h
        Scanner sc = new Scanner(System.in);

        System.out.println( "Introdicu una frase");
        String texto = sc.nextLine();
        String[] textoPorLetras = texto.split("");

        System.out.println( "Introduce una letra para buscar");
        String letra = sc.next();

        int contadorCoincidencias = 0;
        for (int i = 0; i < texto.length(); i++)
        {
            if (textoPorLetras[i].equals(letra))
            {
                contadorCoincidencias++;
            }
        }

        System.out.println("Total de letras '" + letra + "' encontradas: " + contadorCoincidencias);
    }*/

    public static void main(String[] args) {
        /*Quiero que el usuario introduzca una frase, y luego una letra, y ha de decir si hay esa letra en
        el texto, o si no la hay*/
        Scanner sc = new Scanner(System.in);

        System.out.println( "Introdicu una frase");
        String texto = sc.nextLine();

        System.out.println( "Introduce una letra para buscar");
        String letra = sc.next();

        if (texto.contains(letra))
        {
            System.out.println("El texto contiene la letra");
        }
        else
        {
            System.out.println("El texto no contiene la letra");
        }
    }
}