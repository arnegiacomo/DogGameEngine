package dev.arnemunthekaas.gameproject.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import dev.arnemunthekaas.gameproject.Game;
import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.audio.AudioAssets;
import dev.arnemunthekaas.gameproject.audio.Audio;
import dev.arnemunthekaas.gameproject.entities.Entity;
import dev.arnemunthekaas.gameproject.gfx.Animation;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.gfx.GameCamera;
import dev.arnemunthekaas.gameproject.inventory.Inventory;
import dev.arnemunthekaas.gameproject.states.GameState;
import dev.arnemunthekaas.gameproject.states.MenuState;
import dev.arnemunthekaas.gameproject.states.SettingsState;
import dev.arnemunthekaas.gameproject.states.State;

public class Player extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	private Animation animStill;
	
	//Animation speed
	
	private int animSpeed = 175;
	
	//Player attack
	
	private int playerDamage = 1;
	private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;
	private Rectangle attackHitbox;
	
	//Inventory
	private Inventory inventory;
	
	//Movement
	private int movementSpeed; //unused
	
	//Health
	private int health = 3;
	
	private String facingDirection = "South";
	
	//Game States
		public State gameState;
		public State menuState;
		public State settingsState;
	
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Declares Hitbox
		bounds.x = 10;
		bounds.y = 10;
		bounds.width =	40;
		bounds.height = 40;
		
		//Animations
		animDown = new Animation(animSpeed, Assets.player_down);
		animUp = new Animation(animSpeed, Assets.player_up);
		animLeft = new Animation(animSpeed, Assets.player_left);
		animRight = new Animation(animSpeed, Assets.player_right);
		animStill = new Animation(animSpeed, Assets.player_still);
		
		//Inventory
		inventory = new Inventory(handler);
		
		//Health
		setHealth(health);
	}

	@Override
	public void tick() {
		
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animStill.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Check facing direction before attacks
		
		
		//Attack
		checkAttacks();
		
		
		//Inventory
		inventory.tick();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer  = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = cb.width;
		ar.width = arSize;
		ar.height = arSize;
		
		if(!handler.getKeyManager().melee) {
			attackHitbox = null;
			return;
		}
		if(facingDirection.equals("North")){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(facingDirection.equals("South")){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(facingDirection.equals("West")){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(facingDirection.equals("East")){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(facingDirection.equals("NorthWest")){
			ar.x = (cb.x + cb.width / 2 - arSize / 2) - cb.width;
			ar.y = cb.y - arSize;
		}else if(facingDirection.equals("NorthEast")){
			ar.x = (cb.x + cb.width / 2 - arSize / 2) + cb.width;
			ar.y = cb.y - arSize;
		}else if(facingDirection.equals("SouthWest")){
			ar.x = (cb.x + cb.width / 2 - arSize / 2) - cb.width;
			ar.y = cb.y + cb.height;
		}else if(facingDirection.equals("SouthEast")){
			ar.x = (cb.x + cb.width / 2 - arSize / 2) + cb.width;
			ar.y = cb.y + cb.height;
		}else{ 
			return;
		}
		
		attackHitbox = ar;
	
		
		
		attackTimer = 0;
		AudioAssets.bark.playSound();
		
		for (Entity e : handler.getLevel().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(playerDamage);
				return;
			}
		}
		
		
	}
	
	@Override
	public void die() {
		handler.getGame().gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
		
		setFacingDirection(xMove, yMove); //put this another place?
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// Display Hitbox
		
		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		  		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
		bounds.width, bounds.height);
		
		//Display Attack Hitbox
		if(!(attackHitbox == null)) {
			g.drawRect((int) (attackHitbox.x - handler.getGameCamera().getxOffset()), (int) (attackHitbox.y - handler.getGameCamera().getyOffset()), 
					attackHitbox.width, attackHitbox.height);
			
		}
		
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
		
		if(!(attackHitbox == null))
		g.drawImage(Assets.biteAttack, (int) (attackHitbox.x - handler.getGameCamera().getxOffset()), (int) (attackHitbox.y - handler.getGameCamera().getyOffset()), 
				attackHitbox.width, attackHitbox.height, null); //attack anim
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return animStill.getCurrentFrame();
		} 
	}
	
	@Override
	public boolean hasCollision() {
		return true;
	}
	
	private void setFacingDirection(float xMove, float yMove) {
		if (xMove == 0 && yMove == 0)
			return;
		
		String str = "";
		if (yMove < 0) 
			str += "North";
		if (yMove > 0) 
			str += "South";
		if (xMove < 0) 
			str += "West";
		if (xMove > 0) 
			str += "East";
		facingDirection = str;
	}
	
	
	
	//GETTERS SETTERS
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	

}