/**
 * 
 */
package edu.uvg.ej8.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import edu.uvg.ej8.controller.Game;

/**
 * @author moises.alonso
 *
 */
public class CronometroEvent implements ActionListener {

	Game myGame;
	AhorcadoDialog ahorcadoDialogForm;
	
	public CronometroEvent(Game _game, AhorcadoDialog _ahorcadoDialogForm) {
		myGame = _game;
		ahorcadoDialogForm = _ahorcadoDialogForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		int segundos = Integer.parseInt(ahorcadoDialogForm.getlblSegundos().getText());
		segundos--;
		ahorcadoDialogForm.getlblSegundos().setText("" + segundos);
		if (segundos == 0) {
			myGame.tryALetter("1");
			ahorcadoDialogForm.failedAttempt();
			ahorcadoDialogForm.getlblSegundos().setText("5");
		}

		
	}

}
