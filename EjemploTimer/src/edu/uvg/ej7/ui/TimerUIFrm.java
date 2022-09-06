package edu.uvg.ej7.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TimerUIFrm extends JFrame {



	/**
	 * Create the frame.
	 */
	public TimerUIFrm() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblClock = new JLabel("00:00:00");
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClock.setBounds(149, 84, 130, 46);
		getContentPane().add(lblClock);
		
		JButton btnStart = new JButton("Iniciar");
		btnStart.setBounds(169, 162, 89, 23);
		getContentPane().add(btnStart);

	}
}
