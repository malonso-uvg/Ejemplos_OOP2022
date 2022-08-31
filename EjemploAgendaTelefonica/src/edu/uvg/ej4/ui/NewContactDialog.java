package edu.uvg.ej4.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.uvg.ej4.model.Contact;
import edu.uvg.ej4.model.Email;
import edu.uvg.ej4.model.Phone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NewContactDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtContactFirstName;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtApellido;
	private AgendaUI mainForm;
	
	/**
	 * Create the dialog.
	 */
	public NewContactDialog(AgendaUI mainForm) {
		setTitle("Nuevo Contacto");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.mainForm = mainForm;
		
		JLabel lblNewLabel = new JLabel("NUEVO CONTACTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 414, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 129, 66, 24);
		getContentPane().add(lblNewLabel_1);
		
		txtContactFirstName = new JTextField();
		txtContactFirstName.setBounds(86, 69, 338, 20);
		getContentPane().add(txtContactFirstName);
		txtContactFirstName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 65, 66, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(86, 133, 232, 20);
		getContentPane().add(txtTelefono);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 164, 66, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(86, 168, 232, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 94, 66, 24);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(86, 100, 338, 20);
		getContentPane().add(txtApellido);
		
		DefaultComboBoxModel phoneTypetList = new DefaultComboBoxModel();
		phoneTypetList.addElement("Personal");
		phoneTypetList.addElement("Oficina");
		phoneTypetList.addElement("Casa");
		phoneTypetList.addElement("Trabajo");
		
		JComboBox cmbPhoneType = new JComboBox();
		cmbPhoneType.setBounds(337, 133, 87, 21);
		cmbPhoneType.setModel(phoneTypetList);
		cmbPhoneType.setSelectedIndex(0);
		
		getContentPane().add(cmbPhoneType);

		DefaultComboBoxModel EmailTypetList = new DefaultComboBoxModel();
		EmailTypetList.addElement("Personal");
		EmailTypetList.addElement("Trabajo");
		EmailTypetList.addElement("Otro");
		
		JComboBox cmbEmailType = new JComboBox();
		cmbEmailType.setBounds(337, 168, 87, 21);
		cmbEmailType.setModel(EmailTypetList);
		cmbEmailType.setSelectedIndex(0);
		getContentPane().add(cmbEmailType);
		
		JButton btnNewContact = new JButton("Guardar Contacto");
		btnNewContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( (!txtContactFirstName.getText().trim().equals(""))
						&& !(txtApellido.getText().trim().equals(""))) {
					
					String firstName = txtContactFirstName.getText().trim();
					String lastName = txtApellido.getText().trim();
					
					//Check if contact exists or not
					if (mainForm.getMyAgenda() != null) {
						
						Contact theContact = mainForm.getMyAgenda().searchByName(firstName, lastName);
						String telefono = txtTelefono.getText().trim();
						String email = txtEmail.getText().trim();
						
						if ( !telefono.equals("") || !email.equals("") ) {
						
							boolean isNewContact = false;
							
							if (theContact == null) { //It means contact does not exists
								theContact = new Contact(firstName, lastName);
								isNewContact = true;
							} 
							
							if (!telefono.equals("")) {
								theContact.getPhoneNumbers().add(new Phone(Long.parseLong(telefono), cmbPhoneType.getSelectedItem().toString()));
							}
							
							if (!email.equals("")) {
								theContact.getEmailAddresses().add(new Email(email, cmbEmailType.getSelectedItem().toString() ));
							}
							
							if (isNewContact) {
								mainForm.getMyAgenda().getContacts().add(theContact);
							}
							
							mainForm.showInformationOnUI();
							
							JOptionPane.showMessageDialog(
									mainForm, 
									"Contacto agregado exitosamente",
		                            "Contacto creado",
		                            JOptionPane.INFORMATION_MESSAGE);
							
						} else {
							
							JOptionPane.showMessageDialog(
									mainForm, 
									"Debe ingresar al menos telefono o email",
		                            "Campos vacíos",
		                            JOptionPane.ERROR_MESSAGE);
							
						}

						
						
					} else {
						
						JOptionPane.showMessageDialog(
								mainForm, 
								"Debe crear una agenda de primero",
	                            "Agenda vacía",
	                            JOptionPane.ERROR_MESSAGE);
						
					}
					
				} else {
					JOptionPane.showMessageDialog(
							mainForm, 
							"Debe ingresar nombre y apellido válidos",
                            "Campos vacios",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewContact.setBounds(10, 207, 414, 43);
		getContentPane().add(btnNewContact);
		

		
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
	}
	
	public AgendaUI getParent() {
		return mainForm;
	}
}
