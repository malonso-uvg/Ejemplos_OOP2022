import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public class DriverProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Programa de figuras gemetricas");
		Scanner in = new Scanner(System.in);
		ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
		
		int opt = 1;
		
		do {
			
			System.out.println("Seleccione la figura");
			System.out.println("1. Circulo");
			System.out.println("2. Rectangulo");
			System.out.println("4. Mostrar");
			System.out.println("5. Salir");
			
			opt = Integer.parseInt(in.nextLine());
			
			switch (opt) {
			case 1:{
				
				System.out.println("Ingrese el radio");
				double elRadio = Double.parseDouble(in.nextLine());
				figuras.add(new Circulo(elRadio));
				
			}break;
			
			case 2:{
				System.out.println("Ingrese base");
				double laBase = Double.parseDouble(in.nextLine());
				System.out.println("Ingrese altura");
				double laAltura = Double.parseDouble(in.nextLine());
				figuras.add(new Rectangulo(laBase, laAltura));
			}break;
			
			case 4:{
				MostrarFiguras(figuras);
			}break;
			
			case 5:{
				
			}break;
			
			default:{
				System.out.println();
			}break;
			
			}
			
		}while(opt != 5);
		

	}
	
	public static void MostrarFiguras(ArrayList<FiguraGeometrica> _figuras) {
		
		for (FiguraGeometrica figura: _figuras) {
			System.out.println("****** ******  ******");
			System.out.println(figura.toString());
			System.out.println("Perimetro: " + figura.calcularPerimetro());
			
			figura.toString();
			System.out.println("Area: " + figura.calcularArea());
		}
	}

}
