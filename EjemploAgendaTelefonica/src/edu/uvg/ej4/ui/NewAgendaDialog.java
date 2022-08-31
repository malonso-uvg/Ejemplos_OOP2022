package edu.uvg.ej4.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import edu.uvg.ej4.controller.Agenda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class NewAgendaDialog extends JDialog {
	private JTextField txtUserName;

	AgendaUI mainForm;

	/**
	 * Create the dialog.
	 */
	public NewAgendaDialog(AgendaUI mainForm) {
		setTitle("Nueva Agenda");
		setBounds(100, 100, 450, 163);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 24, 66, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(86, 28, 338, 20);
		getContentPane().add(txtUserName);
		
		JButton btnCrearAgenda = new JButton("Crear Agenda");
		btnCrearAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtUserName.getText().trim().equals("")) { //if the field is not empty
					mainForm.setMyAgenda(new Agenda( txtUserName.getText().trim() ));
					mainForm.getLblAgenda().setText("Mi Agenda (" + txtUserName.getText().trim() + ")");
					
					JOptionPane.showMessageDialog(
							mainForm, 
							"Agenda creada exitosamente",
                            "Agenda Creada",
                            JOptionPane.INFORMATION_MESSAGE);
					
					
				} else { //field is empty
					JOptionPane.showMessageDialog(
							mainForm, 
							"Debe ingresar un usuario válido",
                            "Empty username",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCrearAgenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearAgenda.setBounds(10, 60, 414, 43);
		getContentPane().add(btnCrearAgenda);
		
		this.mainForm = mainForm;
	}
	


}
