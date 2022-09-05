/**
 * 
 */
package edu.uvg.ej5.ui;

import java.awt.EventQueue;

/**
 * @author MAAG
 *
 */
public class DriverProgram {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPuzzleUI frame = new MainPuzzleUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
