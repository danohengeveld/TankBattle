package nl.dajo.oopdbp.game;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Shell extends AnimatedSpriteObject implements ICollidableWithGameObjects {
	protected TankBattle world;
	private static Sprite s = new Sprite(TankBattle.MEDIA_URL.concat("bulletBlue.png"));
	private Player p;

	public Shell(TankBattle world, Player p) {
		super(s, 4);
		this.world = world;
		this.p = p;
		if (p instanceof Player2) {
			s.setSprite(TankBattle.MEDIA_URL.concat("bulletRed.png"));
		} else {
			s.setSprite(TankBattle.MEDIA_URL.concat("bulletBlue.png"));
		}
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

}
