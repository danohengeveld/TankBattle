package nl.dajo.oopdbp.game;


import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;
/**
 * This class draws the HP levels of the players when added to world.
 * @author dheng, jruessink
 */
public class HPCounter extends Dashboard{
	
	private Player p;
	private float r, g, b;

	public HPCounter(Player p, float x, float y, float r, float g, float b) {
		super(x, y, 0, 0);
		this.p = p;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
    public void draw(PGraphics g) {
        g.beginDraw();
        g.fill(r, this.g, b);
        g.textSize(20);
        g.text(p.getHP(), x, y);

        g.endDraw();
    }

}
