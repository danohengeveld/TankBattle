package nl.dajo.oopdbp.game;

public class Key {
	public char key;
	private boolean isPressed;
	
	Key(char key){
		this.key = key;
	}

	/**
	 * Returns true or false based on if key is pressed.
     * @returns Returns true or false based on if key is pressed.
     */
	public boolean isPressed() {
		return isPressed;
	}

	/**
     * Set isPressed() to true or false.
     * @param boolean
     */
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	
	
}
