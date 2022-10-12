/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public abstract class FiguraGeometrica {

	protected int tipo;
	public static final int CIRCULO = 0;
	public static final int RECTANGULO = 1;
	public static final int ESFERA = 2;
	public static final int CUBO = 3;
	public static final int TRIANGULO = 4;
	public static final int CONO = 5;
	
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public double calcularArea() {
		return 0;
	}
}
