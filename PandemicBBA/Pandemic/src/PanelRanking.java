import java.awt.Cursor;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PanelRanking extends JPanel implements ActionListener{	
	
	// Creamos cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
	
	Image iRanking = new ImageIcon("Assets/Ranking.png").getImage();
	ImageIcon lRanking = new ImageIcon(iRanking.getScaledInstance(Math.round((Pantalla.width*1200)/1920), Math.round((Pantalla.height*900)/1080), Image.SCALE_DEFAULT));
	
    // Creamos boton
	Boton atras;
	JLabel marcoRanking;
	
	Label f1;
	Label p1;
	Label n1;
	Label f2;
	Label p2;
	Label n2;
	Label f3;
	Label p3;
	Label n3;
	Label f4;
	Label p4;
	Label n4;
	Label f5;
	Label p5;
	Label n5;
	Label f6;
	Label p6;
	Label n6;
	Label f7;
	Label p7;
	Label n7;
	Label f8;
	Label p8;
	Label n8;
	Label f9;
	Label p9;
	Label n9;
	Label f10;
	Label p10;
	Label n10;

	static ArrayList<Usuario> ranking = new ArrayList<Usuario>();
	
	// Creamos imagen
	private Image imagen;
	
	// Creamos el PanelRanking
	PanelRanking() { 
		
//		cargarRanking(PanelUsuario.con);
			
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Botón para volver
		atras = new Boton("ATRÁS", Math.round((Pantalla.width*1600)/1920), Math.round((Pantalla.height*900)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		
		// imagen de ranking
		marcoRanking = new JLabel(lRanking);
		marcoRanking.setBounds(Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*120)/1080), Math.round((Pantalla.width*1200)/1920), Math.round((Pantalla.height*900)/1080));
		marcoRanking.setVisible(true);
		
		// nombre, fecha de última partida y puntuación de cada uno de los 10 mejores usuarios, respectivamente
		n1 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*235)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 239, 184, 16, 40, 0);
		n1.setText(ranking.get(0).getNombre());
		
		f1 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*235)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 239, 184, 16, 40, 1);
		f1.setText(ranking.get(0).getFecha());
		
		p1 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*235)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 239, 184, 16, 40, 2);
		p1.setText(String.valueOf(ranking.get(0).getPuntuacion()));
		
		n2 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*310)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 192, 192, 192, 40, 0);
		n2.setText(ranking.get(1).getNombre());
		
		f2 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*310)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 192, 192, 192, 40, 1);
		f2.setText(ranking.get(1).getFecha());
		
		p2 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*310)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 192, 192, 192, 40, 2);
		p2.setText(String.valueOf(ranking.get(1).getPuntuacion()));
		
		n3 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*375)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 205, 127, 50, 40, 0);
		n3.setText(ranking.get(2).getNombre());
		
		f3 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*375)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 205, 127, 50, 40, 1);
		f3.setText(ranking.get(2).getFecha());
		
		p3 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*375)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 205, 127, 50, 40, 2);
		p3.setText(String.valueOf(ranking.get(2).getPuntuacion()));
		
		n4 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*435)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n4.setText(ranking.get(3).getNombre());
		
		f4 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*435)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f4.setText(ranking.get(3).getFecha());
		
		p4 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*435)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p4.setText(String.valueOf(ranking.get(3).getPuntuacion()));
		
		n5 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n5.setText(ranking.get(4).getNombre());
		
		f5 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f5.setText(ranking.get(4).getFecha());
		
		p5 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p5.setText(String.valueOf(ranking.get(4).getPuntuacion()));
		
		n6 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*565)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n6.setText(ranking.get(5).getNombre());
		
		f6 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*565)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f6.setText(ranking.get(5).getFecha());
		
		p6 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*565)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p6.setText(String.valueOf(ranking.get(5).getPuntuacion()));
		
		n7 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*635)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n7.setText(ranking.get(6).getNombre());
		
		f7 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*635)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f7.setText(ranking.get(6).getFecha());
		
		p7 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*635)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p7.setText(String.valueOf(ranking.get(6).getPuntuacion()));
		
		n8 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*695)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n8.setText(ranking.get(7).getNombre());
		
		f8 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*695)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f8.setText(ranking.get(7).getFecha());
		
		p8 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*695)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p8.setText(String.valueOf(ranking.get(7).getPuntuacion()));
		
		n9 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*765)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n9.setText(ranking.get(8).getNombre());
		
		f9 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*765)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f9.setText(ranking.get(8).getFecha());
		
		p9 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*765)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p9.setText(String.valueOf(ranking.get(8).getPuntuacion()));
	
		n10 = new Label(" ", Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*825)/1080), Math.round((Pantalla.width*325)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 0);
		n10.setText(ranking.get(9).getNombre());
		
		f10 = new Label(" ", Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*825)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 1);
		f10.setText(ranking.get(9).getFecha());
		
		p10 = new Label(" ", Math.round((Pantalla.width*1090)/1920), Math.round((Pantalla.height*825)/1080), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*75)/1080), 255, 255, 255, 40, 2);
		p10.setText(String.valueOf(ranking.get(9).getPuntuacion()));
		
		// Añadimos
		add(f1);
		add(p1);
		add(n1);
		add(f2);
		add(p2);
		add(n2);
		add(f3);
		add(p3);
		add(n3);
		add(f4);
		add(p4);
		add(n4);
		add(f5);
		add(p5);
		add(n5);
		add(f6);
		add(p6);
		add(n6);
		add(f7);
		add(p7);
		add(n7);
		add(f8);
		add(p8);
		add(n8);
		add(f9);
		add(p9);
		add(n9);
		add(f10);
		add(p10);
		add(n10);
		add(marcoRanking);
		add(atras);
		
	}
	
	// Ponemos imagen de fondo
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/ImagenMenu.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen.getScaledInstance(Pantalla.width, Pantalla.height, Image.SCALE_DEFAULT), 0, 0, null);
		
	}
	
	// Cargamos los datos de los usuarios
	public void cargarRanking(Connection con) {
		
		try {
			
			String sql = "SELECT * FROM JUGADOR ORDER BY PUNTOS DESC";
			
			Statement st = con.createStatement();
			
		    ResultSet rs = st.executeQuery(sql);
		       
		   for(int i = 0; i < 10; i++) {
		    
		   rs.next();
		    	
		        String nombre = rs.getString("NOMBRE");
		        String fecha = rs.getString("FECHA");
		        int puntos = rs.getInt("PUNTOS");
		        
		        ranking.add(new Usuario(nombre, fecha, puntos));
		        
		    }
		      
		    st.close();
		   
		} catch (SQLException e) {
			System.out.println("The SELECT had problems!! " + e);
			
		}
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