import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelInfo extends JPanel implements ActionListener{	
	
	// Creamos cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/1cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");

    // Creamos boton
	Boton atras;
	JLabel tituloAutores;
	JTextArea autores;
	JLabel version;
	
	// Creamos imagen
	private Image imagen;
	
	static ArrayList<Musica> canciones;
	
	// Creamos el PanelInfo
	PanelInfo() { 
				
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Título
		tituloAutores = new JLabel("AUTORES");
		tituloAutores.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((Pantalla.height*50)/1080)));
		tituloAutores.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((150*Pantalla.height)/1080), Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*70)/1080));
		tituloAutores.setForeground(Color.white);
		
		// Autores
		autores = new JTextArea("Adahi Baz Riu\r\nAndreu Bellavista Suarez\r\nMarc Ariza Gómez-Coronado");
		autores.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*40)/1080)));
		autores.setForeground(Color.white);
		autores.setOpaque(false);
		autores.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((250*Pantalla.height)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*150)/1080));
		autores.setEditable(false);
		
		// Versión
		version = new JLabel("VERSIÓN 1.0");
		version.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((Pantalla.height*50)/1080)));
		version.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((575*Pantalla.height)/1080), Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*50)/1080));
		version.setForeground(Color.white);
		
		// Botón para volver
		atras = new Boton("ATRÁS", (int) Math.round(Pantalla.width*0.04), (int) Math.round(Pantalla.height*0.75), Math.round((Pantalla.width*425)/1920), Math.round((Pantalla.height*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		
		// Añadimos
		add(tituloAutores);
		add(autores);
		add(atras);
		add(version);
		
	}
	
	// Ponemos imagen de fondo
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/ImagenMenu.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen.getScaledInstance(Pantalla.width, Pantalla.height, Image.SCALE_DEFAULT), 0, 0, null);
		
	}

	// Ponemos enlace a los botones
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == atras) {
			JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelJugar());
			marco.setVisible(true);
		}

	}
	
}