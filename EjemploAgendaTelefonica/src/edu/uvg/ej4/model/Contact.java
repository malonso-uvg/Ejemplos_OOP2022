/**
 * 
 */
package edu.uvg.ej4.model;

import java.util.ArrayList;

/**
 * @author moises.alonso
 *
 */
public class Contact {


	private String firstName;
	private String lastName;
	
	private ArrayList<Phone> phoneNumbers;
	private ArrayList<Email> emailAddresses;
	
	public Contact(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		phoneNumbers = new ArrayList<Phone>();
		emailAddresses = new ArrayList<Email>();
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setPhoneNumbers(ArrayList<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public ArrayList<Email> getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(ArrayList<Email> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	
	
}
