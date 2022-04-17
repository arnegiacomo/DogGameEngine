package no.arnemunthekaas.gameproject.entities.statics;

import no.arnemunthekaas.gameproject.Handler;
import no.arnemunthekaas.gameproject.entities.Entity;

public abstract class StaticEntity extends Entity{
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
