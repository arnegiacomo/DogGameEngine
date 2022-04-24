package no.arnemunthekaas.gameproject.levels;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import no.arnemunthekaas.gameproject.Handler;
import no.arnemunthekaas.gameproject.entities.EntityManager;
import no.arnemunthekaas.gameproject.entities.creatures.Player;
import no.arnemunthekaas.gameproject.items.ItemManager;
import no.arnemunthekaas.gameproject.tiles.Tile;
import no.arnemunthekaas.gameproject.utils.Utils;


public class Level {
	
	private Handler handler;
	private int width = 100, height = 100;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	//Items
	private ItemManager itemManager;
	
	public Level(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		
		//Temp entities
//		entityManager.addEntity(new Tree(handler, 100, 250));
//		entityManager.addEntity(new Tree(handler, 250, 250));
//		entityManager.addEntity(new Tree(handler, 250, 800));
//		entityManager.addEntity(new TallGrass(handler, 550, 550));
//		entityManager.addEntity(new TallGrass(handler, 600, 550));
//		entityManager.addEntity(new TallGrass(handler, 650, 550));
//		entityManager.addEntity(new TallGrass(handler, 550, 600));
//		entityManager.addEntity(new TallGrass(handler, 600, 600));
//		entityManager.addEntity(new TallGrass(handler, 650, 600));
//		entityManager.addEntity(new SlimeEnemy(handler, 400, 800, Tile.TILEWIDTH, Tile.TILEHEIGHT));		
		
		//loadLevel(path);
		generate();
		
		entityManager.getPlayer().setX(spawnX*width);
		entityManager.getPlayer().setY(spawnY*height);
	}

	/**
	 * Inspired by https://www.youtube.com/watch?v=20KHNA9jTsE&ab_channel=DVGen
	 */
	private void generate() {
		// Init size
		tiles = new int[width][height];
		
		Random random = new Random();
		
		// Prepopulate
		for (int[] row: tiles)
		    Arrays.fill(row, 5);
		
		// Test
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				tiles[x][y] = random.nextInt(10 - 0 + 1) + 0;
			}
		}
		
		
	}

	public void tick() {
		entityManager.tick();
		itemManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}	
		
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.DefaultGrass5;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.DefaultGrass5;
		}
		
		return t;
	}
	
	private void loadLevel(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	//GETTERS SETTERS
	
	
	public int getWidth() {
		return width;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
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
