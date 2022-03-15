package dev.arnemunthekaas.gameproject.entities.statics;

import java.awt.Graphics;

import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.items.Item;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class TallGrass extends StaticEntity{

	public TallGrass(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT/2);
		
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
		g.drawImage(Assets.tallGrass, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//Temp hitbox display
		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		 		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
		 bounds.width, bounds.height);
		
		
	}
	
	@Override
	public boolean hasCollision() {
		return false;
	}
	
	

}
