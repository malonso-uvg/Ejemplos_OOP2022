/**
 * 
 */

/**
 * @author MAAG
 *
 */
public class Cubo extends FiguraGeometrica implements IFigura3D{

	private double lado;
	
	public Cubo(double lado) {
		super();
		
		this.setLado(lado);
		this.setTipo(FiguraGeometrica.CUBO);
	}
	
	
	/**
	 * @return the alto
	 */
	public double getLado() {
		return lado;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 6.00 * Math.pow(lado, 2.00);
	}

	@Override
	public double calcularVolumen() {
		return Math.pow(lado, 3.00);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cubo de lado " + lado;
	}
	
	

}
