package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffWestTile extends Tile{
	public CliffWestTile(int id) {
		super(Assets.cliffWest, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
