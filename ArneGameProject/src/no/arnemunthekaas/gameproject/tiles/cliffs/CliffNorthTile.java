package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthTile extends Tile {

	public CliffNorthTile(int id) {
		super(Assets.cliffNorth, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
