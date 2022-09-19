/**
 * 
 */
package edu.uvg.ejemplo.herencia.controller;

/**
 * @author moises.alonso
 *
 */
public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(int[] _numbers) {
		super(_numbers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		
	      int min;
	      int temp;

	      for (int index = 0; index < numbers.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < numbers.length; scan++) {
	        	 
	        	 if (numbers[scan] < numbers[min]) {
	             	min = scan;
	             } 
	         }
	         
	         // Swap the values
	         temp = numbers[min];
	         numbers[min] = numbers[index];
	         numbers[index] = temp;
	      }
	      
	    
	}

	
}
