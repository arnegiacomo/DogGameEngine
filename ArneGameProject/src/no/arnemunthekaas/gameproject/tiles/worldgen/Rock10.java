package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class Rock10 extends Tile {
	
	public Rock10(int id) {
		super(Assets.rock, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
