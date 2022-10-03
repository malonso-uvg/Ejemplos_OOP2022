/**
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * @author MAAG
 *
 */
public class EJemploGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Integer[] misValores = {4, 2, 10, 3, 7, 1 };
		BubbleSort<Integer> mySort = new BubbleSort<Integer>();
		System.out.println("NUMEROS DESORDENADOS");
		EscribirArreglo(misValores);
		System.out.println("ORDENANDO...");
		mySort.sort(misValores, new ComparadorEnteros<Integer>());
		System.out.println("NUMEROS ORDENADOS");
		EscribirArreglo(misValores);
		
		Estudiante[] misEstudiantes_v1 = new Estudiante[5];
		misEstudiantes_v1[0] = new Estudiante(1234, "Moises", 90);
		misEstudiantes_v1[1] = new Estudiante(1235, "Antonio", 50);
		misEstudiantes_v1[2] = new Estudiante(1236, "Estudiante1", 50);
		misEstudiantes_v1[3] = new Estudiante(1237, "Estudiante1", 50);
		misEstudiantes_v1[4] = new Estudiante(1240, "Estudiante3", 100);
		
		BubbleSort<Estudiante> mySortEstudiante = new BubbleSort<Estudiante>();
		System.out.println("ESTUDIANTES DESORDENADOS");
		EscribirArreglo(misEstudiantes_v1);
		System.out.println("ORDENANDO...");
		mySortEstudiante.sort(misEstudiantes_v1, new ComparadorEstudiantes<Estudiante>());
		System.out.println("NUMEROS ORDENADOS");
		EscribirArreglo(misEstudiantes_v1);
		
		ArrayList<String> misPalabras = new ArrayList<String>();
		
		misPalabras.add("Hola");
		misPalabras.add("Adios");
		misPalabras.add("Mundo");
		misPalabras.add("UVG");
		misPalabras.add("Programacion");
		
		System.out.println("PALABRAS DESORDENADAS");
		EscribirArrayList(misPalabras);
		System.out.println("ORDENANDO");
		Collections.sort(misPalabras);
		System.out.println("PALABRAS ORDENADAS");
		EscribirArrayList(misPalabras);
		
	}
	
	public static void EscribirArrayList(ArrayList _items) {
		for (int i = 0; i < _items.size(); i++) {
			System.out.println("[" + i + "] => " + _items.get(i).toString());
		}
	}
	
	public static void EscribirArreglo(Estudiante[] misEstudiantes) {
		for (int i = 0; i < misEstudiantes.length; i++) {
			System.out.println("[" + i + "] => " + misEstudiantes[i].toString());
		}
	}
	
	public static void EscribirArreglo(Integer[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println("[" + i + "] => " + arreglo[i]);
		}
	}

}
