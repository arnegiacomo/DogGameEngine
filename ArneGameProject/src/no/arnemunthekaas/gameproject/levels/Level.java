package no.arnemunthekaas.gameproject.levels;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.entities.EntityManager;
import no.arnemunthekaas.gameproject.entities.creatures.Player;
import no.arnemunthekaas.gameproject.entities.statics.Gravel;
import no.arnemunthekaas.gameproject.input.KeyManager;
import no.arnemunthekaas.gameproject.items.ItemManager;
import no.arnemunthekaas.gameproject.levels.worldgen.WorldGenerator;
import no.arnemunthekaas.gameproject.tiles.Tile;
import no.arnemunthekaas.gameproject.utils.Utils;

public class Level {
	
	public static Level instance;

	public int width = 50, height = 50;
	private int spawnX, spawnY;
	private int[][] tiles = new int[height][width];

	// Entities
	public EntityManager entityManager;
	// Items
	public ItemManager itemManager;

	public Level(String path) {
		instance = this;
		
		entityManager = new EntityManager(new Player(100, 100));
		itemManager = new ItemManager();
		
		generate();

		entityManager.getPlayer().setX(spawnX * Tile.TILEWIDTH);
		entityManager.getPlayer().setY(spawnY * Tile.TILEHEIGHT);
	}

	/**
	 * Inspired by https://www.youtube.com/watch?v=20KHNA9jTsE&ab_channel=DVGen
	 */
	public void generate() {
		entityManager = new EntityManager(new Player(100, 100));

		WorldGenerator wfc = new WorldGenerator(width, height, Tile.tiles.length);
		wfc.start();
		
		tiles = wfc.tiles;
		spawnX = wfc.spawnX;
		spawnY = wfc.spawnY;
	}
	
	public void tick() {
		if (KeyManager.instance.generateNewMap)
			Level.instance.generate();
		entityManager.tick();
		itemManager.tick();
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, Game.instance.gameCamera.getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(Game.instance.gameCamera.getxOffset() + Game.instance.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, Game.instance.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(Game.instance.gameCamera.getyOffset() + Game.instance.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - Game.instance.gameCamera.getxOffset()),
						(int) (y * Tile.TILEHEIGHT - Game.instance.gameCamera.getyOffset()));
			}
		}

		// Items
		itemManager.render(g);
		// Entities
		entityManager.render(g);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.DefaultGrass5;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.DefaultGrass5;
		}

		return t;
	}

	// GETTERS SETTERS

	public int getWidth() {
		return width;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getHeight() {
		return height;
	}

}
