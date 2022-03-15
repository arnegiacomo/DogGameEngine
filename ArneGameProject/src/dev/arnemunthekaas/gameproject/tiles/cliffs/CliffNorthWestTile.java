package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthWestTile extends Tile{

	public CliffNorthWestTile(int id) {
		super(Assets.cliffNorthWest, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}


}
