/**
 * 
 */
package controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.Contacto;

/**
 * @author moises.alonso
 *
 */
public class SaveContactInFile implements IDataDriver<Contacto> {

	private Contacto myData;
	private File myFile;
	private boolean fileExists;
	
	public SaveContactInFile(String filepath, Contacto _data) {
		myFile = new File(filepath);
		fileExists = false;
		setData(_data);
	}
	
	@Override
	public void setData(Contacto _data) {
		myData = _data;
	}

	@Override
	public Contacto getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectDataSource() {
		try {
			if (!myFile.exists()) {
				if (myFile.createNewFile()) {
					fileExists = true;
			    } 
			}
			
		} catch (Exception ex) {
			System.out.println("Ocurrio un error" + ex.getMessage());
		}
		
		
	}

	@Override
	public void dissconnectDataSource() {
		
		
	}

	@Override
	public void saveData() {
		
		 try {
		      FileWriter myWriter = new FileWriter(myFile, true);
		      
		      String linea = "" + myData.getId() + "|" + myData.getFirstname() + "|" + myData.getLastname() + "|";
		      for (int i = 0; i < myData.getPhone_number().size(); i++) {
		    	  linea += myData.getPhone_number().get(i);
		    	  if (i != myData.getPhone_number().size() - 1) {
		    		  linea += ",";
		    	  } else {
		    		  linea += "\r\n";
		    	  }
		      }
		      
		      myWriter.append(linea);
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

}
