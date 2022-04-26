package no.arnemunthekaas.gameproject.entities.statics;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class TallGrass extends StaticEntity{

	public TallGrass(float x, float y) {
		super(x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT/2);
		
		//Hit box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
		
		this.setHealth(1);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tallGrass, (int) (x - Game.instance.gameCamera.getxOffset()), 
				(int) (y - Game.instance.gameCamera.getyOffset()), width, height, null);
		
		//Temp hitbox display
//		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//		 		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//		 bounds.width, bounds.height);
		
		
	}
	
	@Override
	public boolean hasCollision() {
		return false;
	}
	
	

}
