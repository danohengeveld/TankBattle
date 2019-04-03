package nl.dajo.oopdbp.game;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

/**
 * The instances created of the class are the hit markers you see when a player
 * gets hit. Sets the sprite image for the hit.
 * 
 * @author dheng, jruessink
 */
public class Hit extends SpriteObject implements IAlarmListener {

	private TankBattle world;

	public Hit(TankBattle world) {
		super(new Sprite(TankBattle.MEDIA_URL.concat("explosionSmoke4.png")));
		this.world = world;
		startAlarm();
	}

	private void startAlarm() {
		Alarm alarm = new Alarm("alarm", 0.3);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		world.deleteGameObject(this);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
