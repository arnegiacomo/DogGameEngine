package no.arnemunthekaas.gameproject.entities.creatures;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.gfx.Assets;

public class SlimeEnemy extends Creature{
	
	private int slimeHealth = 10;
	private int slimeDamage = 1;
	private int agressionDistance = 300;
	private int slimeMovementSpeed = 1;
	private int knockBack = 50;
	private int attackReach = 50;

	public SlimeEnemy(float x, float y, int width, int height) {
		super(x, y, width, height);
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
		
//		g.drawImage(Assets.slime, (int) (x - Game.instance.gameCamera.getxOffset()), 
//				(int) (y - Game.instance.gameCamera.getyOffset()), width, height, null);
//		
		//temp hitbox display
//		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//		 		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//		 bounds.width, bounds.height);
		
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
		if (Game.instance.level.getEntityManager().hasAggression(this, agressionDistance)) {
			if((Game.instance.level.getEntityManager().getXDistance(Game.instance.level.getEntityManager().getPlayer(), this) < 0)) {
				xMove = -slimeMovementSpeed;
			} else {
				xMove = slimeMovementSpeed;
			}
			
			if((Game.instance.level.getEntityManager().getYDistance(Game.instance.level.getEntityManager().getPlayer(), this) < 0)) {
				yMove = -slimeMovementSpeed;
			} else {
				yMove = slimeMovementSpeed;
			}
		}	
	}
	
	public void checkAttacks() {
		//Add cooldown
		if (Game.instance.level.getEntityManager().getDistance(this, Game.instance.level.getEntityManager().getPlayer()) <= attackReach &&
				Game.instance.level.getEntityManager().getDistance(this, Game.instance.level.getEntityManager().getPlayer()) >= -attackReach) {
			Game.instance.level.getEntityManager().getPlayer().hurt(slimeDamage);

			
			//Knockback stuff
		}
	}

}
