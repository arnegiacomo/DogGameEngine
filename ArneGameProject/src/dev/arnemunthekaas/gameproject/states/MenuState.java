package dev.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import dev.arnemunthekaas.gameproject.Game;
import dev.arnemunthekaas.gameproject.Handler;
import dev.arnemunthekaas.gameproject.audio.AudioAssets;
import dev.arnemunthekaas.gameproject.gfx.Assets;
import dev.arnemunthekaas.gameproject.ui.ClickListener;
import dev.arnemunthekaas.gameproject.ui.UIImageButton;
import dev.arnemunthekaas.gameproject.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.button_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
				//TEMPs
				AudioAssets.piano2.playSound();
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
