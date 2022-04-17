package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffWestTile extends Tile{
	public CliffWestTile(int id) {
		super(Assets.cliffWest, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
