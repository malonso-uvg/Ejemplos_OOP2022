/**
 * 
 */
package edu.uvg.ej4.model;

/**
 * @author moises.alonso
 *
 */
public class Phone {

	private long phoneNumber;
	private String type;
	
	public Phone(long phoneNumber, String type) {
		setPhoneNumber(phoneNumber);
		setType(type);
	}
	
	public Phone() {
		setPhoneNumber(0);
		setType("");
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
