package no.arnemunthekaas.gameproject.levels.worldgen;

import java.util.Arrays;
import java.util.Random;

import no.arnemunthekaas.gameproject.entities.EntityManager;
import no.arnemunthekaas.gameproject.entities.statics.*;
import no.arnemunthekaas.gameproject.levels.Level;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class WorldGenerator {

	public int spawnX;
	public int spawnY;

	public int[][] tiles;

	public int tileAmount;

	private WorldGenNode[][] nodes;

	public WorldGenerator(int width, int height, int tileAmount) {

		this.tileAmount = tileAmount;

		tiles = new int[width][height];
		for (int[] row : tiles)
			Arrays.fill(row, -1);

		nodes = new WorldGenNode[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				nodes[x][y] = new WorldGenNode(Tile.tiles.length, x, y);
			}
		}

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				if (x > 0) {
					nodes[x][y].neighbors.add(nodes[x - 1][y]);

					if (y > 0) {
						nodes[x][y].neighbors.add(nodes[x - 1][y - 1]);
					}

					if (y < height - 1) {
						nodes[x][y].neighbors.add(nodes[x - 1][y + 1]);
					}
				}

				if (y > 0) {
					nodes[x][y].neighbors.add(nodes[x][y - 1]);
				}

				if (y < height - 1) {
					nodes[x][y].neighbors.add(nodes[x][y + 1]);
				}

				if (x < width - 1) {
					nodes[x][y].neighbors.add(nodes[x + 1][y]);

					if (y > 0) {
						nodes[x][y].neighbors.add(nodes[x + 1][y - 1]);
					}

					if (y < height - 1) {
						nodes[x][y].neighbors.add(nodes[x + 1][y + 1]);
					}
				}

			}
		}

	}

	public void start() {
		Random random = new Random();
		spawnX = random.nextInt(tiles.length);
		spawnY = random.nextInt(tiles[0].length);

		nodes[spawnX][spawnY].tile = 5;
		nodes[spawnX][spawnY].propagate();
		EntityManager.instance.getPlayer().setX(spawnX * Tile.TILEWIDTH);
		EntityManager.instance.getPlayer().setY(spawnY * Tile.TILEHEIGHT);

		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				tiles[x][y] = nodes[x][y].tile;
				
				int randomnum = random.nextInt(11);
				
				if ((tiles[x][y] == Tile.DefaultGrass5.getId() || tiles[x][y] == Tile.DarkGrass6.getId()) && randomnum <= Grass.frequency)
					Level.instance.entityManager.addEntity(new Grass(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if (tiles[x][y] == Tile.Beach3.getId() && randomnum <= Gravel.frequency)
					Level.instance.entityManager.addEntity(new Gravel(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if (tiles[x][y] == Tile.Coast2.getId() && randomnum <= Algae.frequency)
					Level.instance.entityManager.addEntity(new Algae(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if (tiles[x][y] == Tile.LightGrass4.getId() && randomnum <= Blueflowers.frequency)
					Level.instance.entityManager.addEntity(new Blueflowers(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if ((tiles[x][y] == Tile.DeepOcean0.getId() || tiles[x][y] == Tile.Ocean1.getId()) && randomnum <= Waves.frequency)
					Level.instance.entityManager.addEntity(new Waves(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if (tiles[x][y] == Tile.DarkerGrass7.getId() && randomnum <= Redflowers.frequency)
					Level.instance.entityManager.addEntity(new Redflowers(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if (tiles[x][y] == Tile.DarkestGrass8.getId() && randomnum <= Mud.frequency)
					Level.instance.entityManager.addEntity(new Mud(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
				
				if ((tiles[x][y] == Tile.LightRock9.getId() || tiles[x][y] == Tile.Rock10.getId()) && randomnum <= Moss.frequency)
					Level.instance.entityManager.addEntity(new Moss(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
			}
		}

	}

}
