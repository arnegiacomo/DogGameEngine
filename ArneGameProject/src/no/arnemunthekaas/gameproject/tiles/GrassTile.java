package no.arnemunthekaas.gameproject.tiles;

import no.arnemunthekaas.gameproject.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.grass, id);

	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
