package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;

public abstract class Player extends AnimatedSpriteObject {

	protected TankBattle world;
	protected int hp;

	public Player(TankBattle world, Sprite s) {
		super(s, 4);
		this.world = world;
		hp = 100;
	}

	@Override
	public void update() {
		if (getX() <= 0) {
			setxSpeed(0);
			setX(0);
		}
		if (getY() <= 0) {
			setySpeed(0);
			setY(0);
		}
		if (getX() >= world.width - getWidth()) {
			setxSpeed(0);
			setX(world.width - getWidth());
		}
		if (getY() >= world.height - getHeight()) {
			setySpeed(0);
			setY(world.height - getHeight());
		}

		if (this.hp <= 0) {
			world.deleteGameObject(this);
			String msg;
			if (this instanceof Player1) {
				msg = "Red WON!!";
			} else {
				msg = "Blue WON!!";
			}

			TextObject to = new TextObject(msg, 50);
			to.setForeColor(255, 255, 255, 255);
			world.addGameObject(to, 5, 55);
		}

	}

	public void shoot(Player p) {
		final int speed = 10;
		Shell s = new Shell(world, p);
		if (this.getCurrentFrameIndex() == 0 || this.getCurrentFrameIndex() == 360) {
			s.setCurrentFrameIndex(0);
			s.setDirectionSpeed(0, speed);
		}
		if (this.getCurrentFrameIndex() == 1) {
			s.setCurrentFrameIndex(1);
			s.setDirectionSpeed(90, speed);
		}
		if (this.getCurrentFrameIndex() == 2) {
			s.setCurrentFrameIndex(2);
			s.setDirectionSpeed(180, speed);
		}
		if (this.getCurrentFrameIndex() == 3) {
			s.setCurrentFrameIndex(3);
			s.setDirectionSpeed(270, speed);
		}
		world.addGameObject(s, getX() + this.getWidth() / 2 - s.getWidth() / 2,
				getY() + this.getHeight() / 2 - s.getHeight() / 2);
	}

	public void hit() {
		this.hp -= 5;
	}

}
