import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {

	// Creamos los atributos de Musica
	private float volumen=0;
	FloatControl fc;
	private Clip clip;
	private boolean mute;
	
	// Creamos el objeto Musica
	Musica(String l, float v){
		this.volumen=v;
		this.mute=false;
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(l).getAbsoluteFile());
			this.clip = AudioSystem.getClip();
			this.clip.open(ais);
			fc =  (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			if(!mute) {fc.setValue(this.volumen);}
			else if (mute) {fc.setValue(-80);}
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {}
		
	}
	
	// Reproducimos la Musica
	public void play() {this.clip.loop(Clip.LOOP_CONTINUOUSLY);}
	
	// Paramos la Musica
	public void stop() {this.clip.stop();}

	// Obtenemos y cambiamos el atributo de Musica
	public Clip getClip() {return clip;}
	public void setClip(Clip clip) {this.clip = clip;}
	public void setMute(boolean mute) {this.mute = mute;}
	public void setVolumen(float volumen) {this.volumen = volumen;}
	
}