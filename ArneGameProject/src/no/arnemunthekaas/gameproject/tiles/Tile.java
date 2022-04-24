package no.arnemunthekaas.gameproject.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import no.arnemunthekaas.gameproject.tiles.worldgen.*;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[11];
	public static Tile DeepOcean0 = new DeepOcean0(0);
	public static Tile Ocean1 = new Ocean1(1);
	public static Tile Coast2 = new Coast2(2);
	public static Tile Beach3 = new Beach3(3);
	public static Tile LightGrass4 = new LightGrass4(4);
	public static Tile DefaultGrass5 = new DefaultGrass5(5);
	public static Tile DarkGrass6 = new DarkGrass6(6);
	public static Tile DarkerGrass7 = new DarkerGrass7(7);
	public static Tile DarkestGrass8 = new DarkestGrass8(8);
	public static Tile LightRock9 = new LightRock9(9);
	public static Tile Rock10 = new Rock10(10);
	
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
