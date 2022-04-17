package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class CliffEastTile extends Tile {

	public CliffEastTile(int id) {
		super(Assets.cliffEast, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
