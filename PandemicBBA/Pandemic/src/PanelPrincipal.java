import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel implements ActionListener{

    //Creamos objetos
	Boton jugar;
	JLabel texto;
	
	//Creamos una imagen
	private Image imagen;
	
	public Timer timer;
	static boolean parar=false;
	
	PanelPrincipal(){
		
		setLayout(null);
		
		// Modificamos el primer boton
		jugar = new Boton("", 0, 0, 1423, 632);
		jugar.addActionListener(this);
		
		// Modificamos el texto
		texto = new JLabel("CLICA PARA JUGAR");
		texto.setForeground(Color.white);
		texto.setBounds(600, 500, 250, 50);
		texto.setVisible(false);
		texto.setFont(new FontUIResource("Calibri BOLD", Font.PLAIN, 20));
		
		// Temporizador
		timer = new Timer(3000, null);
		timer.start();
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				timer.stop(); 
				texto.setVisible(true);
				
			}
		});		
		
		// Lo añadimos al panel
		add(jugar);
		add(texto);	
	}
	
	// Ponemos una imagen de fondo
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/ImagenCarga.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen, 0, 0, null);
		
	}
	
	// Ponemos enlace a los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==jugar){
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.setVisible(false);
			Main.main.close();
			try {Thread.sleep(2000);} catch (InterruptedException e1) {e1.printStackTrace();}
			new Marco();
		}
	
	}
	
}