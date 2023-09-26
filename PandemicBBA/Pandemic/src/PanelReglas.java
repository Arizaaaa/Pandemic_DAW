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
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelReglas extends JPanel implements ActionListener{	
	
	// Creamos cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("C:Assets//cursor1.png");
	Image imagenCursor2 = tk.getImage("C:Assets//cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");

    // Creamos boton
	Boton atras;
	JLabel tituloReglas;
	JTextArea reglas;
	
	// Creamos imagen
	private Image imagen;
		
	// Creamos el PanelInfo
	PanelReglas() { 
		
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Bot�n para volver
		atras = new Boton("ATR�S", (int) Math.round(Pantalla.width*0.04), (int) Math.round(Pantalla.height*0.75), Math.round((Pantalla.width*425)/1920), Math.round((Pantalla.height*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		
		// T�tulo
		tituloReglas = new JLabel("REGLAS");
		tituloReglas.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*50)/1080)));
		tituloReglas.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((100*Pantalla.height)/1080), Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*50)/1080));
		tituloReglas.setForeground(Color.white);
		
		// Explicaci�n del juego
		reglas = new JTextArea();
		reglas.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*15)/1080)));
		reglas.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((225*Pantalla.height)/1080), Math.round((Pantalla.width*800)/1920), Math.round((Pantalla.height*600)/1080));
		reglas.setOpaque(false);
		reglas.setEditable(false);
		reglas.setFont(new FontUIResource("Calibri", Font.PLAIN, 20));
		reglas.setText("Pandemic es un juego en el que proteger�s al mundo de una\n"
				+ "pandemia mundial donde, cuatro enfermedades identificadas con colores;\n"
				+ "amarillo, azul, verde y rojo, ir�n continuamente contagiando y matando.\n"
				+ "\n"
				+ "Para evitar esto, investigar�s las vacunas de las respectivas enfermedades.\n"
				+ "Tambi�n podr�s curar las ciudades que quieras, construir laboratorios\n"
				+ "y hacer publicidad sobre higienizaci�n, lo que aumentar� la velocidad de la\n"
				+ "investigaci�n de las vacunas y reducir� la tasa de mortalidad de las\n"
				+ "enfermedades, respectivamente. Cada acci�n te costar� una cantidad de energia.\n"
				+ "Deber�s tener cuidado, ya que las enfermedades tienen hasta tres niveles,\n"
				+ "siendo el �ltimo mucho peor que los anteriores, puesto que la enfermedad\n"
				+ "habr� llegado a su variante m�s mortal y, si se contagia una ciudad\n"
				+ "con alguna enfermedad a nivel tres, se contagiar�n todas las ciudades colindantes.\n"
				+ "\n"
				+ "En caso de victoria obtendr�s puntos, con lo que podr�s subir en el Ranking.");
		reglas.setForeground(Color.white);
		
		// A�adimos
		add(tituloReglas);
		add(reglas);
		add(atras);
		
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