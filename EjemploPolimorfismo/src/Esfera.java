/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public class Esfera extends FiguraGeometrica {

	private double radio;
	
	public Esfera() {
		super();
		this.tipo = ESFERA;
	}
	
	public Esfera(int _radio) {
		super();
		radio = _radio;
		this.tipo = ESFERA;
	}
	
	/**
	 * @return the radio
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		return 2.00 * Math.PI * getRadio();
	}

	@Override
	public double calcularArea() {
		return 4.00 * Math.PI * Math.pow(getRadio(), 2);
	}
	
	@Override
	public String toString() {
		return "Esfera de radio: " + radio;
	}

	public double calcularVolumen() {
		return (4.00 / 3.00) * Math.PI * Math.pow(radio, 3);
	}
}
