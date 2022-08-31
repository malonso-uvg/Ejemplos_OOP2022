/**
 * 
 */
package edu.uvg.ej4.model;

/**
 * @author moises.alonso
 *
 */
public class Email {

	private String emailAddress;
	private String type;
	
	public Email(String emailAddress, String type) {
		setEmailAddress(emailAddress);
		setType(type);
	}
	
	public Email() {
		this.emailAddress = "";
		this.type = "";
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		if (isAnEmail(emailAddress)) {
			this.emailAddress = emailAddress;
		} else {
			this.emailAddress = "";
		}
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	private boolean isAnEmail(String email) {
		return true;
	}
	
}
