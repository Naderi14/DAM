/*
* EjemploCondiciones.java 9 oct 2024
*
*
* ©Copyright 2024 Leyre Iriarte <liriarte@ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package ejemploBucles;

import java.util.Scanner;

public class EjemploCondiciones {
	public static void main(String[] args) {
		System.out.println("Dame tu edad:");
		Scanner leer = new Scanner(System.in);
		double edad = leer.nextDouble();
		
		if (edad > 18 || edad == 18) {
			// Aquí la condición es verdadera
			System.out.println("Eres mayor de edad.");
		} else {
			System.out.println("Eres menor de edad.");
		}
	}
}
