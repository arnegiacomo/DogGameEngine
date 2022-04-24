package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Beach3 extends Tile {
	
	public Beach3(int id) {
		super(Assets.beach, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
