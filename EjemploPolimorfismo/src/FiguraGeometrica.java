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
	
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	public double calcularPerimetro() {
		return 0;
	}
	
	public double calcularArea() {
		return 0;
	}
}
