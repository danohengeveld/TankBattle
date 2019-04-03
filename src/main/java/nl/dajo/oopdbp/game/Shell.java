package nl.dajo.oopdbp.game;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

/**
 * The instances created of this class are the shells the tanks are shooting.
 * This class contains all the code the shell needs to handle itself after being
 * shot. Like the hit detection, the border checking and tile collision. Sets
 * the sprite image containing the 4 orientations of the shell.
 * 
 * @author dheng, jruessink
 */
public class Shell extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	protected TankBattle world;
	private Player p;

	public Shell(TankBattle world, Player p) {
		super(new Sprite(TankBattle.MEDIA_URL.concat("bulletDark2.png")), 4);
		this.world = world;
		this.p = p;
	}

	@Override
	public void update() {
		if (checkWorldBorder()) {
			world.deleteGameObject(this);
		}
		if (!checkExists()) {
			world.deleteGameObject(this);
		}
	}

	/**
	 * @return Returns true or false based on shell/bullet hitting border or not.
	 */
	public boolean checkWorldBorder() {
		if (getX() <= 0 || getY() <= 0 || getX() >= world.width - getWidth() || getY() >= world.height - getHeight()) {
			return true;
		}
		return false;
	}

	/**
	 * @return Returns true or false based on existence of player that shot this
	 *         shell.
	 */
	public boolean checkExists() {
		for (GameObject go : world.getGameObjectItems()) {
			if (go instanceof Player) {
				if (go == p) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player && !(go == this.p)) {
				world.deleteGameObject(this);
				((Player) go).hit();
				System.out.println("Hit");
			}
		}

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		world.deleteGameObject(this);
	}

}
