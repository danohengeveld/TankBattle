package nl.dajo.oopdbp.game;

/**
 * The instances created of this class are the control keys of the players.
 * 
 * @author dheng, jruessink
 */
public class Key {
	public char key;
	private boolean isPressed;

	Key(char key) {
		this.key = key;
	}

	/**
	 * @return Returns true or false based on if key is pressed.
	 */
	public boolean isPressed() {
		return isPressed;
	}

	/**
	 * Set isPressed() to true or false.
	 * 
	 * @param isPressed boolean
	 */
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

}
