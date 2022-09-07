/**
 * 
 */
package edu.uvg.ej8.ui;

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
					StartFrm frame = new StartFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
