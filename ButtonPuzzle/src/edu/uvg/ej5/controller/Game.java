/**
 * 
 */
package edu.uvg.ej5.controller;

import java.util.ArrayList;
import java.util.Random;

import edu.uvg.ej5.model.Puzzle;

/**
 * @author MAAG
 *
 */
public class Game {

	int moves;
	ArrayList<Puzzle> movements;
	Puzzle goalPuzzle;
	Puzzle actualPuzzle;
	boolean gameIsOver;
	
	public Game(Puzzle goalPuzzle) throws Exception{
		setMovements(new ArrayList<Puzzle>());
		setGoalPuzzle(goalPuzzle);
		setMoves(0);
		setActualPuzzle( new Puzzle( getRandomPuzzle(goalPuzzle.getRows_qty(), goalPuzzle.getColumns_qty()) ) );
		getMovements().add(getActualPuzzle());
		gameIsOver = false;
	}
	
	/**
	 * @return the moves
	 */
	public int getMoves() {
		return moves;
	}
	/**
	 * @param moves the moves to set
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}
	/**
	 * @return the movements
	 */
	public ArrayList<Puzzle> getMovements() {
		return movements;
	}
	/**
	 * @param movements the movements to set
	 */
	public void setMovements(ArrayList<Puzzle> movements) {
		this.movements = movements;
	}
	/**
	 * @return the goalPuzzle
	 */
	public Puzzle getGoalPuzzle() {
		return goalPuzzle;
	}
	/**
	 * @param goalPuzzle the goalPuzzle to set
	 */
	public void setGoalPuzzle(Puzzle goalPuzzle) {
		this.goalPuzzle = goalPuzzle;
	}
	/**
	 * @return the actualPuzzle
	 */
	public Puzzle getActualPuzzle() {
		return actualPuzzle;
	}
	/**
	 * @param actualPuzzle the actualPuzzle to set
	 */
	public void setActualPuzzle(Puzzle actualPuzzle) {
		this.actualPuzzle = actualPuzzle;
	}
	
	/***
	 * This method execute a movement
	 * @param row the row of the value changed
	 * @param column the
	 * @param value
	 */
	public void makeMove(int row, int column, int value) {
		getActualPuzzle().getInternalPuzzle()[row][column] = value;
		moves++;
		getMovements().add(getActualPuzzle());
	}
	
	/***
	 * This method will verify if the actual puzzle and the goal puzzle are the same
	 * then the game is over
	 * @return true if actual and goal puzzle  are the same, false otherwise
	 */
	public boolean isPuzzleComplete() {
		
		for (int i = 0; i < getActualPuzzle().getRows_qty(); i++) {
			for (int j = 0; j < getActualPuzzle().getColumns_qty(); j++) {
				if (getActualPuzzle().getInternalPuzzle()[i][j] != getGoalPuzzle().getInternalPuzzle()[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/***
	 * This method create new puzzle using random numbers
	 * @param rows_qty number of rows of the puzzle
	 * @param columns_qty number of columns of the puzzle
	 * @return an Integer matrix
	 */
	private int[][] getRandomPuzzle(int rows_qty, int columns_qty){
		int[][] randomPuzzle = new int[rows_qty][columns_qty];
		
		for (int i = 0; i < rows_qty; i++) {
			for (int j = 0; j < columns_qty; j++) {
				randomPuzzle[i][j] = (new Random()).nextInt(3);
			}
		}
		
		return randomPuzzle;
	}

	/**
	 * @return the gameIsOver
	 */
	public boolean isGameIsOver() {
		return gameIsOver;
	}

	/**
	 * @param gameIsOver the gameIsOver to set
	 */
	public void setGameIsOver(boolean gameIsOver) {
		this.gameIsOver = gameIsOver;
	}
	
	
	
}
