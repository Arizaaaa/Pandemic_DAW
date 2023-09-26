
public class Main {
	
	static Musica main;
	static Musica menu;
	static Musica game;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Creamos el objeto Musica		main = new Musica("Assets/Musica/mainTheme.wav");
		menu = new Musica("Assets/Musica/menuTheme.wav");
		game = new Musica("Assets/Musica/gameTheme.wav");;
		
		//Creamos el objeto Pantalla
		Pantalla pantalla = new Pantalla();
		
		//Llamamos al marco de carga
		MarcoCarga marcoCarga1 = new MarcoCarga();	
	}

}