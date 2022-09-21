/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public class Rectangulo extends FiguraGeometrica {

	private double base;
	private double altura;
	
	public Rectangulo(double _base, double _altura) {
		setBase(_base);
		setAltura(_altura);
		this.setTipo(1);
	}
	
	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calcularPerimetro() {
		return (2.00 * base + 2.00 * altura);
	}

	@Override
	public double calcularArea() {		
		return (base * altura);
	}

	@Override
	public String toString() {
		return "Rectangulo con base: " + base + " y altura: " + altura;
	}

	
}
