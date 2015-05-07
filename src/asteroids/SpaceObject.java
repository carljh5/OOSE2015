package asteroids;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;


public class SpaceObject {
	protected Vector2f direction = new Vector2f(0,0);
	protected Shape shape;
	protected float speed = 0.1f;	
	public int mirrorLimit = 0;

	
	/**
	 * Used to get the shape object for rendering.
	 * @return Returns the Shape object
	 */
	public Shape getShape() {
		return shape;
	}
	
	/**
	 * Sets the moving direction and speed of the object.
	 * @param rads The direction of the movement in radians.
	 */
	public void setDirection(float rads) {
		direction.x += (float) Math.cos(rads)*speed;
		direction.y += (float) Math.sin(rads)*speed;
		//System.out.println(direction.x + "   " + direction.y );
	}
	
	/**
	 * Sets the speed of the objects.
	 * @param s The amount of speed.
	 */
	public void setSpeed(float s) {
		speed = s;
	}
	
	/**
	 * Rotates the object Shape.
	 * @param rads Rotation in radians.
	 */
	
	public void alignment(float rads) {
		shape = shape.transform(Transform.createRotateTransform(rads, getX(), getY()));
	}
	
	/**
	 * @return The position of the object on the objects center x-coordinate.
	 */
	public float getX() {
		return shape.getCenterX();
	}
	
	/**
	 * Sets the position of the object on the objects center x-coordinate.
	 * @param x The x coordinate.
	 */
	public void setX(float x) {
		shape.setCenterX(x);
	}
	
	/**
	 * @return The position of the object on the objects center y-coordinate.
	 */
	public float getY() {
		return shape.getCenterY();
	}
	/**
	 * Sets the position of the object on the objects center y-coordinate.
	 * @param y The y coordinate.
	 */
	public void setY(float y) {
		shape.setCenterY(y);
	}
	
	/**
	 * Translates the object's transform.
	 */
	public void move() {
		shape = shape.transform(Transform.createTranslateTransform(direction.x, direction.y));
	}
	
	/**
	 * Checks if this object intersects or is inside another object.
	 * @param object The Shape to be compared to.
	 * @return Returns true if the shapes intersects or is inside another object.
	 */
	
	public boolean isColliding(Shape object) {
		if (getShape().intersects(object) || getShape().contains(object))
			return true;
		else
			return false;
	}

}
