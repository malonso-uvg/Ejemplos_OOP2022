import java.util.Scanner;

import edu.uvg.factory.CustomList;
import edu.uvg.factory.NumeroRepetidoException;

/**
 * 
 */

/**
 * @author MAAG
 *
 */
public class DriverProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("Ingrese un numero que sera el dividendo");
			int dividendo = Integer.parseInt(in.nextLine());
			
			System.out.println("Ingrese un numero que sera el divisor");
			int divisor = Integer.parseInt(in.nextLine());
			
			System.out.println("El cociente es: " + dividendo / divisor);
			
			System.out.println("El residuo: " + dividendo % divisor);
			
			int value = 1;
			CustomList miList = new CustomList();
			while (value != 0) {
				System.out.println("Ingrese un numero y 0 para salir");
				value = Integer.parseInt(in.nextLine());
				miList.insertNumber(value);
			}
			
			for (int i = 0; i< miList.internalList.size(); i++) {
				System.out.println(i + " -> " + miList.internalList.get(i));
			}
			

			
		}catch(java.lang.NumberFormatException nfe) {
			System.out.println("El problema se debio a que ingreso letras en lugar de numeros" + nfe.getMessage());
			nfe.printStackTrace();
		}
		catch(java.lang.ArithmeticException ae) {
			System.out.println("El problema se dio ya que el divisor no puede ser 0" + ae.getMessage());
			ae.printStackTrace();
		}catch(NumeroRepetidoException nre) {
			System.out.println("El problema se dio ya que ingreso numeros repetidos" + nre.getMessage());
			nre.printStackTrace();
		}finally {
			System.out.println("Cerrar base de datos");
		}
	}

}
