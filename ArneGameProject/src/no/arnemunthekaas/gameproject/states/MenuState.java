package no.arnemunthekaas.gameproject.states;

import java.awt.Graphics;

import no.arnemunthekaas.gameproject.Handler;
import no.arnemunthekaas.gameproject.Launcher;
import no.arnemunthekaas.gameproject.audio.AudioAssets;
import no.arnemunthekaas.gameproject.gfx.Assets;
import no.arnemunthekaas.gameproject.ui.ClickListener;
import no.arnemunthekaas.gameproject.ui.UIImageButton;
import no.arnemunthekaas.gameproject.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(Launcher.WINDOW_WIDTH / 2 - Assets.STARTBUTTONWIDTH, Launcher.WINDOW_HEIGHT / 2 - Assets.STARTBUTTONHEIGHT
				, Assets.STARTBUTTONWIDTH * 2, Assets.STARTBUTTONHEIGHT * 2, Assets.button_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
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
