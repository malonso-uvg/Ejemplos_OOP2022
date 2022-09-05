/**
 * 
 */
package edu.uvg.ej5.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.uvg.ej5.controller.Game;

/**
 * @author MAAG
 *
 */
public class JMatrixButtonEvent implements ActionListener {

	JMatrixButton button;
	Game game;
	int limit;
	
	public JMatrixButtonEvent(JMatrixButton _button, Game _game, int _limit) {
		button = _button;
		game = _game;
		limit = _limit;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!game.isGameIsOver()) {
			int row = button.getRow();
			int column = button.getColumn();
			int originalValue = game.getActualPuzzle().getInternalPuzzle()[row][column];
			
			int newValue = (originalValue + 1) % limit;
			game.makeMove(row, column, newValue);
			
			button.setBackground(getButtonColor(newValue));
			button.repaint();
			
			if (game.isPuzzleComplete()) {
				game.setGameIsOver(true);
				
				JOptionPane.showMessageDialog(
		    			button.getParent(), 
						"Genial, ha completado el puzzle, necesito " + game.getMoves() + " movimientos ",
                        "Juego completo",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		
		
	}
	
	private Color getButtonColor(int value) {
		switch(value) {
		case 0:{
			return Color.BLACK;
		}
		
		case 1:{
			return Color.WHITE;
		}
		
		case 2:{
			return Color.RED;
		}
		
		default:{
			return Color.BLACK;
		}
		}
	}

}
