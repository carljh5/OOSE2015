package asteroids;

import java.util.Random;

import org.newdawn.slick.geom.Polygon;


public class Asteroid extends SpaceObject {
	int scale;
	float xCenter;
	float yCenter;
	int diffAsteroids = 2;
	float [][] points = new float[diffAsteroids][0];
	
	public Asteroid(int scale, float dir, float xCenter, float yCenter) {
		this.scale = scale;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		float [] pts =  initPoints();
		for(int i = 0; i<pts.length; i++)
			pts[i] *=scale;
		shape = new Polygon(pts);
		shape.setCenterX(xCenter);
		shape.setCenterY(yCenter);
		Random rnd = new Random();
		float randSpeed = (float) rnd.nextInt(2);
		setSpeed(randSpeed+0.5f);
		setDirection(dir);
	}
	
	float [] initPoints() {
		points[0] = new float[] {0,0,5,20,30,10,25,-20,10,-12};
		points[1] = new float[] {17,0,23,7,37,7,43,20,30,33,30,43,17,40,20,31,00,24};
		Random rnd = new Random();
		int version = rnd.nextInt(diffAsteroids);
		return points[version];
	}
	
}
