package asteroids;

import org.newdawn.slick.geom.Circle;


public class Shot extends SpaceObject {
	
	Shot(float x, float y, float rads) {
		shape = new Circle(x,y,1);
		setSpeed(3.0f);
		setDirection(rads);
	}

}
