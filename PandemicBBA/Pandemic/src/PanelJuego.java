import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener{
	
	// Creamos los cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
	
    // Creamos y redimensionamos imagenes
    static ImageIcon pais = new ImageIcon("Assets/b.png");
    Image img = new ImageIcon("Assets/bateria.png").getImage();
    ImageIcon bateria = new ImageIcon(img.getScaledInstance(Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*270)/1080), Image.SCALE_DEFAULT));
    Image img2 = new ImageIcon("Assets/probeta.png").getImage();
    ImageIcon probeta = new ImageIcon(img2.getScaledInstance(Math.round((Pantalla.width*42)/1920), Math.round((Pantalla.height*146)/1080), Image.SCALE_DEFAULT));
    static Image imgT = new ImageIcon("Assets/t.png").getImage();
    static ImageIcon t = new ImageIcon(imgT.getScaledInstance(Math.round((Pantalla.width*20)/1920), Math.round((Pantalla.height*20)/1080), Image.SCALE_DEFAULT));
    Image iLupa = new ImageIcon("Assets/lupa.png").getImage();
    ImageIcon lupa = new ImageIcon(iLupa.getScaledInstance(Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080), Image.SCALE_DEFAULT));
    Image iCalavera = new ImageIcon("Assets/calavera.png").getImage();
    ImageIcon calavera = new ImageIcon(iCalavera.getScaledInstance(Math.round((Pantalla.width*50)/1920), Math.round((Pantalla.height*28)/1080), Image.SCALE_DEFAULT));
    Image iCurar = new ImageIcon("Assets/botonCurar.png").getImage();
    ImageIcon bCurar = new ImageIcon(iCurar.getScaledInstance(Math.round((Pantalla.width*385)/1920), Math.round((Pantalla.height*50)/1080), Image.SCALE_DEFAULT));
    Image iInvestigar = new ImageIcon("Assets/botonInvestigar.png").getImage();
    ImageIcon bInvestigar = new ImageIcon(iInvestigar.getScaledInstance(Math.round((Pantalla.width*50)/1920), Math.round((Pantalla.height*50)/1080), Image.SCALE_DEFAULT));
    Image iAjustes = new ImageIcon("Assets/Ajustes.png").getImage();
    ImageIcon bAjustes = new ImageIcon(iAjustes.getScaledInstance(Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*75)/1080), Image.SCALE_DEFAULT));
    Image lFondoSalir = new ImageIcon("Assets/marcoSalir.png").getImage();
    ImageIcon bFondoSalir = new ImageIcon(lFondoSalir.getScaledInstance(Math.round((Pantalla.width*447)/1920), Math.round((Pantalla.height*175)/1080), Image.SCALE_DEFAULT));
    Image iGuardar = new ImageIcon("Assets/guardar.png").getImage();
    ImageIcon bGuardar = new ImageIcon(iGuardar.getScaledInstance(Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*75)/1080), Image.SCALE_DEFAULT));
    Image iVolumen = new ImageIcon("Assets/volumen.png").getImage();
    ImageIcon bVolumen = new ImageIcon(iVolumen.getScaledInstance(Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*75)/1080), Image.SCALE_DEFAULT));
    static Image iPub = new ImageIcon("Assets/mascarilla.png").getImage();
    static ImageIcon bPub = new ImageIcon(iPub.getScaledInstance(Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*150)/1080), Image.SCALE_DEFAULT));
    Image bFondoGuardar = new ImageIcon("Assets/marcoGuardar.png").getImage();
    ImageIcon iFondoGuardar = new ImageIcon(bFondoGuardar.getScaledInstance(Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*200)/1080), Image.SCALE_DEFAULT));
    Image iVictoria = new ImageIcon("Assets/victoria.png").getImage();
    ImageIcon lVictoria = new ImageIcon(iVictoria.getScaledInstance(Math.round((Pantalla.width*1000)/1920), Math.round((Pantalla.height*500)/1080), Image.SCALE_DEFAULT));
    Image iDerrota = new ImageIcon("Assets/derrota.png").getImage();
    ImageIcon lDerrota = new ImageIcon(iDerrota.getScaledInstance(Math.round((Pantalla.width*1000)/1920), Math.round((Pantalla.height*500)/1080), Image.SCALE_DEFAULT));
    Image iLab0 = new ImageIcon("Assets/Laboratorios/Laboratory0.png").getImage();
    ImageIcon lLab0 = new ImageIcon(iLab0.getScaledInstance(Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*130)/1080), Image.SCALE_DEFAULT));
    Image iPub0 = new ImageIcon("Assets/mascarilla0.png").getImage();
    ImageIcon lPub0 = new ImageIcon(iPub0.getScaledInstance(Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*130)/1080), Image.SCALE_DEFAULT));
    ImageIcon lFondoMenu = new ImageIcon(lFondoSalir.getScaledInstance(Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*75)/1080), Image.SCALE_DEFAULT));
    ImageIcon lFondoVolumen = new ImageIcon(lFondoSalir.getScaledInstance(Math.round((Pantalla.width*350)/1920), Math.round((Pantalla.height*50)/1080), Image.SCALE_DEFAULT));
    Image mdi = new ImageIcon("Assets/mdi.png").getImage();
	ImageIcon mdii = new ImageIcon(mdi.getScaledInstance(Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*441)/1080), Image.SCALE_DEFAULT));
	Image pR = new ImageIcon("Assets/pR.png").getImage();
	ImageIcon pRo = new ImageIcon(pR.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image pV = new ImageIcon("Assets/pV.png").getImage();
	ImageIcon pVe = new ImageIcon(pV.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image pZ = new ImageIcon("Assets/pZ.png").getImage();
	ImageIcon pZu = new ImageIcon(pZ.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image pA = new ImageIcon("Assets/pAm.png").getImage();
	ImageIcon pAm = new ImageIcon(pA.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image pT = new ImageIcon("Assets/pT.png").getImage();
	ImageIcon pTt = new ImageIcon(pT.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image pB = new ImageIcon("Assets/pB.png").getImage();
	ImageIcon pBb = new ImageIcon(pB.getScaledInstance(Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*30)/1080), Image.SCALE_DEFAULT));
	Image mL = new ImageIcon("Assets/iL.png").getImage();
	ImageIcon mll = new ImageIcon(mL.getScaledInstance(Math.round((Pantalla.width*60)/1920), Math.round((Pantalla.height*300)/1080), Image.SCALE_DEFAULT));
	Image mfl = new ImageIcon("Assets/mdi.png").getImage();
	ImageIcon mfll = new ImageIcon(mdi.getScaledInstance(Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*350)/1080), Image.SCALE_DEFAULT));
	
    static ImageIcon r1 = new ImageIcon("Assets/r1.png");
    static ImageIcon r2 = new ImageIcon("Assets/r2.png");
    static ImageIcon r3 = new ImageIcon("Assets/r3.png");
    static ImageIcon am1 = new ImageIcon("Assets/am1.png");
    static ImageIcon am2 = new ImageIcon("Assets/am2.png");
    static ImageIcon am3 = new ImageIcon("Assets/am3.png");
    static ImageIcon az1 = new ImageIcon("Assets/az1.png");
    static ImageIcon az2 = new ImageIcon("Assets/az2.png");
    static ImageIcon az3 = new ImageIcon("Assets/az3.png");
    static ImageIcon v1 = new ImageIcon("Assets/v1.png");
    static ImageIcon v2 = new ImageIcon("Assets/v2.png");
    static ImageIcon v3 = new ImageIcon("Assets/v3.png");
    static ImageIcon n = new ImageIcon("Assets/n.png");
    
    //Creamos elementos varios
    static long limiteMuertos;
    static int limiteEnfermedadRoja;
    static int limiteEnfermedadVerde;
    static int limiteEnfermedadAmarilla;
    static int limiteEnfermedadAzul;
    static int limiteEnfermedad;
    static int limiteBrotes;
    static int totalAmarillo;
    static int totalRojo;
    static int totalVerde;
    static int totalAzul;
    static int totalEnfermedades;
    static int frecuenciaContagio;
    static int recargaEnergia;
    static int velocidadInvestigacion;
    static int cantidadInvestigacionVacunaRoja;
    static int cantidadInvestigacionVacunaVerde;
    static int cantidadInvestigacionVacunaAmarilla;
    static int cantidadInvestigacionVacunaAzul;
    static int contadorBrotes = 0;
	Boton atras;
	
	private Image imagen;

	JButton menu;
	static Barra barra;
	JProgressBar barraAm;
	JProgressBar barraAz;
	JProgressBar barraR;
	JProgressBar barraV;
	Barra muertes;
	static Object objeto = new Object();
	Object objetoAm = new Object();
	Object objetoAz = new Object();
	Object objetoR = new Object();
	Object objetoV = new Object();
	static HiloPrincipal hilo;
	static Thread hiloAm;
	static Thread hiloAz;
    static Thread hiloR;
    static Thread hiloV;
	JButton curar;	
	static JButton investigarAm;
	static JButton investigarAz;
	static JButton investigarR;
	static JButton investigarV;
	JLabel bBateria;
	JLabel probetaAm;
	JLabel probetaAz;
	JLabel probetaR;
	JLabel probetaV;
	JLabel lCalavera;
	static JLabel imagenPais;
	static JLabel nombrePais;
	static JLabel poblacion;
	static JLabel nivelRojo;
	static JLabel nivelAzul;
	static JLabel nivelAmarillo;
	static JLabel nivelVerde;
	static JLabel poblacionMundial;
	static JLabel laboratorios;
	static JLabel publicidades;
	static JLabel laboratorio;
	static JLabel nivelL;
	static JButton mLab;
	static JLabel publicidad;
	static JLabel nivelP;
	static JButton mPub;
	JButton salir;
	JLabel lSalir;
	JLabel pSalir;
	JButton siSalir;
	JButton noSalir;
	JButton guardar;
	JLabel lGuardar;
	JButton partida1;
	JButton partida2;
	JButton partida3;
	JButton volumen;
	JLabel lVolumen;
	static JLabel victoria;
	static JLabel derrota;
	static JButton continuar;
	JLabel fondoMenu;
	static JLabel brotes;
	static JLabel totales;
	static JLabel amarillo;
	static JLabel verde;
	static JLabel azul;
	static JLabel rojo;
	JLabel ll;
	Boton bll;
	JLabel dll;
	Label dlr;
	Label dlv;
	Label dlaz;
	Label dlam;
	Label dlm;
	Label dltr;
	Label dltv;
	Label dltaz;
	Label dltam;
	Label dltm;
	Label dlir1 ,dlir2 ,dlir3 ;
	Label dliv1 ,dliv2 ,dliv3;
	Label dliaz1, dliaz2, dliaz3;
	Label dliam1, dliam2, dliam3;
	Label dlim;
	Label dlit;
	
	static ArrayList <JButton> ciudadesBoton = new ArrayList <JButton>();
	static ArrayList <Ciudad> ciudadesLista = new ArrayList <Ciudad>();
	static ArrayList <ImageIcon> iPais = new ArrayList <ImageIcon>();
	static ArrayList<Musica> canciones;
	
    static float v;
    static float vpc;
    static float vmp;
    static float vj;
    static float[] V = new float[4]; 
	JLabel titulo;
	JSlider s1;
	JSlider s2;
	JSlider s3;
	JSlider s4;
	JLabel md;
	JLabel iVe;
	JLabel iRo;
	JLabel iAzu;
	JLabel iAma;
	JLabel iT;
	JLabel iB;

	static Random rd = new Random();
	static boolean cura = false;
	static boolean investigaAm = false;
	static boolean investigadoAm = false;
	static boolean investigaAz = false;
	static boolean investigadoAz = false;
	static boolean investigaR = false;
	static boolean investigadoR = false;
	static boolean investigaV = false;
	static boolean investigadoV = false;
	static boolean evolucionR = false;
	static boolean evolucionV = false;
	static boolean evolucionAm = false;
	static int paisSeleccionado = 0;
	static long muertosTotales = 0;
	static Long poblacionTotal = 6309825100L;
	static int nvlLab = 0;
	static int nvlPub = 0;
	static int idPartida = 0;
    static int iAm,iAz,iR,iV,eAm,eR,eV = 0;
    static Boolean parar = false;
    Timer timer;
 	Timer ley;
    JLabel texto;
    
	static Habilidad habilidad = new Habilidad(0.01, 1.5 ,2,180000);
	
	PanelJuego(){
		
		setLayout(null);
		
		this.setCursor(cursor1);
		this.setVisible(true);
		
		// Creamos el boton para continuar en caso de ganar o perder junto a los paneles de victorio y derrota
		continuar = new JButton();
		continuar.setContentAreaFilled(false);
		continuar.setBorder(null);
		continuar.setBorderPainted(false);
		continuar.setBounds(0, 0, Pantalla.width, Pantalla.height);
		continuar.setVisible(false);
		continuar.addActionListener(this);
		
		victoria = new JLabel(lVictoria);
		victoria.setBounds(Math.round((Pantalla.width*460)/1920), Math.round((Pantalla.height*290)/1080), Math.round((Pantalla.width*1000)/1920), Math.round((Pantalla.height*500)/1080));
		victoria.setVisible(false);
		
		derrota = new JLabel(lDerrota);
		derrota.setBounds(Math.round((Pantalla.width*460)/1920), Math.round((Pantalla.height*290)/1080), Math.round((Pantalla.width*1000)/1920), Math.round((Pantalla.height*500)/1080));
		derrota.setVisible(false);
		
		add(continuar);
		add(victoria);
		add(derrota);
		
		// Creamos los objetos con los paises y los botones
		try {

			BufferedReader br = new BufferedReader(new FileReader("Ficheros/ciudades.txt"));
			
			for(int i = 0; i < 59; i++) {
	
				ArrayList<String> colindantes = new ArrayList<String>();
				String[] c = br.readLine().split(";");
				String[] n = c[2].split(",");
				int x = Integer.parseInt((n[0]));
				int y = Integer.parseInt((n[1]));
				String[] col = c[3].split(",");

				for(int j = 0; j < col.length; j++) {
					colindantes.add(col[j]);
				}
				
				ciudadesBoton.add(new JButton(pais));
				ciudadesBoton.get(i).setFocusPainted(false);
				ciudadesBoton.get(i).setBorderPainted(false);
				ciudadesBoton.get(i).setContentAreaFilled(false);
				ciudadesBoton.get(i).setBounds(Math.round((Pantalla.width*x)/1920), Math.round((Pantalla.height*y)/1080), 18, 18);
				ciudadesBoton.get(i).addActionListener(this);
				
				ciudadesLista.add(new Ciudad(c[0],Integer.parseInt(c[1]), colindantes));
				
				iPais.add(new ImageIcon(new ImageIcon("Assets/Banderas/" + ciudadesLista.get(i).getNombre() + ".png").getImage().getScaledInstance(Math.round((Pantalla.width*385)/1920), Math.round((Pantalla.height*190)/1080), Image.SCALE_DEFAULT)));
				
				add(ciudadesBoton.get(i));
				
			}
		
			br.close();
	
		} catch (IOException e) {}

		// Barra de energia
	    barra = new Barra(Math.round((Pantalla.width/2)-((45*Pantalla.width)/1920)), Math.round((Pantalla.height)-((237*Pantalla.height)/1080)), Math.round((Pantalla.width*90)/1920), Math.round((Pantalla.height*225)/1080));
		
	    // Botón para curar
		curar = new JButton(bCurar);
		curar.setBounds(0, Math.round((Pantalla.height)-((50*Pantalla.height)/1080)), Math.round((Pantalla.width*385)/1920), Math.round((Pantalla.height*50)/1080));
		curar.addActionListener( new ActionListener() {
		      public void actionPerformed( ActionEvent evt ) {
		    	  synchronized( objeto ) {
						cura=true;
					    objeto.notify();}}});
		curar.setVisible(true);
		curar.setFocusPainted(false);
		curar.setBorder(null);
		curar.setContentAreaFilled(false);
		curar.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*50)/1080)));
		curar.setForeground(Color.white);
		curar.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {if (barra.getValue()>=250) {setCursor(cursor2);}}});
		
		// Imagen dela bateria
		bBateria = new JLabel(bateria);
		bBateria.setBounds(Math.round((Pantalla.width/2)-((50*Pantalla.width)/1920)), Math.round((Pantalla.height)-((265*Pantalla.height)/1080)), Math.round((Pantalla.width*100)/1920), Math.round((Pantalla.height*270)/1080));
		
		// Barra, imagen y botón para investigar de cada vacuna, respectivamente
		barraAm = new Barra(255, 255, 0,cantidadInvestigacionVacunaAmarilla ,(1080*Pantalla.width)/1920, Math.round((Pantalla.height)-((222*Pantalla.height)/1080)), Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*135)/1080));
	//		barraAm.setMaximum((int) (barraAm.getMaximum()*habilidad.getResistencia()));
		barraAm.setMaximum(1000);
		
		probetaAm = new JLabel(probeta);
		probetaAm.setBounds(Math.round((1075*Pantalla.width)/1920), Math.round((Pantalla.height)-((225*Pantalla.height)/1080)), Math.round((Pantalla.width*42)/1920), Math.round((Pantalla.height*146)/1080));
		
		investigarAm = new JButton(lupa);
		investigarAm.setBounds(Math.round((1072*Pantalla.width)/1920), Math.round((Pantalla.height)-((55*Pantalla.height)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		investigarAm.addActionListener( new ActionListener() {
		      public void actionPerformed( ActionEvent evt ) {
		    	  synchronized( objetoAm ) {
		    		  if(barra.getValue()>=999) {hiloAm.start();}
					    objetoAm.notify();}}});
		investigarAm.setVisible(true);
		investigarAm.setFocusPainted(false);
		investigarAm.setBorderPainted(false);
		investigarAm.setContentAreaFilled(false);
		investigarAm.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {if (barra.getValue()>=999) {setCursor(cursor2);}}});
		
		barraAz = new Barra(0, 100, 255,cantidadInvestigacionVacunaAzul,(1140*Pantalla.width)/1920, Math.round((Pantalla.height)-((222*Pantalla.height)/1080)), Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*135)/1080));
		
		probetaAz = new JLabel(probeta);
		probetaAz.setBounds(Math.round((1135*Pantalla.width)/1920), Math.round((Pantalla.height)-((225*Pantalla.height)/1080)), Math.round((Pantalla.width*42)/1920), Math.round((Pantalla.height*146)/1080));
		
		investigarAz = new JButton(lupa);
		investigarAz.setBounds(Math.round((1134*Pantalla.width)/1920), Math.round((Pantalla.height)-((55*Pantalla.height)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		investigarAz.addActionListener( new ActionListener() {
		      public void actionPerformed( ActionEvent evt ) {
		    	  synchronized( objetoAz ) {
						if(barra.getValue()>=999) {investigaAz=true;}
					    objetoAz.notify();}}});
		investigarAz.setVisible(true);
		investigarAz.setFocusPainted(false);
		investigarAz.setBorderPainted(false);
		investigarAz.setContentAreaFilled(false);
		investigarAz.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {if (barra.getValue()>=999) {setCursor(cursor2);}}});
		
		barraR = new Barra(255, 0, 0, cantidadInvestigacionVacunaRoja,(1200*Pantalla.width)/1920, Math.round((Pantalla.height)-((222*Pantalla.height)/1080)), Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*135)/1080));
		
		probetaR = new JLabel(probeta);
		probetaR.setBounds(Math.round((1195*Pantalla.width)/1920), Math.round((Pantalla.height)-((225*Pantalla.height)/1080)), Math.round((Pantalla.width*42)/1920), Math.round((Pantalla.height*146)/1080));
		
		investigarR = new JButton(lupa);
		investigarR.setBounds(Math.round((1195*Pantalla.width)/1920), Math.round((Pantalla.height)-((Pantalla.height*55)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		investigarR.addActionListener( new ActionListener() {
		      public void actionPerformed( ActionEvent evt ) {
		    	  synchronized( objetoR ) {
		    		  if(barra.getValue()>=999) {investigaR=true;}
					    objetoR.notify();}}});
		investigarR.setVisible(true);
		investigarR.setFocusPainted(false);
		investigarR.setBorderPainted(false);
		investigarR.setContentAreaFilled(false);
		investigarR.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {if (barra.getValue()>=999) {setCursor(cursor2);}}});
		
		barraV = new Barra(0, 255, 0,cantidadInvestigacionVacunaVerde,Math.round((1259*Pantalla.width)/1920), Math.round((Pantalla.height)-((222*Pantalla.height)/1080)), Math.round((Pantalla.width*30)/1920), Math.round((Pantalla.height*135)/1080));
		
		probetaV = new JLabel(probeta);
		probetaV.setBounds(Math.round((1253*Pantalla.width)/1920), Math.round((Pantalla.height)-((225*Pantalla.height)/1080)), Math.round((Pantalla.width*42)/1920), Math.round((Pantalla.height*146)/1080));
		
		investigarV = new JButton(lupa);
		investigarV.setBounds(Math.round((1254*Pantalla.width)/1920), Math.round((Pantalla.height)-((55*Pantalla.height)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		investigarV.addActionListener( new ActionListener() {
		      public void actionPerformed( ActionEvent evt ) {
		    	  synchronized( objetoV ) {
		    		  if(barra.getValue()>=999) {investigaV=true;}
					    objetoV.notify();}}});
		investigarV.setVisible(true);
		investigarV.setFocusPainted(false);
		investigarV.setBorderPainted(false);
		investigarV.setContentAreaFilled(false);
		investigarV.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {if (barra.getValue()>=999) {setCursor(cursor2);}}});
		
		// Imagen de pais
		imagenPais = new JLabel();
		imagenPais.setBounds(Math.round((0*Pantalla.width)/1920), Math.round((840*Pantalla.height)/1080), Math.round((Pantalla.width*385)/1920), Math.round((Pantalla.height*190)/1080));
		imagenPais.setVisible(true);
		
		// Nombre de pais
		nombrePais = new JLabel();
		nombrePais.setBounds(Math.round((400*Pantalla.width)/1920), Math.round((840*Pantalla.height)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*50)/1080));
		nombrePais.setForeground(Color.white);
		nombrePais.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*30)/1080)));
		nombrePais.setVisible(true);
		
		// Población de pais
		poblacion = new JLabel();
		poblacion.setBounds(Math.round((650*Pantalla.width)/1920), Math.round((843*Pantalla.height)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		poblacion.setForeground(Color.white);
		poblacion.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		poblacion.setVisible(true);
		poblacion.setHorizontalAlignment(JLabel.RIGHT);

		// Nivel de enfermedades de pais
		nivelRojo = new JLabel();
		nivelRojo.setBounds(Math.round((450*Pantalla.width)/1920), Math.round((880*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		nivelRojo.setForeground(Color.white);
		nivelRojo.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		nivelRojo.setVisible(true);

		nivelAzul = new JLabel();
		nivelAzul.setBounds(Math.round((450*Pantalla.width)/1920), Math.round((920*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		nivelAzul.setForeground(Color.white);
		nivelAzul.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		nivelAzul.setVisible(true);
		
		nivelAmarillo = new JLabel();
		nivelAmarillo.setBounds(Math.round((675*Pantalla.width)/1920), Math.round((880*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		nivelAmarillo.setForeground(Color.white);
		nivelAmarillo.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		nivelAmarillo.setVisible(true);
		
		nivelVerde = new JLabel();
		nivelVerde.setBounds(Math.round((675*Pantalla.width)/1920), Math.round((920*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		nivelVerde.setForeground(Color.white);
		nivelVerde.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		nivelVerde.setVisible(true);
		
		// Nivel de laboratorio
		laboratorios = new JLabel();
		laboratorios.setBounds(Math.round((450*Pantalla.width)/1920), Math.round((1000*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		laboratorios.setText("Laboratorios: 0");
		laboratorios.setForeground(Color.white);
		laboratorios.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		laboratorios.setVisible(true);
		
		// Nivel de publicidad
		publicidades = new JLabel();
		publicidades.setBounds(Math.round((675*Pantalla.width)/1920), Math.round((1000*Pantalla.height)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		publicidades.setText("Publicidades: 0");
		publicidades.setForeground(Color.white);
		publicidades.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		publicidades.setVisible(true);
		
		// Parámetro de poblacion muerta
		poblacionMundial = new JLabel();
		poblacionMundial.setBounds(Math.round((1625*Pantalla.width)/1920), Math.round((750*Pantalla.height)/1080), Math.round((Pantalla.width*225)/1920), Math.round((Pantalla.height*25)/1080));
		poblacionMundial.setForeground(Color.white);
		poblacionMundial.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		poblacionMundial.setVisible(true);
		poblacionMundial.setText("0 / " + limiteMuertos);
		poblacionMundial.setHorizontalAlignment(JLabel.RIGHT);
		
		// Información de leyenda
		bll = new Boton(mll,Math.round(0), Math.round((450*Pantalla.height)/1080), Math.round((Pantalla.width*60)/1920), Math.round((Pantalla.height*300)/1080),true);
		bll.addActionListener(this);

		dll = new JLabel(mfll);
		dll.setBounds(Math.round(0), Math.round((Pantalla.height*470)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*350)/1080));
		dll.setVisible(false);
		
		dlam = new Label("Enfermedad Amarilla:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*480)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080),20);
		dlaz = new Label("Enfermedad Azul:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*550)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080),20);
		dlr = new Label("Enfermedad Roja:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*620)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080),20);
		dlv = new Label("Enfermedad Verde:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*690)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080),20);
		dlm = new Label("Estado Ciudades:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*760)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080),20);

		dltam = new Label("Nlv 1:             Nlv 2:             Nlv 3:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*512)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080),17);
		dltaz = new Label("Nlv 1:             Nlv 2:             Nlv 3:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*582)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080),17);
		dltr = new Label("Nlv 1:             Nlv 2:             Nlv 3:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*652)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080),17);
		dltv = new Label("Nlv 1:             Nlv 2:             Nlv 3:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*722)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080),17);
		dltm = new Label("Muerta:             Infectada 100%:",Math.round((Pantalla.width*15)/1920), Math.round((Pantalla.height*792)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080),17);

		dlir1 = new Label(r1,Math.round((Pantalla.width*70)/1920), Math.round((Pantalla.height*650)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));
		dlir2 = new Label(r2,Math.round((Pantalla.width*160)/1920), Math.round((Pantalla.height*650)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));
		dlir3 = new Label(r3,Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*650)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));

		dliam1 = new Label(am1,Math.round((Pantalla.width*70)/1920), Math.round((Pantalla.height*510)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		dliam2 = new Label(am2,Math.round((Pantalla.width*160)/1920), Math.round((Pantalla.height*510)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		dliam3 = new Label(am3,Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*510)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));

		dliv1 = new Label(v1,Math.round((Pantalla.width*70)/1920), Math.round((Pantalla.height*720)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));
		dliv2 = new Label(v2,Math.round((Pantalla.width*160)/1920), Math.round((Pantalla.height*720)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));
		dliv3 = new Label(v3,Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*720)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*20)/1080));
		
		dliaz1 = new Label(az1,Math.round((Pantalla.width*70)/1920), Math.round((Pantalla.height*580)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		dliaz2 = new Label(az2,Math.round((Pantalla.width*160)/1920), Math.round((Pantalla.height*580)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		dliaz3 = new Label(az3,Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*580)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		
		dlim = new Label(n,Math.round((Pantalla.width*80)/1920), Math.round((Pantalla.height*785)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));
		dlit = new Label(t,Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*785)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*20)/1080));

		// Demás información de los parámetros
		rojo = new JLabel(totalRojo + " / " + limiteEnfermedadRoja);
		rojo.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((700*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		rojo.setHorizontalAlignment(JLabel.RIGHT);
		rojo.setForeground(Color.white);
		rojo.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		rojo.setVisible(true);
		
		azul = new JLabel(totalAzul + " / " + limiteEnfermedadAzul);
		azul.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((650*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		azul.setHorizontalAlignment(JLabel.RIGHT);
		azul.setForeground(Color.white);
		azul.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		azul.setVisible(true);
		
		verde = new JLabel(totalVerde + " / " + limiteEnfermedadVerde);
		verde.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((600*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		verde.setVisible(true);
		verde.setHorizontalAlignment(JLabel.RIGHT);
		verde.setForeground(Color.white);
		verde.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		
		amarillo = new JLabel(totalAmarillo + " / " + limiteEnfermedadAmarilla);
		amarillo.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((550*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		amarillo.setVisible(true);
		amarillo.setForeground(Color.white);
		amarillo.setHorizontalAlignment(JLabel.RIGHT);
		amarillo.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		
		totales = new JLabel(totalEnfermedades +" / "+ limiteEnfermedad);
		totales.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((500*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		totales.setForeground(Color.white);
		totales.setHorizontalAlignment(JLabel.RIGHT);
		totales.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		totales.setVisible(true);
		
		brotes = new JLabel(contadorBrotes+" / "+ limiteBrotes);
		brotes.setBounds(Math.round((1550*Pantalla.width)/1920), Math.round((450*Pantalla.height)/1080), Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*25)/1080));
		brotes.setForeground(Color.white);
		brotes.setHorizontalAlignment(JLabel.RIGHT);
		brotes.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*20)/1080)));
		brotes.setVisible(true);
		 
		// Imagen de parámetros
		lCalavera = new JLabel(calavera);
		lCalavera.setBounds(Math.round((1850*Pantalla.width)/1920), Math.round((750*Pantalla.height)/1080), Math.round((Pantalla.width*50)/1920), Math.round((Pantalla.height*28)/1080));
		lCalavera.setVisible(true);
		
		md = new JLabel(mdii);
		md.setBounds(Math.round((Pantalla.width*1500)/1920), Math.round((Pantalla.height*150)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		md.setVisible(true);
		
		iVe = new JLabel(pVe);
		iVe.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*160)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iVe.setVisible(true);
		
		iRo = new JLabel(pRo);
		iRo.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*260)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iRo.setVisible(true);
		
		
		iAma = new JLabel(pAm);
		iAma.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*110)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iAma.setVisible(true);
		
		iAzu = new JLabel(pZu);
		iAzu.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*210)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iAzu.setVisible(true);
		
		iT = new JLabel(pTt);
		iT.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*60)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iT.setVisible(true);
		
		iB = new JLabel(pBb);
		iB.setBounds(Math.round((Pantalla.width*1550)/1920), Math.round((Pantalla.height*10)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*900)/1080));
		iB.setVisible(true);
		
		// Imagen, nivel y botón de laboratorio
		laboratorio = new JLabel();
		laboratorio.setIcon(lLab0);
		laboratorio.setBounds(Math.round((1400*Pantalla.width)/1920), Math.round((Pantalla.height)-((220*Pantalla.height)/1080)), Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*130)/1080));
		laboratorio.setVisible(true);
		
		nivelL = new JLabel();
		nivelL.setBounds(Math.round((1525*Pantalla.width)/1920), Math.round((Pantalla.height)-((230*Pantalla.height)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		nivelL.setBackground(Color.white);
		nivelL.setVisible(true);
		
		mLab = new JButton(bInvestigar);
		mLab.setFocusPainted(false);
		mLab.setBorder(null);
		mLab.setContentAreaFilled(false);
		mLab.setBounds(Math.round((1400*Pantalla.width)/1920), Math.round((Pantalla.height)-((50*Pantalla.height)/1080)), Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*50)/1080));
		mLab.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) { setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) { setCursor(cursor2);}
			public void mouseClicked(MouseEvent e) {if(barra.getValue() >= 999) {barra.setValue(0); nvlUpLab();}}});
		
		// Imagen, nivel y botón de publicidad
		publicidad = new JLabel();
		publicidad.setIcon(lPub0);
		publicidad.setBounds(Math.round((1600*Pantalla.width)/1920), Math.round((Pantalla.height)-((220*Pantalla.height)/1080)), Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*150)/1080));
		publicidad.setVisible(true);
		
		nivelP = new JLabel();
		nivelP.setBounds(Math.round((1725*Pantalla.width)/1920), Math.round((Pantalla.height)-((230*Pantalla.height)/1080)), Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080));
		nivelP.setBackground(Color.white);
		nivelP.setVisible(true);
		
		mPub = new JButton(bInvestigar);
		mPub.setFocusPainted(false);
		mPub.setBorder(null);
		mPub.setContentAreaFilled(false);
		mPub.setBounds(Math.round((1600*Pantalla.width)/1920), Math.round((Pantalla.height)-((50*Pantalla.height)/1080)), Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*50)/1080));
		mPub.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) { setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) { setCursor(cursor2);}
			public void mouseClicked(MouseEvent e) {if(barra.getValue() >= 999) {barra.setValue(0); nvlUpPub();}}});
		
		// Botón para salir
		salir = new JButton(bAjustes);
		salir.setFocusPainted(false);
		salir.setBorder(null);
		salir.setContentAreaFilled(false);
		salir.setBounds(Math.round((1845*Pantalla.width)/1920), 0, Math.round((Pantalla.width*80)/1920), Math.round((Pantalla.height*75)/1080));
		salir.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}
			public void mouseClicked(MouseEvent e) {lSalir.setVisible(true); pSalir.setVisible(true); siSalir.setVisible(true); noSalir.setVisible(true); volumen.setIcon(bVolumen); guardar.setIcon(bGuardar);}});
		
		// Fondo de salir
		lSalir = new JLabel(bFondoSalir);
		lSalir.setBounds(Math.round((1485*Pantalla.width)/1920), Math.round((Pantalla.height*75)/1080), Math.round((Pantalla.width*447)/1920), Math.round((Pantalla.height*175)/1080));
		lSalir.setVisible(false);
		lSalir.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {lSalir.setVisible(false); pSalir.setVisible(false); siSalir.setVisible(false); noSalir.setVisible(false); salir.setIcon(bAjustes);}});
		
		// Texto para confirmar
		pSalir = new JLabel("¿Seguro que quieres salir?");
		pSalir.setBounds(Math.round((1520*Pantalla.width)/1920), Math.round((Pantalla.height*100)/1080), Math.round((Pantalla.width*405)/1920), Math.round((Pantalla.height*35)/1080));
		pSalir.setVisible(false);
		pSalir.setVerticalAlignment(Label.CENTER);
		pSalir.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*30)/1080)));
		pSalir.setForeground(Color.white);
		
		// Boton salir
		siSalir= new JButton("SI");
		siSalir.setBounds(Math.round((1505*Pantalla.width)/1920), Math.round((Pantalla.height*178)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		siSalir.setVisible(false);
		siSalir.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2); lSalir.setVisible(true); pSalir.setVisible(true); siSalir.setVisible(true); noSalir.setVisible(true);}});
		siSalir.addActionListener(this);
		
		// Boton no salir
		noSalir = new JButton("NO");
		noSalir.setBounds(Math.round((1707*Pantalla.width)/1920), Math.round((Pantalla.height*178)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		noSalir.setVisible(false);
		noSalir.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2); lSalir.setVisible(true); pSalir.setVisible(true); siSalir.setVisible(true); noSalir.setVisible(true);}
			public void mouseClicked(MouseEvent e) {lSalir.setVisible(false); pSalir.setVisible(false); siSalir.setVisible(false); noSalir.setVisible(false); salir.setIcon(bAjustes);}});
		
		// Boton guardar
		guardar = new JButton(bGuardar);
		guardar.setBounds(Math.round((1760*Pantalla.width)/1920), 0, Math.round((Pantalla.width*80)/1920), Math.round((Pantalla.height*75)/1080));
		guardar.setFocusPainted(false);
		guardar.setBorder(null);
		guardar.setContentAreaFilled(false);
		guardar.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}
			public void mouseClicked(MouseEvent e) {lGuardar.setVisible(true); partida1.setVisible(true); partida2.setVisible(true); partida3.setVisible(true);
				lSalir.setVisible(false); pSalir.setVisible(false); siSalir.setVisible(false); noSalir.setVisible(false); salir.setIcon(bAjustes); volumen.setIcon(bVolumen); lVolumen.setVisible(false); s1.setVisible(false);}});
		
		// Marco guardar
		lGuardar = new JLabel(iFondoGuardar);
		lGuardar.setBounds(Math.round((1520*Pantalla.width)/1920), Math.round((Pantalla.height*75)/1080), Math.round((Pantalla.width*400)/1920), Math.round((Pantalla.height*200)/1080));
		lGuardar.setVisible(false);
		lGuardar.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {lGuardar.setVisible(false); partida1.setVisible(false); partida2.setVisible(false); partida3.setVisible(false); guardar.setIcon(bGuardar);}});
		
		// Guardar en partida 1
		partida1 = new JButton("PARTIDA 1");
		partida1.setBounds(Math.round((1570*Pantalla.width)/1920), Math.round((Pantalla.height*90)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		partida1.setVisible(false);
		partida1.setFocusPainted(false);
		partida1.setBorderPainted(false);
		partida1.setContentAreaFilled(false);
		partida1.setForeground(Color.white);
		partida1.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*30)/1080)));
		partida1.addActionListener(this);
		partida1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1); partida1.setForeground(Color.white);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); partida1.setForeground(Color.gray); partida1.setVisible(true); partida2.setVisible(true); partida3.setVisible(true);}
			public void mouseClicked(MouseEvent e) {lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); guardar.setIcon(bGuardar); partida1.setVisible(false); partida2.setVisible(false); partida3.setVisible(false); lVolumen.setVisible(false); s1.setVisible(false);}});
		
		// Guardar en partida 2
		partida2 = new JButton("PARTIDA 2");
		partida2.setBounds(Math.round((1570*Pantalla.width)/1920), Math.round((Pantalla.height*145)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		partida2.setVisible(false);
		partida2.setFocusPainted(false);
		partida2.setBorderPainted(false);
		partida2.setContentAreaFilled(false);
		partida2.setForeground(Color.white);
		partida2.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*30)/1080)));
		partida2.addActionListener(this);
		partida2.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1); partida2.setForeground(Color.white);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); partida2.setForeground(Color.gray); partida1.setVisible(true); partida2.setVisible(true); partida3.setVisible(true);}
			public void mouseClicked(MouseEvent e) {lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); guardar.setIcon(bGuardar); partida1.setVisible(false); partida2.setVisible(false); partida3.setVisible(false); lVolumen.setVisible(false); s1.setVisible(false);}});
		
		// Guardar en parida 3
		partida3 = new JButton("PARTIDA 3");
		partida3.setBounds(Math.round((1570*Pantalla.width)/1920), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*300)/1920), Math.round((Pantalla.height*50)/1080));
		partida3.setVisible(false);
		partida3.setFocusPainted(false);
		partida3.setBorderPainted(false);
		partida3.setContentAreaFilled(false);
		partida3.setForeground(Color.white);
		partida3.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*30)/1080)));
		partida3.addActionListener(this);
		partida3.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1); partida3.setForeground(Color.white);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); lGuardar.setVisible(true); partida3.setForeground(Color.gray); partida1.setVisible(true); partida2.setVisible(true); partida3.setVisible(true);}
			public void mouseClicked(MouseEvent e) {lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); lGuardar.setVisible(false); guardar.setIcon(bGuardar); partida1.setVisible(false); partida2.setVisible(false); partida3.setVisible(false); lVolumen.setVisible(false); s1.setVisible(false);}});
		
		// Botón volumen
		volumen = new JButton(bVolumen);
		volumen.setBounds(Math.round((1675*Pantalla.width)/1920), 0, Math.round((Pantalla.width*80)/1920), Math.round((Pantalla.height*75)/1080));
		volumen.setFocusPainted(false);
		volumen.setBorder(null);
		volumen.setContentAreaFilled(false);
		volumen.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}
			public void mouseClicked(MouseEvent e) {lSalir.setVisible(false); pSalir.setVisible(false); siSalir.setVisible(false); noSalir.setVisible(false); lVolumen.setVisible(true); s1.setVisible(true);}});

		// Marco volumen
		lVolumen = new JLabel(lFondoVolumen);
		lVolumen.setBounds(Math.round((1525*Pantalla.width)/1920), Math.round((Pantalla.height*75)/1080), Math.round((Pantalla.width*350)/1920), Math.round((Pantalla.height*50)/1080));
		lVolumen.setVisible(false);
		lVolumen.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {lVolumen.setVisible(true); s1.setVisible(true);}
			public void mouseExited(MouseEvent e) {lVolumen.setVisible(false); s1.setVisible(false);}});
		
		// Slider volumen
		s1 = new JSlider(0, 100, Math.round(V[0]));
		s1.setVisible(false);
		s1.setBounds(Math.round((1525*Pantalla.width)/1920), Math.round((Pantalla.height*75)/1080), Math.round((Pantalla.width*350)/1920), Math.round((Pantalla.height*50)/1080));
		s1.setVisible(false);
		s1.setOpaque(false);
		s1.setBackground(Color.GREEN);
		s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {lVolumen.setVisible(true); s1.setVisible(true);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1); lVolumen.setVisible(false); s1.setVisible(false);}});
		s1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				v = s1.getValue();
				vpc = s2.getValue();
				vmp = s3.getValue();
				vj = s4.getValue();
				
				escribir();

				try{Main.game.setVolumen(((v/100)*(vj))-80);}catch(Exception e1) {}
			}
		});
		
		// Texto para indicar
		texto = new JLabel("CLICA PARA VOLVER AL MENÚ");
		texto.setForeground(Color.white);
		texto.setBounds(Math.round((700*Pantalla.width)/1920), Math.round((700*Pantalla.height)/1080), Math.round((Pantalla.width*600)/1920), Math.round((Pantalla.height*40)/1080));
		texto.setVisible(false);
		texto.setFont(new FontUIResource("Calibri BOLD", Font.PLAIN, 35));
		
		// Marco de menú
		fondoMenu = new JLabel();
		fondoMenu.setIcon(lFondoMenu);
		fondoMenu.setBounds(Math.round((1670*Pantalla.width)/1920), 0, Math.round((Pantalla.width*250)/1920), Math.round((Pantalla.height*75)/1080));
		fondoMenu.setVisible(true);
		
		// Barra de muertos totales
		muertes = new Barra(255, 0, 0, (int)(limiteMuertos), Math.round((1625*Pantalla.width)/1920), Math.round((750*Pantalla.height)/1080), Math.round((Pantalla.width*225)/1920), Math.round((Pantalla.height*25)/1080));
		muertes.setOrientation(0);
		
		// Añadimos
		add(texto);
		add(imagenPais);
		add(nombrePais);
		add(rojo);
		add(azul);
		add(verde);
		add(amarillo);
		add(totales);
		add(brotes);
		add(iRo);
		add(iVe);
		add(iAma);
		add(iAzu);
		add(iT);
		add(dlam);
		add(dlaz);
		add(dlr);
		add(dlv);
		add(dltam);
		add(dltaz);
		add(dltr);
		add(dltv);
		add(dlir1);
		add(dlir2);
		add(dlir3);
		add(dliam1);
		add(dliam2);
		add(dliam3);
		add(dliv1);
		add(dliv2);
		add(dliv3);
		add(dliaz1);
		add(dliaz2);
		add(dliaz3);
		add(dlm);
		add(dltm);
		add(dlim);
		add(dlit);
		add(iB);
		add(bll);
		add(dll);		
		add(poblacion);
		add(nivelRojo);
		add(nivelAzul);
		add(nivelAmarillo);
		add(nivelVerde);
		add(laboratorios);
		add(nivelL);
		add(laboratorio);
		add(mLab);
		add(nivelP);
		add(publicidad);
		add(mPub);
		add(publicidades);
		add(poblacionMundial);
		add(muertes);
		add(lCalavera);
		add(bBateria);
		add(probetaAm);
	    add(investigarAm);
		add(probetaAz);
	    add(investigarAz);
		add(probetaR);
	    add(investigarR);
		add(probetaV);
	    add(investigarV);
	    add(curar);
		add(barra);
		add(barraAm);
		add(barraAz);
		add(barraR);
		add(md);
		add(barraV);
		add(guardar);
		add(salir);
		add(pSalir);
		add(siSalir);
		add(noSalir);
		add(lSalir);
		add(partida1);
		add(partida2);
		add(partida3);
		add(lGuardar);
		add(volumen);
		add(s1);
		add(lVolumen);
		add(fondoMenu);
		
		Main.game.run();
		
		actualizarMenu();
		
		// Empezamos el hilo del juego
		hilo = new HiloPrincipal();
		hilo.start();
		
		hiloAm = new ThreadInvestigarAm();
		
		hiloAz = new ThreadInvestigarAz();
		hiloAz.start();
		hiloV = new ThreadInvestigarV();
		hiloV.start();
		hiloR = new ThreadInvestigarR();
		hiloR.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/mapa.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen.getScaledInstance(Pantalla.width, Pantalla.height, Image.SCALE_DEFAULT), 0, 0, null);
	}	
	
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
	
	// Aumentamos el nivel del laboratorio
	public static void nvlUpLab() {
		
		if(nvlLab<12) {
			nvlLab++;
			
			Image iLab = new ImageIcon("Assets/Laboratorios/Laboratory"+(nvlLab)+".png").getImage();
			ImageIcon lab = new ImageIcon(iLab.getScaledInstance(Math.round((Pantalla.width*150)/1920), Math.round((Pantalla.height*130)/1080), Image.SCALE_DEFAULT));
			laboratorio.setIcon(lab);
			laboratorios.setText("Publicidades: "+nvlLab);
			
			Image iNvl = new ImageIcon("Assets/Laboratorios/XP"+(nvlLab)+".png").getImage();
			ImageIcon nvl = new ImageIcon(iNvl.getScaledInstance(Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080), Image.SCALE_DEFAULT));
			nivelL.setIcon(nvl);
			
			if(nvlLab == 12) {mLab.setEnabled(false);}}
		
	}
	
	// Aumentamos el nivel de publicidad
	public static void nvlUpPub() {
		
		if(nvlPub<12) {
			nvlPub++;
			
			Image iNvl = new ImageIcon("Assets/Laboratorios/XP"+(nvlPub)+".png").getImage();
			ImageIcon nvl = new ImageIcon(iNvl.getScaledInstance(Math.round((Pantalla.width*40)/1920), Math.round((Pantalla.height*40)/1080), Image.SCALE_DEFAULT));
			nivelP.setIcon(nvl);
			publicidades.setText("Publicidades: "+nvlPub);
			
			if(nvlPub >= 1) {publicidad.setIcon(bPub);}
			if(nvlPub == 12) {mPub.setEnabled(false);}}
		
	}
	
	// Actualizamos el menu del pais
	public static void actualizarMenu() {
		
		imagenPais.setIcon(iPais.get(paisSeleccionado));
		nombrePais.setText(ciudadesLista.get(paisSeleccionado).getNombre());
		poblacion.setText(ciudadesLista.get(paisSeleccionado).getPoblacionTotal() - ciudadesLista.get(paisSeleccionado).getPoblacionMuerta() + " / " + ciudadesLista.get(paisSeleccionado).getPoblacionTotal());
		nivelRojo.setText("Nivel Rojo: " + ciudadesLista.get(paisSeleccionado).getRojo());
		nivelAzul.setText("Nivel Azul: " + ciudadesLista.get(paisSeleccionado).getAzul());
		nivelVerde.setText("Nivel Verde: " + ciudadesLista.get(paisSeleccionado).getVerde());
		nivelAmarillo.setText("Nivel Amarillo: " + ciudadesLista.get(paisSeleccionado).getAmarillo());
		
	}
	
	// Hilo para investigar la vacuna amarilla
	class ThreadInvestigarAm extends Thread {

		public void run() {
			barra.setValue(0);
			for (int i = 0; i <= 250; i++) {
				synchronized (objetoAm) {
					try {Thread.sleep(100);} catch (InterruptedException e) {}
				}
				try{barraAm.setValue(barraAm.getValue()+1);}catch(Exception e) {}
				System.out.println(barraAm.getValue() + " / " + barraAm.getMaximum());
				}

			
			if(barraAm.getValue()<barraAm.getMaximum()) {investigarAm.setVisible(true); investigarAm.setEnabled(true);}
			else {investigadoAm=true;;}
			if(!investigadoAz) {investigarAz.setVisible(true); investigarAz.setEnabled(true);}
			if(!investigadoR) {investigarR.setVisible(true); investigarR.setEnabled(true);}
			if(!investigadoV) {investigarV.setVisible(true); investigarV.setEnabled(true);}

		}
	}

	// Hilo para investigar la vacuna azul
	class ThreadInvestigarAz extends Thread {

		public void run() {

			investigaAz = false;
			for (int i = 0; i <= 250; i++) {
				synchronized (objetoAz) {
					try {Thread.sleep(velocidadInvestigacion-(((velocidadInvestigacion/2)/12)*nvlLab));} catch (InterruptedException e) {}
				}
				try{if(barraAz.getValue()>30 || i>30) {barraAz.setValue(barraAz.getValue()+1);}}catch(Exception e) {}
				}
			
			if(barraAz.getValue()<barraAz.getMaximum()) {investigarAz.setVisible(true); investigarAz.setEnabled(true);}
			else {investigadoAz=true;}
			if(!investigadoAm) {investigarAm.setVisible(true); investigarAm.setEnabled(true);}
			if(!investigadoR) {investigarR.setVisible(true); investigarR.setEnabled(true);}
			if(!investigadoV) {investigarV.setVisible(true); investigarV.setEnabled(true);}
			
		}
	}
	
	// Hilo para investigar la vacuna roja
	class ThreadInvestigarR extends Thread {

		public void run() {

			investigaR = false;
			for (int i = 0; i <= 250; i++) {
				synchronized (objetoR) {
					try {Thread.sleep(velocidadInvestigacion-(((velocidadInvestigacion/2)/12)*nvlLab));} catch (InterruptedException e) {}
				}
				try{if(barraR.getValue()>30 || i>30) {barraR.setValue(barraR.getValue()+1);}}catch(Exception e) {}
				}
			
			if(barraR.getValue()<cantidadInvestigacionVacunaRoja) {investigarR.setVisible(true); investigarR.setEnabled(true);}
			else {investigadoR=true; }
			if(!investigadoAz) {investigarAz.setVisible(true); investigarAz.setEnabled(true);}
			if(!investigadoAm) {investigarAm.setVisible(true); investigarAm.setEnabled(true);}
			if(!investigadoV) {investigarV.setVisible(true); investigarV.setEnabled(true);}

		}
	}
	
	// Hilo para investigar la vacuna verde
	class ThreadInvestigarV extends Thread {

		public void run() {
			
			investigaV = false;
			for (int i = 0; i <= 250; i++) {
				synchronized (objetoV) {
					try {Thread.sleep(velocidadInvestigacion-(((velocidadInvestigacion/2)/12)*nvlLab));} catch (InterruptedException e) {}
				}
				try{if(barraV.getValue()>30 || i>30) {barraV.setValue(barraV.getValue()+1);}}catch(Exception e) {}
			}
			if(barraV.getValue()<cantidadInvestigacionVacunaVerde) {investigarV.setVisible(true); investigarV.setEnabled(true);}
			else {investigadoV=true;}
			if(!investigadoAz) {investigarAz.setVisible(true); investigarAz.setEnabled(true);}
			if(!investigadoR) {investigarR.setVisible(true); investigarR.setEnabled(true);}
			if(!investigadoAm) {investigarAm.setVisible(true); investigarAm.setEnabled(true);}

		}
	}

	
	// Hilo para calcular los brotes
