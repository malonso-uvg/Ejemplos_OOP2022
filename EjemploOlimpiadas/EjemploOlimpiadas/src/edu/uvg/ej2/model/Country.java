/**
 * 
 */
package edu.uvg.ej2.model;

import java.util.ArrayList;


/**
 * @author MAAG
 *
 */
public class Country {

	private String name;
	private ArrayList<Team> teams;
	private ArrayList<String> olimpicGames;
	private ArrayList<Integer> olimpicWins;
	
	
	public Country() {
		teams = new ArrayList<Team>();
		olimpicGames = new ArrayList<String>();
		olimpicWins = new ArrayList<Integer>();
		
		olimpicGames.add("Londres");
		olimpicGames.add("Beijin");
		olimpicGames.add("Atenas");
		olimpicGames.add("Sidney");
		olimpicGames.add("Atlanta");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the teams
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	/**
	 * @param teams the teams to set
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	/**
	 * @return the olimpicGames
	 */
	public ArrayList<String> getOlimpicGames() {
		return olimpicGames;
	}
	/**
	 * @param olimpicGames the olimpicGames to set
	 */
	public void setOlimpicGames(ArrayList<String> olimpicGames) {
		this.olimpicGames = olimpicGames;
	}
	/**
	 * @return the olimpicWins
	 */
	public ArrayList<Integer> getOlimpicWins() {
		return olimpicWins;
	}
	/**
	 * @param olimpicWins the olimpicWins to set
	 */
	public void setOlimpicWins(ArrayList<Integer> olimpicWins) {
		this.olimpicWins = olimpicWins;
	}
	
	
	
}
