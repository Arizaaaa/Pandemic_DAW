import java.awt.Color;

import javax.swing.JProgressBar;

@SuppressWarnings("serial")
// Objeto para barras de progreso personalizadas
public class Barra extends JProgressBar {

	public Barra(int x, int y, int h, int w) {
	
		this.setOrientation(1);  
		this.setValue(0);
		this.setMinimum(0);
		this.setOpaque(false);
		this.setBackground(new Color(255, 155, 0));
		this.setMaximum(1000);
		this.setBounds(x,y,h,w);
		this.setVisible(true);
		this.setStringPainted(true);
		
	}
	
	public Barra(int r, int g, int b, int max ,int x, int y, int h, int w) {
		
		this.setOrientation(1);  
		this.setValue(30);
		this.setMinimum(0);
		this.setBorder(null);
		this.setOpaque(false);
		this.setBackground(new Color(0, 255, 0));
		this.setForeground(new Color(r, g, b));
		this.setMaximum(max);
		this.setBounds(x,y,h,w);
		this.setVisible(true);
		
	}
}
