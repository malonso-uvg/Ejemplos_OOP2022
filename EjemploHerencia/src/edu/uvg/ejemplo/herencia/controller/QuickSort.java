/**
 * 
 */
package edu.uvg.ejemplo.herencia.controller;

/**
 * @author moises.alonso
 *
 */
public class QuickSort extends SortingAlgorithm {

	public QuickSort(int[] _numbers) {
		super(_numbers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		quickSort(numbers, 0, numbers.length - 1);
	}

	   /***
		 * Sorts the specified array of objects using recursive quicksort 
		 * sort algorithm.
		 * @param list List of elements need to be sorted
		 * @param inf lower index limit of the array, when you call this method you should us 0
		 * @param sup upper index limit of the array, when you call this method you should us .size  - 1 or .length - 1 
		 */
	   private void quickSort(int[] list, int inf, int sup) {
		   int i = inf - 1;
		   int j = sup;
		   boolean flag = true;
		   int temp = 0;
		   
		   		   
		   if (inf >= sup) {
			   return;
		   }
		   
		   int elem_div = list[sup];
		   
		   
		   while (flag) {
			   while(list[++i] < elem_div) ; //Move the index i until it finds an element bigger than elem_div
			   while((list[--j] > elem_div) && (j > inf)); //Move the index j until it finds element smaller than elem_div
			   
			   if (i < j) {
				   temp = list[i];
				   list[i] = list[j];
				   list[j] = temp;
			   } else {
				   flag = false;
			   }
		   }
		   
		   temp = list[i];
		   list[i] = list[sup];
		   list[sup] = temp;
		   quickSort(list, inf, i - 1);
		   quickSort(list, i + 1, sup);
	   }
	
}
