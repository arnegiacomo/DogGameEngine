package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class DefaultGrass5 extends Tile {
	
	public DefaultGrass5(int id) {
		super(Assets.defaultGrass, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
