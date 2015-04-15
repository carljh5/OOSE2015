package asteroids;

import org.newdawn.slick.geom.Polygon;


public class Asteroid extends SpaceObject {
	int scale;
	
	public Asteroid(int scale) {
		
		this.scale = scale;
		
		float[] points = {0,0,5,20,30,10,25,-20,10,-12};
		for(float p : points) {
			p = p*scale;
		}
		shape = new Polygon(points);
		shape.setCenterX(100);
		shape.setCenterY(100);
	}
	
}
