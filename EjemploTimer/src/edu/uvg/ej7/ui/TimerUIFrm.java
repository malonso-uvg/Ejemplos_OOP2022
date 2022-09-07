package edu.uvg.ej7.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import edu.uvg.ej7.model.Clock;

import java.awt.event.ActionEvent;

public class TimerUIFrm extends JFrame {

	Timer timer;
	Clock myClock;

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
		
		myClock = new Clock();
		
		timer = new Timer (1000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	myClock.work();
		    	lblClock.setText(myClock.getHours() + ":" + myClock.getMinutes() + ":" + myClock.getSeconds()); 
		    }
		});
		
		JButton btnStart = new JButton("Iniciar");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		btnStart.setBounds(169, 162, 89, 23);
		getContentPane().add(btnStart);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		btnDetener.setBounds(169, 210, 85, 21);
		getContentPane().add(btnDetener);
		
		

	}
}
