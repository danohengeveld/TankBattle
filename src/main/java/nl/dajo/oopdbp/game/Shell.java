package nl.dajo.oopdbp.game;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

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
		if (getX() <= 0 || getY() <= 0 || getX() >= world.width - getWidth() || getY() >= world.height - getHeight()) {
			world.deleteGameObject(this);
		}

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject go : collidedGameObjects) {
			if(go instanceof Player && !(go == this.p)) {
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
