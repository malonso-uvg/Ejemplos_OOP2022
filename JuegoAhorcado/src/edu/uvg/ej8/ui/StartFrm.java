package edu.uvg.ej8.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrm extends JFrame {

	private JTextField txtPalabra;

	/**
	 * Create the frame.
	 */
	public StartFrm() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese la palabra:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 160, 30);
		getContentPane().add(lblNewLabel);
		
		txtPalabra = new JTextField();
		txtPalabra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPalabra.setBounds(164, 25, 145, 30);
		getContentPane().add(txtPalabra);
		txtPalabra.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AhorcadoDialog newGame = new AhorcadoDialog(txtPalabra.getText());
				newGame.setVisible(true);
			}
		});
		
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIniciar.setBounds(327, 25, 85, 30);
		getContentPane().add(btnIniciar);
	}

}
