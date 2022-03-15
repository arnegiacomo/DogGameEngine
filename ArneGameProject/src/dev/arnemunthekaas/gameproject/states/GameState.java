package dev.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import dev.arnemunthekaas.gameproject.Game;
import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.entities.creatures.Player;
import dev.arnemunthekaas.gameproject.entities.statics.Tree;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.levels.Level;
import dev.arnemunthekaas.gameproject.tiles.Tile;

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