//	class ThreadBrote extends Thread {
//		
//		public void run() { for(int i = 0; i < 1; i++) { contadorBrotes = 0; i--;
//				
//			try {Thread.sleep(5000);} catch (InterruptedException e) {}
//			if (parar) {i = 10;}}}
//
//	}
	
	// Hilo para calcular y actualizar las muertes totales
//	class ThreadMuertes extends Thread {
//		
//		public void run () {
//	
//			int muertos = 0;
//
//			for(int i = 0; i < 1; i++) {
//				
//				for(int j = 0; j < 59; j++) {
//					
//
//					if(ciudadesLista.get(j).getRojo() > 0 && ciudadesLista.get(j).getCiudadMuerta() == 0) {
//						if(ciudadesLista.get(j).getRojo() == 3) {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * 2) * 5)) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * 2) * 5));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}
//						else {	
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad() * 2)) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionTotal()); }
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * 2) * ciudadesLista.get(j).getRojo()));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}}
//
//					if (ciudadesLista.get(j).getAmarillo() > 0 && ciudadesLista.get(j).getCiudadMuerta() == 0) {
//						if(ciudadesLista.get(j).getAmarillo() == 3) {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad() * 5)) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad() * 5));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}
//						else {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * habilidad.getMortalidad()) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * ciudadesLista.get(j).getAmarillo())));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}}
//
//					if (ciudadesLista.get(j).getAzul() > 0 && ciudadesLista.get(j).getCiudadMuerta() == 0) {
//						if(ciudadesLista.get(j).getAzul() == 3) {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad()* 5)) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad() * 5));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}
//						else {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * habilidad.getMortalidad()) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * ciudadesLista.get(j).getAzul())));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}}					
//
//					if (ciudadesLista.get(j).getVerde() > 0 && ciudadesLista.get(j).getCiudadMuerta() == 0) {
//						if(ciudadesLista.get(j).getVerde() == 3) {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad()* 5)) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * (habilidad.getMortalidad() * 5));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}
//						else {
//							if (ciudadesLista.get(j).getPoblacionMuerta() + (int)(ciudadesLista.get(j).getPoblacionTotal() * habilidad.getMortalidad()) > ciudadesLista.get(j).getPoblacionTotal()) {ciudadesLista.get(j).setPoblacionMuerta((int)(ciudadesLista.get(j).getPoblacionTotal()));}
//							else {muertos = (int)(ciudadesLista.get(j).getPoblacionTotal() * ((habilidad.getMortalidad() * ciudadesLista.get(j).getVerde())));
//							ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionMuerta() + (muertos-(((muertos/2)/12)*nvlPub)));}}}					
//					
//					if (ciudadesLista.get(j).getPoblacionMuerta() >= ciudadesLista.get(j).getPoblacionTotal()) { ciudadesLista.get(j).setPoblacionMuerta(ciudadesLista.get(j).getPoblacionTotal()); ciudadesBoton.get(j).setIcon(n); ciudadesLista.get(j).setCiudadMuerta(1); }
//					muertosTotales+=ciudadesLista.get(j).getPoblacionMuerta()/10;
//
//				}
//				
//				muertes.setValue((int)muertosTotales);
//				poblacionMundial.setText(Math.round(muertosTotales) + " / " + limiteMuertos);
//
//				i --;
//				try {Thread.sleep(100); muertosTotales = 0;}  catch (InterruptedException e) {}
//				if (parar) {i = 10;}
//			}
//			
//		}
//	}
	
	// Hilo para actualizar la habilidad evolutiva
