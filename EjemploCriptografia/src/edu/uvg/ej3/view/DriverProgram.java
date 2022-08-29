/**
 * 
 */
package edu.uvg.ej3.view;

import java.util.Scanner;

/**
 * @author MAAG
 *
 */
public class DriverProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Seleccione el tipo de interfaz");
		System.out.println("1. Interfaz de cosola");
		System.out.println("2. Interfaz grafica con ventanas");
		System.out.println("3. Salir");
		
		Scanner in = new Scanner(System.in);
		String selection = in.nextLine();
		
		switch (selection) {
		case "1":{
			
			ConsoleUI miGUI = new ConsoleUI(in);
			miGUI.Start();
			
		}break;
		
		case "2":{
			
		}break;
		
		default:{
			
		}break;
		
		}
		
	}

}
