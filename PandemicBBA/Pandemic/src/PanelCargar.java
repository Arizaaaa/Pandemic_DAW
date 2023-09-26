import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class PanelCargar extends JPanel implements ActionListener{	
	
	// Creamos cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
	
	Image iPartida1 = new ImageIcon("Assets/CargarPartida1.png").getImage();
    ImageIcon bPartida1 = new ImageIcon(iPartida1.getScaledInstance(Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080), Image.SCALE_DEFAULT));
    Image iPartida2 = new ImageIcon("Assets/CargarPartida2.png").getImage();
    ImageIcon bPartida2 = new ImageIcon(iPartida2.getScaledInstance(Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080), Image.SCALE_DEFAULT));
    Image iPartida3 = new ImageIcon("Assets/CargarPartida3.png").getImage();
    ImageIcon bPartida3 = new ImageIcon(iPartida3.getScaledInstance(Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080), Image.SCALE_DEFAULT));
	
    // Creamos boton
	Boton atras;
	JLabel tituloAutores;
	JLabel partida1;
	Label dP1;
	Label pP1;
	Label fP1;
	Label vRP1;
	Label vVP1;
	Label vAmP1;
	Label vAzP1;
	JLabel partida2;
	Label dP2;
	Label pP2;
	Label fP2;
	Label vRP2;
	Label vVP2;
	Label vAmP2;
	Label vAzP2;
	JLabel partida3;
	Label dP3;
	Label pP3;
	Label fP3;
	Label vRP3;
	Label vVP3;
	Label vAmP3;
	Label vAzP3;
	JLabel version;
	
	// Creamos variables varias
	static String dificultad1,dificultad2,dificultad3;
	static String fecha1,fecha2,fecha3;
	static String facil;
	static int pR1, pV1, pAm1, pAz1;
	static int mR1,mV1,mAm1,mAz1;
	static int pR2, pV2, pAm2, pAz2;
	static int mR2,mV2,mAm2,mAz2;
	static int pR3, pV3, pAm3, pAz3;
	static int mR3,mV3,mAm3,mAz3;
	static int idPartida;
	static int rr = 242; 
	static int rg = 0;
	static int rb = 6;
	static int vr = 14; 
	static int vg = 237;
	static int vb = 31;
	static boolean cargarPasar;
	
	JButton cargar1;
	JButton cargar2;
	JButton cargar3;
	
	// Creamos imagen
	private Image imagen;
	
	static ArrayList<Musica> canciones;
	
	// Creamos el PanelInfo
	PanelCargar(ArrayList<Musica> cancion) { 
		
//		// Cargamos datos para las fichas del panel
//		cargarDatosFicha();
		
		canciones = cancion;
		
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Creamos el título
		tituloAutores = new JLabel("CARGAR PARTIDA");
		tituloAutores.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((Pantalla.height*50)/1080)));
		tituloAutores.setBounds(Math.round((100*Pantalla.width)/1920), Math.round((100*Pantalla.height)/1080), Math.round((Pantalla.width*700)/1920), Math.round((Pantalla.height*70)/1080));
		tituloAutores.setForeground(Color.white);
		
		// Creamos el label de la partida 1
		partida1 = new JLabel(bPartida1);
		partida1.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((200*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		
		// Escribimos la información de la partida 1
		if (mR1 != 0 ) {dP1 = new Label(dificultad1,Math.round((287*Pantalla.width)/1920), Math.round((344*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);
		} else {dP1 = new Label("",Math.round((287*Pantalla.width)/1920), Math.round((344*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);}
		pP1 = new Label("Partida 1",Math.round((520*Pantalla.width)/1920), Math.round((230*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);
		if (mR1 != 0 ){fP1 = new Label(fecha1,Math.round((715*Pantalla.width)/1920), Math.round((225*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else {fP1 = new Label("--/--/-- --:--:--",Math.round((780*Pantalla.width)/1920), Math.round((225*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);}
		if (mR1 == 0) { vRP1 = new Label("Estado Vacuna Roja: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((280*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);
		}else if (pR1 == mR1 ) { vRP1 = new Label("Estado Vacuna Roja: " +pR1+ " / "+mR1,Math.round((520*Pantalla.width)/1920), Math.round((280*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		} else { vRP1 = new Label("Estado Vacuna Roja: " +pR1+ " / "+mR1,Math.round((520*Pantalla.width)/1920), Math.round((280*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mV1 == 0 ) { vVP1 = new Label("Estado Vacuna Verde: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((310*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);
		}else if (pV1 == mV1 ) { vVP1 = new Label("Estado Vacuna Verde: "+pV1+" / "+mV1,Math.round((520*Pantalla.width)/1920), Math.round((310*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);}
		else { vVP1 = new Label("Estado Vacuna Verde: "+pV1+" / "+mV1,Math.round((520*Pantalla.width)/1920), Math.round((310*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20); }
		if (mAm1 == 0) { vAmP1 = new Label("Estado Vacuna Amarilla: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((340*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);
		}else if (pAm1 == mAm1) { vAmP1 = new Label("Estado Vacuna Amarilla: "+pAm1+" / "+mAm1,Math.round((520*Pantalla.width)/1920), Math.round((340*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20); }
		else { vAmP1 = new Label("Estado Vacuna Amarilla: "+pAm1+" / "+mAm1,Math.round((520*Pantalla.width)/1920), Math.round((340*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mAz1 == 0) {vAzP1 = new Label("Estado Vacuna Azul: "+pAz1+" / "+mAz1,Math.round((520*Pantalla.width)/1920), Math.round((370*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20); }
		else if (pAz1 == mAz1) {vAzP1 = new Label("Estado Vacuna Azul: "+pAz1+" / "+mAz1,Math.round((520*Pantalla.width)/1920), Math.round((370*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20); }
		else {vAzP1 = new Label("Estado Vacuna Azul: "+pAz1+" / "+mAz1,Math.round((520*Pantalla.width)/1920), Math.round((370*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20); }

		// Creamos el título de la partida 2
		partida2 = new JLabel(bPartida2);
		partida2.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((500*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		
		// Información de la partida 2
		if(mR2 != 0) { dP2 = new Label(dificultad2,(287*Pantalla.width)/1920, Math.round((645*Pantalla.height)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);
		} else {dP2 = new Label("",(287*Pantalla.width)/1920, Math.round((645*Pantalla.height)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);}
		pP2 = new Label("Partida 2",Math.round((520*Pantalla.width)/1920), Math.round((530*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);
		if(mR2 != 0) {fP2 = new Label(fecha2,Math.round((715*Pantalla.width)/1920), Math.round((525*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else {fP2 = new Label("--/--/-- --:--:--",Math.round((780*Pantalla.width)/1920), Math.round((525*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);}
		if(mR2 == 0) { vRP2 = new Label("Estado Vacuna Roja: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((575*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);
		}else if(pR2 == mR2) { vRP2 = new Label("Estado Vacuna Roja: " +pR2+" / "+mR2,Math.round((520*Pantalla.width)/1920), Math.round((575*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		} else {vRP2 = new Label("Estado Vacuna Roja: " +pR2+" / "+mR2,Math.round((520*Pantalla.width)/1920), Math.round((575*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if(mV2 == 0) {vVP2 = new Label("Estado Vacuna Verde: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((605*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);}
		else if(pV2 == mV2) {vVP2 = new Label("Estado Vacuna Verde: "+pV2+" / "+mV2,Math.round((520*Pantalla.width)/1920), Math.round((605*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);}
		else {vVP2 = new Label("Estado Vacuna Verde: "+pV2+" / "+mV2,Math.round((520*Pantalla.width)/1920), Math.round((605*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20); }
		if(mAm2 == 0) {vAmP2 = new Label("Estado Vacuna Amarilla: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((635*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);	
		}else if(pAm2 == mAm2) {vAmP2 = new Label("Estado Vacuna Amarilla: "+pAm2+" / "+mAm2,Math.round((520*Pantalla.width)/1920), Math.round((635*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		} else {vAmP2 = new Label("Estado Vacuna Amarilla: "+pAm2+" / "+mAm2,Math.round((520*Pantalla.width)/1920), Math.round((635*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mAz2 == 0) { vAzP2 = new Label("Estado Vacuna Azul: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((665*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255,255,255,20);
		}else if (pAz2 == mAz2) { vAzP2 = new Label("Estado Vacuna Azul: "+pAz2+" / "+mAz2,Math.round((520*Pantalla.width)/1920), Math.round((665*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		} else {vAzP2 = new Label("Estado Vacuna Azul: "+pAz2+" / "+mAz2,Math.round((520*Pantalla.width)/1920), Math.round((665*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		
		// Título de la partida 3
		partida3 = new JLabel(bPartida3);
		partida3.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((800*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		
		// Información de la partida 3
		if (mR3 != 0) {dP3 = new Label(dificultad3,Math.round((287*Pantalla.width)/1920), Math.round((945*Pantalla.height)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,28);
		} else {dP3 = new Label("",Math.round((287*Pantalla.width)/1920), Math.round((945*Pantalla.height)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,28);}
		pP3 = new Label("Partida 3",Math.round((520*Pantalla.width)/1920), Math.round((830*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,30);
		if(mR3 != 0) {fP3 = new Label(fecha3,Math.round((715*Pantalla.width)/1920), Math.round((825*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else {fP3 = new Label("--/--/-- --:--:--",Math.round((780 *Pantalla.width)/1920), Math.round((825*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);}
		if (mR3 == 0) { vRP3 = new Label("Estado Vacuna Roja: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((875*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else if(pR3 == mR3) {vRP3 = new Label("Estado Vacuna Roja: "+pR2+" / "+mR2,Math.round((520*Pantalla.width)/1920), Math.round((875*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		}else{vRP3 = new Label("Estado Vacuna Roja: "+pR2+" / "+mR2,Math.round((520*Pantalla.width)/1920), Math.round((875*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mV3 == 0) { vVP3 = new Label("Estado Vacuna Verde: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((905*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else if(pV3 == mV3) {vVP3 = new Label("Estado Vacuna Verde: "+pV2+" / "+mV2,Math.round((520*Pantalla.width)/1920), Math.round((905*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		}else{vVP3 = new Label("Estado Vacuna Verde: "+pV2+" / "+mV2,Math.round((520*Pantalla.width)/1920), Math.round((905*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mAm3 == 0) {vAmP3 = new Label("Estado Vacuna Amarilla: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((935*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255 ,255, 255,20);
		}else if (pAm3 == mAm3) {vAmP3 = new Label("Estado Vacuna Amarilla: "+pAm2+" / "+mAm2,Math.round((520*Pantalla.width)/1920), Math.round((935*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		}else{vAmP3 = new Label("Estado Vacuna Amarilla: "+pAm2+" / "+mAm2,Math.round((520*Pantalla.width)/1920), Math.round((935*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		if (mAz3 == 0) { vAzP3 = new Label("Estado Vacuna Azul: -- / --",Math.round((520*Pantalla.width)/1920), Math.round((965*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),255, 255, 255,20);
		}else if(pAz3 == mAz3) {vAzP3 = new Label("Estado Vacuna Azul: "+pAz2+" / "+mAz2,Math.round((520*Pantalla.width)/1920), Math.round((965*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),vr, vg, vb,20);
		}else{vAzP3 = new Label("Estado Vacuna Azul: "+pAz2+" / "+mAz2,Math.round((520*Pantalla.width)/1920), Math.round((965*Pantalla.height)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*60)/1080),rr, rg, rb,20);}
		
		// Botón para volver al menú
		atras = new Boton("ATRÁS", Math.round((1600*Pantalla.width)/1920), Math.round((900*Pantalla.height)/1080), Math.round((Pantalla.width*425)/1920), Math.round((Pantalla.height*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		
		// Botón para cargar la partida 1
		cargar1 = new JButton();
		cargar1.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((200*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		cargar1.setFocusPainted(false);
		cargar1.setBorderPainted(false);
		cargar1.setContentAreaFilled(false);
		cargar1.addActionListener(this);
		cargar1.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		// Botón para cargar la aprtida 2
		cargar2 = new JButton();
		cargar2.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((500*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		cargar2.setFocusPainted(false);
		cargar2.setBorderPainted(false);
		cargar2.setContentAreaFilled(false);
		cargar2.addActionListener(this);
		cargar2.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		// Botón para cargar la partida 3
		cargar3 = new JButton();
		cargar3.setBounds(Math.round((250*Pantalla.width)/1920), Math.round((800*Pantalla.height)/1080), Math.round((Pantalla.width*750)/1920), Math.round((Pantalla.height*250)/1080));
		cargar3.setFocusPainted(false);
		cargar3.setBorderPainted(false);
		cargar3.setContentAreaFilled(false);
		cargar3.addActionListener(this);
		cargar3.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		// Añadimos
		add(cargar1);
		add(cargar2);
		add(cargar3);
		add(tituloAutores);
		add(dP1);
		add(pP1);
		add(fP1);
		add(vRP1);
		add(vVP1);
		add(vAmP1);
		add(vAzP1);
		add(partida1);
		add(dP2);
		add(pP2);
		add(fP2);
		add(vRP2);
		add(vVP2);
		add(vAmP2);
		add(vAzP2);
		add(partida2);
		add(dP3);
		add(pP3);
		add(fP3);
		add(vRP3);
		add(vVP3);
		add(vAmP3);
		add(vAzP3);
		add(partida3);
		add(atras);
	
	}
	
//	// Lee de la base de datos los datos de las partidas
//	public void cargarDatosFicha() {
//		
//		Connection con = PanelUsuario.con;
//		
//				
//		try {
//			
//			String sql = "SELECT * FROM PARTIDA WHERE ID_PARTIDA = '"+1+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		    while (rs.next()) { 
//		    	
//		    	long limi = rs.getLong("LIMITEMUEROTS");
//		    	String li = String.valueOf(limi);
//		    	
//		    	fecha1 = rs.getString("FECHA");
//		    	pR1 = rs.getInt("INLABR"); if (pR1 == 30) { pR1 = 0;}
//		    	pV1 = rs.getInt("INLABV"); if (pV1 == 30) { pV1 = 0;}
//		    	pAm1 = rs.getInt("INLABAM"); if (pAm1 == 30) { pAm1 = 0;}
//		    	pAz1 = rs.getInt("INLABAZ"); if (pAz1 == 30) { pAz1 = 0;}
//		    	mR1 = rs.getInt("CIVACUNAROJA");
//		    	mV1 = rs.getInt("CIVACUNA_VERDE");
//		    	mAm1 = rs.getInt("CIVACUNA_AMARILLA");
//		    	mAz1 = rs.getInt("CIVACUNA_AZUL");
//		    
//		    	if(li .equals("3943184274")) { dificultad1 = "FACIL"; } else if(li .equals("2143184274")) { dificultad1 = "DIFICIL"; } else if(li .equals("-1")) { dificultad1 = "TUTORIAL"; } else { dificultad1 = "CUSTOM"; };
//		         
//		    }
//		     
//		    st.close();
//		    
//		} catch (SQLException e) {
//			System.out.println("The SELECT had problems!! " + e);
//			
//		}
//		
//		try {
//			
//			String sql = "SELECT * FROM PARTIDA WHERE ID_PARTIDA = '"+2+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		    while (rs.next()) { 
//		    	
//		    	long limi = rs.getLong("LIMITEMUEROTS");
//		    	String li = String.valueOf(limi);
//		    	
//		    	fecha2 = rs.getString("FECHA");
//		    	pR2 = rs.getInt("INLABR"); if (pR2 == 30) { pR2 = 0;}
//		    	pV2 = rs.getInt("INLABV"); if (pV2 == 30) { pV2 = 0;}
//		    	pAm2 = rs.getInt("INLABAM"); if (pAm2 == 30) { pAm2 = 0;}
//		    	pAz2 = rs.getInt("INLABAZ"); if (pAz2 == 30) { pAz2 = 0;}
//		    	mR2 = rs.getInt("CIVACUNAROJA");
//		    	mV2 = rs.getInt("CIVACUNA_VERDE");
//		    	mAm2 = rs.getInt("CIVACUNA_AMARILLA");
//		    	mAz2 = rs.getInt("CIVACUNA_AZUL");
//		    
//		    	if(li .equals("3943184274")) { dificultad2 = "FACIL"; } else if(li .equals("2143184274")) { dificultad2 = "DIFICIL"; } else if(li .equals("-1")) { dificultad2 = "TUTORIAL"; } else { dificultad2 = "CUSTOM"; };
//		         
//		    }
//		     
//		    st.close();
//		    
//		} catch (SQLException e) {
//			System.out.println("The SELECT had problems!! " + e);
//			
//		}
//		
//		try {
//			
//			String sql = "SELECT * FROM PARTIDA WHERE ID_PARTIDA = '"+3+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		    while (rs.next()) { 
//		    	
//		    	long limi = rs.getLong("LIMITEMUEROTS");
//		    	String li = String.valueOf(limi);
//		    	
//		    	fecha3 = rs.getString("FECHA");
//		    	pR3 = rs.getInt("INLABR"); if (pR3 == 30) { pR3 = 0;}
//		    	pV3 = rs.getInt("INLABV"); if (pV3 == 30) { pV3 = 0;}
//		    	pAm3 = rs.getInt("INLABAM"); if (pAm3 == 30) { pAm3 = 0;}
//		    	pAz3 = rs.getInt("INLABAZ"); if (pAz3 == 30) { pAz3 = 0;}
//		    	mR3 = rs.getInt("CIVACUNAROJA");
//		    	mV3 = rs.getInt("CIVACUNA_VERDE");
//		    	mAm3 = rs.getInt("CIVACUNA_AMARILLA");
//		    	mAz3 = rs.getInt("CIVACUNA_AZUL");
//		    
//		    	if(li .equals("3943184274")) { dificultad3 = "FACIL"; } else if(li .equals("2143184274")) { dificultad3 = "DIFICIL"; } else if(li .equals("-1")) { dificultad3 = "TUTORIAL"; } else { dificultad3 = "CUSTOM"; };
//		         
//		    }
//		     
//		    st.close();
//		    
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! " + e);}
//	}
	
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
			
		} else if (e.getSource() == cargar1) {
			
			if (mR1 != 0) {
				idPartida = 1;
				cargarPasar = true;
				canciones.get(1).close();
				JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.add(new PanelJuego());
				
			}
			
		}else if (e.getSource() == cargar2) {
			
			if (mR2 != 0) {
				idPartida = 2;
				cargarPasar = true;
				canciones.get(1).close();
				JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.add(new PanelJuego());
				
				}
			
		}else if (e.getSource() == cargar3) {

			if (mR3 != 0) {
				idPartida = 3;				
				cargarPasar = true;
				canciones.get(1).close();
				JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.add(new PanelJuego());
				
				}
		}
	}
}