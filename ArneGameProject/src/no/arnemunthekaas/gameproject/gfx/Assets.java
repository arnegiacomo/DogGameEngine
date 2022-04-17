package no.arnemunthekaas.gameproject.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
		private static final int width = 96, height = 104;
		
		//Terrain sprites
		public static BufferedImage grass, cliffNorth, cliffWest, cliffSouth, cliffEast, cliffNorthWest, 
		rockFace, cliffNorthWestAlt, cliffNorthEastAlt, cliffNorthEast, attack; //All terrain sprites
		
		//Items
		public static BufferedImage log; 
		
		//Static Entities
		public static BufferedImage pine1, pine2, tallGrass;
		//Entities
		
		//Enemies
		public static BufferedImage slime;
		
		//Player Animantions
		public static BufferedImage[] player_down, player_up, player_left, player_right, player_still;
		
		//Attacks
		public static BufferedImage biteAttack;
		
		// UI Elements
		public static BufferedImage[] button_start;
		public static BufferedImage inventoryScreen;
		
		// Font(s)
		public static Font font28;
		
		public static void init() {
			
			// Fonts
			font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
			
			// Sprite sheets
			
			SpriteSheet TerrainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrainSprites.png"));
			SpriteSheet MainMenu = new SpriteSheet(ImageLoader.loadImage("/textures/start.png"));
			SpriteSheet WizardSheet = new SpriteSheet(ImageLoader.loadImage("/textures/redWizardSprites.png"));
			SpriteSheet TeddySheet = new SpriteSheet(ImageLoader.loadImage("/textures/teddySprites.png"));
			SpriteSheet AttacksSheet = new SpriteSheet(ImageLoader.loadImage("/textures/attacksSprites.png"));
			
			// UI
			
			inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
			
			button_start = new BufferedImage[2];
			
			button_start[0] = MainMenu.crop(0, 0, 387, 182);
			button_start[1] = MainMenu.crop(0, 182, 387, 182);
			
			// Player Animations
			
			player_down = new BufferedImage[4];
			
//			player_down[0] = WizardSheet.crop(0, 0, 16, 32);
//			player_down[1] = WizardSheet.crop(0, 32, 16, 32);
//			player_down[2] = WizardSheet.crop(0, 64, 16, 32);
//			player_down[3] = WizardSheet.crop(0, 96, 16, 32);
			
			player_down[0] = TeddySheet.crop(0, 0, 32, 32);
			player_down[1] = TeddySheet.crop(0, 32, 32, 32);
			player_down[2] = TeddySheet.crop(0, 64, 32, 32);
			player_down[3] = TeddySheet.crop(0, 96, 32, 32);
			
			
			player_up = new BufferedImage[4];
			
//			player_up[0] = WizardSheet.crop(48, 0, 16, 32);
//			player_up[1] = WizardSheet.crop(48, 32, 16, 32);
//			player_up[2] = WizardSheet.crop(48, 64, 16, 32);
//			player_up[3] = WizardSheet.crop(48, 96, 16, 32);
			
			player_up[0] = TeddySheet.crop(32, 0, 32, 32);
			player_up[1] = TeddySheet.crop(32, 32, 32, 32);
			player_up[2] = TeddySheet.crop(32, 64, 32, 32);
			player_up[3] = TeddySheet.crop(32, 96, 32, 32);
			
			
			player_left = new BufferedImage[4];
			
//			player_left[0] = WizardSheet.crop(32, 0, 16, 32);
//			player_left[1] = WizardSheet.crop(32, 32, 16, 32);
//			player_left[2] = WizardSheet.crop(32, 64, 16, 32);
//			player_left[3] = WizardSheet.crop(32, 96, 16, 32);
			
			player_left[0] = TeddySheet.crop(0, 0, 32, 32);
			player_left[1] = TeddySheet.crop(0, 32, 32, 32);
			player_left[2] = TeddySheet.crop(0, 64, 32, 32);
			player_left[3] = TeddySheet.crop(0, 96, 32, 32);
	
			
			
			player_right = new BufferedImage[4];
			
//			player_right[0] = WizardSheet.crop(16, 0, 16, 32);
//			player_right[1] = WizardSheet.crop(16, 32, 16, 32);
//			player_right[2] = WizardSheet.crop(16, 64, 16, 32);
//			player_right[3] = WizardSheet.crop(16, 96, 16, 32);
			
			player_right[0] = TeddySheet.crop(32, 0, 32, 32);
			player_right[1] = TeddySheet.crop(32, 32, 32, 32);
			player_right[2] = TeddySheet.crop(32, 64, 32, 32);
			player_right[3] = TeddySheet.crop(32, 96, 32, 32);
		
			
			player_still = new BufferedImage[2];
//			
//			player_still[0] = WizardSheet.crop(0, 0, 16, 32);
//			player_still[1] = WizardSheet.crop(0, 32, 16, 32);
//		
			player_still[0] = TeddySheet.crop(0, 0, 32, 32);
			player_still[1] = TeddySheet.crop(0, 64, 32, 32);
			
			//Terrain
			
			grass = TerrainSheet.crop(0, 0, 16, 16);
			cliffNorth = TerrainSheet.crop(0, 16, 16, 16);
			cliffWest = TerrainSheet.crop(0, 32, 16, 16);
			cliffSouth = TerrainSheet.crop(0, 48, 16, 16);
			cliffEast= TerrainSheet.crop(0, 0, 64, 16);
			rockFace = TerrainSheet.crop(0, 80, 16, 16);
			cliffNorthWest = TerrainSheet.crop(0, 96, 16, 16);
			cliffNorthWestAlt = TerrainSheet.crop(0, 112, 16, 16);
			cliffNorthEastAlt = TerrainSheet.crop(16, 112, 16, 16);
			cliffNorthEast = TerrainSheet.crop(16, 96, 16, 16);
			cliffEast = TerrainSheet.crop(0, 64, 16, 16);
			
			//Items
			
			log = TerrainSheet.crop(32, 0, 16, 16);
			
			//Static Entities
			pine1 = TerrainSheet.crop(16, 0, 16, 32);
			pine2 = TerrainSheet.crop(16, 32, 16, 32);
			tallGrass = TerrainSheet.crop(16, 64, 16, 16);
			
			//Enemies
			
			SpriteSheet slimeSprite = new SpriteSheet(ImageLoader.loadImage("/textures/slimeEnemy.png"));
			
			slime = slimeSprite.crop(0,0,32,32);
			
			//Attacks
			
			biteAttack = AttacksSheet.crop(0,0,32,32);
			
			
			
		}
}
