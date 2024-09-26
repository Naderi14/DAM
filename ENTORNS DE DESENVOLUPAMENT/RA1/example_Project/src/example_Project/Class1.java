/*
* Class1.java 26 sept 2024
*
*
* ©Copyright 2024 Juan Francisco Sanchez Castelblanque <ditarex95@alumnes.ilerna.com>
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package example_Project;

public class Class1 {
	public static void main(String[] args) {
			mostrarCadenas(args);
	}
	
	public static void mostrarCadenas(String[] args) {		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}	
	}
}
