package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthEastTile extends Tile {

	public CliffNorthEastTile(int id) {
		super(Assets.cliffNorthEast, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
