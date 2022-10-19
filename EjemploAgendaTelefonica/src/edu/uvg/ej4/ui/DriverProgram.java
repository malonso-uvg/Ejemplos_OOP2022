/**
 * 
 */
package edu.uvg.ej4.ui;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author moises.alonso
 *
 */
public class DriverProgram {
	
	public static Properties config;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*Load config file*/
		config = new Properties();
		
		try {
			FileInputStream propFiles = new FileInputStream("./src/config.properties");
			config.load(propFiles);
			System.out.println("Datastore set successfully");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaUI frame = new AgendaUI(config);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
