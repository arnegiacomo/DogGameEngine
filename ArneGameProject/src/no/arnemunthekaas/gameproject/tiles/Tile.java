package no.arnemunthekaas.gameproject.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import no.arnemunthekaas.gameproject.tiles.cliffs.CliffEastTile;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffNorthEastTile;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffNorthEastTileAlt;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffNorthTile;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffNorthWestTile;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffNorthWestTileAlt;
import no.arnemunthekaas.gameproject.tiles.cliffs.CliffWestTile;
import no.arnemunthekaas.gameproject.tiles.cliffs.RockFaceTile;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new RockFaceTile(1);
	public static Tile cliffNorth = new CliffNorthTile(2);
	public static Tile cliffWest = new CliffWestTile(3);
	public static Tile cliffNorthWest = new CliffNorthWestTile(4);
	public static Tile cliffNorthWestAlt = new CliffNorthWestTileAlt(5);
	public static Tile cliffNorthEastAlt = new CliffNorthEastTileAlt(6);
	public static Tile cliffNorthEast = new CliffNorthEastTile(7);
	public static Tile cliffEast = new CliffEastTile(8);
	
	//CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

}
