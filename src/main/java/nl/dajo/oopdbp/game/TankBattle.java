package nl.dajo.oopdbp.game;

import java.awt.Color;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.dashboard.FPSCounter;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.View;

/**
 * Main class of the project. Initializes all of the players and the map.
 * 
 * @author dheng, jruessink
 * @version 1.1
 */
@SuppressWarnings("serial")
public class TankBattle extends GameEngine {

	private Player1 p1;
	private Player2 p2;
	private Dashboard db;
	public int worldWidth;
	public int worldHeight;
	public final int tileSize = 64;

	public static String MEDIA_URL = "src/main/java/nl/dajo/oopdbp/game/media/";

	public static void main(String[] args) {
		TankBattle world = new TankBattle();
		world.runSketch();
	}

	@Override
	public void setupGame() {
		worldWidth = 640;
		worldHeight = 640;

		p1 = new Player1(this);
		HPCounter hp1 = new HPCounter(p1, 10, worldHeight - 10, 0, 0, 255);
		p2 = new Player2(this);
		HPCounter hp2 = new HPCounter(p2, worldWidth - 50, worldHeight - 10, 255, 0, 0);

		addGameObject(p1, 0, 0);
		addGameObject(hp1);
		addGameObject(p2, worldWidth, worldHeight);
		addGameObject(hp2);
		addGameObject(new FPSCounter(worldWidth - 30, 30));

		createMap();

		View view = new View(worldWidth, worldHeight);
		view.setBackground(loadImage(MEDIA_URL.concat("TankBattle-BG.png")));

		setView(view);
		size(worldWidth, worldHeight);
	}

	/**
	 * Initializes the tiles map.
	 */
	private void createMap() {
		Sprite MetalCrate = new Sprite(MEDIA_URL.concat("crateMetal.png"));
		Sprite BrownTree = new Sprite(MEDIA_URL.concat("treeBrown_large.png"));

		TileType<BoardsTile> boardTileTypeMetalCrate = new TileType<>(BoardsTile.class, MetalCrate);
		TileType<BoardsTile> boardTileTypeBrownTree = new TileType<>(BoardsTile.class, BrownTree);

		@SuppressWarnings("rawtypes")
		TileType[] tileTypes = { boardTileTypeMetalCrate, boardTileTypeBrownTree };
		int tilesMap[][] = { { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, 1, -1, -1, -1, -1, -1, -1, 0, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, 1, -1, -1, -1, -1 },
				{ -1, -1, -1, 1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, 1, -1, -1, -1 },
				{ -1, -1, -1, -1, 1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, 0, -1, -1, -1, -1, -1, -1, 1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, };
		tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}

	@Override
	public void update() {
		p1.loop();
		p2.loop();

	}
}
