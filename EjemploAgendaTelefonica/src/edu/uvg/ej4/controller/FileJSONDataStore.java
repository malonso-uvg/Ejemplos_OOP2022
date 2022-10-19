/**
 * 
 */
package edu.uvg.ej4.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.uvg.ej4.model.Contact;
import edu.uvg.ej4.model.Email;
import edu.uvg.ej4.model.Phone;


/**
 * @author MAAG
 *
 */
public class FileJSONDataStore extends DataStore {

	private String path;
	private File file;
	
	public FileJSONDataStore(Agenda _agenda) {
		super();
		setAgenda(_agenda);
	}
	
	public FileJSONDataStore(Agenda _agenda, String _path) {
		super();
		setAgenda(_agenda);
		setPath(_path);
		setFile(new File(_path));
	}
	
	public FileJSONDataStore(Agenda _agenda, File _file, String _path) {
		super();
		setAgenda(_agenda);
		setFile(_file);
		setPath(_path);
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
			writer.write(convertAgendaToJSon(getAgenda()));
			writer.close();
		} 

	}

	@Override
	public void getData() throws Exception {
		
		
		if (getFile().isFile() && getFile().canRead()) {
			
			BufferedReader reader = new BufferedReader(new FileReader(getFile()));

			String completeFile = "";
			
	        try {
	            String line;
	            
	            while ((line = reader.readLine()) != null) {
	                completeFile += line;
	            }

	        } finally {
	            reader.close();
	        }
	        
	        JSONObject agendaFile = new JSONObject(completeFile);
	        Agenda savedAgenda = new Agenda(agendaFile.getString("owner"));
	        
	        JSONArray contacts = agendaFile.getJSONArray("contacts");
	        
	        for (int i = 0; i < contacts.length(); i++) {
	        	//Load Phones
	        	JSONArray phones = ((JSONObject)contacts.get(i)).getJSONArray("phones");
	        	for (int j = 0; j < phones.length(); j++) {
	        		savedAgenda.saveNewContactOnlyPhone(
	        				((JSONObject)contacts.get(i)).getString("firstname")
	        				, ((JSONObject)contacts.get(i)).getString("lastname")
	        				,  Long.parseLong( ((JSONObject)phones.get(j)).getString("phoneNumber") )
	        				, ((JSONObject)phones.get(j)).getString("type"));
	        	}
	        	
	        	//Load Emails
	        	JSONArray emails = ((JSONObject)contacts.get(i)).getJSONArray("emails");
	        	for (int j = 0; j < emails.length(); j++) {
	        		savedAgenda.saveNewContactOnlyEmail(
	        				((JSONObject)contacts.get(i)).getString("firstname")
	        				, ((JSONObject)contacts.get(i)).getString("lastname")
	        				, ((JSONObject)phones.get(j)).getString("emailAddress") 
	        				, ((JSONObject)phones.get(j)).getString("type"));
	        	}
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
	private String convertAgendaToJSon(Agenda _theAgenda) throws Exception{
		
		JSONObject agendaJSON = new JSONObject();
		
		agendaJSON.put("owner", _theAgenda.getOwnerID());
		
		
		//Saving the contacts
		JSONArray contactsJSON = new JSONArray();
		for (Contact aContact : _theAgenda.getContacts()) {
			JSONObject contact = new JSONObject();
			contact.put("firstname", aContact.getFirstName());
			contact.put("lastname", aContact.getLastName());
			
			//Saving the phones
			JSONArray phonesJSON = new JSONArray();
			for (Phone aPhone: aContact.getPhoneNumbers()) {
				JSONObject phone = new JSONObject();
				phone.put("type", aPhone.getType());
				phone.put("phoneNumber", aPhone.getPhoneNumber());
			}
			contact.put("phones", phonesJSON);
			
			
			//Saving the emails
			JSONArray emailsJSON = new JSONArray();
			for (Email anEmail: aContact.getEmailAddresses()) {
				JSONObject email = new JSONObject();
				email.put("type", anEmail.getType());
				email.put("emailAddress", anEmail.getEmailAddress());
			}
			contact.put("emails", emailsJSON);
			
			contactsJSON.put(contact);
		}
		
		agendaJSON.put("contacts", contactsJSON);
		
		return agendaJSON.toString();
		
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
