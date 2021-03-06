package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;

/**
 * The instances created of this class are the animations you see when a player
 * has lost (got to 0 hp). Sets the sprite image containing the 5 stages of the
 * explosion animation.
 * 
 * @author dheng, jruessink
 */
public class Explosion extends AnimatedSpriteObject implements IAlarmListener {

	private TankBattle world;

	public Explosion(TankBattle world) {
		super(new Sprite(TankBattle.MEDIA_URL.concat("explosion.png")), 5);
		this.world = world;
		this.setCurrentFrameIndex(0);
		startAlarm();

	}

	private void startAlarm() {
		Alarm alarm = new Alarm("alarm", 0.1);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void update() {

	}

	@Override
	public void triggerAlarm(String alarmName) {

		if (this.getCurrentFrameIndex() < 4) {
			this.setCurrentFrameIndex(this.getCurrentFrameIndex() + 1);
			startAlarm();
		} else {
			world.deleteGameObject(this);
		}

	}

}
