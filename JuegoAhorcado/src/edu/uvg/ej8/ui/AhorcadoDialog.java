package edu.uvg.ej8.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.Timer;

import edu.uvg.ej8.controller.Game;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AhorcadoDialog extends JDialog {

	private JTextField txtLetter;
	private Game myGame;
	private ArrayList<JTextField> txtAllLetters; //going to need an ArrayList of letters
	JLabel lblFailedLetters;
	JLabel lblAhorcado;
	JButton btnProbar;
	Timer cronometro;
	JLabel lblSegundos;

	public JLabel getlblSegundos() {
		return this.lblSegundos;
	}
	
	
	private String[] IMAGES = {
			"./src/images/empty.jpg"
			, "./src/images/head.jpg"
			, "./src/images/right_arm.jpg"
			, "./src/images/left_arm.jpg"
			, "./src/images/body.jpg"
			, "./src/images/right_leg.jpg"
			, "./src/images/left_leg.jpg"
	};

	/**
	 * Create the frame.
	 */
	public AhorcadoDialog(String word) {
		
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		myGame = new Game(word);
		txtAllLetters = new ArrayList<JTextField>(); //Arreglo de Jtext field
		cronometro = new Timer(1000, new CronometroEvent(myGame, this));
		cronometro.start();
		
		JLabel lblLetra = new JLabel("Letra");
        lblLetra.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLetra.setBounds(350, 30, 75, 35);
        getContentPane().add(lblLetra);
        
        txtLetter = new JTextField();
        txtLetter.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLetter.setBounds(430, 30, 60, 35);
        getContentPane().add(txtLetter);
        txtLetter.setColumns(10);
        txtLetter.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        		warn();
        	}
        	
        	public void removeUpdate(DocumentEvent e) {
        		warn();
        	}
        	
        	public void insertUpdate(DocumentEvent e) {
        		warn();
        	}

        	/**
        	 * This method allow only one letter in the field
        	 */
        	public void warn() {
        		if (txtLetter.getText().length() > 1){
        			txtLetter.setText("" + txtLetter.getText().charAt(0));
        		}
        	}
        });
        
        
        btnProbar = new JButton("Intentar");
        btnProbar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!txtLetter.getText().trim().equals("")) {
        			ArrayList<Integer> result = myGame.tryALetter(txtLetter.getText());
        			if (result.size() > 0) { //Success
        				successfulAttempt(result);
        			} else { //Fail
        				failedAttempt();
        			}
        		}
        	}
        });
        btnProbar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnProbar.setBounds(500, 30, 115, 35);
        getContentPane().add(btnProbar);

        
		//Adding the label with the image
		try {
		
			lblAhorcado = new JLabel("");
	        BufferedImage imgLcl = ImageIO.read(new File(IMAGES[0]));
	        ImageIcon iconLcl = new ImageIcon(imgLcl);
	        lblAhorcado.setIcon(iconLcl );
	        Dimension size = lblAhorcado.getPreferredSize();
	        lblAhorcado.setBounds(30, 30, size.width, size.height);
	        
	        getContentPane().add(lblAhorcado);
	        
	        JLabel lblIncorrectas = new JLabel("Incorrectas:");
	        lblIncorrectas.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblIncorrectas.setBounds(350, 216, 103, 35);
	        getContentPane().add(lblIncorrectas);
	        
	        lblFailedLetters = new JLabel("");
	        lblFailedLetters.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblFailedLetters.setBounds(476, 216, 103, 35);
	        getContentPane().add(lblFailedLetters);
	        
	        lblSegundos = new JLabel("5");
	        lblSegundos.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblSegundos.setBounds(350, 311, 103, 35);
	        getContentPane().add(lblSegundos);
	        
	        createTextBoxes(myGame);
	        
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
	}
	
	private void createTextBoxes(Game game) {
		for (int i = 0; i < game.getWord().length(); i++) {
			JTextField txtALetter = new JTextField();
			txtALetter.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtALetter.setBounds(350 + i * 60, 80, 60, 35);
			txtALetter.setEnabled(false);
	        getContentPane().add(txtALetter);
	        txtAllLetters.add(txtALetter);
		}
		
		//This code will allow me to resize the window automatically so all the textbox will fit
		int lastTextBoxPositionX = txtAllLetters.get(txtAllLetters.size() - 1).getX();
		if (lastTextBoxPositionX > 800)
			setBounds(100, 100, lastTextBoxPositionX + 100, 600);
	}
	
	public void successfulAttempt(ArrayList<Integer> result) {
		for (Integer index : result) {
			txtAllLetters.get(index).setText(txtLetter.getText());
		}
		
		if (myGame.isGameComplete()) {
			txtLetter.setEnabled(false);
			btnProbar.setEnabled(false);
			
			JOptionPane.showMessageDialog(
					this, 
					"Felicidades, ha ganado el juego",
                    "Juego completado",
                    JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public void failedAttempt() {
		
		lblFailedLetters.setText("");
		for (String failed : myGame.getFailedLetters()) {
			lblFailedLetters.setText(lblFailedLetters.getText() + " " + failed);
		}
			
		//New image to the hangman
		try {
			BufferedImage imgLcl = ImageIO.read(new File(IMAGES[myGame.getFailedAtempts()]));
	        ImageIcon iconLcl = new ImageIcon(imgLcl);
	        lblAhorcado.setIcon(iconLcl );
	        Dimension size = lblAhorcado.getPreferredSize();
	        lblAhorcado.setBounds(30, 30, size.width, size.height);
	        
	        if (myGame.getFailedAtempts() == 6) {
	        	btnProbar.setEnabled(false);
				txtLetter.setEnabled(false);
				JOptionPane.showMessageDialog(
						this, 
						"No se logro enconrar la palabra, ha perdido",
	                    "Operación Fallida",
	                    JOptionPane.ERROR_MESSAGE);
	        }
		} catch (Exception e) {
			
		}
				
	}
}
