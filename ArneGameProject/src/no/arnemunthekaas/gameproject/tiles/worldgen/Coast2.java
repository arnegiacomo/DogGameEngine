package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Coast2 extends Tile{
	
	public Coast2(int id) {
		super(Assets.coast, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
