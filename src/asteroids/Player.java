package asteroids;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;

public class Player extends SpaceObject {
	
	Vector2f align = new Vector2f(0,0);
	float radians;
	
	
	public Player() {
		float[] points = {0, -5, 20, 0, 0, 5};
		shape = new Polygon(points);
		shape.setCenterX(360);
		shape.setCenterY(240);
	}
	
	/**
	 * Applies force in the pointing direction of the ship.
	 */
	public void thrust() {
		setDirection(radians);
	}
	
	/**
	 * Rotates the ship to the left around its own axis.
	 */
	public void rotateLeft() {
		radians += -0.1f;
		align.x = (float)(Math.cos(-0.1f));
		align.y = (float)(Math.sin(-0.1f));
		alignment(-0.1f);
		
	}
	
	/**
	 * Rotates the ship to the right around its own axis.
	 */
	public void rotateRight() {
		radians += 0.1f;
		align.x = (float)(Math.cos(0.1f));
		align.y = (float)(Math.sin(0.1f));
		alignment(0.1f);
	}
	
	/*public void shoot() {
		//spawnBullet(getX(), getY(), radians);
		System.out.println("spawnBullet(" + getX() + ", " + getY() + ", " + radians +")");
	}*/


}
