package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class LightRock9 extends Tile {
	
	public LightRock9(int id) {
		super(Assets.lightRock, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
