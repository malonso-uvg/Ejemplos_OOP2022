package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Contacto;
import controller.IDataDriver;
import controller.SaveContactInFile;

public class MainWindow extends JFrame {
	private JTextField textNombre;
	private JTextField txtApellido;
	private JTextField txtNumeroTelefono;


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(40, 26, 45, 13);
		getContentPane().add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(95, 23, 96, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setBounds(40, 59, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(95, 56, 96, 19);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefonos:");
		lblNewLabel_2.setBounds(40, 92, 67, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setBounds(117, 85, 244, 19);
		getContentPane().add(txtNumeroTelefono);
		txtNumeroTelefono.setColumns(10);
		
		JButton btnGuardarContacto = new JButton("Guardar");
		btnGuardarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto newContact = new Contacto();
				newContact.setFirstname( textNombre.getText() );
				newContact.setLastname( txtApellido.getText() );
				
				String[] telefonos = txtNumeroTelefono.getText().split(",");
				for (int i = 0; i < telefonos.length; i++) {
					newContact.getPhone_number().add(telefonos[i]);
				}
				newContact.setId(1);
				
				IDataDriver saveContact = new SaveContactInFile("C:\\ejemplos\\contacto.txt", newContact);
				
				saveContact.connectDataSource();
				saveContact.saveData();
				saveContact.dissconnectDataSource();
				
			}
		});
		btnGuardarContacto.setBounds(40, 127, 85, 21);
		getContentPane().add(btnGuardarContacto);

	}
}
