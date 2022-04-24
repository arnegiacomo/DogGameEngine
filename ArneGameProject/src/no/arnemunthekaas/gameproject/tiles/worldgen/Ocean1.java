package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Ocean1 extends Tile {
	
	public Ocean1(int id) {
		super(Assets.ocean, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
