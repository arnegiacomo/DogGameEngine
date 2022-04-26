package no.arnemunthekaas.gameproject.entities.statics;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.items.Item;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(float x, float y) {
		super(x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		//Hit box
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		Game.instance.level.getItemManager().addItem(Item.logItem.createNew((int) x,(int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pine1, (int) (x - Game.instance.gameCamera.getxOffset()), 
				(int) (y - Game.instance.gameCamera.getyOffset()), width, height, null);
		
		//temp hitbox display
//		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//		 		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//		 bounds.width, bounds.height);
	}
	
	@Override
	public boolean hasCollision() {
		return true;
	}

}
