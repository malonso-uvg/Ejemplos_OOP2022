/**
 * 
 */

/**
 * @author MAAG
 *
 */
public class Esfera extends FiguraGeometrica implements IFigura3D{

	private double radio;
	
	public Esfera(double _radio) {
		super();
		this.setTipo(FiguraGeometrica.ESFERA);
		this.setRadio(_radio);
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
	public double calcularArea() {
		return 4.00 * Math.PI * Math.pow(radio, 2.00);
	}

	@Override
	public double calcularVolumen() {
		return (4.00 / 3.00) * Math.PI * Math.pow(radio, 3.00);
	}


	@Override
	public String toString() {
		return "Esfera de radio " + radio;
	}
	
	

}
