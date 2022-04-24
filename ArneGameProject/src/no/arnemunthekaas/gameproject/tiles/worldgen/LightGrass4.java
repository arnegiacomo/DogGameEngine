package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class LightGrass4 extends Tile {
	
	public LightGrass4(int id) {
		super(Assets.lightGrass, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
