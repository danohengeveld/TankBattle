package nl.dajo.oopdbp.game;

import java.util.ArrayList;
import nl.han.ica.oopg.objects.Sprite;

/**
 * Class of the first player, initializes the input keys, <strong>WASD</strong>.
 * Checks if keys have been pressed and applies speed and direction to
 * player/tank. Sets sprite image containing the 4 orientations of the Player.
 * 
 * @author dheng, jruessink
 */
public class Player1 extends Player {

	private ArrayList<Key> keys;

	public Player1(TankBattle world) {
		super(world, new Sprite(TankBattle.MEDIA_URL.concat("tank_blue.png")));
		this.keys = new ArrayList<Key>();
		keys.add(new Key((char) 65));
		keys.add(new Key((char) 68));
		keys.add(new Key((char) 87));
		keys.add(new Key((char) 83));
		keys.add(new Key((char) 32));
	}

	/**
	 * Loops and changes direction and speed of player.
	 */
	public void loop() {
		for (Key k : keys) {
			if (k.isPressed()) {
				if (k.key == 65) {
					setDirectionSpeed(270, speed);
					setCurrentFrameIndex(3);
				}
				if (k.key == 68) {
					setDirectionSpeed(90, speed);
					setCurrentFrameIndex(1);
				}
				if (k.key == 87) {
					setDirectionSpeed(0, speed);
					setCurrentFrameIndex(0);
				}
				if (k.key == 83) {
					setDirectionSpeed(180, speed);
					setCurrentFrameIndex(2);
				}
				if (k.key == 32) {
					shoot(this);
				}
			}
		}
	}

	/**
	 * For each key in keys sets isPressed() to true.
	 */
	public void keyPressed(int keyCode, char key) {
		for (Key k : keys) {
			if (keyCode == k.key) {
				k.setPressed(true);
			}
		}
	}

	/**
	 * For each key in keys sets isPressed() to false.
	 */
	public void keyReleased(int keyCode, char key) {
		for (Key k : keys) {
			if (keyCode == k.key) {
				k.setPressed(false);
				setSpeed(0);
			}
		}
	}

	public String toString() {
		return "Blue";
	}

}