/**
 * 
 */
package edu.uvg.ej5.model;

/**
 * @author MAAG
 *
 */
public class Puzzle {

	int rows_qty;
	int columns_qty;
	
	int[][] internalPuzzle;
	
	public Puzzle(int rows_qty, int columns_qty) throws Exception{
		setRows_qty(rows_qty);
		setColumns_qty(columns_qty);
		setInternalPuzzle(new int[rows_qty][columns_qty]);
	}
	
	public Puzzle(int[][] _puzzle) throws Exception{
		setRows_qty(_puzzle.length);
		setColumns_qty(_puzzle[0].length);
		setInternalPuzzle(_puzzle);
	}

	/**
	 * @return the rows_qty
	 */
	public int getRows_qty() {
		return rows_qty;
	}

	/**
	 * @param rows_qty the rows_qty to set
	 */
	public void setRows_qty(int rows_qty) throws Exception{
		if (rows_qty > 0) {
			this.rows_qty = rows_qty;
		} else {
			throw new Exception("Invalid dimensions");
		}
	}

	/**
	 * @return the columns_qty
	 */
	public int getColumns_qty() {
		return columns_qty;
	}

	/**
	 * @param columns_qty the columns_qty to set
	 */
	public void setColumns_qty(int columns_qty) throws Exception{
		
		if (columns_qty > 0) {
			this.columns_qty = columns_qty;
		} else {
			throw new Exception("Invalid dimensions");
		}
		
	}

	/**
	 * @return the internalPuzzle
	 */
	public int[][] getInternalPuzzle() {
		return internalPuzzle;
	}

	/**
	 * @param internalPuzzle the internalPuzzle to set
	 */
	public void setInternalPuzzle(int[][] internalPuzzle) {
		this.internalPuzzle = internalPuzzle;
	}
	
	
}
