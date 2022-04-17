package no.arnemunthekaas.gameproject;

import no.arnemunthekaas.gameproject.gfx.GameCamera;
import no.arnemunthekaas.gameproject.input.KeyManager;
import no.arnemunthekaas.gameproject.input.MouseManager;
import no.arnemunthekaas.gameproject.levels.Level;

public class Handler {
	
	private Game game;
	private Level level;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
