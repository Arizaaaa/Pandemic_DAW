import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MarcoCarga extends JFrame{
	
	//Creamos un objeto de PanelPrincipal

	PanelPrincipal lamina1;
	
    static float[] v = new float[4];
	
	MarcoCarga(){
		
		//Obtenemos la altura y el ancho de la pantalla
		Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
		int h = p.height;
	    int w = p.width;
  
	    //Creamos el marco de carga
        setIconImage(Toolkit.getDefaultToolkit().getImage("Assets/Icono.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setBounds(((w - 1423) / 2), ((h - 632) / 2), 1423, 632);
		
		// Leemos el txt para saber qué volumen guardó el usuario al jugar
		leer();
		
		// Creamos el arraylist para guardar los objetos de musica
		ArrayList<Musica> cancion = new ArrayList<Musica>();
		
		cancion.add(new Musica("Assets/Musica/mainTheme.wav", ((v[0]/100)*(v[1]))-80));
		cancion.add(new Musica("Assets/Musica/menuTheme.wav", ((v[0]/100)*(v[2]))-80));
		cancion.add(new Musica("Assets/Musica/gameTheme.wav", ((v[0]/100)*(v[3]))-80));

		//Añadimo el objeto de PanelPrincipal
		add(lamina1 = new PanelPrincipal(cancion));
		setVisible(true);
		
	}
	
	// Función para leer el txtd el volumen
	static void leer() {
		
		try {

			BufferedReader br = new BufferedReader(new FileReader("Ficheros/volumen.txt"));
			
			for(int i = 0; i < 4; i++) {
	
				v[i] = Float.parseFloat(br.readLine());

			}
		
			br.close();
	
		} catch (IOException e) {}
		
	}
	
}