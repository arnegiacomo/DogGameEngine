package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthWestTile extends Tile{

	public CliffNorthWestTile(int id) {
		super(Assets.cliffNorthWest, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}


}
