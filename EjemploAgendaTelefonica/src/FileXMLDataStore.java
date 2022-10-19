/**
 * 
 */
import java.io.File;

import edu.uvg.ej4.controller.Agenda;
import edu.uvg.ej4.controller.DataStore;
/**
 * @author MAAG
 *
 */
public class FileXMLDataStore extends DataStore {

	private File file;
	private String path;
	
	public FileXMLDataStore(Agenda _agenda) {
		super();
		setAgenda(_agenda);
	}
	
	public FileXMLDataStore(Agenda _agenda, String _path) {
		super();
		setAgenda(_agenda);
		setPath(_path);
		setFile(new File(_path));
	}
	
	public FileXMLDataStore(Agenda _agenda, File _file, String _path) {
		super();
		setAgenda(_agenda);
		setFile(_file);
		setPath(_path);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finalizeDS() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveData() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getData() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
