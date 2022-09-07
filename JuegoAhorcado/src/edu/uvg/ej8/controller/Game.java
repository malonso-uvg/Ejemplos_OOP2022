/**
 * 
 */
package edu.uvg.ej8.controller;

import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class Game {

	private String word;
	private int failedAtempts;
	private ArrayList<String> correctLetters;
	private ArrayList<String> failedLetters;
	
	public Game(String word) {
		setWord(word);
		setFailedAtempts(0);
		failedLetters = new ArrayList<String>();
		correctLetters = new ArrayList<String>();
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the failedAtempts
	 */
	public int getFailedAtempts() {
		return failedAtempts;
	}

	/**
	 * @param failedAtempts the failedAtempts to set
	 */
	public void setFailedAtempts(int failedAtempts) {
		this.failedAtempts = failedAtempts;
	}

	/**
	 * @return the failedLetters
	 */
	public ArrayList<String> getFailedLetters() {
		return failedLetters;
	}
	
	public ArrayList<Integer> tryALetter(String _letter) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for (int i = 0; i < getWord().length(); i++) {
			if (_letter.toUpperCase().charAt(0) == getWord().toUpperCase().charAt(i)) {
				positions.add(i);
				correctLetters.add(_letter);
			}
		}
		
		//If the letter is not in the word, then failed attempt will increase
		if (positions.size() == 0) {
			failedAtempts++;
			failedLetters.add(_letter);
		}
		
		return positions;
	}
	
	public boolean isGameComplete() {
		return word.length() == correctLetters.size();
	}
}
