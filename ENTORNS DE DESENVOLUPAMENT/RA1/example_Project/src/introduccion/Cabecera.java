/*
* Capecera.java 26 sept 2024
*
*
* ©Copyright 2024 Juan Francisco Sanchez Castelblanque <ditarex95@alumnes.ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package introduccion;
import java.util.Scanner;
public class Cabecera {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce un número y te lo diré a cambio...");
		int numero = leer.nextInt();
		System.out.println("Has introducido: " + numero);
	}
}
