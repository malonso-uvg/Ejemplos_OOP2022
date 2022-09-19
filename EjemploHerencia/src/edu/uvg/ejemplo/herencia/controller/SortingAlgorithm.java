/**
 * 
 */
package edu.uvg.ejemplo.herencia.controller;

/**
 * @author moises.alonso
 *
 */
public abstract class SortingAlgorithm {

	int[] numbers;

	/**
	 * @return the numbers
	 */
	public int[] getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * This method will sort an array of integers previously set.
	 */
	public void sort() {
		
	}
	
	/**
	 * If the array "numbers" has not been set, then you need pass as parameter
	 * @param _numbers the array you need to sort
	 */
	public void sort(int[] _numbers) {
		setNumbers(_numbers);
		this.sort();
	}
}
