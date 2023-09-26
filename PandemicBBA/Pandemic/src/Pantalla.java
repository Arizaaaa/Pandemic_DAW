import java.awt.Toolkit;
import java.awt.Dimension;

public class Pantalla {
	
	static int height;
	static int width;
	
	public Pantalla() {
		
		//Obtenemos la altura y el ancho de la pantalla
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		height = screen.height;
	    width = screen.width;
	}
}
