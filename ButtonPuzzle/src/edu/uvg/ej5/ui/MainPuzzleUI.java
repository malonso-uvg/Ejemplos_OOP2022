package edu.uvg.ej5.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import edu.uvg.ej5.controller.Game;
import edu.uvg.ej5.controller.PersistentDataManagement;
import edu.uvg.ej5.model.Puzzle;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainPuzzleUI extends JFrame {


	public MainPuzzleUI selfFrame;
	public Game _game;
	
	
	/**
	 * Create the frame.
	 */
	public MainPuzzleUI() {
		this.selfFrame = this;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		//Start Menu declaration
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load Puzzle");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final JFileChooser  fileDialog = new JFileChooser();
				
				int returnVal = fileDialog.showOpenDialog(selfFrame);
	            
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	               File file = fileDialog.getSelectedFile();
	               
	               PersistentDataManagement savedPuzzle = new PersistentDataManagement();
				    
				    try {
				    	
				    	_game = new Game( new Puzzle(savedPuzzle.getPuzzleFromFile(file)) );
				    	targetPuzzleFromMatrix(_game.getGoalPuzzle());
				    	
				    	JOptionPane.showMessageDialog(
				    			selfFrame, 
								"El tablero se cargó exitosamente",
	                            "Operación Exitosa",
	                            JOptionPane.INFORMATION_MESSAGE);
				    	
				    } catch (Exception ex ){
				    	JOptionPane.showMessageDialog(
				    			selfFrame, 
								"Se encontró un error al intentar cargar el tablero: " + ex.getMessage(),
	                            "No se pudo cargar",
	                            JOptionPane.ERROR_MESSAGE);
				    }
	               
	            } else {
	            	JOptionPane.showMessageDialog(
	            			selfFrame, 
							"Se encontró un error al intentar cargar el tablero",
                            "No se pudo cargar",
                            JOptionPane.ERROR_MESSAGE);
	            }      
	         
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//End Menu declaration
		

		
		
	}
	
	private void targetPuzzleFromMatrix(Puzzle _targetMatrix){
		int rows_qty = _targetMatrix.getRows_qty();
		int columns_qty = _targetMatrix.getColumns_qty();
		JMatrixButton[][] _targetPuzzle = new JMatrixButton[rows_qty][columns_qty];
		
		//Instance of all the buttons
		for (int i = 0; i < rows_qty; i++) {
			for (int j = 0; j < columns_qty; j++) {
				JMatrixButton btnNewButton = new JMatrixButton(i, j);
				
				switch(_targetMatrix.getInternalPuzzle()[i][j]) {
				case 0:{
					btnNewButton.setBackground(Color.BLACK);
				}break;
				
				case 1:{
					btnNewButton.setBackground(Color.WHITE);
				}break;
				
				case 2:{
					btnNewButton.setBackground(Color.RED);
				}break;
				
				default:{
					btnNewButton.setBackground(Color.BLACK);
				}break;
				}
				
				btnNewButton.setBounds(60 * i, 60 * j, 40, 40);
				getContentPane().add(btnNewButton);
			}
		}
		
		getContentPane().revalidate();
	}
	
}
