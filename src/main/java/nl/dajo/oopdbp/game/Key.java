package nl.dajo.oopdbp.game;

public class Key {
	public char key;
	private boolean isPressed;
	
	Key(char key){
		this.key = key;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}	
}
