package no.arnemunthekaas.gameproject.gfx;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.entities.Entity;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class GameCamera {
	
	public static GameCamera instance;
	private float xOffset, yOffset;
	
	public GameCamera(float xOffset, float yOffset) {
		instance = this;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		} else if(xOffset > Game.instance.level.getWidth() * Tile.TILEWIDTH - Game.instance.getWidth()) {
			xOffset = Game.instance.level.getWidth() * Tile.TILEWIDTH - Game.instance.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		} else if(yOffset > Game.instance.level.getHeight() * Tile.TILEHEIGHT - Game.instance.getHeight()) {
			yOffset = Game.instance.level.getHeight() * Tile.TILEHEIGHT - Game.instance.getHeight();
		}
		
		
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - Game.instance.getWidth() / 2 + e.getWidth() / 22;
		yOffset = e.getY() - Game.instance.getHeight() / 2 + e.getHeight() / 2; 
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	
	
	// GETTERS SETTERS
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
