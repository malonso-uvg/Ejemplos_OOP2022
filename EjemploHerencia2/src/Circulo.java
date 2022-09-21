/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public class Circulo extends FiguraGeometrica {

	private double radio;
	
	public Circulo(double _radio) {
		this.radio = _radio;
		this.setTipo(0);
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
		return (2.00 * Math.PI * radio); 
	}

	@Override
	public double calcularArea() {
		return (Math.PI * Math.pow(radio, 2));
	}

	@Override
	public String toString() {
		return "Circulo de radio: " + radio;
	}

	
}
