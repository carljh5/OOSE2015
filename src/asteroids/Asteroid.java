package asteroids;

import java.util.Random;

import org.newdawn.slick.geom.Polygon;


public class Asteroid extends SpaceObject {
	int scale;
	
	public Asteroid(int scale, float dir) {
		this.scale = scale;
		float[] points = {0,0,5,20,30,10,25,-20,10,-12};
		for(int i = 0; i < points.length; i++){
			points[i] *= scale;
		}
		//float[] points = {17,0,23,7,37,7,43,20,30,33,30,43,17,40,20,31,00,24};
		for(float p : points) {
			p = p*scale;
		}
		shape = new Polygon(points);
		shape.setCenterX(100);
		shape.setCenterY(100);
		Random rnd = new Random();
		float randSpeed = (float) rnd.nextInt(2);
		setSpeed(randSpeed+0.5f);
		setDirection(dir);
	}
	
	
}
