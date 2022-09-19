/**
 * 
 */
package edu.uvg.ejemplo.herencia.controller;

/**
 * @author moises.alonso
 *
 */
public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int[] _numbers) {
		super(_numbers);
		this.setNumbers(_numbers);
	}

	@Override
	public void sort() {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}
	
	

}
