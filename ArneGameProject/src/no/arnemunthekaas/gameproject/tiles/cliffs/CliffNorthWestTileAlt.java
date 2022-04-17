package no.arnemunthekaas.gameproject.tiles.cliffs;


import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffNorthWestTileAlt extends Tile{

	public CliffNorthWestTileAlt(int id) {
		super(Assets.cliffNorthWestAlt, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}


}
