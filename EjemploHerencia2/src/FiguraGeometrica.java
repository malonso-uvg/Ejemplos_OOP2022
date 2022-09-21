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
	public static final int RECTANGULO = 0;
	
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

	public double calcularPerimetro() {
		return 0;
	}
	
	public double calcularArea() {
		return 0;
	}
}
