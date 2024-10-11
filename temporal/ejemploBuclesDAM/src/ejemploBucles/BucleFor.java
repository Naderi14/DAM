/*
* BucleFor.java 10 oct 2024
*
*
* ©Copyright 2024 Leyre Iriarte <liriarte@ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package ejemploBucles;

public class BucleFor {
	public static void main(String[] args) {
//Escribir numeros pares entre 0 y 100
		System.out.println("Los numeros pares son:");
		// i++
		// para i=0 hasta 100 incremento 1 hacer

		for (int i = 0; i < 100; i = i + 2) {
			System.out.println("El numero par es: " + i);
		}
	}
}
