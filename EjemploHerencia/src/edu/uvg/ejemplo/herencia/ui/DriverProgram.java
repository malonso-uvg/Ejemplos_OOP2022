/**
 * 
 */
package edu.uvg.ejemplo.herencia.ui;

import java.util.Scanner;

import edu.uvg.ejemplo.herencia.controller.BubbleSort;
import edu.uvg.ejemplo.herencia.controller.QuickSort;
import edu.uvg.ejemplo.herencia.controller.SelectionSort;
import edu.uvg.ejemplo.herencia.controller.SortingAlgorithm;

/**
 * @author moises.alonso
 *
 */
public class DriverProgram {

	static int[] items = {2, 5, 10, 3, 50, 15, 30};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Local variables
		Scanner in = new Scanner(System.in);
		SortingAlgorithm sortingMethod;
		
		System.out.println("Seleccione su método de ordenamiento");
		System.out.println("1. BubbleSort");
		System.out.println("2. SelectionSort");
		System.out.println("3. Quicksort");
		
		int option = Integer.parseInt(in.nextLine());
		
		switch(option) {
		
			case 1:{
				sortingMethod = new BubbleSort(items);
			}break;

			case 2:{
				sortingMethod = new SelectionSort(items);
			}break;
				
			case 3:{
				sortingMethod = new QuickSort(items);
			}break;
			
			default:{
				sortingMethod = new QuickSort(items);
			}break;
		}
		
		System.out.println("*** Original array ***");
		print(items);
		
		sortingMethod.sort();
		
		System.out.println("*** Array after sort ***");
		print(items);
		
		
	}
	
	static void print(int[] _items) {
		for (int i = 0; i < items.length; i++) {
			System.out.println("[ " + i + " ] => " + _items[i]);
		}
	}

}
