package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthEastTileAlt extends Tile{

	public CliffNorthEastTileAlt(int id) {
		super(Assets.cliffNorthEastAlt, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}