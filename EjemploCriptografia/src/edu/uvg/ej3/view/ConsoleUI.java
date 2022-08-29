/**
 * 
 */
package edu.uvg.ej3.view;

import java.util.ArrayList;
import java.util.Scanner;

import edu.uvg.ej3.controller.CaesarCipher;
import edu.uvg.ej3.controller.TranspositionCipher;

/**
 * @author MAAG
 *
 */
public class ConsoleUI {

	private Scanner entrada;
	
	public ConsoleUI(Scanner in) {
		entrada = in;
	}
	
	public void Start() {
		
		String selection = "4";
		
		do 
		{
			System.out.println("Seleccione su método de cifrado / decifrado");
			System.out.println("1. Algoritmo del Cesar");
			System.out.println("2. Algoritmo de Transposicion");
			System.out.println("3. Ambos");
			System.out.println("4. Salir");
			
			selection = entrada.nextLine();
			
			switch (selection) {
			
			case "1":{
				System.out.println(" ** Algoritmo del Cesar **");
				System.out.println("a. codificar");
				System.out.println("b. decodificar");
				
				selection = entrada.nextLine();
				
				if (selection.equalsIgnoreCase("a")) {
					
					System.out.println("Ingrese el valor entero de desplazamiento");
					int shift = Integer.parseInt(entrada.nextLine());
					
					CaesarCipher myCipher = new CaesarCipher(shift);
					
					System.out.println("Ingrese el texto a cifrar");
					
					String cipherText = myCipher.encode(entrada.nextLine());
					
					System.out.println("El texto cifrado es: ");
					System.out.println(cipherText);
					
					
				} else if (selection.equalsIgnoreCase("b")) {
					
					System.out.println("Ingrese el valor entero de desplazamiento usado al encriptar");
					int shift = Integer.parseInt(entrada.nextLine());
					
					CaesarCipher myCipher = new CaesarCipher(shift);
					
					System.out.println("Ingrese el texto a decifrar");
					
					String plainText = myCipher.decode(entrada.nextLine());
					
					System.out.println("El texto original es: ");
					System.out.println(plainText);
					
				} else {
					System.out.println("Opcion no valida");
				}
				
			}break;
			
			case "2":{
				System.out.println(" ** Algoritmo de transposicion **");
				System.out.println("a. codificar");
				System.out.println("b. decodificar");
				
				selection = entrada.nextLine();
				
				if (selection.equalsIgnoreCase("a")) {
					
					TranspositionCipher myCipher = new TranspositionCipher();
					
					System.out.println("Ingrese el texto a cifrar");
					
					String cipherText = myCipher.encode(entrada.nextLine());
					
					System.out.println("El texto cifrado es: ");
					System.out.println(cipherText);
					
				} else if (selection.equalsIgnoreCase("b")) {
					
					TranspositionCipher myCipher = new TranspositionCipher();
					
					System.out.println("Ingrese el texto a decifrar");
					
					String plainText = myCipher.decode(entrada.nextLine());
					
					System.out.println("El texto original es: ");
					System.out.println(plainText);
					
				} else {
					System.out.println("Opcion no valida");
				}
			}break;
			
			case "3":{
				System.out.println(" ** Algoritmo Mixto **");
				System.out.println("a. codificar");
				System.out.println("b. decodificar");
				
				selection = entrada.nextLine();
				
				if (selection.equalsIgnoreCase("a")) {
					

					System.out.println("Ingrese el valor entero de desplazamiento");
					int shift = Integer.parseInt(entrada.nextLine());
					
					CaesarCipher myCipher = new CaesarCipher(shift);
					
					System.out.println("Ingrese el texto a cifrar");
					
					String cipherText = myCipher.encode(entrada.nextLine());
					
					TranspositionCipher myCipher2 = new TranspositionCipher();
					
					String cipherText2 = myCipher2.encode(cipherText);
					
					System.out.println("El texto cifrado es: ");
					System.out.println(cipherText2);
					
				} else if (selection.equalsIgnoreCase("b")) {
					
					TranspositionCipher myCipher = new TranspositionCipher();
					
					System.out.println("Ingrese el texto a decifrar");
					
					String plainText = myCipher.decode(entrada.nextLine());
					
					System.out.println("Ingrese el valor entero de desplazamiento usado al encriptar");
					int shift = Integer.parseInt(entrada.nextLine());
					
					CaesarCipher myCipher2 = new CaesarCipher(shift);
					
					String plainText2 = myCipher2.decode(plainText);
					
					
					System.out.println("El texto original es: ");
					System.out.println(plainText2);
					
				} else {
					System.out.println("Opcion no valida");
				}
			}break;
			
			case "4":{
				System.out.println("Hasta luego");
			}break;
			
			default:{
				System.out.println("Opcion no valida");
			}break;
		
			}
			
		}while (!selection.equals("4"));
	}
	
}
