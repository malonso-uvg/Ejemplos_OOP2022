/**
 * 
 */
package gui;

/**
 * @author MAAG
 *
 */
public class Estudiante {

	
	private int carnet;
	private String nombre;
	private double nota;
	
	public Estudiante(int carnet, String nombre, double nota) {
		setCarnet(carnet);
		setNombre(nombre);
		setNota(nota);
	}
	/**
	 * @return the carnet
	 */
	public int getCarnet() {
		return carnet;
	}
	/**
	 * @param carnet the carnet to set
	 */
	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the nota
	 */
	public double getNota() {
		return nota;
	}
	/**
	 * @param nota the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		
		return "Estudiante " + getNombre() + " Carnet: " + getCarnet() + " Nota: " + getNota();
	}
	
	
}
