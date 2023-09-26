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
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("serial")
public class PanelPartidaPersonalizada extends JPanel implements ActionListener{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");	

	Image imgI = new ImageIcon("Assets/izquierda.png").getImage();
    ImageIcon izquierda = new ImageIcon(imgI.getScaledInstance(Math.round((Pantalla.width*50)/1920), Math.round((Pantalla.height*50)/1080), Image.SCALE_DEFAULT));
    
    Image imgD = new ImageIcon("Assets/derecha.png").getImage();
    ImageIcon derecha = new ImageIcon(imgD.getScaledInstance(Math.round((Pantalla.width*50)/1920), Math.round((Pantalla.height*50)/1080), Image.SCALE_DEFAULT));

    // Botones
	Boton atras; 
	Boton limiteMIzquierda;
	Boton limiteMDerecha;
	TextField limiteMValor;
	Label limiteMTitulo;
	Boton limiteERIzquierda;
	Boton limiteERDerecha;
	TextField limiteERValor;
	Label limiteERTitulo;
	Boton limiteEVIzquierda;
	Boton limiteEVDerecha;
	TextField limiteEVValor;
	Label limiteEVTitulo;
	Boton limiteEAmIzquierda;
	Boton limiteEAmDerecha;
	TextField limiteEAmValor;
	Label limiteEAmTitulo;
	Boton limiteEAzIzquierda;
	Boton limiteEAzDerecha;
	TextField limiteEAzValor;
	JLabel limiteEAzTitulo;
	Boton limiteBIzquierda;
	Boton limiteBDerecha;
	TextField limiteBValor;
	JLabel limiteBTitulo;
	Boton limiteEIzquierda;
	Boton limiteEDerecha;
	TextField limiteEValor;
	Label limiteETitulo;
	Boton frecuenciaCIzquierda;
	Boton frecuenciaCDerecha;
	TextField frecuenciaCValor;
	Label frecuenciaCTitulo;
	Boton recargaEnergiaIzquierda;
	Boton recargaEnergiaDerecha;
	TextField recargaEnergiaValor;
	Label recargaEnergiaTitulo;
	Boton velocidadInvestigacionIzquierda;
	Boton velocidadInvestigacionDerecha;
	TextField velocidadInvestigacionValor;
	Label velocidadInvestigacionTitulo;
	Label cantidadInvestigacionVacunaRojaTitulo;
	Boton cantidadInvestigacionVacunaRojaIzquierda;
	Boton cantidadInvestigacionVacunaRojaDerecha;
	TextField cantidadInvestigacionVacunaRojaValor;
	Boton cantidadInvestigacionVacunaAmarillaIzquierda;
	Boton cantidadInvestigacionVacunaAmarillaDerecha;
	TextField cantidadInvestigacionVacunaAmarillaValor;
	Label cantidadInvestigacionVacunaAmarillaTitulo;
	Boton cantidadInvestigacionVacunaAzulIzquierda;
	Boton cantidadInvestigacionVacunaAzulDerecha;
	TextField cantidadInvestigacionVacunaAzulValor;
	Label cantidadInvestigacionVacunaVerdeTitulo;
	Boton cantidadInvestigacionVacunaVerdeIzquierda;
	Boton cantidadInvestigacionVacunaVerdeDerecha;
	TextField cantidadInvestigacionVacunaVerdeValor;
	Label cantidadInvestigacionVacunaAzulTitulo;
	Label titulo;
	Boton comenzar;
	Thread actualizarValor;
	JTextArea texto;
	
	private Image imagen;
	
	static Long limite = 6309825100L;
	
	static Long limiteM = 100000000L;
	static int limiteER = 5;
	static int limiteEV = 10;
	static int limiteEAm = 5;
	static int limiteEAz = 5;
	static int limiteE = 20;
	static int limiteB = 3;
	static int frecuenciaC = 5;
	static int recargaE = 0;
	static int velocidadI = 1;
	static int cantidadIR = 250;
	static int cantidadIV = 250;
	static int cantidadIAm = 250;
	static int cantidadIAz = 250;
	
