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
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelJugar extends JPanel implements ActionListener{
	
	// Creamos el cursor
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	
	// Obtenemos la altura y el ancho de la pantalla
	Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
	int h = p.height;
    int w = p.width;

    // Creamos los botones
	Boton salir; 
	Boton nueva;
	Boton cargar;
	Boton ajustes;
	Boton ranking;
	Boton creditos;
	Boton reglas;
	JLabel titulo;
	static boolean cargarPasar = false;

	// Creamos una imagen
	private Image imagen;
	
	static ArrayList<Musica> canciones;
	
	PanelJugar(ArrayList<Musica> cancion){
		
		canciones = cancion;
		
		// Ponemos el cursor
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Creamos el titulo
		titulo = new JLabel("PANDEMIC");
		titulo.setBounds((int) Math.round(w*0.05), (int) Math.round(h*0.1), Math.round((w*500)/1920), Math.round((h*100)/1080));
		titulo.setVisible(true);
		titulo.setFont(new FontUIResource("Calibri Bold", Font.PLAIN, Math.round((w*100)/1920)));
		titulo.setForeground(Color.white);
		
		// Creamos el boton de nueva partida
		nueva = new Boton("NUEVA PARTIDA", (int) Math.round(w*0.04), (int) Math.round(h*0.375), Math.round((w*450)/1920), Math.round((h*50)/1080));
		nueva.addActionListener(this);
		nueva.MouseListener();
		
		// Creamos el boton de cargar partida
		cargar = new Boton("CARGAR PARTIDA", (int) Math.round(w*0.04), (int) Math.round(h*0.450), Math.round((w*450)/1920), Math.round((h*50)/1080));
		cargar.addActionListener(this);
		cargar.MouseListener();
		
		// Creamos el boton de ajustes
		ajustes = new Boton("AJUSTES", (int) Math.round(w*0.04), (int) Math.round(h*0.525), Math.round((w*425)/1920), Math.round((h*50)/1080));
		ajustes.addActionListener(this);
		ajustes.MouseListener();
		
		// Creamos el boton de ranking
		ranking = new Boton("RANKING", (int) Math.round(w*0.04), (int) Math.round(h*0.600), Math.round((w*425)/1920), Math.round((h*50)/1080));
		ranking.addActionListener(this);
		ranking.MouseListener();
		
		// Creamos el boton de creditos
		creditos = new Boton("CRÉDITOS", (int) Math.round(w*0.04), (int) Math.round(h*0.675), Math.round((w*425)/1920), Math.round((h*50)/1080));
		creditos.addActionListener(this);
		creditos.MouseListener();
		
		// Creamos el boton de reglas
		reglas = new Boton("REGLAS", (int) Math.round(w*0.04), (int) Math.round(h*0.75), Math.round((w*425)/1920), Math.round((h*50)/1080));
		reglas.addActionListener(this);
		reglas.MouseListener();
		
		// Creamos el boton para salir
		salir = new Boton("SALIR", (int) Math.round(w*0.04), (int) Math.round(h*0.825), Math.round((w*425)/1920), Math.round((h*50)/1080));
		salir.addActionListener(this);
		salir.MouseListener();
		
		// A�adimos todo al Panel
		add(titulo);
		add(nueva);
		add(cargar);
		add(ajustes);
		add(ranking);
		add(creditos);
		add(reglas);
		add(salir);
		
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
		
		if (e.getSource()==salir){
			System.exit(0);
			
		} else if (e.getSource() == nueva) {
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelNuevaPartida(canciones));
			marco.setVisible(true);
			
		} else if (e.getSource() == cargar) {
			
			cargar(PanelUsuario.con);
			
			if (cargarPasar) {
				
				JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.add(new PanelCargar(canciones));
				marco.setVisible(true);	
	
			}
			
		}else if (e.getSource() == ajustes) {
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelAjustes(canciones));
			marco.setVisible(true);	
		
		} else if (e.getSource() == ranking) {
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelRanking(canciones));
			marco.setVisible(true);			
			
		} else if (e.getSource() == creditos) {
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelInfo(canciones));
			marco.setVisible(true);			
			
		} else if (e.getSource() == reglas) {
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelReglas(canciones));
			marco.setVisible(true);	
			
		}
		
	}
	
	public static void cargar(Connection con) {
		
		String sql = "SELECT USUARIO, LIMITEMUEROTS FROM PARTIDA WHERE USUARIO ='"+PanelUsuario.nombre+"'";
		
		try {
			Statement st = con.createStatement();
			
		    ResultSet rs = st.executeQuery(sql);
		       
		    while (rs.next()){
		    	
		        String nombre = rs.getString("USUARIO");
		        long limi = rs.getLong("LIMITEMUEROTS");
		        
		        if (PanelUsuario.nombre.equals(nombre) && limi != 0) { cargarPasar = true;}
		    }
		      
		    st.close();
		    
		} catch (SQLException e) {
			System.out.println("The SELECT had problems!! " + e);
			
		}
	}

}
