/**
 * 
 */
package edu.uvg.ej2.controller;

import edu.uvg.ej2.model.*;
import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class Statistics {
	
	ArrayList<Country> countries;
	
	public Statistics() {
		countries = new ArrayList<Country>();
	}
	

	/**
	 * @return the countries
	 */
	public ArrayList<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	/**
	 * This method check if a country existis in the list
	 * @param _countryName a String that represents the name of the country
	 * @return true if the country exists, false otherwise
	 */
	public boolean recordExists(String _countryName) {
		
		for (Country searchCountry: countries) {
			if (searchCountry.getName().toUpperCase().equals(_countryName.toUpperCase())) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * This method get the number of Athletes, woman and men in each team, by country
	 * @param _countryName the name of the country
	 * @return count of all athletes
	 */
	public int getOlimpicAthletesCount(String _countryName) {
		if (recordExists(_countryName)) {
			//Buscar al pais
			Country searchCountry = countries.get(0);
			
			for (Country myCountry: countries) {
				if (myCountry.getName().toUpperCase().equals(_countryName.toUpperCase())) {
					searchCountry = myCountry;
				}
			}
			
			//De primero recorro todos los equipos
			int totalCount = 0;
			for (Team myTeam: searchCountry.getTeams()) {
				totalCount += myTeam.getCountMan() + myTeam.getCountWoman();
			}
			
			return totalCount;
			
		} else {
			return 0;
		}
	}
	
	/**
	 * This method get the total count of medals the team got
	 * @param _countryName the name of the country
	 * @param _teamName the name of the team
	 * @return total count of medals, if -1 then the team or the country does not exists.
	 */
	public int getWinsByTeam(String _countryName, String _teamName) {
		Team myTeam = getTeamByCountry(_countryName, _teamName);
		
		if (myTeam != null) {
			return myTeam.getGoldQty() + myTeam.getSilverQty() + myTeam.getBronzeQty(); //Total of all medals
		}
		
		return -1; //The country or the team does not exists
	}
	
	/**
	 * Get the total count of medals by country
	 * @param _countryName the name of the country
	 * @return the total count of medals collected by the country, -1 if the country does not exists 
	 */
	public int getWinsByCountry(String _countryName) {
		
		Country myCountry = getCountryByName(_countryName);
		int total = -1;
		
		if (myCountry != null) {
			total = 0;
			for (Team myTeam : myCountry.getTeams()) {
				total += getWinsByTeam(myCountry.getName(), myTeam.getName());
			}
		}
		
		return total;
	}
	
	/**
	 * This method return the team with max number of gold medals, it has to be collective 
	 * @param _countryName the name of the country
	 * @return null if the Country does not exists, or it has no teams
	 */
	public Team getMaxWinsByTeam(String _countryName) {
		Country myCountry = getCountryByName(_countryName);
		
		if (myCountry != null) {
			Team teamWithMaxMedals = myCountry.getTeams().get(0); //I asume the first team is the one which has max number of medals
			
			for (Team aTeam: myCountry.getTeams()) {
				if (aTeam.getGoldQty() > teamWithMaxMedals.getGoldQty()) {
					teamWithMaxMedals = aTeam;
				}
			}
			
			return teamWithMaxMedals; //The team which has the max number of medals
		}
		
		return null;
	}
	
	public boolean isHigherRecord(String _countryName) {
		//First I'm going to get the average number of medals in the past
		double average = 0;
		
		Country myCountry = getCountryByName(_countryName);
		
		if (myCountry != null) {
			for (Integer pastWins: myCountry.getOlimpicWins()) {
				average += (double)pastWins;
			}
			average = average / (double)myCountry.getOlimpicWins().size(); //The average count
		}
		
		
		//Get the total medals of the actual olimpic games
		double actualWins = (double)getWinsByCountry(_countryName);
		
		return actualWins > average; //True if actual wins is higer than the average
	}
	
	private Country getCountryByName(String _countryName) {
		//Busco al pais
		for (Country myCountry: countries) {
			if (myCountry.getName().toUpperCase().equals(_countryName.toUpperCase())) {
				return myCountry;
			}
		}
		
		return null; //if the country is not found then return null
	}
	
	
	/**
	 * Get an specific team for a specific country
	 * @param _countryName the name of the country
	 * @param _teamName the name of the team
	 * @return a Team object
	 */
	private Team getTeamByCountry(String _countryName, String _teamName) {
		
		Country myCountry = getCountryByName(_countryName); 
		
		if (myCountry != null) {
			
			//Busco al equipo
			for (Team myTeam: myCountry.getTeams()) {
				if (myTeam.getName().equalsIgnoreCase(_teamName)) {
					return myTeam;
				}
			}
		}
		
		return null; // If the country or the team does not exists then return null
		
	}
}