//	class ThreadEvolucion extends Thread {
//		
//		public void run() { 
//			
//			for(int i = 0; i < 1; i++) { 
//				for(int j = 0; j < 1; j++) { 
//				
//					int rn = rd.nextInt(3);
//				
//					if (rn == 0 && !evolucionR) {evolucionR = true;}
//					else if (rn == 1 && !evolucionV) {evolucionV = true;}
//					else if (rn == 2 && !evolucionAm) {evolucionAm = true; investigaAz = false; investigarAz.setVisible(true);  investigarAz.setEnabled(true);}
//					else if (evolucionAm || evolucionR || evolucionV) {j--;}
//					
//				} 
//				
//				if (evolucionAm) { barraAz.setMaximum((int) (cantidadInvestigacionVacunaAmarilla * habilidad.getResistencia()));}
//				i--;
//				try {Thread.sleep(habilidad.getEvolucion());} catch (InterruptedException e) {}
//				if (parar) {i = 10;}
//				}
//			}
//		}

	// Actualiza la imagen del pais en funcion del nivel
	public static void nivel(int rn) {
		
		if(ciudadesLista.get(rn).getRojo() == 0 && ciudadesLista.get(rn).getVerde() == 0 && ciudadesLista.get(rn).getAmarillo() == 0 && ciudadesLista.get(rn).getAzul() == 0) {ciudadesBoton.get(rn).setIcon(pais);}
		else if(ciudadesLista.get(rn).getRojo() == 3 && ciudadesLista.get(rn).getVerde() == 3 && ciudadesLista.get(rn).getAmarillo() == 3 && ciudadesLista.get(rn).getAzul() == 3) {ciudadesBoton.get(rn).setIcon(t);}		
		else if(ciudadesLista.get(rn).getRojo() > ciudadesLista.get(rn).getAzul() && ciudadesLista.get(rn).getRojo() > ciudadesLista.get(rn).getVerde() && ciudadesLista.get(rn).getRojo() > ciudadesLista.get(rn).getAmarillo()) {
			if(ciudadesLista.get(rn).getRojo() == 1) {ciudadesBoton.get(rn).setIcon(r1);}
			else if (ciudadesLista.get(rn).getRojo() == 2) {ciudadesBoton.get(rn).setIcon(r2);}
			else if (ciudadesLista.get(rn).getRojo() == 3) {ciudadesBoton.get(rn).setIcon(r3);}
		} else if(ciudadesLista.get(rn).getAzul() > ciudadesLista.get(rn).getRojo() && ciudadesLista.get(rn).getAzul() > ciudadesLista.get(rn).getVerde() && ciudadesLista.get(rn).getAzul() > ciudadesLista.get(rn).getAmarillo()) {
			if(ciudadesLista.get(rn).getAzul() == 1) {ciudadesBoton.get(rn).setIcon(az1);}
			else if (ciudadesLista.get(rn).getAzul() == 2) {ciudadesBoton.get(rn).setIcon(az2);}
			else if (ciudadesLista.get(rn).getAzul() == 3) {ciudadesBoton.get(rn).setIcon(az3);}
		} else if(ciudadesLista.get(rn).getVerde() > ciudadesLista.get(rn).getRojo() && ciudadesLista.get(rn).getVerde() > ciudadesLista.get(rn).getAzul() && ciudadesLista.get(rn).getVerde() > ciudadesLista.get(rn).getAmarillo()) {
			if(ciudadesLista.get(rn).getVerde() == 1) {ciudadesBoton.get(rn).setIcon(v1);}
			else if (ciudadesLista.get(rn).getVerde() == 2) {ciudadesBoton.get(rn).setIcon(v2);}
			else if (ciudadesLista.get(rn).getVerde() == 3) {ciudadesBoton.get(rn).setIcon(v3);}
		} else if(ciudadesLista.get(rn).getAmarillo() > ciudadesLista.get(rn).getRojo() && ciudadesLista.get(rn).getAmarillo() > ciudadesLista.get(rn).getVerde() && ciudadesLista.get(rn).getAmarillo() > ciudadesLista.get(rn).getAzul()) {
			if(ciudadesLista.get(rn).getAmarillo() == 1) {ciudadesBoton.get(rn).setIcon(am1);}
			else if (ciudadesLista.get(rn).getAmarillo() == 2) {ciudadesBoton.get(rn).setIcon(am2);}
			else if (ciudadesLista.get(rn).getAmarillo() == 3) {ciudadesBoton.get(rn).setIcon(am3);}
		} else {
			if(ciudadesLista.get(rn).getRojo() == 1) {ciudadesBoton.get(rn).setIcon(r1);}
			else if (ciudadesLista.get(rn).getRojo() == 2) {ciudadesBoton.get(rn).setIcon(r2);}
			else if (ciudadesLista.get(rn).getRojo() == 3) {ciudadesBoton.get(rn).setIcon(r3);}
		}
		
	}
	
	// Calcula cuantos contagios a nivel 3
	public static void limiteContagios () {
		
		totalAmarillo = 0;
		totalAzul = 0;
		totalRojo = 0;
		totalVerde = 0;
		totalEnfermedades = 0;
		
		for (int i = 0; i < ciudadesLista.size(); i++) {
			
			if(ciudadesLista.get(i).getCiudadMuerta() == 0) {
				if (ciudadesLista.get(i).getAmarillo() == 3 ) { totalAmarillo++; }
				if (ciudadesLista.get(i).getAzul() == 3 ) { totalAzul++; }
				if (ciudadesLista.get(i).getRojo() == 3 ) { totalRojo++; }
				if (ciudadesLista.get(i).getVerde() == 3 ) { totalVerde++; }
			}
			
		}
		totalEnfermedades = totalAmarillo + totalAzul +totalRojo + totalVerde;
	}
	
	// Guarda partida en la base de datos
