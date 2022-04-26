package no.arnemunthekaas.gameproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import no.arnemunthekaas.gameproject.display.Display;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.gfx.GameCamera;
import no.arnemunthekaas.gameproject.gfx.Text;
import no.arnemunthekaas.gameproject.input.KeyManager;
import no.arnemunthekaas.gameproject.input.MouseManager;
import no.arnemunthekaas.gameproject.levels.Level;
import no.arnemunthekaas.gameproject.states.GameState;
import no.arnemunthekaas.gameproject.states.MenuState;
import no.arnemunthekaas.gameproject.states.SettingsState;
import no.arnemunthekaas.gameproject.states.State;

public class Game implements Runnable {
	
	public static Game instance;
	
	private String str;
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	
	//Input
	public KeyManager keyManager;
	public MouseManager mouseManager;
	
	//Camera
	public GameCamera gameCamera;
	
	//Level
	public Level level;

	
	public Game(String title, int width, int height) {
		instance = this;
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		gameCamera = new GameCamera(0, 0);

		gameState = new GameState();
		menuState = new MenuState();
		settingsState = new SettingsState();
		State.setState(menuState);
		
	}
	

	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//temp
		
		if(str!=null)
		Text.drawString(g, str, 20, 20, true, Color.black, Assets.font28);
		// End of temp
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60; //Tick + Render update frequency
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta --;
			}
			
			if (timer >= 1000000000) {
				// System.out.println("Ticks and Frames: " + ticks);
				
				//Temp testing
				// str = Integer.toString(ticks);
				
				
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Game getGame() {
		return this;
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
