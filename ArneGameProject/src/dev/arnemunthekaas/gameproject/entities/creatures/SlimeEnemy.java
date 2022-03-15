package dev.arnemunthekaas.gameproject.entities.creatures;

import java.awt.Graphics;

import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.items.Item;

public class SlimeEnemy extends Creature{
	
	private int slimeHealth = 10;
	private int slimeDamage = 1;
	private int agressionDistance = 300;
	private int slimeMovementSpeed = 1;
	private int knockBack = 50;
	private int attackReach = 50;

	public SlimeEnemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.setHealth(slimeHealth);
		
		//Hit box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
	}

	@Override
	public void tick() {
		movementAI();
		move();
		checkAttacks();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.slime, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//temp hitbox display
		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		 		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
		 bounds.width, bounds.height);
		
	}

	@Override
	public void die() {
	
		
	}
	
	@Override
	public boolean hasCollision() {
		return true;
	}
	
	
	public void movementAI() {
		xMove = 0;
		yMove = 0;
		if (handler.getLevel().getEntityManager().hasAggression(this, agressionDistance)) {
			if((handler.getLevel().getEntityManager().getXDistance(handler.getLevel().getEntityManager().getPlayer(), this) < 0)) {
				xMove = -slimeMovementSpeed;
			} else {
				xMove = slimeMovementSpeed;
			}
			
			if((handler.getLevel().getEntityManager().getYDistance(handler.getLevel().getEntityManager().getPlayer(), this) < 0)) {
				yMove = -slimeMovementSpeed;
			} else {
				yMove = slimeMovementSpeed;
			}
		}	
	}
	
	public void checkAttacks() {
		//Add cooldown
		if (handler.getLevel().getEntityManager().getDistance(this, handler.getLevel().getEntityManager().getPlayer()) <= attackReach &&
				handler.getLevel().getEntityManager().getDistance(this, handler.getLevel().getEntityManager().getPlayer()) >= -attackReach) {
			handler.getLevel().getEntityManager().getPlayer().hurt(slimeDamage);

			
			//Knockback stuff
		}
	}

}
