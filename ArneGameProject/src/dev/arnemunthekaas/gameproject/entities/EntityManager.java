package dev.arnemunthekaas.gameproject.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.entities.creatures.Player;
import dev.arnemunthekaas.gameproject.gfx.Assets;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) 
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		player.postRender(g);
	}
	
	public void addEntity (Entity e) {
		entities.add(e);
	}
	
	public void removeEntity (Entity e) {
		entities.remove(e);
	}
	
	public double getDistance (Entity a, Entity b) {
		//Only returns absolute distance
		float xDistance = a.getX() + a.getWidth()/2 - b.getX() - b.getWidth()/2;
		float yDistance = a.getY() + a.getHeight()/2 - b.getY() - b.getHeight()/2;
		
		double distance = Math.sqrt(((xDistance*xDistance) + (yDistance*yDistance)));
		
		return distance;
		
	}
	
	public double getXDistance (Entity a, Entity b) {
		float Distance = a.getX() + a.getWidth()/2 - b.getX() - b.getWidth()/2;
		return Distance;
	}
	
	public double getYDistance (Entity a, Entity b) {
		float Distance = a.getY() + a.getHeight()/2 - b.getY() - b.getHeight()/2;
		return Distance;
	}
	
	public boolean hasAggression(Entity e, int aggressionDistance) {
		if (getDistance(handler.getLevel().getEntityManager().getPlayer(), e) < aggressionDistance) 
			return true;
		return false;
		
	}
	
	public void knockBack (Entity a, int knockBackX, int knockBackY) {
		a.setX(a.getX()+knockBackX);
		a.setY(a.getY()+knockBackY);
	}

	
	//GETTERS SETTERS
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
}

