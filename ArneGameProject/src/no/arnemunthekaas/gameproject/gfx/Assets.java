package no.arnemunthekaas.gameproject.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
		
		//Worldgen sprites
		public static BufferedImage deepOcean, ocean, coast, beach, lightGrass, defaultGrass, darkGrass,
		darkerGrass, darkestGrass, lightRock, rock;
		public static final int terrainWidth = 16, terrainHeight = 16;
		
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
		public static final int STARTBUTTONWIDTH = 128;
		public static final int STARTBUTTONHEIGHT = 64;
		public static BufferedImage[] button_start;
		public static BufferedImage inventoryScreen;
		
		// Font(s)
		public static Font font28;
		
		public static void init() {
			
			// Fonts
			font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
			
			// Sprite sheets
			
			SpriteSheet worldGenSheet = new SpriteSheet(ImageLoader.loadImage("/images/spritesheets/terrain.png"));
			
			SpriteSheet TeddySheet = new SpriteSheet(ImageLoader.loadImage("/images/spritesheets/teddySprites.png"));
			SpriteSheet AttacksSheet = new SpriteSheet(ImageLoader.loadImage("/images/spritesheets/attacksSprites.png"));
			
			// UI
			
			inventoryScreen = ImageLoader.loadImage("/images/inventoryScreen.png");
			SpriteSheet PlayButton = new SpriteSheet(ImageLoader.loadImage("/images/playbutton.png"));
			
			button_start = new BufferedImage[2];
			
			button_start[0] = PlayButton.crop(0, 0, STARTBUTTONWIDTH, STARTBUTTONHEIGHT);
			button_start[1] = PlayButton.crop(0, STARTBUTTONHEIGHT, STARTBUTTONWIDTH, STARTBUTTONHEIGHT);
			
			// Player Animations
			
			player_down = new BufferedImage[4];
			
			player_down[0] = TeddySheet.crop(0, 0, 32, 32);
			player_down[1] = TeddySheet.crop(0, 32, 32, 32);
			player_down[2] = TeddySheet.crop(0, 64, 32, 32);
			player_down[3] = TeddySheet.crop(0, 96, 32, 32);
			
			
			player_up = new BufferedImage[4];

			player_up[0] = TeddySheet.crop(32, 0, 32, 32);
			player_up[1] = TeddySheet.crop(32, 32, 32, 32);
			player_up[2] = TeddySheet.crop(32, 64, 32, 32);
			player_up[3] = TeddySheet.crop(32, 96, 32, 32);
			
			
			player_left = new BufferedImage[4];
			
			player_left[0] = TeddySheet.crop(0, 0, 32, 32);
			player_left[1] = TeddySheet.crop(0, 32, 32, 32);
			player_left[2] = TeddySheet.crop(0, 64, 32, 32);
			player_left[3] = TeddySheet.crop(0, 96, 32, 32);
	
			
			
			player_right = new BufferedImage[4];
				
			player_right[0] = TeddySheet.crop(32, 0, 32, 32);
			player_right[1] = TeddySheet.crop(32, 32, 32, 32);
			player_right[2] = TeddySheet.crop(32, 64, 32, 32);
			player_right[3] = TeddySheet.crop(32, 96, 32, 32);
		
			
			player_still = new BufferedImage[2];

			player_still[0] = TeddySheet.crop(0, 0, 32, 32);
			player_still[1] = TeddySheet.crop(0, 64, 32, 32);
			
			//Worldgen
			deepOcean = worldGenSheet.crop(0, 0, terrainWidth, terrainHeight);
			ocean = worldGenSheet.crop(terrainWidth, 0, terrainWidth, terrainHeight);
			coast = worldGenSheet.crop(terrainWidth*2, 0, terrainWidth, terrainHeight);
			beach = worldGenSheet.crop(terrainWidth*3, 0, terrainWidth, terrainHeight);
			
			lightGrass = worldGenSheet.crop(0, terrainHeight, terrainWidth, terrainHeight);
			defaultGrass = worldGenSheet.crop(terrainWidth, terrainHeight, terrainWidth, terrainHeight);
			darkGrass = worldGenSheet.crop(terrainWidth*2, terrainHeight, terrainWidth, terrainHeight);
			darkerGrass = worldGenSheet.crop(terrainWidth*3, terrainHeight, terrainWidth, terrainHeight);
			
			darkestGrass = worldGenSheet.crop(0, terrainHeight*2, terrainWidth, terrainHeight);
			lightRock = worldGenSheet.crop(terrainWidth, terrainHeight*2, terrainWidth, terrainHeight);
			rock = worldGenSheet.crop(terrainWidth*2, terrainHeight*2, terrainWidth, terrainHeight);
			
			
			//Items
			
//			log = TerrainSheet.crop(32, 0, 16, 16);
//			
//			//Static Entities
//			pine1 = TerrainSheet.crop(16, 0, 16, 32);
//			pine2 = TerrainSheet.crop(16, 32, 16, 32);
//			tallGrass = TerrainSheet.crop(16, 64, 16, 16);
			
			//Enemies
			
			// SpriteSheet slimeSprite = new SpriteSheet(ImageLoader.loadImage("/textures/slimeEnemy.png"));
			
			// slime = slimeSprite.crop(0,0,32,32);
			
			//Attacks
			
			biteAttack = AttacksSheet.crop(0,0,32,32);
			
			
			
		}
}
