package no.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Game;
import no.arnemunthekaas.gameproject.Launcher;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.ui.ClickListener;
import no.arnemunthekaas.gameproject.ui.UIImageButton;
import no.arnemunthekaas.gameproject.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState() {
		super();
		uiManager = new UIManager();
		Game.instance.mouseManager.setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(Launcher.WINDOW_WIDTH / 2 - Assets.STARTBUTTONWIDTH, Launcher.WINDOW_HEIGHT / 2 - Assets.STARTBUTTONHEIGHT
				, Assets.STARTBUTTONWIDTH * 2, Assets.STARTBUTTONHEIGHT * 2, Assets.button_start, new ClickListener() {

			@Override
			public void onClick() {
				Game.instance.mouseManager.setUIManager(null);
				State.setState(Game.instance.gameState);
				
				//TODO Clicksound
				// AudioAssets.piano2.playSound();
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
