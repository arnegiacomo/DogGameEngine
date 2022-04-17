package no.arnemunthekaas.gameproject.tiles.cliffs;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class RockFaceTile extends Tile {

	public RockFaceTile(int id) {
		super(Assets.rockFace, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
