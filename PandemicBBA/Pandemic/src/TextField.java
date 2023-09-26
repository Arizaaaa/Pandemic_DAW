import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
// Creamos textFields personalizados
public class TextField extends JTextField {

	public TextField(String string,int x, int y, int h, int w) {
		
		this.setText(string);
		this.setBounds(x,y,h,w);
		this.setFont(new FontUIResource ("Comic Sans+" ,Font.PLAIN, Math.round((Pantalla.height*40)/1920)));
		this.setForeground(Color.white);
		this.setVisible(true);
		this.setOpaque(false);
		this.setBorder(null);
		this.setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
		
	}
}
