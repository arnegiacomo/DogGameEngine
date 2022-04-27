package no.arnemunthekaas.gameproject.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.gfx.Assets;

public class Item {
	
	// Handler
	
	public static Item[] items = new Item[256]; //all items in game
	// public static Item logItem = new Item(Assets.log, "Log", 0); //texture, name, id
	
	// Class

	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		items[id] = this;
	}
	
	public void tick() {
		if(Game.instance.level.getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds) ) {
			pickedUp = true;
			Game.instance.level.getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g) {
		render(g, (int) (x - Game.instance.gameCamera.getxOffset()), (int) (y - Game.instance.gameCamera.getyOffset()));
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
		
	}
	
	public Item createNew(int count) {
		//TESTING ONLY
		Item i = new Item(texture, name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	//GETTERS SETTERS

	public boolean isPickedUp() {
		return pickedUp;
	}


	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	
	
	
}
