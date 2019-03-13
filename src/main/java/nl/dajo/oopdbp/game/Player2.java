package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.objects.Sprite;

public class Player2 extends Player {

	public Player2(TankBattle world) {
		super(world, new Sprite(TankBattle.MEDIA_URL.concat("tank_red.png")));
	}

	@SuppressWarnings("static-access")
	public void keyPressed(int keyCode, char key) {
		final int speed = 2;
		if (keyCode == world.LEFT) {
			setDirectionSpeed(270, speed);
			setCurrentFrameIndex(3);
		}
		if (keyCode == world.RIGHT) {
			setDirectionSpeed(90, speed);
			setCurrentFrameIndex(1);
		}
		if (keyCode == world.UP) {
			setDirectionSpeed(0, speed);
			setCurrentFrameIndex(0);
		}
		if (keyCode == world.DOWN) {
			setDirectionSpeed(180, speed);
			setCurrentFrameIndex(2);
		}

		if (keyCode == world.ENTER || keyCode == world.RETURN) {
			shoot(this);
		}

	}

	@SuppressWarnings("static-access")
	public void keyReleased(int keyCode, char key) {
		if (keyCode == world.LEFT || keyCode == world.RIGHT || keyCode == world.UP || keyCode == world.DOWN) {
			setSpeed(0);
		}

	}
	
	public String toString() {
		return "Red";
		
	}

}
