/**
 * 
 */
package edu.uvg.ej4.controller;

import java.util.ArrayList;

import edu.uvg.ej4.model.Contact;
import edu.uvg.ej4.model.Email;
import edu.uvg.ej4.model.Phone;

/**
 * @author moises.alonso
 *
 */
public class Agenda {
	ArrayList<Contact> myAgenda;
	String ownerID;
	
	public Agenda(String ownerID) {
		myAgenda = new ArrayList<Contact>();
		this.ownerID = ownerID; 
	}
	
	public String getOwnerID() {
		return ownerID;
	}
	
	public boolean saveNewContactOnlyPhone(String firstname, String lastname, long phone, String type) {
		try {
			Contact newContact = this.searchByName(firstname, lastname);
			boolean isNewContact = false;
			
			if (newContact == null) {
				newContact = new Contact(firstname, lastname);
				isNewContact = true;
			}
				
			newContact.getPhoneNumbers().add(new Phone(phone, type));
			
			if (isNewContact) {
				myAgenda.add(newContact);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		}
		return true;
	}
	
	public boolean saveNewContactOnlyEmail(String firstname, String lastname, String emailAddress, String type) {
		try {
			Contact newContact = this.searchByName(firstname, lastname);
			boolean isNewContact = false;
			
			if (newContact == null) {
				newContact = new Contact(firstname, lastname);
				isNewContact = true;
			}
			
			newContact.getEmailAddresses().add(new Email(emailAddress, type));
			
			if (isNewContact) {
				myAgenda.add(newContact);
			}
			
		} catch (Exception e) {
			return false;
			
		}
		return true;
	}
	
	public boolean saveNewContactPhoneAndEmail(String firstname
			, String lastname, long phone, String phoneType
			, String emailAddress, String emailType) {
		try {
			Contact newContact = this.searchByName(firstname, lastname);
			boolean isNewContact = false;
			
			if (newContact == null) {
				newContact = new Contact(firstname, lastname);
				isNewContact = true;
			}
			
			newContact.getPhoneNumbers().add(new Phone(phone, phoneType));
			newContact.getEmailAddresses().add(new Email(emailAddress, emailType));
			
			if (isNewContact) {
				myAgenda.add(newContact);
			}
			
		} catch (Exception e) {
			return false;
			
		}
		return true;
	}
	
	public ArrayList<Contact> getContacts(){
		return myAgenda;
	}
	
	public Contact searchByName(String firstname, String lastname) {
		for (Contact aContact : myAgenda) {
			if (	(lastname.equalsIgnoreCase(aContact.getLastName())) //only if firstname and lastname match
					&& (firstname.equalsIgnoreCase(aContact.getFirstName())) ) {
				return aContact;
			}
		}
		return null; //if contact is not found
	}
	
}
