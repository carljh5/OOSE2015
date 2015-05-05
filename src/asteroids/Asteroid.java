package asteroids;

import java.util.Random;

import org.newdawn.slick.geom.Polygon;


public class Asteroid extends SpaceObject {
	int scale;
	float xCenter;
	float yCenter;
	int diffAsteroids = 4;
	float [][] points = new float[diffAsteroids][0];
	
	public Asteroid(int scale, float dir, float xCenter, float yCenter) {
		this.scale = scale;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		float [] pts =  initPoints();
		for(int i = 0; i<pts.length; i++)
			pts[i] *=(scale/1.4);
		shape = new Polygon(pts);
		shape.setCenterX(xCenter);
		shape.setCenterY(yCenter);
		Random rnd = new Random();
		float randSpeed = (float) rnd.nextInt(2);
		setSpeed(randSpeed+0.5f);
		setDirection(dir);
		Random rand = new Random();
		alignment((float)(2*Math.PI*rand.nextFloat()));
	}
	
	float [] initPoints() {
		points[0] = new float[] {0,0,5,20,30,10,25,-20,10,-12};
		points[1] = new float[] {17,0,23,7,37,7,43,20,30,33,30,43,17,40,20,31,00,24};
		points[2] = new float[] {172, 140, 292, 175, 311, 236, 236, 251, 232, 299, 173, 269, 186, 219, 132, 185, 183, 183, 173, 140};
		points[3] = new float[] {168, 282, 281, 242, 198, 213, 201, 180, 138, 175, 55, 283, 111, 343, 140, 311, 198, 312, 170, 285};
		for(int i = 0; i < points[2].length; i++) {
			points[2][i] = points[2][i]/4;
			points[3][i] /= 4;
		}
		Random rnd = new Random();
		int version = rnd.nextInt(diffAsteroids);
		return points[version];
	}
	
}
