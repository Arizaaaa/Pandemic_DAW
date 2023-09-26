// Clase de los atributos de las habilidades de las enfermedades
public class Habilidad {

	private double mortalidad;
	private double resistencia;
	private int contagio;
	private int evolucion;
	
	public Habilidad(double mortalidad, double d, int contagio, int evolucion) {
		
		this.mortalidad = mortalidad;
		this.resistencia = d;
		this.contagio = contagio;
		this.evolucion = evolucion;
		
	}
	
	// Setters y getters
	public double getMortalidad() { return mortalidad; }
	public void setMortalidad(int mortalidad) { this.mortalidad = mortalidad; }
	public double getResistencia() { return resistencia; } 
	public void setResistencia(int resistencia) { this.resistencia = resistencia; }
	public int getContagio() { return contagio; }
	public void setContagio(int contagio) { this.contagio = contagio;}
	public int getEvolucion() { return evolucion; }
	public void setEvolucion(int evolucion) { this.evolucion = evolucion; }
	
	//rojo mata
	//amarillo resistente
	//verde contagio
	//azul evoluciona habilidad+

}