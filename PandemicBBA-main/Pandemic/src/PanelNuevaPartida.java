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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

@SuppressWarnings("serial")
public class PanelNuevaPartida extends JPanel implements ActionListener{

	// Creamos los cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");
	
	// Obtenemos la altura y el ancho de la pantalla
	static Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
	static int h = p.height;
    static int w = p.width;
    
    // Creamos Booleanos
    static boolean t;
    boolean f;
    boolean d;
    static boolean c;
    
    // Creamos botones y demás
    Boton tutorial; 
	Boton facil;
	Boton dificil;
    Boton custom; 
	Boton atras;
	Boton comenzar;
	TextArea tFacil;
	TextArea tDificil;
	TextArea tCustom;
	TextArea tTutorial;
	JLabel dificultad;
	JLabel titulo;
	
	// Creamos una imagen
	private Image imagen;
	
	static ArrayList<Musica> canciones;
	
	PanelNuevaPartida(ArrayList<Musica> cancion){
		
		canciones = cancion;
		
		// Ponemos el cursor
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Creamos el titulo
		titulo = new JLabel("NUEVA PARTIDA");
		titulo.setBounds((int) Math.round(w*0.035), (int) Math.round(h*0.1), Math.round((w*750)/1920), Math.round((h*100)/1080));
		titulo.setVisible(true);
		titulo.setFont(new FontUIResource("Calibri Bold", Font.PLAIN, Math.round((w*100)/1920)));
		titulo.setForeground(Color.white);
		
		// Creamos el subtitulo
		dificultad = new JLabel("DIFICULTAD");
		dificultad.setBounds((int) Math.round(w*0.04), (int) Math.round(h*0.3), Math.round((w*500)/1920), Math.round((h*100)/1080));
		dificultad.setVisible(true);
		dificultad.setFont(new FontUIResource("Calibri", Font.PLAIN, Math.round((w*60)/1920)));
		dificultad.setForeground(Color.white);
		
		// Creamos el boton de tutorial
		tutorial = new Boton("TUTORIAL", w*0.04, h*0.40, Math.round((w*225)/1920), Math.round((h*50)/1080));
		tutorial.addActionListener(this);
		tutorial.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {tTutorial.setVisible(true); tutorial.setForeground(Color.gray); setCursor(cursor2);}
			public void mouseExited(MouseEvent e) {tTutorial.setVisible(false); if (!t) {tutorial.setForeground(Color.white); setCursor(cursor1);}}
			public void mouseClicked(MouseEvent e) {comenzar.setVisible(true); tutorial.setForeground(Color.gray); t=true; f=false; d=false; c=false;
			facil.setForeground(Color.white); dificil.setForeground(Color.white); custom.setForeground(Color.white);}}));
		tutorial.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Creamos el texto para tutorial
		tTutorial = new TextArea("Practica cuanto quieras, no podrás perder", w*0.3, h*0.4, Math.round((w*400)/1920), Math.round((h*150)/1080));
		
		// Creamos el boton para facil
		facil = new Boton("FÁCIL", w*0.04, h*0.47, Math.round((w*225)/1920), Math.round((h*50)/1080));
		facil.addActionListener(this);
		facil.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {tFacil.setVisible(true); facil.setForeground(Color.gray); setCursor(cursor2);}
			public void mouseExited(MouseEvent e) {tFacil.setVisible(false); if (!f) {facil.setForeground(Color.white); setCursor(cursor1);}}
			public void mouseClicked(MouseEvent e) {comenzar.setVisible(true); facil.setForeground(Color.gray); f=true; d=false; t=false; c=false;
			tutorial.setForeground(Color.white); dificil.setForeground(Color.white); custom.setForeground(Color.white);}}));
		facil.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Creamos el texto para facil
		tFacil = new TextArea("Modo sencillo para aquellos \nque recién han empezado a jugar", w*0.3, h*0.4, 400, 150);
		
		// Creamos el boton para dificil
		dificil = new Boton("DIFÍCIL", w*0.04, h*0.54, Math.round((w*225)/1920), Math.round((h*50)/1080));
		dificil.addActionListener(this);
		dificil.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {tDificil.setVisible(true); dificil.setForeground(Color.gray); setCursor(cursor2);}
			public void mouseExited(MouseEvent e) {tDificil.setVisible(false); if(!d) {dificil.setForeground(Color.white); setCursor(cursor1);}}
			public void mouseClicked(MouseEvent e) {comenzar.setVisible(true); dificil.setForeground(Color.gray); d=true; t=false; f=false; c=false;
			tutorial.setForeground(Color.white); facil.setForeground(Color.white); custom.setForeground(Color.white);}}));
		dificil.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Creamos el texto para dificil
		tDificil = new TextArea("Modo dificil para quien sabe jugar", w*0.3, h*0.4, 400, 150);
		
		// Creamos el boton para personalizada
		custom = new Boton("PERSONALIZADA", w*0.04, h*0.61, Math.round((w*350)/1920), Math.round((h*50)/1080));
		custom.addActionListener(this);
		custom.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {tCustom.setVisible(true); custom.setForeground(Color.gray); setCursor(cursor2);}
			public void mouseExited(MouseEvent e) {tCustom.setVisible(false); if(!c) {custom.setForeground(Color.white); setCursor(cursor1);}}
			public void mouseClicked(MouseEvent e) {comenzar.setVisible(true); custom.setForeground(Color.gray); c=true; t=false; f=false; d=false;
			tutorial.setForeground(Color.white); facil.setForeground(Color.white); dificil.setForeground(Color.white);}}));
		custom.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Creamos el texto para personalizada
		tCustom = new TextArea("Elige los parámetros de tu partida \npara crear partidas únicas", w*0.3, h*0.4, Math.round((w*400)/1920), Math.round((h*150)/1080));
		
		// Creamos el boton para atras
		atras = new Boton("ATRÁS", w*0.035, h*0.8, Math.round((w*200)/1920), Math.round((h*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		atras.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Creamos el boton para comenzar
		comenzar = new Boton("COMENZAR", w*0.425, h*0.8, Math.round((w*275)/1920), Math.round((h*50)/1080));
		comenzar.addActionListener(this);
		comenzar.MouseListener();
		comenzar.setVisible(false);
		comenzar.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((w*40)/1920)));
		
		// Añadimos todo al Panel
		add(tutorial);
		add(tTutorial);
		add(facil);
		add(dificil);
		add(custom);
		add(atras);
		add(dificultad);
		add(titulo);
		add(tFacil);
		add(tDificil);
		add(tCustom);
		add(comenzar);
		
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
		
		if (e.getSource()==comenzar){
			
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			
			if(c) {marco.add(new PanelPartidaPersonalizada(canciones)); marco.setVisible(true);}
			else {
				canciones.get(1).stop();
				parametros();
				
				if(t) {
					marco.add(new PanelJuego(canciones));  PanelJuego.leer();}
				else if(f) {marco.add(new PanelJuego(canciones));}
				else if(d) {marco.add(new PanelJuego(canciones));}
			
			}
			
			marco.setVisible(true);
			
		} else if (e.getSource()==atras){
			
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelJugar(canciones));
			marco.setVisible(true);
			
		}
		
	}
	
	// Escribimos el xml para los paramertos
	public void parametros () {
		
		  Document dom;
		  Element e = null;
		  
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    
		    try {
		    	
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        dom = db.newDocument();
		        
		        Element rootEle = dom.createElement("parametros");
		        
		         String parametros = "C:Ficheros/inicio_Partida.xml";
		         String limiteMuertos = "";
		         String limiteEfermedadRoja = "";
		         String limiteEfermedadVerde = "";
		         String limiteEnfermedadAmarilla = "";
		         String limiteEnfermedad = "";
		         String limiteEnfermedadAzul = "";
		         String limiteBrotes = "";
		         String frecuenciaContagio = "";
		         String recargaEnergia = "";
		         String velocidadInvestigacion = "";
		         String cantidadInvestigacionVacunaRoja = "";
		         String cantidadInvestigacionVacunaVerde = "";
		         String cantidadInvestigacionVacunaAmarilla = "";
		         String cantidadInvestigacionVacunaAzul = "";

		        if (t) { limiteMuertos = "-1"; }
				else if (f) { limiteMuertos = "143184274"; } 
		        else if (d) { limiteMuertos = "2143184274"; }
		        
		        e = dom.createElement("limiteMuertos");
		        e.appendChild(dom.createTextNode(limiteMuertos));
		        rootEle.appendChild(e);

		        if (t) { limiteEfermedadRoja = "-1"; }
				else if (f) { limiteEfermedadRoja = "20"; }
		        else if (d) { limiteEfermedadRoja = "10";}
		        
		        e = dom.createElement("limiteEnfermedadRoja");
		        e.appendChild(dom.createTextNode(limiteEfermedadRoja));
		        rootEle.appendChild(e);
		        
		        if (t) { limiteEfermedadVerde = "-1"; }
				else if (f) { limiteEfermedadVerde = "20"; }
		        else if (d) {  limiteEfermedadVerde = "10"; }

		        e = dom.createElement("limiteEnfermedadVerde");
		        e.appendChild(dom.createTextNode(limiteEfermedadVerde));
		        rootEle.appendChild(e);

		       if (t) { limiteEnfermedadAmarilla = "-1"; }
			   else if (f) { limiteEnfermedadAmarilla = "20"; }
		       else if (d) {  limiteEnfermedadAmarilla = "10"; }
		        
		        e = dom.createElement("limiteEnfermedadAmarilla");
		        e.appendChild(dom.createTextNode(limiteEnfermedadAmarilla));
		        rootEle.appendChild(e);
		        
		        if (t) { limiteEnfermedadAzul = "-1"; }
				else if (f) { limiteEnfermedadAzul = "20"; }
			    else if (d) {  limiteEnfermedadAzul = "10"; }
			        
			    e = dom.createElement("limiteEnfermedadAzul");
			    e.appendChild(dom.createTextNode(limiteEnfermedadAzul));
			    rootEle.appendChild(e);
			    
			    if (t) { limiteEnfermedad = "-1"; }
				else if (f) { limiteEnfermedad = "80"; }
			    else if (d) {  limiteEnfermedad = "40"; }
			        
			    e = dom.createElement("limiteEnfermedad");
			    e.appendChild(dom.createTextNode(limiteEnfermedad));
			    rootEle.appendChild(e);

			    if (t) { limiteBrotes = "-1"; }
				else if (f) { limiteBrotes = "10"; }
			    else if (d) {  limiteBrotes = "7"; }
			        
			    e = dom.createElement("limiteBrotes");
			    e.appendChild(dom.createTextNode(limiteBrotes));
			    rootEle.appendChild(e);
			    
			    if (t) { frecuenciaContagio = "3000"; }
				else if (f) { frecuenciaContagio = "3000"; }
			    else if (d) {  frecuenciaContagio = "2000"; }
			        
			    e = dom.createElement("frecuenciaContagio");
			    e.appendChild(dom.createTextNode(frecuenciaContagio));
			    rootEle.appendChild(e);
			    
			    if (t) { recargaEnergia = "10"; }
				else if (f) { recargaEnergia = "10"; }
			    else if (d) {  recargaEnergia = "30"; }
			        
			    e = dom.createElement("recargaEnergia");
			    e.appendChild(dom.createTextNode(recargaEnergia));
			    rootEle.appendChild(e);
			    
			    if (t) { velocidadInvestigacion = "50"; }
				else if (f) { velocidadInvestigacion = "50"; }
			    else if (d) {  velocidadInvestigacion = "100"; }
			        
			    e = dom.createElement("velocidadInvestigacion");
			    e.appendChild(dom.createTextNode(velocidadInvestigacion));
			    rootEle.appendChild(e);
			    
			    if (t) { cantidadInvestigacionVacunaRoja = "500"; }
				else if (f) { cantidadInvestigacionVacunaRoja = "1000"; }
			    else if (d) {  cantidadInvestigacionVacunaRoja = "1500"; }
			        
			    e = dom.createElement("cantidadInvestigacionVacunaRoja");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaRoja));
			    rootEle.appendChild(e);
			    
			    if (t) { cantidadInvestigacionVacunaVerde = "500"; }
				else if (f) { cantidadInvestigacionVacunaVerde = "1000"; }
			    else if (d) {  cantidadInvestigacionVacunaVerde = "1500"; }
			        
			    e = dom.createElement("cantidadInvestigacionVacunaVerde");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaVerde));
			    rootEle.appendChild(e);
			    
			    if (t) { cantidadInvestigacionVacunaAmarilla = "500"; }
				else if (f) { cantidadInvestigacionVacunaAmarilla = "1000"; }
			    else if (d) {  cantidadInvestigacionVacunaAmarilla = "1500"; }
			        
			    e = dom.createElement("cantidadInvestigacionVacunaAmarilla");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaAmarilla));
			    rootEle.appendChild(e);
			    
			    if (t) { cantidadInvestigacionVacunaAzul = "500"; }
				else if (f) { cantidadInvestigacionVacunaAzul = "1000"; }
			    else if (d) {  cantidadInvestigacionVacunaAzul = "1500"; }
			        
			    e = dom.createElement("cantidadInvestigacionVacunaAzul");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaAzul));
			    rootEle.appendChild(e);
			    
		        dom.appendChild(rootEle);
		        
		        try {
		        	
		            Transformer tr = TransformerFactory.newInstance().newTransformer();
		        	tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(parametros)));

		        } catch (TransformerException te) {
		            System.out.println(te.getMessage());
		        } catch (IOException ioe) {
		            System.out.println(ioe.getMessage());
		        }
		        
		    } catch (ParserConfigurationException pce) {
		        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	
		    }   
	}

}