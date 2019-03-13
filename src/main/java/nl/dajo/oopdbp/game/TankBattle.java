package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.dashboard.FPSCounter;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

@SuppressWarnings("serial")
public class TankBattle extends GameEngine {

	private Player1 p1;
	private Player2 p2;
	public int worldWidth;
	public int worldHeight;

	public static String MEDIA_URL = "src/main/java/nl/dajo/oopdbp/game/media/";

	public static void main(String[] args) {
		TankBattle world = new TankBattle();
		world.runSketch();

	}

	@Override
	public void setupGame() {
		worldWidth = 500;
		worldHeight = 500;

		p1 = new Player1(this);
		p2 = new Player2(this);

		addGameObject(p1, 0, 0);
		addGameObject(p2, 500, 500);
		addGameObject(new FPSCounter(worldWidth-30, 30));

		View view = new View(worldWidth, worldHeight);
		
		setView(view);
		size(worldWidth, worldHeight);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
