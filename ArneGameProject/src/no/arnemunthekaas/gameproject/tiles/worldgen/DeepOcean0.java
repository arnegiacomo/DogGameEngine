package no.arnemunthekaas.gameproject.tiles.worldgen;

import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.tiles.Tile;

public class DeepOcean0 extends Tile {
	
	public DeepOcean0(int id) {
		super(Assets.deepOcean, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
