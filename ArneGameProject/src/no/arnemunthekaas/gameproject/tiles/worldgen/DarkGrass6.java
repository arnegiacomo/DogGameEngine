package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class DarkGrass6 extends Tile {
	
	public DarkGrass6(int id) {
		super(Assets.darkGrass, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
