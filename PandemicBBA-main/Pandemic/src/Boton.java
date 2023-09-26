import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class Boton extends JButton{
	
	// Guardamos en una variable la altura de la pantalla
	Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
	int H = p.height;
	
	// Creamos cursores
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image imagenCursor1 = tk.getImage("Assets/cursor1.png");
	Image imagenCursor2 = tk.getImage("Assets/cursor2.png");
	Cursor cursor1 = tk.createCustomCursor(imagenCursor1, new Point(0,0), "cursor1");
	Cursor cursor2 = tk.createCustomCursor(imagenCursor2, new Point(0,0), "cursor2");

	// Modificamos el boton
	public Boton(String string, double x, double y, double w, double h) {

		this.setText(string);
		this.setBounds((int)Math.round(x), (int)Math.round(y), (int)Math.round(w), (int)Math.round(h));
		this.setForeground(Color.white);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setHorizontalAlignment(LEFT);
		this.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((H*50)/1080)));
		
	}
	
	public Boton(ImageIcon izquierda, double x, double y, double w, double h, boolean vis) {
		
		this.setIcon(izquierda);
		this.setBounds((int)Math.round(x), (int)Math.round(y), (int)Math.round(w), (int)Math.round(h));
		this.setVisible(vis);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
	}
	
	// Añadimos efectos al cursor y botones
	
	public void MouseListener () {
		this.addMouseListener(new MouseAdapter() {			
			public void mouseExited(MouseEvent e) {setForeground(Color.white); setCursor(cursor1);}
			public void mouseEntered(MouseEvent e) {setForeground(Color.gray); setCursor(cursor2);}});
	}
	
}