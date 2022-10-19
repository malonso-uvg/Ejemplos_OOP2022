/**
 * 
 */
package edu.uvg.ej4.controller;

/**
 * @author MAAG
 *
 */
public interface IDataStoreInitializable {

	public boolean initializeDS() throws Exception;
	public boolean finalizeDS() throws Exception;
	
}