//	@SuppressWarnings("unused")
//	public void guardarPartida(Connection con) {
//
//		String sql2 = null;
//		
//		int iAm,iAz,iR,iV,eAm,eR,eV = 0;
//		
//		if (investigadoAm) {iAm = 1;} else {iAm = 0;}
//		if (investigadoAz) {iAz = 1;} else {iAz = 0;}
//		if (investigadoR) {iR = 1;} else {iR = 0;}
//		if (investigadoV) {iV = 1;} else {iV = 0;}
//		if (evolucionAm) {eAm = 1;} else {eAm = 0;}
//		if (evolucionR) {eR = 1;} else {eR = 0;}
//		if (evolucionV) {eV = 1;} else {eV = 0;}
//		if (evolucionAm) { cantidadInvestigacionVacunaAzul = barraAz.getMaximum(); }
//		cantidadInvestigacionVacunaAmarilla = (int) (barraAm.getMaximum());
//		
//		String sql = "UPDATE PARTIDA SET FECHA = SYSDATE, LIMITEMUEROTS = '"+limiteMuertos+"', LENEFERMEDAD_ROJ = '"+limiteEnfermedadRoja+"', LENEFERMEDAD_VERDE = '"+limiteEnfermedadVerde+"', LENEFERMEDAD_AMARILLA = '"+limiteEnfermedadAmarilla+"',"
//				+ " LENEFERMEDAD_AZUL = '"+limiteEnfermedadAzul+"', LENEFERMEDAD = '"+limiteEnfermedad+"', LIMITEBROTES = '"+limiteBrotes+"', FRECUENCIACONTAGIO = '"+frecuenciaContagio+"', RECARGAENERGIA = '"+recargaEnergia+"',"
//				+ " VELOCIDADINVESTIGACION = '"+velocidadInvestigacion+"', CIVACUNAROJA = '"+cantidadInvestigacionVacunaRoja+"', CIVACUNA_VERDE = '"+cantidadInvestigacionVacunaVerde+"', CIVACUNA_AMARILLA = '"+cantidadInvestigacionVacunaAmarilla+"',"
//				+ " CIVACUNA_AZUL = '"+cantidadInvestigacionVacunaAzul+"', INVESTIGADOAM = '"+iAm+"', INVESTIGADOAZ = '"+iAz+"', INVESTIGADOR = '"+iR+"', INVESTIGADOV = '"+iV+"', EVOLUCIONR = '"+eR+"', EVOLUCIONV = '"+eV+"',"
//				+ " EVOLUCIONAM = '"+eAm+"', INLABAM = '"+barraAm.getValue()+"', INLABAZ = '"+barraAz.getValue()+"', INLABR = '"+barraR.getValue()+"', INLABV = '"+barraV.getValue()+"', ENERGIA = '"+barra.getValue()+"',"
//				+ " LAB = '"+nvlLab+"', PUB = '"+nvlPub+"'"
//				+ "where ID_PARTIDA = '"+idPartida+"'"
//				+ "and USUARIO = '"+PanelUsuario.nombre+"'";
//			
//		try {
//			Statement statement = (Statement) con.createStatement();
//			statement.execute(sql);
//			statement.close();
//			
//		} catch (SQLException e) {
//			System.out.println("The Insert had problems!! DIFICULTAD " + e);
//			
//			} 
//	}
//	
//	// Guarda las cuidades en la base de datos
//	public void guardarCiudades(Connection con) { 
//		
//		
//		for(int i = 0; i < 59;i++) {
//		 String sql = "UPDATE TABLACIUDADES SET CIUDAD"+i+" = CIUDAD('"+ciudadesLista.get(i).getNombre()+"','"+ciudadesLista.get(i).getPoblacionTotal()+"','"+ciudadesLista.get(i).getPoblacionMuerta()+"','"+ciudadesLista.get(i).getCiudadMuerta()+"','"+ciudadesLista.get(i).getRojo()+"','"+ciudadesLista.get(i).getAmarillo()+"','"+ciudadesLista.get(i).getVerde()+"','"+ciudadesLista.get(i).getAzul()+"')"
//					+ "where idpartida = '"+idPartida+"'"
//					+ "and USUARIO = '"+PanelUsuario.nombre+"'";
//			
//		
//		try {
//			Statement statement = (Statement) con.createStatement();
//			statement.execute(sql);
//			statement.close();
//			
//		} catch (SQLException e) {
//			System.out.println("The Insert had problems!! CIUDADES " + e);
//			
//			} 
//		}
//	}
//	
	// Carga la partida desde la base de datos
