/*
* Money.java 11 oct 2024
*
*
* ©Copyright 2024 Leyre Iriarte <liriarte@ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package ejemploBucles;

import java.util.Scanner;

public class Money {
	public static void main(String[] args) {
		int cashTotal = 0;
		System.out.println("Dame el número de euros que quieres convertir:");
		Scanner leer = new Scanner(System.in);
		double euros = leer.nextDouble();
		while (euros >= 200) {
			euros = euros - 200;
			cashTotal++;
		}
		if (euros >= 100) {
			euros = euros - 100;
			cashTotal++;
		}
		if (euros >= 50) {
			euros = euros - 50;
			cashTotal++;
		}
		while (euros >= 20) {
			euros = euros - 20;
			cashTotal++;
		}
		if (euros >= 10) {
			euros = euros - 10;
			cashTotal++;
		}
		if (euros >= 5) {
			euros = euros - 5;
			cashTotal++;
		}
		while (euros >= 2) {
			euros = euros - 2;
			cashTotal++;
		}
		if (euros >= 1) {
			euros = euros - 1;
			cashTotal++;
		}
		if (euros >= 0.50) {
			euros = euros - 0.50;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		while (euros >= 0.20) {
			euros = euros - 0.20;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		if (euros >= 0.10) {
			euros = euros - 0.10;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		if (euros >= 0.05) {
			euros = euros - 0.05;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		while (euros >= 0.02) {
			euros = euros - 0.02;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		if (euros >= 0.01) {
			euros = euros - 0.01;
			euros = Math.round(euros * 100.0) / 100.0;
			cashTotal++;
		}
		System.out.println("El número de billetes y " + 
		"monedas total es: " + cashTotal);

		leer.close();
	}
}
