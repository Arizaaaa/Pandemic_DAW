import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
// Creamos areas de texto personalizados
public class TextArea extends JTextArea {

	// Creamos el objeto
	JTextArea textArea;
	
	// Modificamos el area de texto
	public TextArea(String texto, double x, double y, double w, double h) {
		
		this.setText(texto);
		this.setEditable(false);
		this.setForeground(Color.white);
		this.setFont(new FontUIResource("Calibri", Font.PLAIN, 20));
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setCaretPosition(0);
		this.setBackground(null);
		this.setVisible(false);
		this.setOpaque(false);
		this.setBounds((int)Math.round(x), (int)Math.round(y), (int)Math.round(w), (int)Math.round(h));		
	}
	
}