package no.arnemunthekaas.gameproject.audio;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	
	private final float SFXVOLUME = -0.0f;
	private static final float MUSICVOLUME = -0.0f;
	public static Clip currentSong;

	// private final float BALANCE = 0.0f;
	
	protected String path;
	
	public Audio(String path) {
		this.path = path;
	}

	public void playSound() {
		
		try {
			
			File soundFile = new File(path);
			
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			FloatControl volumeControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volumeControl.setValue(SFXVOLUME);
				
			//FloatControl balanceControl = 
			//		    (FloatControl) clip.getControl(FloatControl.Type.BALANCE);
			//		balanceControl.setValue(BALANCE);
					
			clip.start(); 

			 
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*
	 * public void playSound(float balance) { try {
	 * 
	 * File soundFile = new File(path);
	 * 
	 * AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
	 * Clip clip = AudioSystem.getClip(); clip.open(audioInput); FloatControl
	 * volumeControl = (FloatControl)
	 * clip.getControl(FloatControl.Type.MASTER_GAIN);
	 * volumeControl.setValue(SFXVOLUME);
	 * 
	 * FloatControl balanceControl = (FloatControl)
	 * clip.getControl(FloatControl.Type.BALANCE); balanceControl.setValue(balance);
	 * 
	 * clip.start();
	 * 
	 * 
	 * } catch (Exception e){ e.printStackTrace(); } }
	 */
	
	public float getSFXVOLUME() {
		return SFXVOLUME;
	}
	
	public static float getMUSICVOLUME() {
		return MUSICVOLUME;
	}
	
	public static Clip getCurrentSong() {
		return currentSong;
		
	}

	public static void stopCurrentMusic() {
		if (currentSong == null)
			return;
		currentSong.stop();
		currentSong = null;
	}

	
	
	
	
	
	

}
