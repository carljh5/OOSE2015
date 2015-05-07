package asteroids;

import org.newdawn.slick.geom.Circle;

public class Shot extends SpaceObject {
		
	/**
	 * Constructor for generating shots
	 * @param float x position
	 * @param float y position
	 * @param rads size
	 */
	Shot(float x, float y, float rads) {
		shape = new Circle(x,y,1);
		setSpeed(5.0f);
		setDirection(rads);
	}
}
