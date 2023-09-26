import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica extends Thread{

	// Creamos los atributos de Musica
	private static FloatControl fc;
	private static Clip clip;	
	private String rutaArchivo;
	private float volumen;
	
	static float[] v = new float[4];

	public Musica(String name) {
		
		leer();
		
		if(name.equals("Assets/Musica/mainTheme.wav")) {this.rutaArchivo = name; this.volumen = ((v[0]/100)*(v[1]))-80;}
		else if(name.equals("Assets/Musica/menuTheme.wav")) {this.rutaArchivo = name; this.volumen = ((v[0]/100)*(v[2]))-80;}
		else if(name.equals("Assets/Musica/gameTheme.wav")) {this.rutaArchivo = name; this.volumen = ((v[0]/100)*(v[3]))-80;}
	}
	
	static void leer(){//Leer el archivo de volúmen
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("Ficheros/volumen.txt"));
			
			for(int i = 0; i < 4; i++) { v[i] = Float.parseFloat(br.readLine()); }
			
			br.close();
			
		} catch (IOException e) {}
	}

    @Override
    public void run() {
    	
        try {
            // Cargar el archivo de audio
        	try {
    			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(rutaArchivo).getAbsoluteFile());
    			clip = AudioSystem.getClip();
    			clip.open(ais);
    			fc =  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    			
//    			if(!mute) {
    				fc.setValue(this.volumen);
//    				}
//    			else if (mute) {fc.setValue(-80);}
    		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {}

            // Reproducir el audio
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public void setVolumen(float volumen) { fc.setValue(volumen); }


	public void close() {
		
        // Cerrar el clip
        try { clip.close(); } catch (Exception e) { e.printStackTrace(); }
	}	
}
// .start(); para reproducir el clip
// .close(); para parar el clip