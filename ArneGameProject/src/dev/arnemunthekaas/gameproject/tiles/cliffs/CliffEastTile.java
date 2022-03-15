package dev.arnemunthekaas.gameproject.tiles.cliffs;

import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.tiles.Tile;

public class CliffEastTile extends Tile {

	public CliffEastTile(int id) {
		super(Assets.cliffEast, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