//	public void cargarDatos(Connection con) {
//		
//		
//		try {
//			
//			String sql = "SELECT * FROM PARTIDA WHERE ID_PARTIDA = '"+PanelCargar.idPartida+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		       
//		    while (rs.next()){
//		    	
//		        	limiteMuertos = rs.getLong("LIMITEMUEROTS");
//		        	limiteEnfermedadRoja = rs.getInt("LENEFERMEDAD_ROJ");
//		        	limiteEnfermedadVerde = rs.getInt("LENEFERMEDAD_VERDE");
//		        	limiteEnfermedadAmarilla = rs.getInt("LENEFERMEDAD_AMARILLA");
//		        	limiteEnfermedadAzul= rs.getInt("LENEFERMEDAD_AZUL");
//		        	limiteEnfermedad = rs.getInt("LENEFERMEDAD");
//		        	limiteBrotes = rs.getInt("LIMITEBROTES");
//		        	frecuenciaContagio = rs.getInt("FRECUENCIACONTAGIO");
//		        	recargaEnergia = rs.getInt("RECARGAENERGIA");
//		        	velocidadInvestigacion = rs.getInt("VELOCIDADINVESTIGACION");
//		        	cantidadInvestigacionVacunaRoja = rs.getInt("CIVACUNAROJA");
//		        	cantidadInvestigacionVacunaVerde = rs.getInt("CIVACUNA_VERDE");
//		        	cantidadInvestigacionVacunaAmarilla = rs.getInt("CIVACUNA_AMARILLA");
//		        	cantidadInvestigacionVacunaAzul = rs.getInt("CIVACUNA_AZUL");
//		        	iAm = rs.getInt("INVESTIGADOAM");
//		        	iAz = rs.getInt("INVESTIGADOAZ"); 
//		        	iR = rs.getInt("INVESTIGADOR");
//		        	iV = rs.getInt("INVESTIGADOV");
//		        	eR = rs.getInt("EVOLUCIONR");
//		        	eR = rs.getInt("EVOLUCIONV");
//		        	eAm = rs.getInt("EVOLUCIONAM");
//		        	barraAm.setValue(rs.getInt("INLABAM"));
//		        	barraAz.setValue(rs.getInt("INLABAZ"));
//		        	barraR.setValue(rs.getInt("INLABR"));
//		        	barraV.setValue(rs.getInt("INLABV"));
//		        	nvlLab = rs.getInt("LAB");
//		        	nvlPub = rs.getInt("PUB");
//
//		    }
//		    
//		    if (iAm == 1) {investigadoAm = true; investigarAm.setVisible(false); investigarAm.setEnabled(false);} else {investigadoAm = false;}
//		    if (iAz == 1) {investigadoAz = true; investigarAz.setVisible(false); investigarAz.setEnabled(false);} else {investigadoAz = false;}
//		    if (iR == 1) {investigadoR = true; investigarR.setVisible(false); investigarR.setEnabled(false);} else {investigadoR = false;}
//		    if (iV == 1) {investigadoV = true; investigarV.setVisible(false); investigarV.setEnabled(false); } else {investigadoV = false;}
//
//		    
//		    st.close();
//		    
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! 1 " + e);}
//		
//		for(int i = 0; i < 59; i++) {		
//			
//			try {
//				String sql = "SELECT CIUDAD"+i+" FROM TABLACIUDADES WHERE IDPARTIDA = '"+PanelCargar.idPartida+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//				
//				Statement st = con.createStatement();
//				
//				ResultSet rs = st.executeQuery(sql);
//			    
//			    while (rs.next()){		
//				   
//			    	Struct c = (Struct) rs.getObject("CIUDAD"+i);
//			    	String a = (String) c.getAttributes()[0]; ciudadesLista.get(i).setNombre(a);
//			    	BigDecimal b = (BigDecimal) c.getAttributes()[1]; ciudadesLista.get(i).setPoblacionTotal(b.longValue());
//			    	BigDecimal d = (BigDecimal) c.getAttributes()[2]; ciudadesLista.get(i).setPoblacionMuerta(d.longValue());
//			    	BigDecimal e = (BigDecimal) c.getAttributes()[3]; ciudadesLista.get(i).setCiudadMuerta(e.intValue());
//			    	BigDecimal f = (BigDecimal) c.getAttributes()[4]; ciudadesLista.get(i).setRojo(f.intValue());
//			    	BigDecimal g = (BigDecimal) c.getAttributes()[5]; ciudadesLista.get(i).setAmarillo(g.intValue());
//			    	BigDecimal h = (BigDecimal) c.getAttributes()[6]; ciudadesLista.get(i).setVerde(h.intValue());
//			    	BigDecimal j = (BigDecimal) c.getAttributes()[7]; ciudadesLista.get(i).setAzul(j.intValue());
//			    	nivel(i);
//			   }
//			    
//			    st.close();
//			    
//			} catch (SQLException e) {System.out.println("The SELECT had problems!! 2 " + e);}
//		}
//	}
//	
//	// Actualiza los puntos en la base de datos
//	public void puntos(Connection con) {
//		
//		int puntuacion = 0;
//				
//		try {
//			
//			String sql = "SELECT PUNTOS FROM JUGADOR WHERE NOMBRE = '"+PanelUsuario.nombre+"'";
//
//			Statement st = con.createStatement();
//			
//		    ResultSet rs = st.executeQuery(sql);
//		       
//		    rs.next();
//		    
//		    puntuacion = rs.getInt("PUNTOS");
//		    
//		    st.close();
//		    
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! " + e);}
//				
//	puntuacion +=1;
//	
//		try {
//			String sql = "UPDATE JUGADOR SET PUNTOS = '"+puntuacion+"', FECHA = SYSDATE WHERE NOMBRE = '"+PanelUsuario.nombre+"'";
//					
//			Statement statement = (Statement) con.createStatement();
//			statement.execute(sql);
//			statement.close();
//		
//		} catch (SQLException e) {System.out.println("The UPDATE had problems!! CIUDADES " + e);} 
//
//	}
//	
//	// Borra la partida en la base de datos
//	public void borrarPartida (Connection con) {
//			
//		try {
//			
//			String sql = "DELETE FROM PARTIDA WHERE ID_PARTIDA = '"+PanelCargar.idPartida+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			Statement st = con.createStatement();
//			
//		    @SuppressWarnings("unused")
//			ResultSet rs = st.executeQuery(sql);
//		       		    		    
//		    st.close();
//		    
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! " + e);}
//		
//		try {
//			
//			String sql = "DELETE FROM TABLACIUDADES WHERE IDPARTIDA = '"+PanelCargar.idPartida+"' AND USUARIO = '"+PanelUsuario.nombre+"'";
//			Statement st = con.createStatement();
//	
//		    @SuppressWarnings("unused")
//			ResultSet rs = st.executeQuery(sql);
//		       		    		    
//		    st.close();
//		    
//		} catch (SQLException e) {System.out.println("The SELECT had problems!! " + e);}
//		
//		try {
//
//			String sql = "INSERT INTO PARTIDA(USUARIO,ID_PARTIDA,FECHA) VALUES ('"+PanelUsuario.nombre+"', '"+PanelCargar.idPartida+"', SYSDATE)";
//			
//				Statement statement = (Statement) con.createStatement();
//				statement.execute(sql);
//				statement.close();
//				
//			} catch (SQLException e) {}
//		try {
//
//			String sql = "INSERT INTO TABLACIUDADES(USUARIO,IDPARTIDA) VALUES ('"+PanelUsuario.nombre+"', '"+PanelCargar.idPartida+"')";
//			
//				Statement statement = (Statement) con.createStatement();
//				statement.execute(sql);
//				statement.close();
//				
//			} catch (SQLException e) {}
//	}
//	
//	// Reiniciamos la partida cuando el usuario sale de ésta
//	public void reiniciarPartida() {
//		
//		  limiteMuertos = 0;
//	      limiteEnfermedadRoja = 0;
//	      limiteEnfermedadVerde = 0;
//	      limiteEnfermedadAmarilla = 0;
//	      limiteEnfermedadAzul = 0;
//	      limiteEnfermedad = 0;
//	      limiteBrotes = 0;
//	      totalAmarillo = 0;
//	      totalRojo = 0;
//	      totalVerde = 0;
//	      totalAzul = 0;
//	      totalEnfermedades = 0;
//	      frecuenciaContagio = 0;
//	      recargaEnergia = 0;
//	      velocidadInvestigacion = 0;
//	      cantidadInvestigacionVacunaRoja = 0;
//	      cantidadInvestigacionVacunaVerde = 0;
//	      cantidadInvestigacionVacunaAmarilla = 0;
//	      cantidadInvestigacionVacunaAzul = 0;
//	      contadorBrotes = 0;
//		
//	      cura = false;
//	 	  investigaAm = false;
//	 	  investigadoAm = false;
//	 	  investigaAz = false;
//	 	  investigadoAz = false;
//	 	  investigaR = false;
//	 	  investigadoR = false;
//	 	  investigaV = false;
//	 	  investigadoV = false;
//	 	  evolucionR = false;
//	 	  evolucionV = false;
//	 	  evolucionAm = false;
//	 	  paisSeleccionado = 0;
//	 	  muertosTotales = 0;
//	 	  poblacionTotal = 6309825100L;
//	 	  nvlLab = 0;
//	 	  nvlPub = 0;
//	 	  idPartida = 0;
//	      iAm = 0;
//	      iAz = 0;
//	      iR = 0;
//	      iV = 0;
//	      eAm = 0;
//	      eR = 0;
//	      eV = 0;
//	      
//	      for(int i = 0; i < ciudadesLista.size(); i++) {
//	    	  
//	    	  ciudadesLista.get(i).setAmarillo(0);
//	    	  ciudadesLista.get(i).setAzul(0);
//	    	  ciudadesLista.get(i).setVerde(0);
//	    	  ciudadesLista.get(i).setRojo(0);
//	    	  ciudadesLista.get(i).setCiudadMuerta(0);
//	    	  ciudadesLista.get(i).setPoblacionMuerta(0);
//	    	  
//	      }
//	      
//	      @SuppressWarnings("unused")
//		Boolean parar = false;
//	     
//	      for (int i = 0; i < ciudadesLista.size(); i++) {
//	    	  
//	    	  ciudadesLista.get(i).setAmarillo(0);
//	    	  ciudadesLista.get(i).setAzul(0);
//	    	  ciudadesLista.get(i).setVerde(0);
//	    	  ciudadesLista.get(i).setRojo(0);
//	    	  ciudadesLista.get(i).setPoblacionMuerta(0);
//	    	  ciudadesLista.get(i).setCiudadMuerta(0);
//	    	  nivel(i);
//	      }
//	      
//	     ciudadesLista.removeAll(ciudadesLista);
//	     ciudadesBoton.removeAll(ciudadesBoton);
//	     
//	     barra.remove(barra);
//	     barraAz.remove(barraAz);
//	     barraAm.remove(barraAm);
//	     barraR.remove(barraR);
//	     barraV.remove(barraV);
//	     
//	     
//	     
//	   }
	
	// Enlace a los botones
	public void actionPerformed(ActionEvent e) {
		
//		if(e.getSource() == partida1) {
//		
//			guardarCiudades(PanelUsuario.con); 
//			guardarPartida(PanelUsuario.con);
//			
//			idPartida = 1;
//			
//		}else if (e.getSource() == partida2) {
//			
//			guardarCiudades(PanelUsuario.con);
//			guardarPartida(PanelUsuario.con);
//			
//			idPartida = 2;
//
//		}else if (e.getSource() == partida3) {
//			
//			guardarCiudades(PanelUsuario.con);
//			guardarPartida(PanelUsuario.con);
//			
//			idPartida = 3;
//
//		}else 
		if (e.getSource() == ciudadesBoton.get(0)) {
			paisSeleccionado = 0;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(1)) {
			paisSeleccionado = 1;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(2)) {
			paisSeleccionado = 2;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(3)) {
			paisSeleccionado = 3;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(4)) {
			paisSeleccionado = 4;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(5)) {
			paisSeleccionado = 5;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(6)) {
			paisSeleccionado = 6;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(7)) {
			paisSeleccionado = 7;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(8)) {
			paisSeleccionado = 8;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(9)) {
			paisSeleccionado = 9;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(10)) {
			paisSeleccionado = 10;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(11)) {
			paisSeleccionado = 11;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(12)) {
			paisSeleccionado = 12;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(13)) {
			paisSeleccionado = 13;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(14)) {
			paisSeleccionado = 14;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(15)) {
			paisSeleccionado = 15;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(16)) {
			paisSeleccionado = 16;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(17)) {
			paisSeleccionado = 17;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(18)) {
			paisSeleccionado = 18;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(19)) {
			paisSeleccionado = 19;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(20)) {
			paisSeleccionado = 20;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(21)) {
			paisSeleccionado = 21;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(22)) {
			paisSeleccionado = 22;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(23)) {
			paisSeleccionado = 23;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(24)) {
			paisSeleccionado = 24;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(25)) {
			paisSeleccionado = 25;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(26)) {
			paisSeleccionado = 26;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(27)) {
			paisSeleccionado = 27;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(28)) {
			paisSeleccionado = 28;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(29)) {
			paisSeleccionado = 29;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(30)) {
			paisSeleccionado = 30;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(31)) {
			paisSeleccionado = 31;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(32)) {
			paisSeleccionado = 32;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(33)) {
			paisSeleccionado = 33;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(34)) {
			paisSeleccionado = 34;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(35)) {
			paisSeleccionado = 35;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(36)) {
			paisSeleccionado = 36;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(37)) {
			paisSeleccionado = 37;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(38)) {
			paisSeleccionado = 38;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(39)) {
			paisSeleccionado = 39;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(40)) {
			paisSeleccionado = 40;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(41)) {
			paisSeleccionado = 41;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(42)) {
			paisSeleccionado = 42;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(43)) {
			paisSeleccionado = 43;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(44)) {
			paisSeleccionado = 44;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(45)) {
			paisSeleccionado = 45;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(46)) {
			paisSeleccionado = 46;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(47)) {
			paisSeleccionado = 47;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(48)) {
			paisSeleccionado = 48;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(49)) {
			paisSeleccionado = 49;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(50)) {
			paisSeleccionado = 50;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(51)) {
			paisSeleccionado = 51;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(52)) {
			paisSeleccionado = 52;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(53)) {
			paisSeleccionado = 53;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(54)) {
			paisSeleccionado = 54;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(55)) {
			paisSeleccionado = 55;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(56)) {
			paisSeleccionado = 56;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(57)) {
			paisSeleccionado = 57;
			actualizarMenu();
			
		} else if (e.getSource() == ciudadesBoton.get(58)) {
			paisSeleccionado = 58;
			actualizarMenu();
			
		} else if (e.getSource() == siSalir) {
			
			Main.game.close();
			Main.menu.run();
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelJugar());
			marco.setVisible(true);

		} else 
