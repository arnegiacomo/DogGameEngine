package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class DarkerGrass7 extends Tile {
	
	public DarkerGrass7(int id) {
		super(Assets.darkerGrass, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
