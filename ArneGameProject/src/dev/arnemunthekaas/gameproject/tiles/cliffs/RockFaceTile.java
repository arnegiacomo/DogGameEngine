package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class RockFaceTile extends Tile {

	public RockFaceTile(int id) {
		super(Assets.rockFace, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
