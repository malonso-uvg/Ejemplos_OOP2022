package edu.uvg.ej4.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

import edu.uvg.ej4.controller.Agenda;
import edu.uvg.ej4.controller.PersistentAgendaManagement;
import edu.uvg.ej4.model.Contact;
import edu.uvg.ej4.model.Email;
import edu.uvg.ej4.model.Phone;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;

public class AgendaUI extends JFrame {

	private JPanel contentPane;
	private Agenda myAgenda;
	private AgendaUI selfAgendaUI;
	private Properties config;
	
	JLabel lblUserName;
	JList lstContacts;
	JTextArea txtPhones;
	JTextArea txtEmails;

	/**
	 * Create the frame.
	 */
	public AgendaUI(Properties _config) {
		super();
		
		this.selfAgendaUI = this; 
		config = _config;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 625);
		
		setTitle("Agenda OOP 2022");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Nueva Agenda");
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NewAgendaDialog dialog = new NewAgendaDialog(selfAgendaUI);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cargar Agenda");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser  fileDialog = new JFileChooser();
				
				int returnVal = fileDialog.showOpenDialog(selfAgendaUI);
	            
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	               File file = fileDialog.getSelectedFile();
	               
	               PersistentAgendaManagement agendaController = new PersistentAgendaManagement();
				    
				    try {
				    	
				    	myAgenda = agendaController.getAgendaFromFile(file);
				    	showInformationOnUI();
				    	
				    	JOptionPane.showMessageDialog(
								selfAgendaUI, 
								"La agenda se cargó exitosamente",
	                            "Operación Exitosa",
	                            JOptionPane.INFORMATION_MESSAGE);
				    	
				    } catch (Exception ex ){
				    	JOptionPane.showMessageDialog(
								selfAgendaUI, 
								"Se encontró un error al intentar cargar la agenda: " + ex.getMessage(),
	                            "No se pudo cargar",
	                            JOptionPane.ERROR_MESSAGE);
				    }
	               
	            } else {
	            	JOptionPane.showMessageDialog(
							selfAgendaUI, 
							"Se encontró un error al intentar cargar la agenda",
                            "No se pudo cargar",
                            JOptionPane.ERROR_MESSAGE);
	            }      
	         
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Guardar Agenda");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Especificar en donde guardar la agenda");   
				 
				int userSelection = fileChooser.showSaveDialog(selfAgendaUI);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    
				    PersistentAgendaManagement agendaController = new PersistentAgendaManagement();
				    
				    JOptionPane.showMessageDialog(
							selfAgendaUI, 
							"La agenda se guardó exitosamente",
                            "Operación Exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
				    
				    try {
				    	agendaController.saveAgendaIntoFile(myAgenda, fileChooser.getSelectedFile().getAbsolutePath());
				    } catch (Exception ex ){
				    	JOptionPane.showMessageDialog(
								selfAgendaUI, 
								"Se encontró un error al intentar guardar la agenda: " + ex.getMessage(),
	                            "No se pudo guardar",
	                            JOptionPane.ERROR_MESSAGE);
				    }
				    
				    
				} else {
			    	JOptionPane.showMessageDialog(
							selfAgendaUI, 
							"Se encontró un error al intentar guardar la agenda",
                            "No se pudo guardar",
                            JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblUserName = new JLabel("Mi Agenda (Usuario)");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(10, 30, 264, 36);
		contentPane.add(lblUserName);
		
		JButton btnAddContact = new JButton("Agregar Nuevo Contacto");
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Checking if the agenda has been created
					if(myAgenda != null) {
						NewContactDialog dialog = new NewContactDialog(selfAgendaUI);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(
								selfAgendaUI, 
								"Debe crear una agenda de primero",
	                            "Agenda vacía",
	                            JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAddContact.setBounds(10, 77, 264, 48);
		contentPane.add(btnAddContact);
		
		lstContacts = new JList();
		lstContacts.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (lstContacts.getSelectedIndex() >= 0) {
					
					String fname = myAgenda.getContacts().get( lstContacts.getSelectedIndex() ).getFirstName();
					String lname = myAgenda.getContacts().get( lstContacts.getSelectedIndex() ).getLastName();
					Contact aContact = myAgenda.searchByName(fname, lname);
					
					if (aContact != null) {
						String phoneNumbers = "";
						for (Phone aPhone: aContact.getPhoneNumbers()) {
							phoneNumbers += "" + aPhone.getPhoneNumber() + " ( " + aPhone.getType() + " )" + "\r\n"; 
						}
						txtPhones.setText(phoneNumbers);
						
						String emailAddresses = "";
						for (Email anEmail: aContact.getEmailAddresses()) {
							emailAddresses += "" + anEmail.getEmailAddress() + " ( " + anEmail.getType() + " )" + "\r\n"; 
						}
						
						txtEmails.setText(emailAddresses);
					}
				}
			}
		});
		
		lstContacts.setBounds(10, 147, 264, 114);
		contentPane.add(lstContacts);
		
		JLabel lblNewLabel_1 = new JLabel("Contacto: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 291, 264, 28);
		contentPane.add(lblNewLabel_1);
		
		txtPhones = new JTextArea();
		txtPhones.setBounds(10, 330, 264, 87);
		contentPane.add(txtPhones);
		
		txtEmails = new JTextArea();
		txtEmails.setBounds(10, 439, 264, 87);
		contentPane.add(txtEmails);
		
	}
	
	
	public JLabel getLblAgenda() {
		return lblUserName;
	}
	
	
	public Agenda getMyAgenda() {
		return myAgenda;
	}

	public void setMyAgenda(Agenda myAgenda) {
		this.myAgenda = myAgenda;
	}
	
	public void showInformationOnUI() {
		if (this.myAgenda != null) { //it means agenda has been created
			getLblAgenda().setText("Mi Agenda (" + myAgenda.getOwnerID() + ")");
	        
			DefaultListModel<String> contactList = new DefaultListModel<String>();
			
			for (Contact aContact : myAgenda.getContacts()) {
				
				contactList.addElement("" + aContact.getFirstName() + " " + aContact.getLastName());
			}
			
			lstContacts.setModel(contactList);
		
			if ( lstContacts.getModel().getSize() > 0) {
				lstContacts.setSelectedIndex(0);
			}
			
		}
	}
}
