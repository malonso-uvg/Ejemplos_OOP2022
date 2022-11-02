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
	 * @exception Exception Cuando el indice esta fuera de rango
	 */
	public void setActualIndex(int actual_index) throws Exception;
	
	/**
	 * Este metodo guarda una cancion en listado de favoritos
	 * @param _song la cancion que se desea guardar
	 * @exception Exception cuando la lista ya esta llena
	 */
	public void addToFavorite(ICancion _song) throws Exception;
	
	/***
	 * Devolvera una cancion especifica del listado general
	 * @param index el indice en el que se encuentra la cancion
	 * @return El objeto Cancion
	 * @exception Exception Cuando el indice esta fuera de rango
	 */
	public ICancion selectSpecificSong(int index) throws Exception;
	
	/***
	 * Devolvera una cancion especifica del listado de las favoritas
	 * @param index el indice en el que se encuentra la cancion
	 * @return El objeto Cancion
	 * @exception Exception Cuando el indice esta fuera de rango
	 */
	public ICancion selectSpecificFavoriteSong(int index) throws Exception;
	
	/**
	 * Este metodo devuelve el listado completo de canciones
	 * @return el listado de canciones
	 */
	public ICancion[] getAllSongs();
	
	/***
	 * ESte metodo devuelve el estado general del ipod
	 * @param _isON valor logico que indica si esta encendido o apagado
	 * @param _isLocked valor logico que indica si esta bloqueado o desbloqueado
	 * @param _isPlaying valor logico que indica si esta sonando una cancion o no
 	 * @param _actualSong valor que indica que cancion esta sonando
	 * @return Un cadena que contien e el estado de la informacion
	 */
	public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong);
	
	/***
	 * Verifica si un indice es valido o no
	 * @param index el indice que se desea verificar
	 * @return true si el indice contiene cancion, false de lo cointrario
	 */
	public boolean isValidIndex(int index);
	
	/***
	 * Se agrega una cancion para ser instanciada en el metodo y agregada a la lista
	 * @param _titulo 
	 * @param _artista
	 * @param _album
	 * @param _duracion
	 * @param _id
	 * @exception Exception si el listado esta lleno
	 */
	public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id) throws Exception;
	
	/**
	 * Este metodo elimina una cancion de una posicion determinada
	 * @param index
	 * @exception Exception Cuando el indice esta fuera de rango
	 */
	public void deleteSongFromList(int index) throws Exception;
	
	/**
	 * Elimina una cancion de la lista de favoritas pero no del listado general
	 * @param index
	 * @exception Exception Cuando el indice esta fuera de rango
	 */
	public void deleteSongFromTop10(int index) throws Exception;
	
	
	
}
