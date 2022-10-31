/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public interface IIpod_simulator {

	/***
	 * Este método enciende / Apaga el dispositivo, recibe una variable booleana
	 * que tiene el estado actual del dispositivo
	 * @param actual_state el estado actual del dispositivo
	 * @return el estado futuro del dipositivo
	 */
	public boolean SwitchONOFF(boolean actual_state);

	
	/***
	 * Este método bloquea / Desblocquea el dispositivo, para que no se ejecute ninguna
	 * acción cuando esté bloqueado
	 * @param actual_locked_state estado de bloqueo actual del dispositivo
	 * @return estado de bloqueo futuro del dispositivo
	 */
	public boolean LockUnlockDevice(boolean actual_locked_state);
	
	/***
	 * Obtiene el volumen actual
	 * @return valor que indica el volumen actual
	 */
	public float getVolume();
	
	/***
	 * Establece el volumen actual
	 * @param volume 
	 * @return
	 */
	public float setVolume(float volume);
	
	/***
	 * Adelanta una cancion en la lista y la devuelve
	 * @param actual_index el indice actual
	 * @return el nuevo indice
	 */
	public int Prev(int actual_index);
	
	/***
	 * Regresa una cancion en la lista y la devuelve
	 * @param actual_index el indice actual
	 * @return el nuevo indice
	 */
	public int Next(int actual_index);
	
	/***
	 * Obtiene el indice actual de la cancion que se esta ejecutando
	 * @return el indice actual
	 */
	public int getActualIndex();
	
	/***
	 * Establece el indice Actual
	 * @param actual_index 
	 */
	public void setActualIndex(int actual_index);
	
	
}
