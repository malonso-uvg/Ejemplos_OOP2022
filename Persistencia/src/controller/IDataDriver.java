/**
 * 
 */
package controller;

/**
 * @author moises.alonso
 *
 */
public interface IDataDriver<T> {

	void setData(T _data);
	T getData();
	
	void connectDataSource();
	void dissconnectDataSource();
	
	void saveData();
	
}
