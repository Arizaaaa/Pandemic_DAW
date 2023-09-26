import java.awt.Toolkit;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Marco extends JFrame{

	// Creamos un objeto de PanelJugar
		PanelJugar lamina1;
		
		// Creamos y modificamos el objeto Marco
		Marco(){
			
	        setIconImage(Toolkit.getDefaultToolkit().getImage("Assets/Icono.png"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setUndecorated(true);
			setExtendedState(MAXIMIZED_BOTH);
			setTitle("Pandemic");
			
			// Reproducimos la música
	        Main.menu.start();
	        
			add(lamina1 = new PanelJugar());
			setVisible(true);
	}	
}