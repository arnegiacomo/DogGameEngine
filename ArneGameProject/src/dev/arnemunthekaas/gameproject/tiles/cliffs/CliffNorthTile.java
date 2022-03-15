package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthTile extends Tile {

	public CliffNorthTile(int id) {
		super(Assets.cliffNorth, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
