/**
 * 
 */
package edu.uvg.ej5.ui;

import javax.swing.JButton;

/**
 * @author MAAG
 *
 */
public class JMatrixButton extends JButton {

	private int row;
	private int column;
	
	public JMatrixButton(int row, int column) {
		super();
		setRow(row);
		setColumn(column);
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	
}
