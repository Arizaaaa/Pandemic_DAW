import java.util.ArrayList;

// Clase de las ciudades
public class Ciudad {
	
	private String nombre;
	private long poblacionTotal;
	private long poblacionMuerta;
	private int ciudadMuerta;
	private int rojo;
	private int amarillo;
	private int verde;
	private int azul;	
	private ArrayList<String> colindantes = new ArrayList<String>();

	public Ciudad(String nombre, long poblacionTotal, ArrayList<String> colindantes) {
		
		this.nombre = nombre;
		this.poblacionTotal = poblacionTotal;
		this.poblacionMuerta = 0;
		this.ciudadMuerta = 0;
		this.rojo = 0;
		this.amarillo = 0;
		this.verde = 0;
		this.azul = 0;
		this.colindantes = colindantes;
		
	}
	
	public Ciudad(String nombre, long poblacionTotal, long poblacionMuerta, int rojo, int amarillo, int verde, int azul, ArrayList<String> colindantes) {
		
		this.nombre = nombre;
		this.poblacionTotal = poblacionTotal;
		this.poblacionMuerta = poblacionMuerta;
		this.ciudadMuerta = 0;
		this.rojo = rojo;
		this.amarillo = amarillo;
		this.verde = verde;
		this.azul = azul;
		this.colindantes = colindantes;
		
	}	
	
	// Función para curar donde restamos el nivel del color
	public void curar(boolean amarillo, boolean azul, boolean rojo, boolean verde) {
		
		if(amarillo  && this.ciudadMuerta == 0) {this.amarillo=0;} else if(!amarillo && this.amarillo>0  && this.ciudadMuerta == 0) {this.amarillo--;}
		if(azul && this.azul>0 && this.ciudadMuerta == 0) {this.azul=0;} else if(!azul && this.azul>0 && this.ciudadMuerta == 0) {this.azul--;}
		if(rojo && this.rojo>0 && this.ciudadMuerta == 0) {this.rojo=0;} else if(!rojo && this.rojo>0 && this.ciudadMuerta == 0) {this.rojo--;}
		if(verde && this.verde>0 && this.ciudadMuerta == 0) {this.verde=0;} else if(!verde && this.verde>0 && this.ciudadMuerta == 0) {this.verde--;}
		
	}

	// Setters y getters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public long getPoblacionTotal() { return poblacionTotal; }
	public void setPoblacionTotal(long poblacionTotal) { this.poblacionTotal = poblacionTotal; }
	public long getPoblacionMuerta() { return poblacionMuerta; }
	public void setPoblacionMuerta(long poblacionMuerta) { this.poblacionMuerta = poblacionMuerta; }
	public int getCiudadMuerta() {return this.ciudadMuerta;}
	public int getRojo() { return rojo; }
	public void setRojo(int rojo) { this.rojo = rojo; }
	public int getAmarillo() { return amarillo; }
	public void setAmarillo(int amarillo) { this.amarillo = amarillo; }
	public int getVerde() { return verde; }
	// Como el verde se contagia de 2 en 2, hacemos un setter para que no pase de 3, el nivel máximo
	public void setVerde(int verde) { 
		
		if (verde > 3) { this.verde = 3;} 
		else { this.verde = verde; }
		
	}
	public int getAzul() { return azul; }
	public void setAzul(int azul) { this.azul = azul; }
	public ArrayList<String> getColindantes() { return colindantes; }
	public void setColindantes(ArrayList<String> colindantes) { this.colindantes = colindantes; }
	public void setCiudadMuerta(int b) {this.ciudadMuerta = b;}

}
