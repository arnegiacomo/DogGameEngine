package no.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Handler;
import no.arnemunthekaas.gameproject.levels.Level;

public class GameState extends State {
	
	private Level level;
	
	public GameState(Handler handler) {
		super(handler);
		
		level = new Level(handler, "res/levels/level1.txt");
		handler.setLevel(level);
		
	}

	@Override
	public void tick() {
		level.tick();
		
	}

	@Override
	public void render(Graphics g) {
		level.render(g);

	}
	
	

}
