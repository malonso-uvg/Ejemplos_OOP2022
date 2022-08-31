/**
 * 
 */
package edu.uvg.ej4.ui;

import java.awt.EventQueue;

/**
 * @author moises.alonso
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
					AgendaUI frame = new AgendaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
