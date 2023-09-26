import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
// Clase para labels personalizados
public class Label extends JLabel {

	// Guardamos en ua variable la altura de la pantalla
	Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
	int H = p.height;
	
		public Label(String string, int x, int y, int h, int w) {
			
			this.setText(string);
			this.setBounds(x,y,h,w);
			this.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((H*75)/1080)));
			this.setForeground(Color.white);
			this.setVisible(true);
			
		}
		
		public Label(String string, int center, int x, int y, int h, int w,boolean vis) {
			
			this.setText(string);
			this.setBounds(x,y,h,w);
			this.setFont(new FontUIResource ("Calibri" ,Font.PLAIN, Math.round((H*15)/1080)));
			this.setForeground(Color.white);
			this.setVisible(vis);
			
		}
		
		public Label(String string, int x, int y, int h, int w, int r, int g, int b,int l) {
			
			this.setText(string);
			this.setBounds(x, y, h, w);
			this.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((H*l)/1080)));
			this.setForeground(new Color(r,g,b));
			this.setVisible(true);
			
		}
		
		public Label(String string, int x, int y, int h, int w, int r, int g, int b,int l, int centrar) {
			
			this.setText(string);
			this.setBounds(x, y, h, w);
			this.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((H*l)/1080)));
			this.setForeground(new Color(r,g,b));
			this.setVisible(true);
			if (centrar == 0) {this.setHorizontalAlignment(JLabel.LEFT);}
			else if (centrar == 1) {this.setHorizontalAlignment(JLabel.CENTER);}
			else if (centrar == 2) {this.setHorizontalAlignment(JLabel.RIGHT);}
	
		}
		
		public Label(String string, int x, int y, int h, int w,int l) {
			
			this.setText(string);
			this.setBounds(x, y, h, w);
			this.setFont(new FontUIResource ("Calibri" ,Font.BOLD, Math.round((H*l)/1080)));
			this.setForeground(new Color(255,255,255));
			this.setVisible(false);
			
	
		}
		
		public Label(ImageIcon a, int x, int y, int h, int w) {
		
			this.setIcon(a);
			this.setBounds(x, y, h, w);
			this.setForeground(new Color(255,255,255));
			this.setVisible(false);
			
	
		}
		
}
