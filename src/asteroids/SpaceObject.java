package asteroids;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;


public class SpaceObject {
	protected Vector2f direction = new Vector2f(0,0);
	protected Shape shape;
	protected float speed = 0.1f;
	private Shape boundingBox;
	
	/**
	 * Used to get the shape object for rendering.
	 * @return Returns the Shape object
	 */
	public Shape getShape() {
		return shape;
	}
	
	/**
	 * Used to know when entity is in collision
	 * @return Returns the bounding box object
	 */
	public Shape getBoundingbox() {
		return this.boundingBox;
	}
	
	public boolean intersects(SpaceObject entity){
		if (this.getBoundingbox() == null){
			return false;
		}
		return this.getBoundingbox().intersects(entity.getBoundingbox());
	}
	
	/**
	 * Sets the moving direction and speed of the object.
	 * @param rads The direction of the movement in radians.
	 */
	public void setDirection(float rads) {
		direction.x += (float) Math.cos(rads)*speed;
		direction.y += (float) Math.sin(rads)*speed;
	}
	
	/**
	 * Sets the speed of the objects
	 * @param s
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
	 * 
	 * @return The position of the object on the objects center x-coordinate.
	 */
	public float getX() {
		return shape.getCenterX();
	}
	
	/**
	 * Sets the position of the object on the objects center x-coordinate.
	 */
	public void setX(float x) {
		shape.setCenterX(x);
	}
	
	/**
	 * 
	 * @return The position of the object on the objects center y-coordinate.
	 */
	public float getY() {
		return shape.getCenterY();
	}
	/**
	 * Sets the position of the object on the objects center y-coordinate.
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
	 * Checks if this object intersects with another object.
	 * @param object
	 * @return Returns true if the shapes intersects.
	 */
	
	public boolean isColliding(Shape object) {
		return getShape().intersects(object);
	}

}
