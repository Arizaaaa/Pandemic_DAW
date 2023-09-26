//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Point;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.imageio.ImageIO;
//import javax.swing.AbstractAction;
//import javax.swing.Action;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import javax.swing.plaf.FontUIResource;
//
//@SuppressWarnings("serial")
//public class PanelUsuario extends JPanel implements ActionListener{	
//	
//	// Creamos cursores
//	Toolkit tk = Toolkit.getDefaultToolkit();
//	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
//	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
//	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
//	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
//	
//	// Obtenemos la altura y el ancho de la pantalla
//	Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
//	int h = p.height;
//    int w = p.width;
//    
//    // Creamos y redimensionamos imagen
//    Image imgLogin = new ImageIcon("Assets/login.png").getImage();
//    ImageIcon imagenUsuario = new ImageIcon(imgLogin.getScaledInstance(Math.round((w*1220)/1920), Math.round((h*600)/1080), Image.SCALE_DEFAULT));
//	
//    private static final String USER = "PND_LIDHULT";
//	private static final String PWD = "AAM1234";
//	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
//	static Connection con = null;
//    
//    // Creamos boton
//	JButton siguiente;
//	JLabel lTitulo;
//	JLabel login;
//	JLabel aviso;
//	static JTextField usuario;
//	
//	static String nombre;
//	
//	static boolean crearUsu = true;
//	
//	// Creamos imagen
//	private Image imagen;
//	
//	static ArrayList<Musica> canciones;
//	
//	// Creamos el PanelUsuario
//	PanelUsuario(ArrayList<Musica> cancion) { 
//		
//	//	Connection connection = makeConnection();
//		
//		canciones = cancion;
//		
//		this.setCursor(cursor1);
//		this.setVisible(true);
//		
//		setLayout(null);
//		
//		// Comprobamos si el usuario exite
//		Action action = new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				nombre = usuario.getText();
//				
//				comprobar();
//				if (!crearUsu || aviso.isVisible()) {
//					
//					if(aviso.isVisible()) { pasar();
//						
//					} else { pasar(); }
//					
//				} else { aviso.setVisible(true);}
//					
//				
//			}
//		};
//		
//		// Botón para seguir
//		siguiente = new JButton("SIGUIENTE");
//		siguiente.setBounds((int) Math.round((775*w)/1920), (int) Math.round((675*h)/1080), Math.round((w*200)/1920), Math.round((h*50)/1080));
//		siguiente.addActionListener(this);
//		siguiente.setBackground(Color.darkGray);
//		siguiente.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((h*22)/1080)));
//		siguiente.setForeground(Color.white);
//		siguiente.addMouseListener(new MouseAdapter() {
//			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
//			public void mouseEntered(MouseEvent e) {if (!usuario.getText().equals("")) {setCursor(cursor2);}}});
//		
//		// Título de login
//		lTitulo = new JLabel("LOGIN");
//		lTitulo.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((h*50)/1080)));
//		lTitulo.setBounds(Math.round((325*w)/1920), Math.round((275*h)/1080), Math.round((w*450)/1920), Math.round((h*50)/1080));
//		lTitulo.setForeground(Color.white);
//		
//		// Textfield para que el usuario escriba su usuario
//		usuario = new JTextField();
//		usuario.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((h*25)/1080)));
//		usuario.setBounds((int)Math.round((325*w)/1920), (int)Math.round((515*h)/1080), Math.round((w*1100)/1920), Math.round((h*50)/1080));
//		usuario.setOpaque(false);
//		usuario.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {usuario.setEditable(true); aviso.setVisible(false);}});
//		usuario.addActionListener(action);
//		
//		// Imagen de login
//		login = new JLabel(imagenUsuario);
//		login.setBounds((int)Math.round((250*w)/1920), (int)Math.round((220*h)/1080), Math.round((w*1220)/1920), Math.round((h*600)/1080));
//		login.setVisible(true);
//		login.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {usuario.setEditable(false);}});
//		
//		// Alerta para confirmar la creación de un usuario
//		aviso = new Label("Este usuario no esta creado, vuelve a clicar para crearlo", Math.round((100* w)/1920), (int)Math.round((600*h)/1080), Math.round((w*920)/1920), Math.round((h*25)/1080),255,0,0,25,1);
//		aviso.setVisible(false);
//		
//		// Añadimos
//		add(aviso);
//		add(lTitulo);
//		add(usuario);
//		add(siguiente);
////		add(login);
//		
////		@SuppressWarnings("unused")
////		Connection con = makeConnection();
//		
//		// Ponemos la Musica
//		cancion.get(1).play();
//		
//	}
//	
//	// Ponemos imagen de fondo
//	public void paintComponent(Graphics g) {
//		
//		super.paintComponent(g);
//		File file = new File("Assets/ImagenMenu.png");
//		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
//		g.drawImage(imagen.getScaledInstance(w, h, Image.SCALE_DEFAULT), 0, 0, null);
//		
//	}
//	
////	public static Connection makeConnection() {
////		
////		System.out.println("Connecting database...");
////		
////		
////		//intentamos la conexion a la base de datos
////		try  {
////			Class.forName("oracle.jdbc.driver.OracleDriver");
////			con = DriverManager.getConnection(URL,USER,PWD);
////			
////			System.out.println("Database connected!");
////			
////		} catch (SQLException e) {
////		    throw new IllegalStateException("Cannot connect the database! ", e);
////		    
////		} catch (ClassNotFoundException e) {
////			e.printStackTrace();
////		}
////		//devolvemos el valor de la conexion
////		return con;		
////	}
//
//	public static void login(Connection con) {
//		
//		try {
//
//		String sql2 = "INSERT INTO JUGADOR(NOMBRE) VALUES ('"+usuario.getText()+"')";
//		
//			Statement statement = (Statement) con.createStatement();
//			statement.execute(sql2);
//			statement.close();
//			
//		} catch (SQLException e) {}
//	}
//	
//	// Comprobamos que el usuario existe
//	public void comprobar() {
//		
//		try {
//			
//			String sql = "SELECT * FROM JUGADOR ORDER BY PUNTOS DESC";
//			
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		    
//		   while(rs.next()) {
//		    	
//		        String usu = rs.getString("NOMBRE");
//		       
//		        if (nombre.equals(usu)) { crearUsu = false; }
//		        
//		    }
//		      
//		    st.close();
//		   
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! " + e);}
//	}
//	
//	// pasamos pantalla
//	public void pasar() {
//		
//		
//		if (!crearUsu ||  aviso.isVisible()) {
//			
//			login(con);
//			JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
//			marco.remove(this);
//			marco.add(new PanelJugar(canciones));
//			marco.setVisible(true);
//		
//		} else if (!usuario.getText().equals("")) {
//			
//			login(con);
//			JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
//			marco.remove(this);
//			marco.add(new PanelJugar(canciones));
//			marco.setVisible(true);
//			
//		}
//	}
//	
//	// Ponemos enlace a los botones
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if (e.getSource() == siguiente) {
//			
//			nombre = usuario.getText();
//			
//			comprobar();
//			System.out.println(crearUsu);
//			
//			if (!crearUsu || aviso.isVisible()) {
//				
//				if(aviso.isVisible()) {
//					
//					pasar();
//					
//				} else {
//					
//					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
//					marco.remove(this);
//					marco.add(new PanelJugar(canciones));
//					marco.setVisible(true);
//				}
//				
//			} else { aviso.setVisible(true); }
//			
//		}
//	}
//}