package no.arnemunthekaas.gameproject;

public class Launcher {
	
	public static final int WINDOW_WIDTH = 1920;
	public static final int WINDOW_HEIGHT = 1080;
	
	public static void main(String[] args) {
		Game game = new Game("2D-Game", WINDOW_WIDTH, WINDOW_HEIGHT);
		game.start();
	}
}
