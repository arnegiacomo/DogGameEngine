package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthEastTile extends Tile {

	public CliffNorthEastTile(int id) {
		super(Assets.cliffNorthEast, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
