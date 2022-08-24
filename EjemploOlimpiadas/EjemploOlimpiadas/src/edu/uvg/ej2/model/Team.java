/**
 * 
 */
package edu.uvg.ej2.model;

/**
 * @author MAAG
 *
 */
public class Team {

	private String name;
	private boolean isATeam;
	private int countMan;
	private int countWoman;
	private int goldQty;
	private int silverQty;
	private int BronzeQty;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the isATeam
	 */
	public boolean isATeam() {
		return isATeam;
	}
	/**
	 * @param isATeam the isATeam to set
	 */
	public void setATeam(boolean isATeam) {
		this.isATeam = isATeam;
	}
	/**
	 * @return the countMan
	 */
	public int getCountMan() {
		return countMan;
	}
	/**
	 * @param countMan the countMan to set
	 */
	public void setCountMan(int countMan) {
		this.countMan = countMan;
	}
	/**
	 * @return the countWoman
	 */
	public int getCountWoman() {
		return countWoman;
	}
	/**
	 * @param countWoman the countWoman to set
	 */
	public void setCountWoman(int countWoman) {
		this.countWoman = countWoman;
	}
	/**
	 * @return the goldQty
	 */
	public int getGoldQty() {
		return goldQty;
	}
	/**
	 * @param goldQty the goldQty to set
	 */
	public void setGoldQty(int goldQty) {
		this.goldQty = goldQty;
	}
	/**
	 * @return the silverQty
	 */
	public int getSilverQty() {
		return silverQty;
	}
	/**
	 * @param silverQty the silverQty to set
	 */
	public void setSilverQty(int silverQty) {
		this.silverQty = silverQty;
	}
	/**
	 * @return the bronzeQty
	 */
	public int getBronzeQty() {
		return BronzeQty;
	}
	/**
	 * @param bronzeQty the bronzeQty to set
	 */
	public void setBronzeQty(int bronzeQty) {
		BronzeQty = bronzeQty;
	}
	
	
}
