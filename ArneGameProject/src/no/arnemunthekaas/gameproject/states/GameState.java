package no.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.levels.Level;

public class GameState extends State {
	
	private Level level;
	
	public GameState() {
		super();
		
		level = new Level("res/levels/level1.txt");
		Game.instance.level = level;
		
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
