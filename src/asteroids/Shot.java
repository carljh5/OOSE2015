package asteroids;

import org.newdawn.slick.geom.Circle;

public class Shot extends SpaceObject {
		
	/**
	 * Constructor for generating shots
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param rads The moving direction in radians.
	 */
	Shot(float x, float y, float rads) {
		shape = new Circle(x,y,1);
		setSpeed(5.0f);
		setDirection(rads);
	}

}
