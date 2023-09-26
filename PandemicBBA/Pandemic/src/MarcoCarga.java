import java.awt.Toolkit;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MarcoCarga extends JFrame{
	
	//Creamos un objeto de PanelPrincipal

	PanelPrincipal lamina1;
	
    static float[] v = new float[4];
	
	MarcoCarga(){
  
	    //Creamos el marco de carga
        setIconImage(Toolkit.getDefaultToolkit().getImage("Assets/Icono.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setBounds(((Pantalla.width - 1423) / 2), ((Pantalla.height - 632) / 2), 1423, 632);
        
		// Reproducimos la música
        Main.main.start();
        
		//Añadimos el objeto de PanelPrincipal
		add(lamina1 = new PanelPrincipal());
		setVisible(true);
		
	}
}