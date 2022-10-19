/**
 * 
 */
package edu.uvg.ej4.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import edu.uvg.ej4.model.Contact;
import edu.uvg.ej4.model.Email;
import edu.uvg.ej4.model.Phone;

/**
 * @author MAAG
 *
 */
public class PersistentAgendaManagement {

	
	/**
	 * This method allow get an Agenda from a file
	 * @param agendaFile the file that contains a Agenda
	 * @return a Agenda object with the information collected from the file
	 */
	public Agenda getAgendaFromFile(File agendaFile) throws Exception{
		if (agendaFile.isFile() && agendaFile.canRead()) {
			Agenda savedAgenda = null;
			BufferedReader reader = new BufferedReader(new FileReader(agendaFile));

	        try {
	            String line;

	            int counter = 0;
	            while ((line = reader.readLine()) != null) {
	                if (counter == 0) { //Is the first line
	                	savedAgenda = new Agenda(line);  //Then create the agenda
	                } else { //if is not the firstline, then the following lines are data
	                	if (savedAgenda != null) {
	                		
	                		if (line.split(",").length == 5) {
	                			String[] fields = line.split(",");
	                			
	                			if (fields[DataStore.TYPE_FIELD].charAt(DataStore.TYPE_FIELD) == '1') { //it is a phone
	                				addPhoneToAgenda(savedAgenda, fields);
	                			} else if (fields[0].charAt(0) == '2') { //it is a email
	                				addEmailToAgenda(savedAgenda, fields);
	                			} else {
	                				throw new Exception("Incorrect line format at line: " + counter);
	                			}
	                			
	                		} else {
	                			throw new Exception("Incorrect file format");
	                		}
	                		
	                	} else {
	                		throw new Exception("Agenda couldn't be created");
	                	}
	                }
	                counter++;
	            }

	        } finally {
	            reader.close();
	        }
	        
	        return savedAgenda;
	        
		} else {
			throw new Exception("Is not a file");
		}
	}
	
	/***
	 * This method will save an agenda object into a file
	 * @param myAgenda the agenda object you need to save
	 * @param file_path the specified absolute path where the agenda will be saved
	 * @return true if save operation was successful, false otherwise
	 * @throws Exception any IO exception must be handled
	 */
	public boolean saveAgendaIntoFile(Agenda myAgenda, String file_path) throws Exception{
 
		File myFile = new File(file_path);
		FileWriter writer;
		
		if (myFile.createNewFile()) {
			writer = new FileWriter(myFile);
		} else {
			if (myFile.exists()) { //I will overwrite the file
				writer = new FileWriter(myFile, false);
			} else {
				return false;
			}
		}
		
		if (writer != null) {
			writer.write(convertAgendaToText(myAgenda));
			writer.close();
			return true;
		} 
		
		return false;
	}
	
	/***
	 * This method add a phone number into an existing agenda, the 
	 * format of the array must be: 1,FIRSTNAME,LASTNAME,PHONE,TYPE
	 * @param _theAgenda The agenda where the phone will be saved
	 * @param fileLine an array of 5 strings, use the correct format
	 */
	private void addPhoneToAgenda(Agenda _theAgenda, String[] fileLine) {
		if (_theAgenda != null) {
			Contact aContact = _theAgenda.searchByName(fileLine[DataStore.FIRSTNAME_FIELD], fileLine[DataStore.LASTNAME_FIELD]);
			boolean contactFound = aContact != null; //If aContact is not null then the value is true;
			
			if (!contactFound) { //No contact found
				aContact = new Contact(fileLine[DataStore.FIRSTNAME_FIELD], fileLine[DataStore.LASTNAME_FIELD]);
			}
			
			//Save the phone
			aContact.getPhoneNumbers().add(new Phone(Long.parseLong(fileLine[DataStore.DATA_FIELD]), fileLine[DataStore.DATATYPE_FIELD]));
			
			if (!contactFound) { //If the contact didn't exists, then I create it and save into the arrayList
				_theAgenda.getContacts().add(aContact);
			}
		}
	}
	
	/***
	 * This method add a email address into an existing agenda, the 
	 * format of the array must be: 1,FIRSTNAME,LASTNAME,EMAIL,TYPE
	 * @param _theAgenda The agenda where the phone will be saved
	 * @param fileLine an array of 5 strings, use the correct format
	 */
	private void addEmailToAgenda(Agenda _theAgenda, String[] fileLine) {
		if (_theAgenda != null) {
			Contact aContact = _theAgenda.searchByName(fileLine[DataStore.FIRSTNAME_FIELD], fileLine[DataStore.LASTNAME_FIELD]);
			boolean contactFound = aContact != null; //If aContact is not null then the value is true;
			
			if (!contactFound) { //No contact found
				aContact = new Contact(fileLine[DataStore.FIRSTNAME_FIELD], fileLine[DataStore.LASTNAME_FIELD]);
			}
			
			//Save the email
			aContact.getEmailAddresses().add(new Email(fileLine[DataStore.DATA_FIELD], fileLine[DataStore.DATATYPE_FIELD]));
			
			if (!contactFound) { //If the contact didn't exists, then I create it and save into the arrayList
				_theAgenda.getContacts().add(aContact);
			}
		}
	}
	
	/***
	 * This method will convert an aganda into a string to be saved in a file
	 * @param _theAgenda the agenda that needs to be saved
	 * @return the file content, as String
	 */
	private String convertAgendaToText(Agenda _theAgenda) {
		
		String content = "";
		
		content = "" + _theAgenda.getOwnerID() + "\r\n";
		
		//Saving the contacts
		for (Contact aContact : _theAgenda.getContacts()) {
			
			//Saving the phones
			String phones = "";
			for (Phone aPhone : aContact.getPhoneNumbers()) {
				phones += "1," + aContact.getFirstName() 
					+ "," + aContact.getLastName() 
					+ "," + aPhone.getPhoneNumber()
					+ "," + aPhone.getType() + "\r\n";
			}
			
			content += phones;
			
			//Saving the emails
			String emails = "";
			for (Email anEmail : aContact.getEmailAddresses()) {
				emails += "2," + aContact.getFirstName() 
					+ "," + aContact.getLastName() 
					+ "," + anEmail.getEmailAddress()
					+ "," + anEmail.getType() + "\r\n";
			}
			content += emails;
		}
		
		return content;
		
	}
	
}
