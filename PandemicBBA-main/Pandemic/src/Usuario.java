// Objeto de usuario
public class Usuario {

	private String nombre;
	private int puntuacion;
	private String fecha;
	
	
	public Usuario(String nombre, String fecha, int puntuacion) {
		
		this.nombre = nombre;
		this.fecha = fecha;
		this.puntuacion = puntuacion;

	}
	
	public Usuario() {
		
		this.nombre = "--------";
		this.puntuacion = 0;
		this.fecha = "--/--/-- --:--:--";
	}

	// Setters y getters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public int getPuntuacion() {return puntuacion;}
	public void setPuntuacion(int puntuacion) {this.puntuacion = puntuacion;}
	public String getFecha() {return fecha;}
	public void setFecha(String fecha) {this.fecha = fecha;}
	
	
	
}
