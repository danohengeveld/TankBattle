package nl.dajo.oopdbp.game;

import java.util.List;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PVector;

public abstract class Player extends AnimatedSpriteObject implements ICollidableWithTiles, IAlarmListener {

	protected TankBattle world;
	private int hp = 100;
	private int ammo = 1;

	public Player(TankBattle world, Sprite s) {
		super(s, 4);
		this.world = world;
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

			Explosion ex = new Explosion(world);
			world.addGameObject(ex, this.getX(), this.getY());

			String msg;
			if (this instanceof Player1) {
				msg = "Red WON!!";
			} else {
				msg = "Blue WON!!";
			}

			TextObject to = new TextObject(msg, 50);
			to.setForeColor(255, 255, 255, 255);
			world.addGameObject(to, 5, 55);
			world.deleteGameObject(this);
		}

	}

	private void startAlarm() {
		Alarm alarm = new Alarm("alarm", 1);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (ammo <= 0) {
			ammo = 1;
		}

	}

	public void shoot(Player p) {
		final int speed = 10;
		if (ammo == 1) {
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
			ammo--;
			startAlarm();
		}
	}

	public void hit() {
		this.hp -= 5;
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;

		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof BoardsTile) {
				if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
					try {
						vector = world.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y - getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
					try {
						vector = world.getTileMap().getTilePixelLocation(ct.getTile());
						setX(vector.x + world.tileSize);
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				if (CollisionSide.LEFT.equals(ct.getCollisionSide())) {
					try {
						vector = world.getTileMap().getTilePixelLocation(ct.getTile());
						setX(vector.x - getWidth());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				if (CollisionSide.BOTTOM.equals(ct.getCollisionSide())) {
					try {
						vector = world.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y + world.tileSize);
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