	PanelPartidaPersonalizada(){
		
		this.setCursor(cursor1);
		this.setVisible(true);
		
		setLayout(null);
		
		// Título
		titulo = new Label("PARTIDA PERSONALIZADA",Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*25)/1080), Math.round((Pantalla.width*850)/1920), Math.round((Pantalla.height*100)/1080));
		
		// Título, botón izquierdo, botón derecho y textField de todos los parametros, respesctivamente
		limiteMTitulo = new Label("Límite de muertos", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*170)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteMTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de fallecidos para perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteMIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteMIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteM>0) {limiteM--; updateProgress(limiteMValor, limiteM);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteMDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteMDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteM++; updateProgress(limiteMValor, limiteM);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteMValor = new TextField(String.valueOf(limiteM),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		limiteERTitulo = new Label("Límite de enfermedades rojas máximas", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*270)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteERTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de enfermedades \nrojas con nivel 3 activas\npara perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteERIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteERIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteER>0) {limiteER--; updateProgress(limiteERValor, limiteER);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteERDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteERDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteER++; updateProgress(limiteERValor, limiteER);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteERValor = new TextField(String.valueOf(limiteER),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		limiteETitulo = new Label("Límite de enfermedades máximas", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*370)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteETitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de enfermedades \ncon nivel 3 activas\npara perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteEIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteE>0) {limiteE--; updateProgress(limiteEValor, limiteE);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteEDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteE++; updateProgress(limiteEValor, limiteE);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		limiteEValor = new TextField(String.valueOf(limiteER),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		recargaEnergiaTitulo = new Label("Frecuencia de recarga de energia (milisegundos)", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*470)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		recargaEnergiaTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Determina cada cuantos milisegundos se \ngenera energía, la cantidad máxima \nde energía son 1000 unidades");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		recargaEnergiaIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		recargaEnergiaIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(recargaE>0) {recargaE--; updateProgress(recargaEnergiaValor, recargaE);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		recargaEnergiaDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		recargaEnergiaDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {recargaE++; updateProgress(recargaEnergiaValor, recargaE);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		recargaEnergiaValor = new TextField(String.valueOf(recargaE),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		velocidadInvestigacionTitulo = new Label("Frecuencia de investigación (milisegundos)", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*570)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		velocidadInvestigacionTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Determina cada cuantos milisegundos se \ngenera un punto de investigacion, la \ncantidad máxima para investigar una \nvacuna son 1000 unidades");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		velocidadInvestigacionIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		velocidadInvestigacionIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {velocidadI--; updateProgress(velocidadInvestigacionValor, velocidadI);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		velocidadInvestigacionDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		velocidadInvestigacionDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {velocidadI++; updateProgress(velocidadInvestigacionValor, velocidadI);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		velocidadInvestigacionValor = new TextField(String.valueOf(velocidadI),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		
		cantidadInvestigacionVacunaAzulTitulo = new Label("Coste de investigación Azul", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*670)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		cantidadInvestigacionVacunaAzulTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de investigacion para\ncompletar la vacuna azul\n(cada investigación da 250 puntos)");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		cantidadInvestigacionVacunaAzulIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaAzulIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(cantidadIAz>0) {cantidadIAz--; updateProgress(cantidadInvestigacionVacunaAzulValor, cantidadIAz);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaAzulDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaAzulDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {cantidadIAz++; updateProgress(cantidadInvestigacionVacunaAzulValor, cantidadIAz);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaAzulValor = new TextField(String.valueOf(cantidadIAz),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		cantidadInvestigacionVacunaAmarillaTitulo = new Label("Coste de investigación Amarilla", SwingConstants.CENTER,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*770)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		cantidadInvestigacionVacunaAmarillaTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de investigacion para\ncompletar la vacuna amarilla\n(cada investigación da 250 puntos)");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		cantidadInvestigacionVacunaAmarillaIzquierda = new Boton(izquierda,Math.round((Pantalla.width*75)/1920), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaAmarillaIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(cantidadIAm>0) {cantidadIAm--; updateProgress(cantidadInvestigacionVacunaAmarillaValor, cantidadIAm);}}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaAmarillaDerecha = new Boton(derecha,Math.round(((Pantalla.width*75)/1920)+255), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaAmarillaDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {cantidadIAm++; updateProgress(cantidadInvestigacionVacunaAmarillaValor, cantidadIAm);}
			public void mouseExited(MouseEvent e) {setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaAmarillaValor = new TextField(String.valueOf(cantidadIAm),Math.round(((Pantalla.width*75)/1920)+55), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		limiteEVTitulo = new Label("Límite de enfermedades verdes máximas", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*170)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteEVTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de enfermedades \nverdes con nivel 3 activas\npara perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		
		limiteEVIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEVIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteEV>0) {limiteEV--; updateProgress(limiteEVValor, limiteEV);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEVDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEVDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteEV++; updateProgress(limiteEVValor, limiteEV);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEVValor = new TextField(String.valueOf(limiteEV),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*200)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));

		limiteEAmTitulo = new Label("Límite de enfermedades amarillas máxima", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*270)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteEAmTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de enfermedades \namarillas con nivel 3 activas\npara perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteEAmIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEAmIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteEAm>0) {limiteEAm--; updateProgress(limiteEAmValor, limiteEAm);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEAmDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEAmDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteEAm++; updateProgress(limiteEAmValor, limiteEAm);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEAmValor = new TextField(String.valueOf(limiteEAm),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*300)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		limiteEAzTitulo = new Label("Límite de enfermedades azules máximas", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*370)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteEAzTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de enfermedades \nazules con nivel 3 activas\npara perder");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteEAzIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEAzIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteEAz>0) {limiteEAz--; updateProgress(limiteEAzValor, limiteEAz);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEAzDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteEAzDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteEAz++; updateProgress(limiteEAzValor, limiteEAz);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteEAzValor = new TextField(String.valueOf(limiteEAz),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*400)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		limiteBTitulo = new Label("Límite de brotes", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*470)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		limiteBTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de brotes para perder la partida");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		limiteBIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteBIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(limiteB>0) {limiteB--; updateProgress(limiteBValor, limiteB);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteBDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		limiteBDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {limiteB++; updateProgress(limiteBValor, limiteB);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		limiteBValor = new TextField(String.valueOf(limiteB),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*500)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		frecuenciaCTitulo = new Label("Frecuencia de contagio (segundos)", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*570)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		frecuenciaCTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Determina cada cuántos segundos \nse contagiarán las ciudades");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		frecuenciaCIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		frecuenciaCIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(frecuenciaC>0) {frecuenciaC--; updateProgress(frecuenciaCValor, frecuenciaC);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		frecuenciaCDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		frecuenciaCDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {frecuenciaC++; updateProgress(frecuenciaCValor, frecuenciaC);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		frecuenciaCValor = new TextField(String.valueOf(frecuenciaC),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*600)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
	
		cantidadInvestigacionVacunaRojaTitulo = new Label("Coste de investigación Roja", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*670)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		cantidadInvestigacionVacunaRojaTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de investigacion para\ncompletar la vacuna roja\n(cada investigación da 250 puntos)");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
		
		cantidadInvestigacionVacunaRojaIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaRojaIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(cantidadIR>0) {cantidadIR--; updateProgress(cantidadInvestigacionVacunaRojaValor, cantidadIR);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaRojaDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaRojaDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {cantidadIR++; updateProgress(cantidadInvestigacionVacunaRojaValor, cantidadIR);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaRojaValor = new TextField(String.valueOf(cantidadIR),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*700)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		cantidadInvestigacionVacunaVerdeTitulo = new Label("Coste de investigacion Verde", SwingConstants.CENTER,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*770)/1080), Math.round((Pantalla.width*310)/1920), Math.round((Pantalla.height*30)/1080),true);
		cantidadInvestigacionVacunaVerdeTitulo.addMouseListener((new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {texto.setVisible(true); texto.setText("Cantidad de investigacion para\ncompletar la vacuna verden\n(cada investigación da 250 puntos)");}
			public void mouseExited(MouseEvent e) {texto.setVisible(false);}}));
			
		cantidadInvestigacionVacunaVerdeIzquierda = new Boton(izquierda,Math.round((Pantalla.width*450)/1920), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaVerdeIzquierda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {if(cantidadIV>0) {cantidadIV--; updateProgress(cantidadInvestigacionVacunaVerdeValor, cantidadIV);}}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaVerdeDerecha = new Boton(derecha,Math.round(((Pantalla.width*450)/1920)+255), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*55)/1920), Math.round((Pantalla.height*50)/1080),true);
		cantidadInvestigacionVacunaVerdeDerecha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {cantidadIV++; updateProgress(cantidadInvestigacionVacunaVerdeValor, cantidadIV);}
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
		
		cantidadInvestigacionVacunaVerdeValor = new TextField(String.valueOf(cantidadIV),Math.round(((Pantalla.width*450)/1920)+55), Math.round((Pantalla.height*800)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		
		// Botón para volver
		atras = new Boton("ATRAS", Math.round((Pantalla.width*1600)/1920), Math.round((Pantalla.height*900)/1080), Math.round((Pantalla.width*200)/1920), Math.round((Pantalla.height*50)/1080));
		atras.addActionListener(this);
		atras.MouseListener();
		atras.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*40)/1080)));
		
		// Botón para comezar partida
		comenzar = new Boton("COMENZAR", Math.round((Pantalla.width*275)/1920), Math.round((Pantalla.height*900)/1080), Math.round((Pantalla.width*350)/1920), Math.round((Pantalla.height*50)/1080));
		comenzar.addActionListener(this);
		comenzar.MouseListener();
		comenzar.setVisible(true);
		comenzar.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.width*50)/1920)));
		comenzar.addActionListener(this);
		
		// Area de texto donde se muestra detalles de cada parámetro
		texto = new JTextArea("");
		texto.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((Pantalla.height*25)/1080)));
		texto.setVisible(false);
		texto.setBounds(Math.round((Pantalla.width*950)/1920), Math.round((Pantalla.height*350)/1080), Math.round((Pantalla.width*500)/1920), Math.round((Pantalla.height*200)/1080));
		texto.setForeground(Color.black);
		texto.setBackground(null);
		texto.setEditable(false);
		texto.setOpaque(false);
		
		// Añadimos
		add(limiteMTitulo);
		add(limiteMIzquierda);
		add(limiteMDerecha);
		add(limiteMValor);
		add(limiteERTitulo);
		add(limiteERIzquierda);
		add(limiteERDerecha);
		add(limiteERValor);
		add(limiteEVTitulo);
		add(limiteEVIzquierda);
		add(limiteEVDerecha);
		add(limiteEVValor);
		add(limiteEAmTitulo);
		add(limiteEAmIzquierda);
		add(limiteEAmDerecha);
		add(limiteEAmValor);
		add(limiteEAzTitulo);
		add(limiteEAzIzquierda);
		add(limiteEAzDerecha);
		add(limiteEAzValor);
		add(limiteETitulo);
		add(limiteEIzquierda);
		add(limiteEDerecha);
		add(limiteEValor);
		add(limiteBTitulo);
		add(limiteBIzquierda);
		add(limiteBDerecha);
		add(limiteBValor);
		add(frecuenciaCTitulo);
		add(frecuenciaCIzquierda);
		add(frecuenciaCDerecha);
		add(frecuenciaCValor);
		add(recargaEnergiaTitulo);
		add(recargaEnergiaIzquierda);
		add(recargaEnergiaDerecha);
		add(recargaEnergiaValor);
		add(velocidadInvestigacionTitulo);
		add(velocidadInvestigacionIzquierda);
		add(velocidadInvestigacionDerecha);
		add(velocidadInvestigacionValor);
		add(cantidadInvestigacionVacunaRojaTitulo);
		add(cantidadInvestigacionVacunaRojaIzquierda);
		add(cantidadInvestigacionVacunaRojaDerecha);
		add(cantidadInvestigacionVacunaRojaValor);
		add(cantidadInvestigacionVacunaAmarillaTitulo);
		add(cantidadInvestigacionVacunaAmarillaIzquierda);
		add(cantidadInvestigacionVacunaAmarillaDerecha);
		add(cantidadInvestigacionVacunaAmarillaValor);
		add(cantidadInvestigacionVacunaAzulTitulo);
		add(cantidadInvestigacionVacunaAzulIzquierda);
		add(cantidadInvestigacionVacunaAzulDerecha);
		add(cantidadInvestigacionVacunaAzulValor);
		add(cantidadInvestigacionVacunaVerdeTitulo);
		add(cantidadInvestigacionVacunaVerdeIzquierda);
		add(cantidadInvestigacionVacunaVerdeDerecha);
		add(cantidadInvestigacionVacunaVerdeValor);
		add(texto);
		add(titulo);
		add(atras);
		add(comenzar);
		
		// Llamamos al hilo
		actualizarValor = new ThreadActualizarValor();
		actualizarValor.start();
		
		// Escribimos y cogemos los parametros de un xml
		parametros();
		
	}
	
	// Ponemos la imagen de fondo
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		File file = new File("Assets/ImagenMenu.png");
		try {imagen=ImageIO.read(file);} catch (IOException e) {e.printStackTrace();}
		g.drawImage(imagen.getScaledInstance(Pantalla.width, Pantalla.height, Image.SCALE_DEFAULT), 0, 0, null);
		
	}	
	
	// Actualiza el valor en caso de superar el máximo o el mínimo
	class ThreadActualizarValor extends Thread {
		
		public void run() {
			// Si supera valor maximo, que se actualice al valor maximo
			for(int i = 0; i < 5; i++) {
				i--;
				try{if(limiteM>=0 && limiteM<=(limite)) {limiteM=Long.valueOf(limiteMValor.getText());} else if(limiteM<0) {limiteM=(long) 0; limiteMValor.setText("0");} else if(limiteM>limite) {limiteM=limite; limiteMValor.setText("6309825100");}}catch(Exception e) {}
				try{if(limiteER>=0 && limiteER<=59) {limiteER=Integer.valueOf(limiteERValor.getText());} else if(limiteER<0) {limiteER=0; limiteERValor.setText("0");} else if(limiteER>59) {limiteER=59; limiteERValor.setText("59");}}catch(Exception e) {}
				try{if(limiteEV>=0 && limiteEV<=59) {limiteEV=Integer.valueOf(limiteEVValor.getText());} else if(limiteEV<0) {limiteEV=0; limiteEVValor.setText("0");} else if(limiteEV>59) {limiteEV=59; limiteEVValor.setText("59");}}catch(Exception e) {}
				try{if(limiteEAm>=0 && limiteEAm<=59) {limiteEAm=Integer.valueOf(limiteEAmValor.getText());} else if(limiteEAm<0) {limiteEAm=0; limiteEAmValor.setText("0");} else if(limiteEAm>59) {limiteEAm=59; limiteEAmValor.setText("59");}}catch(Exception e) {}
				try{if(limiteEAz>=0 && limiteEAz<=59) {limiteEAz=Integer.valueOf(limiteEAzValor.getText());} else if(limiteEAz<0) {limiteEAz=0; limiteEAzValor.setText("0");} else if(limiteEAz>59) {limiteEAz=59; limiteEAzValor.setText("59");}}catch(Exception e) {}
				try{if(limiteE>=0 && limiteE<=236) {limiteE=Integer.valueOf(limiteEValor.getText());} else if(limiteE<0) {limiteE=0; limiteEValor.setText("0");} else if(limiteE>236) {limiteE=236; limiteEValor.setText("236");}}catch(Exception e) {}
				try{if(limiteB>=0 && limiteB<=100) {limiteB=Integer.valueOf(limiteBValor.getText());} else if(limiteB<0) {limiteB=0; limiteBValor.setText("0");} else if(limiteB>100) {limiteB=100; limiteBValor.setText("100");}}catch(Exception e) {}
				try{if(frecuenciaC>=0 && frecuenciaC<=10) {frecuenciaC=Integer.valueOf(frecuenciaCValor.getText());} else if(frecuenciaC<0) {frecuenciaC=0; frecuenciaCValor.setText("0");} else if(frecuenciaC>10) {frecuenciaC=10; frecuenciaCValor.setText("10");}}catch(Exception e) {}
				try{if(recargaE>=0 && recargaE<=10) {recargaE=Integer.valueOf(recargaEnergiaValor.getText());} else if(recargaE<0) {recargaE=0; recargaEnergiaValor.setText("0");} else if(recargaE>10) {recargaE=10; recargaEnergiaValor.setText("10");}}catch(Exception e) {}
				try{if(velocidadI>=0 && velocidadI<=25) {velocidadI=Integer.valueOf(velocidadInvestigacionValor.getText());} else if(velocidadI<0) {velocidadI=0; velocidadInvestigacionValor.setText("0");} else if(velocidadI>25) {velocidadI=25; velocidadInvestigacionValor.setText("25");}}catch(Exception e) {}
				try{if(cantidadIV>=0 && cantidadIV<=2000) {cantidadIV=Integer.valueOf(cantidadInvestigacionVacunaVerdeValor.getText());} else if(cantidadIV<0) {cantidadIV=0; cantidadInvestigacionVacunaVerdeValor.setText("0");} else if(cantidadIV>2000) {cantidadIV=2000; cantidadInvestigacionVacunaVerdeValor.setText("2000");}}catch(Exception e) {}
				try{if(cantidadIR>=0 && cantidadIR<=2000) {cantidadIR=Integer.valueOf(cantidadInvestigacionVacunaRojaValor.getText());} else if(cantidadIR<0) {cantidadIR=0; cantidadInvestigacionVacunaRojaValor.setText("0");} else if(cantidadIR>2000) {cantidadIR=2000; cantidadInvestigacionVacunaRojaValor.setText("2000");}}catch(Exception e) {}
				try{if(cantidadIAm>=0 && cantidadIAm<=2000) {cantidadIAm=Integer.valueOf(cantidadInvestigacionVacunaAmarillaValor.getText());} else if(cantidadIAm<0) {cantidadIAm=0; cantidadInvestigacionVacunaAmarillaValor.setText("0");} else if(cantidadIAm>2000) {cantidadIAm=2000; cantidadInvestigacionVacunaAmarillaValor.setText("2000");}}catch(Exception e) {}
				try{if(cantidadIAz>=0 && cantidadIAz<=2000) {cantidadIAz=Integer.valueOf(cantidadInvestigacionVacunaAzulValor.getText());} else if(cantidadIAz<0) {cantidadIAz=0; cantidadInvestigacionVacunaAzulValor.setText("0");} else if(cantidadIAz>2000) {cantidadIAz=2000; cantidadInvestigacionVacunaAzulValor.setText("2000");}}catch(Exception e) {}
				
				try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			}
			
		}
	}
	
	// Actualizamos los datos que nos introduce el usuario por teclado
	private void updateProgress(JTextField ciiValor2, Long limiteM2) {
		 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ciiValor2.setText(Long.toString(limiteM2));
            }
        });
 
    }	
	
	// Actualizamos los datos que nos introduce el usuario por teclado
	private void updateProgress(JTextField ciiValor2, int limiteM2) {
		 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ciiValor2.setText(Integer.toString(limiteM2));
            }
        });
 
    }	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == comenzar) {
			
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			parametros();
			marco.add(new PanelJuego());
			marco.setVisible(true);
			
		}	else if (e.getSource()==atras){
			JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new PanelNuevaPartida());
			marco.setVisible(true);
		}
	}
	
	public void parametros () {
		
		  Document dom;
		  Element e = null;
		  
		  velocidadI = velocidadI * 10;
		  recargaE =  recargaE * 10;
		  frecuenciaC = frecuenciaC * 1000;
		 
		  
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    
		    try {
		    	
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        dom = db.newDocument();
		        
		        Element rootEle = dom.createElement("parametros");
		        
		         String parametros = "Ficheros/inicio_Partida.xml";
		         String limiteMuertos = String.valueOf(limiteM);
		         String limiteEfermedadRoja = String.valueOf(limiteER);
		         String limiteEfermedadVerde = String.valueOf(limiteEV);
		         String limiteEnfermedadAmarilla = String.valueOf(limiteEAm);
		         String limiteEnfermedad = String.valueOf(limiteE);
		         String limiteEnfermedadAzul = String.valueOf(limiteEAz);
		         String limiteBrotes = String.valueOf(limiteB);
		         String frecuenciaContagio = String.valueOf(frecuenciaC);
		         String recargaEnergia = String.valueOf(recargaE);
		         String velocidadInvestigacion = String.valueOf(velocidadI);
		         String cantidadInvestigacionVacunaRoja = String.valueOf(cantidadIR);
		         String cantidadInvestigacionVacunaVerde = String.valueOf(cantidadIV);
		         String cantidadInvestigacionVacunaAmarilla = String.valueOf(cantidadIAm);
		         String cantidadInvestigacionVacunaAzul = String.valueOf(cantidadIAz);
		      	        
		        e = dom.createElement("limiteMuertos");
		        e.appendChild(dom.createTextNode(limiteMuertos));
		        rootEle.appendChild(e);
		        
		        e = dom.createElement("limiteEnfermedadRoja");
		        e.appendChild(dom.createTextNode(limiteEfermedadRoja));
		        rootEle.appendChild(e);
		        
		        e = dom.createElement("limiteEnfermedadVerde");
		        e.appendChild(dom.createTextNode(limiteEfermedadVerde));
		        rootEle.appendChild(e);
		        
		        e = dom.createElement("limiteEnfermedadAmarilla");
		        e.appendChild(dom.createTextNode(limiteEnfermedadAmarilla));
		        rootEle.appendChild(e);
		        			        
			    e = dom.createElement("limiteEnfermedadAzul");
			    e.appendChild(dom.createTextNode(limiteEnfermedadAzul));
			    rootEle.appendChild(e);
			    			        
			    e = dom.createElement("limiteEnfermedad");
			    e.appendChild(dom.createTextNode(limiteEnfermedad));
			    rootEle.appendChild(e);
			        
			    e = dom.createElement("limiteBrotes");
			    e.appendChild(dom.createTextNode(limiteBrotes));
			    rootEle.appendChild(e);
			        
			    e = dom.createElement("frecuenciaContagio");
			    e.appendChild(dom.createTextNode(frecuenciaContagio));
			    rootEle.appendChild(e);
			        
			    e = dom.createElement("recargaEnergia");
			    e.appendChild(dom.createTextNode(recargaEnergia));
			    rootEle.appendChild(e);
			    			        
			    e = dom.createElement("velocidadInvestigacion");
			    e.appendChild(dom.createTextNode(velocidadInvestigacion));
			    rootEle.appendChild(e);
			     			        
			    e = dom.createElement("cantidadInvestigacionVacunaRoja");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaRoja));
			    rootEle.appendChild(e);
			    			       
			    e = dom.createElement("cantidadInvestigacionVacunaVerde");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaVerde));
			    rootEle.appendChild(e);
			    			       
			    e = dom.createElement("cantidadInvestigacionVacunaAmarilla");
			    e.appendChild(dom.createTextNode(cantidadInvestigacionVacunaAmarilla));
			    rootEle.appendChild(e);
			    			        
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