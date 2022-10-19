/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author moises.alonso
 *
 */
public class Contacto {

	private String firstname;
	private String lastname;
	private int id;
	private ArrayList<String> phone_number;
	
	public Contacto() {
		phone_number = new ArrayList<String>();
	}
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the phone_number
	 */
	public ArrayList<String> getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(ArrayList<String> phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
}
