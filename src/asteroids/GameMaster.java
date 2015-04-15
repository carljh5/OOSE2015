
package asteroids;

import org.newdawn.slick.GameContainer;

public class GameMaster {
	
	public int height;
	public int width;
	public SpaceObject object = new SpaceObject();
	
	public void initialize(GameContainer gcon) {
		width = gcon.getWidth();
		height = gcon.getHeight();
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	void mirror() {
		if (object.getX() < 0) {
			object.setX(width);
		} 
		if (object.getY() < 0) {
			object.setY(height);
		} 
		if (object.getX() > width) {
			object.setX(0);
		} 
		if (object.getY() > height) {
			object.setY(0);
		}
		
	}

}
