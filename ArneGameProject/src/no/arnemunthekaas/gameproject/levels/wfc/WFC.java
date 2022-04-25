package no.arnemunthekaas.gameproject.levels.wfc;

import java.util.Arrays;
import java.util.Random;

import no.arnemunthekaas.gameproject.tiles.Tile;

public class WFC {

	public int spawnX;
	public int spawnY;

	public int[][] tiles;

	public int tileAmount;

	private WFCnode[][] nodes;

	public WFC(int width, int height, int tileAmount) {

		this.tileAmount = tileAmount;

		tiles = new int[width][height];
		for (int[] row : tiles)
			Arrays.fill(row, -1);

		nodes = new WFCnode[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				nodes[x][y] = new WFCnode(Tile.tiles.length, x, y);
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
				tiles[x][y] = nodes[x][y].tile;
			}
		}

	}

}
