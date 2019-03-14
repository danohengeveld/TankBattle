package nl.dajo.oopdbp.game;

import java.util.ArrayList;

import nl.han.ica.oopg.objects.Sprite;

public class Player2 extends Player {
	
	private ArrayList<Key> keys;
	final int speed = 2;

	public Player2(TankBattle world) {
		super(world, new Sprite(TankBattle.MEDIA_URL.concat("tank_red.png")));
		this.keys = new ArrayList<Key>();
		keys.add(new Key((char) world.LEFT));
		keys.add(new Key((char) world.RIGHT));
		keys.add(new Key((char) world.UP));
		keys.add(new Key((char) world.DOWN));
		keys.add(new Key((char) world.ENTER));
	}
	
	public void loop() {
		for(Key k : keys) {
			if(k.isPressed()) {
				if(k.key == world.LEFT) {
					setDirectionSpeed(270, speed);
					setCurrentFrameIndex(3);
				}
				if(k.key == world.RIGHT) {
					setDirectionSpeed(90, speed);
					setCurrentFrameIndex(1);
				}
				if(k.key == world.UP) {
					setDirectionSpeed(0, speed);
					setCurrentFrameIndex(0);
				}
				if(k.key == world.DOWN) {
					setDirectionSpeed(180, speed);
					setCurrentFrameIndex(2);
				}
				if(k.key == world.ENTER) {
					shoot(this);
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	public void keyPressed(int keyCode, char key) {
		for(Key k : keys) {
			if(keyCode == k.key) {
				k.setPressed(true);
			}
		}	
	}

	@SuppressWarnings("static-access")
	public void keyReleased(int keyCode, char key) {
		for(Key k : keys) {
			if(keyCode == k.key) {
				k.setPressed(false);
				setSpeed(0);
			}
		}
	}
	
	public String toString() {
		return "Red";
		
	}

}