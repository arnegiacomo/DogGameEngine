package dev.arnemunthekaas.gameproject.tiles.cliffs;


import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthWestTileAlt extends Tile{

	public CliffNorthWestTileAlt(int id) {
		super(Assets.cliffNorthWestAlt, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}


}