//			if (e.getSource() == continuar) {
//				
//			reiniciarPartida();
//			PanelJugar.cargarPasar = false;
//			canciones.get(2).stop();
//			canciones.get(1).play();
//			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
//			marco.remove(this);
//			marco.add(new PanelJugar(canciones));
//			marco.setVisible(true);
//
//		} else 
			if (e.getSource() == bll) {
			
			bll.setVisible(false);
			dll.setVisible(true);
			dlam.setVisible(true);
			dlaz.setVisible(true);
			dlr.setVisible(true);
			dlv.setVisible(true);
			dltam.setVisible(true);
			dltaz.setVisible(true);
			dltr.setVisible(true);
			dltv.setVisible(true);
			dlir1.setVisible(true);
			dlir2.setVisible(true);
			dlir3.setVisible(true);
			dliam1.setVisible(true);
			dliam2.setVisible(true);
			dliam3.setVisible(true);
			dliv1.setVisible(true);
			dliv2.setVisible(true);
			dliv3.setVisible(true);
			dliaz1.setVisible(true);
			dliaz2.setVisible(true);
			dliaz3.setVisible(true);
			dlim.setVisible(true);
			dltm.setVisible(true);
			dlm.setVisible(true);
			dlit.setVisible(true);

			ley = new Timer(5000, null);
			ley.start();
			ley.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ley.stop(); 
					
					dll.setVisible(false);
					dlam.setVisible(false);
					dlaz.setVisible(false);
					dlr.setVisible(false);
					dlv.setVisible(false);
					dltam.setVisible(false);
					dltaz.setVisible(false);
					dltr.setVisible(false);
					dltv.setVisible(false);
					dlir1.setVisible(false);
					dlir2.setVisible(false);
					dlir3.setVisible(false);
					dliam1.setVisible(false);
					dliam2.setVisible(false);
					dliam3.setVisible(false);
					dliv1.setVisible(false);
					dliv2.setVisible(false);
					dliv3.setVisible(false);
					dliaz1.setVisible(false);
					dliaz2.setVisible(false);
					dliaz3.setVisible(false);
					dlim.setVisible(false);
					dltm.setVisible(false);
					dlm.setVisible(false);
					dlit.setVisible(false);

					bll.setVisible(true);

				}
			});	
		}
	}
	
	// Leemos el archivo xml
	public static void leer() {
		
		 String parametros = "Ficheros/inicio_Partida.xml";
	     String parLimiteMuertos = "";
	     String parLimiteEnfermedadRoja = "";
	     String parLimiteEnfermedadVerde = "";
	     String parLimiteEnfermedadAmarilla = "";
	     String parLimiteEnfermedadAzul = "";
	     String parLimiteEnfermedad = "";
	     String parLimiteBrotes = "";
	     String parFrecuenciaContagio = "";
	     String parRecargaEnergia = "";
	     String parVelocidadInvestigacion = "";
	     String parCantidadInvestigacionVacunaRoja = "";
	     String parCantidadInvestigacionVacunaVerde = "";
	     String parCantidadInvestigacionVacunaAmarilla = "";
	     String parCantidadInvestigacionVacunaAzul = "";
		
		Document dom;
       
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       
       try {
       	
           DocumentBuilder db = dbf.newDocumentBuilder();
           dom = db.parse(parametros);

           Element doc = dom.getDocumentElement();
         
           parLimiteMuertos = getTextValue(parLimiteMuertos, doc, "limiteMuertos");
           limiteMuertos = Long.parseLong(parLimiteMuertos);
           
           parLimiteEnfermedadRoja = getTextValue(parLimiteEnfermedadRoja, doc, "limiteEnfermedadRoja");
           limiteEnfermedadRoja = Integer.parseInt(parLimiteEnfermedadRoja);
       
           parLimiteEnfermedadVerde = getTextValue(parLimiteEnfermedadVerde, doc, "limiteEnfermedadVerde");
           limiteEnfermedadVerde = Integer.parseInt(parLimiteEnfermedadVerde);

           parLimiteEnfermedadAmarilla = getTextValue(parLimiteEnfermedadAmarilla, doc, "limiteEnfermedadAmarilla");
           limiteEnfermedadAmarilla = Integer.parseInt(parLimiteEnfermedadAmarilla);
           
           parLimiteEnfermedadAzul = getTextValue(parLimiteEnfermedadAzul, doc, "limiteEnfermedadAzul");
           limiteEnfermedadAzul = Integer.parseInt(parLimiteEnfermedadAzul);

           parLimiteEnfermedad = getTextValue(parLimiteEnfermedad, doc, "limiteEnfermedad");
           limiteEnfermedad = Integer.parseInt(parLimiteEnfermedad);

           parLimiteBrotes = getTextValue(parLimiteBrotes, doc, "limiteBrotes");
           limiteBrotes = Integer.parseInt(parLimiteBrotes);

           parFrecuenciaContagio = getTextValue(parFrecuenciaContagio, doc, "frecuenciaContagio");
           frecuenciaContagio = Integer.parseInt(parFrecuenciaContagio);
           
           parVelocidadInvestigacion = getTextValue(parVelocidadInvestigacion, doc, "velocidadInvestigacion");
           velocidadInvestigacion = Integer.parseInt(parVelocidadInvestigacion);
           
           parCantidadInvestigacionVacunaRoja = getTextValue(parCantidadInvestigacionVacunaRoja, doc, "cantidadInvestigacionVacunaRoja");
           cantidadInvestigacionVacunaRoja = Integer.parseInt(parCantidadInvestigacionVacunaRoja);

           parCantidadInvestigacionVacunaVerde = getTextValue(parCantidadInvestigacionVacunaVerde, doc, "cantidadInvestigacionVacunaVerde");
           cantidadInvestigacionVacunaVerde = Integer.parseInt(parCantidadInvestigacionVacunaVerde);

           parCantidadInvestigacionVacunaAmarilla = getTextValue(parCantidadInvestigacionVacunaAmarilla, doc, "cantidadInvestigacionVacunaAmarilla");
           cantidadInvestigacionVacunaAmarilla = Integer.parseInt(parCantidadInvestigacionVacunaAmarilla);

           parCantidadInvestigacionVacunaAzul = getTextValue(parCantidadInvestigacionVacunaAzul, doc, "cantidadInvestigacionVacunaAzul");
           cantidadInvestigacionVacunaAzul = Integer.parseInt(parCantidadInvestigacionVacunaAzul);
           
           parRecargaEnergia = getTextValue(parRecargaEnergia, doc, "recargaEnergia");
           recargaEnergia = Integer.parseInt(parRecargaEnergia);
             
       } catch (ParserConfigurationException pce) {
           System.out.println(pce.getMessage());
       } catch (SAXException se) {
           System.out.println(se.getMessage());
       } catch (IOException ioe) {
           System.err.println(ioe.getMessage());
       }
	}
	
	// Cogemos el valor del xml
	private static String getTextValue(String def, Element doc, String tag) {
		
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	    	
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
	
}