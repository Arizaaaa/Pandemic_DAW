import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelAjustes extends JPanel implements ActionListener{
	
	// Creamos el cursor
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
	
	// Obtenemos la altura y el ancho de la pantalla
	Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
	int h = p.height;
    int w = p.width;
    
    // Creamos variable spara guardar el volumen
    static float v;
    static float vpc;
    static float vmp;
    static float vj;
    static float[] V = new float[4];

    // Creamos los botones
	Boton atras; 
	JLabel titulo;
	JLabel v1;
	static JSlider s1;
	JLabel v2;
	static JSlider s2;
	JLabel v3;
	static JSlider s3;
	JLabel v4;
	static JSlider s4;

	// Creamos una imagen
	private Image imagen;
	
	// Creamos una arraylist estática para pasar la música al siguiente panel
	static ArrayList<Musica> canciones;
	
	PanelAjustes(ArrayList<Musica> cancion){
		
		// Pasamos la música
		canciones = cancion;
		
		// Ponemos el cursor
		this.setCursor(cursor1);
		this.setVisible(true);
		
		// Leemos el txt para saber el volumen
		definirVolumen();
		v=V[0];
		vpc=V[1];
		vmp=V[2];
		vj=V[3];

		setLayout(null);
		
		// Creamos el título
		titulo = new JLabel("AJUSTES");
		titulo.setBounds((int) Math.round(w*0.05), (int) Math.round(h*0.1), Math.round((w*400)/1920), Math.round((h*100)/1080));
		titulo.setVisible(true);
		titulo.setFont(new FontUIResource("Calibri Bold", Font.PLAIN, Math.round((h*100)/1080)));
		titulo.setForeground(Color.white);
		
		// Título de volumen general
		v1 = new JLabel("VOLUMEN GENERAL");
		v1.setBounds((int) Math.round(w*0.05), (int) Math.round(h*0.3), Math.round((w*750)/1920), Math.round((h*40)/1080));
		v1.setVisible(true);
		v1.setForeground(Color.white);
		v1.setFont(new FontUIResource("Calibri", Font.PLAIN, Math.round((h*40)/1080)));
		
		// Slider de volumen general
		s1 = new JSlider(0, 100, Math.round(V[0]));
		s1.setBounds((int) Math.round(w*0.3), (int) Math.round(h*0.3), Math.round((w*250)/1920), Math.round((h*50)/1080));
		s1.setVisible(true);
		s1.setOpaque(false);
		s1.setBackground(Color.GREEN);
		s1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				v = s1.getValue();
				vpc = s2.getValue();
				vmp = s3.getValue();
				vj = s4.getValue();
				
				try{canciones.get(0).fc.setValue(((v/100)*(vpc))-80);}catch(Exception e1) {}
				try{canciones.get(1).fc.setValue(((v/100)*(vmp))-80);}catch(Exception e1) {}
				try{canciones.get(2).fc.setValue(((v/100)*(vj))-80);}catch(Exception e1) {}
				
			}
		});
		
		// Título del volumen de carga
		v2 = new JLabel("VOLUMEN DE CARGA");
		v2.setBounds((int) Math.round(w*0.11), (int) Math.round(h*0.375), Math.round((w*750)/1920), Math.round((h*100)/1080));
		v2.setVisible(true);
		v2.setForeground(Color.white);
		v2.setFont(new FontUIResource("Calibri", Font.PLAIN, Math.round((h*25)/1080)));
		
		// Slider del volumend de carga
		s2 = new JSlider(0, 80, Math.round(V[1]));
		s2.setBounds((int) Math.round(w*0.3), (int) Math.round(h*0.395), Math.round((w*200)/1920), Math.round((h*50)/1080));
		s2.setVisible(true);
		s2.setOpaque(false);
		s2.setBackground(Color.GREEN);
		s2.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				v = s1.getValue();
				vpc = s2.getValue();
				vmp = s3.getValue();
				vj = s4.getValue();
				
				try{canciones.get(0).fc.setValue(((v/100)*(vpc))-80);}catch(Exception e1) {}
				try{canciones.get(1).fc.setValue(((v/100)*(vmp))-80);}catch(Exception e1) {}
				try{canciones.get(2).fc.setValue(((v/100)*(vj))-80);}catch(Exception e1) {}
				
			}
		});

		// Título del columen del menú
		v3 = new JLabel("VOLUMEN DE MENÚ");
		v3.setBounds((int) Math.round(w*0.11), (int) Math.round(h*0.425), Math.round((w*750)/1920), Math.round((h*100)/1080));
		v3.setVisible(true);
		v3.setForeground(Color.white);
		v3.setFont(new FontUIResource("Calibri", Font.PLAIN, Math.round((h*25)/1080)));
		
		// Slider del volumen del menú
		s3 = new JSlider(0, 80, Math.round(V[2]));
		s3.setBounds((int) Math.round(w*0.3), (int) Math.round(h*0.445), Math.round((w*200)/1920), Math.round((h*50)/1080));
		s3.setVisible(true);
		s3.setOpaque(false);
		s3.setBackground(Color.GREEN);
		s3.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				v = s1.getValue();
				vpc = s2.getValue();
				vmp = s3.getValue();
				vj = s4.getValue();
				
				try{canciones.get(0).fc.setValue(((v/100)*(vpc))-80);}catch(Exception e1) {}
				try{canciones.get(1).fc.setValue(((v/100)*(vmp))-80);}catch(Exception e1) {}
				try{canciones.get(2).fc.setValue(((v/100)*(vj))-80);}catch(Exception e1) {}
				
			}
		});
		
		// Título del volumen del juego
		v4 = new JLabel("VOLUMEN DE JUEGO");
		v4.setBounds((int) Math.round(w*0.11), (int) Math.round(h*0.475), Math.round((w*750)/1920), Math.round((h*100)/1080));
		v4.setVisible(true);
		v4.setForeground(Color.white);
		v4.setFont(new FontUIResource("Calibri", Font.PLAIN, Math.round((h*25)/1080)));
		
		// Slider del volumen del juego
		s4 = new JSlider(0, 80, Math.round(V[3]));
		s4.setBounds((int) Math.round(w*0.3), (int) Math.round(h*0.5), Math.round((w*200)/1920), Math.round((h*50)/1080));
		s4.setVisible(true);
		s4.setOpaque(false);
		s4.setBackground(Color.GREEN);
		s4.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				v = s1.getValue();
				vpc = s2.getValue();
				vmp = s3.getValue();
				vj = s4.getValue();
				
				try{canciones.get(0).fc.setValue(((v/100)*(vpc))-80);}catch(Exception e1) {}
				try{canciones.get(1).fc.setValue(((v/100)*(vmp))-80);}catch(Exception e1) {}
				try{canciones.get(2).fc.setValue(((v/100)*(vj))-80);}catch(Exception e1) {}
				
			}
		});
		
		// Creamos el boton para salir
		atras = new Boton("ATRÁS", (int) Math.round(w*0.04), (int) Math.round(h*0.75), Math.round((w*425)/1920), Math.round((h*75)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		
		// Añadimos todo al Panel
		add(titulo);
		add(atras);
		add(v1);
		add(s1);
		add(v2);
		add(s2);
		add(v3);
		add(s3);
		add(v4);
		add(s4);
			
	}
	
	// Función para leer el txtd el volumen
	static void definirVolumen() {
		
		try {

			BufferedReader br = new BufferedReader(new FileReader("Ficheros/volumen.txt"));
			
			for(int i = 0; i < 4; i++) {
	
				V[i] = Float.parseFloat(br.readLine());

			}
		
			br.close();
	
		} catch (IOException e) {}
		
	}
	
	// Ponemos la imagen de fondo
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/ImagenMenu.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen.getScaledInstance(w, h, Image.SCALE_DEFAULT), 0, 0, null);
		
	}	
	
	// Ponemos enlace a los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==atras){
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			escribir();
			marco.remove(this);
			marco.add(new PanelJugar(canciones));
			marco.setVisible(true);
			
		}	
		
	}
	
	// Escribimos el txt del volumen
	public void escribir() {
			
			try {

				BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros/volumen.txt", false));
		
					bw.write(Math.round(v)+"\n");
					bw.write(Math.round(vpc)+"\n");
					bw.write(Math.round(vmp)+"\n");
					bw.write(Math.round(vj)+"\n");
			
				bw.close();
		
			} catch (IOException e) {}
			
		}

}
