package no.arnemunthekaas.gameproject.entities.statics;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Waves extends StaticEntity {
	
	public static int frequency = 5;

	public Waves(float x, float y) {
		super(x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		this.zIndex = -100;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.waves, (int) (x - Game.instance.gameCamera.getxOffset()), 
				(int) (y - Game.instance.gameCamera.getyOffset()), width, height, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasCollision() {
		// TODO Auto-generated method stub
		return false;
	}

}
