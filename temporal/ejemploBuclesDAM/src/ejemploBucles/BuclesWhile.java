/*
* Bucles.java 9 oct 2024
*
*
* ©Copyright 2024 Leyre Iriarte <liriarte@ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package ejemploBucles;

import java.util.Scanner;

public class BuclesWhile {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);

		System.out.print("Dame un número:");
		int numero = leer.nextInt();
		while (numero != 0) {
			System.out.print("Dame otro número: ");
			numero = leer.nextInt();
		}
		System.out.println("¡Eureka! ¡Has encontrado el número!");


	}
}

/*
 * int numeroGrandePrimero = leer.nextInt();
 * System.out.println(numeroGrandePrimero);
 */
