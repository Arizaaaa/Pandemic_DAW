import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Marco extends JFrame{

	// Creamos un objeto de PanelJugar
		PanelUsuario lamina1;
		
		// Creamos y modificamos el objeto Marco
		Marco(ArrayList<Musica> cancion){
			
	        setIconImage(Toolkit.getDefaultToolkit().getImage("Assets/Icono.png"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setUndecorated(true);
			setExtendedState(MAXIMIZED_BOTH);
			setTitle("Pandemic");
			add(lamina1 = new PanelUsuario(cancion));
			setVisible(true);
		
	}
	
}

