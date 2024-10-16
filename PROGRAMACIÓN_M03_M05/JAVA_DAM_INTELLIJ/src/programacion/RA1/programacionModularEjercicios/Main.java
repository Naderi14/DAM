package programacion.RA1.programacionModularEjercicios;

/*
* Juan Francisco Sanchez Castelblanque DAM 1r
* */

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce el número de Ejercicio");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                Ejercicio1.sumarDigitosDeNumero();
                break;
            case 2:
                Ejercicio2.numeroFactorial();
                break;
            case 3:
                Ejercicio3.expCubo();
                break;
            case 4:
                Ejercicio4.menorDeDos();
                break;
            case 5:
                Ejercicio5.positiveNegativeZero();
                break;
            case 6:
                Ejercicio6.sumarDigitosConFuncion();
                break;
            case 7:
                Ejercicio7.digitCounter();
                break;
            case 8:
                Ejercicio8.cambioDeDivisa();
                break;
            case 9:
                Ejercicio9.numeroPrimoOno();
                break;
            case 10:
                Ejercicio10.convertidorBinario();
                break;
            case 11:
                Ejercicio11.chekPalabraPalindroma();
                break;
            case 12:
                Ejercicio12.areaDeTresFiguras();
                break;
        }
    }
}