package no.arnemunthekaas.gameproject.levels.worldgen;

import java.util.Arrays;
import java.util.Random;

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

		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				nodes[x][y].genTile();
				tiles[x][y] = nodes[x][y].tile;
			}
		}

	}

}
