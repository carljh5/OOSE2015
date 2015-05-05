package asteroids;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;


public class Player extends SpaceObject {
	
	float radians;
	float drag = 1.0075f;
	
	public Player() {
		float[] points = {0, -5, 20, 0, 0, 5};
		shape = new Polygon(points);
		shape.setCenterX(GameMaster.getWidth()/2 - shape.getWidth()/2);
		shape.setCenterY(GameMaster.getHeight()/2 - shape.getHeight()/2);
	}
	
	public Player(float align) {
		float[] points = {0, -5, 20, 0, 0, 5};
		shape = new Polygon(points);
		shape.setCenterX(GameMaster.getWidth()/2 - shape.getWidth()/2);
		shape.setCenterY(GameMaster.getHeight()/2 - shape.getHeight()/2);
		alignment(align);
		radians = align;
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
		alignment(-0.1f);
	}
	
	/**
	 * Rotates the ship to the right around its own axis.
	 */
	public void rotateRight() {
		radians += 0.1f;
		alignment(0.1f);
	}
	
	@Override
	/**
	 * Translates the players transform with angular drag.
	 */
	public void move() {
		direction.x /= drag;
		direction.y /= drag;
		shape = shape.transform(Transform.createTranslateTransform(direction.x, direction.y));
	}


}
