package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthEastTileAlt extends Tile{

	public CliffNorthEastTileAlt(int id) {
		super(Assets.cliffNorthEastAlt, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}