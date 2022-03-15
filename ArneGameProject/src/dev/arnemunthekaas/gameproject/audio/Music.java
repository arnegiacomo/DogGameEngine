package dev.arnemunthekaas.gameproject.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music extends Audio{
	
	

	public Music(String path) {
		super(path);
	}
	
	
	@Override
	public void playSound() {
		//loops music, use stopSong() to stop current song
			try {
				
				File soundFile = new File(path);
				
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				FloatControl volumeControl = 
					    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					volumeControl.setValue(getMUSICVOLUME());
				stopCurrentMusic();
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
				currentSong = clip;

				 
			} catch (Exception e){
				e.printStackTrace();
		}
	}

}
