/**
 * 
 */
package edu.uvg.ej4.controller;

/**
 * @author MAAG
 *
 */
public abstract class DataStore implements IDataStoreInitializable, IDataStoreOperations{

	public static final int TYPE_FIELD = 0;
	public static final int FIRSTNAME_FIELD = 1;
	public static final int LASTNAME_FIELD = 2;
	public static final int DATA_FIELD = 3;
	public static final int DATATYPE_FIELD = 4;
	
	private Agenda agenda;
	
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
	
}
