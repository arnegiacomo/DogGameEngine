package dev.arnemunthekaas.gameproject.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.audio.AudioAssets;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.gfx.Text;
import dev.arnemunthekaas.gameproject.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		//TEMPORARY
		
		addItem(Item.logItem.createNew(10));
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I))
			active = !active;
		if(!active)
			return;
	}
	
	public void render(Graphics g) {
		if(!active)
			return;
		//TEMP
		g.drawImage(Assets.inventoryScreen, 100, 100, 300, 300, null);
		Text.drawString(g, "Hei", 150, 150, true, Color.black, Assets.font28);
	}
	
	//Inventory methods
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId())
				i.setCount(i.getCount() + item.getCount());
			return;
		}
		inventoryItems.add(item);
	}
	
	//GETTERS SETTERS
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	

}
