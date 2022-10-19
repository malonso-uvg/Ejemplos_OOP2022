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
public class FileTXTDataStore extends DataStore {
	
	private Agenda agenda;
	private File file;
	private String path;
	
	public FileTXTDataStore(Agenda _agenda) {
		super();
		setAgenda(_agenda);
	}
	
	public FileTXTDataStore(Agenda _agenda, File _file, String _path) {
		super();
		setAgenda(_agenda);
		setFile(_file);
		setPath(_path);
	}

	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean initializeDS() throws Exception {
		
		if (getFile() == null) {
			setFile(new File(getPath()));
		}
		
		if (getFile().createNewFile()) {
			System.out.println("New File created");
		} else {
			System.out.println("File already exists");
		}
		
		return true;
		
	}

	@Override
	public boolean finalizeDS() throws Exception {
		setFile(null);
		setPath(null);
		setAgenda(null);
		return true;
	}

	@Override
	public void saveData() throws Exception {
		
		FileWriter writer;
		
		if (getFile().createNewFile()) {
			writer = new FileWriter(getFile());
		} else {
			if (getFile().exists()) { //I will overwrite the file
				writer = new FileWriter(getFile(), false);
			} else {
				throw new Exception("Data could not be saved");
			}
		}
		
		if (writer != null) {
			writer.write(convertAgendaToText(getAgenda()));
			writer.close();
		} 

	}

	@Override
	public void getData() throws Exception {
		
		
		if (getFile().isFile() && getFile().canRead()) {
			Agenda savedAgenda = null;
			BufferedReader reader = new BufferedReader(new FileReader(getFile()));

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
	        
	        setAgenda(savedAgenda);
	        
		} else {
			throw new Exception("Is not a file");
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

}
