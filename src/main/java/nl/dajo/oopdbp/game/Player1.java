package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.objects.Sprite;

public class Player1 extends Player {

	public Player1(TankBattle world) {
		super(world, new Sprite(TankBattle.MEDIA_URL.concat("tank_blue.png")));
	}

	public void keyPressed(int keyCode, char key) {
		// Movement (Change speed to adjust driving speed)
		final int speed = 2;
		if (keyCode == 65) {
			setDirectionSpeed(270, speed);
			setCurrentFrameIndex(3);
		}
		if (keyCode == 68) {
			setDirectionSpeed(90, speed);
			setCurrentFrameIndex(1);
		}
		if (keyCode == 87) {
			setDirectionSpeed(0, speed);
			setCurrentFrameIndex(0);
		}
		if (keyCode == 83) {
			setDirectionSpeed(180, speed);
			setCurrentFrameIndex(2);
		}

		if (keyCode == 32) {
			shoot(this);
		}

	}

	public void keyReleased(int keyCode, char key) {
		if (keyCode == 65 || keyCode == 68 || keyCode == 87 || keyCode == 83) {
			setSpeed(0);
		}

	}
	
	public String toString() {
		return "Blue";
	}


}
