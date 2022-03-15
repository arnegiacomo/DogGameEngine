package dev.arnemunthekaas.gameproject.entities.statics;

import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.entities.Entity;

public abstract class StaticEntity extends Entity{
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
